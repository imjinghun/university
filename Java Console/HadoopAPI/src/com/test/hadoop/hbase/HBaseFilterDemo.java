package com.test.hadoop.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FamilyFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.QualifierFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SkipFilter;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HBaseFilterDemo {
	Connection conn;
	@Before
	public void init(){
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "jing");
		conf.set("hbase.rootdir", "hdfs://jing:9000/hbase");
		try {
			conn = ConnectionFactory.createConnection(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After
	public void end() {
		try {
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCounter() throws Exception{
		Table table = conn.getTable(TableName.valueOf("counters"));
		long num = table.incrementColumnValue(Bytes.toBytes("2017-07"), Bytes.toBytes("month"), Bytes.toBytes("hits"), 0);
		System.out.println(num);
	}

	//过滤出行键为row-key-0001和row-key-0002的address列值信息
	@Test
	public void testFilterList() throws Exception{
		Table table = conn.getTable(TableName.valueOf("user"));
		List<Filter> filters = new ArrayList<Filter>();

		Filter filter1 = new RowFilter(
				CompareFilter.CompareOp.GREATER_OR_EQUAL,
				new BinaryComparator(Bytes.toBytes("row-key-0001")));
		filters.add(filter1);

		Filter filter2 = new RowFilter(
				CompareFilter.CompareOp.LESS_OR_EQUAL,
				new BinaryComparator(Bytes.toBytes("row-key-0002")));
		filters.add(filter2);

		Filter filter3 = new QualifierFilter(CompareFilter.CompareOp.EQUAL,
				new RegexStringComparator("address"));
		filters.add(filter3);

		FilterList filterList1 = new FilterList(filters);

		
		Scan scan = new Scan();
		scan.setFilter(filterList1);
		ResultScanner scanner1 = table.getScanner(scan);
		 System.out.println("Results of scan #1 - MUST_PASS_ALL:");
		int n = 0;
		// vv FilterListExample
		for (Result result : scanner1) {
			for (Cell cell : result.rawCells()) {
				System.out.println("Cell: " + cell + ", Value: "
						+ Bytes.toString(cell.getValueArray(),
								cell.getValueOffset(),
								cell.getValueLength()));
				n++;
			}
		}
		scanner1.close();
	}
	
	@Test
	public void testSkipFilter() throws Exception{
		Table table = conn.getTable(TableName.valueOf("user"));
		// 所有列的值不等于0
		Filter filter1 = new ValueFilter(CompareFilter.CompareOp.NOT_EQUAL,
				new RegexStringComparator("^tianjin[0-9]{2}"));

		Scan scan = new Scan();
		//scan.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"));
		scan.setFilter(filter1);

		ResultScanner scanner1 = table.getScanner(scan);
		System.out.println("Results of scan #1:");
		int n = 0;
		for (Result result : scanner1) {
			for (Cell cell : result.rawCells()) {
				System.out.println("Cell: "
						+ cell + ", Value: "
						+ Bytes.toString(cell.getValueArray(),
								cell.getValueOffset(),
								cell.getValueLength()));
				n++;
			}
		}
		scanner1.close();
		System.out.println("Total cell count for scan #1: " + n);

		
		// 把任何列的值为0的行过滤
		Filter filter2 = new SkipFilter(filter1);
		scan.setFilter(filter2);
		//scan.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"));

		ResultScanner scanner2 = table.getScanner(scan);

		n = 0;
		System.out.println("Results of scan #2:");
		for (Result result : scanner2) {
			for (Cell cell : result.rawCells()) {
				System.out.println("Cell: "
						+ cell
						+ ", Value: "
						+ Bytes.toString(cell.getValueArray(),
								cell.getValueOffset(),
								cell.getValueLength()));
				n++;
			}
		}
		scanner2.close(); 
		System.out.println("Total cell count for scan #2: " + n);
		table.close();

		
		
	}
	
	@Test
	public void testPageFilter() throws Exception{
		Table table = conn.getTable(TableName.valueOf("user"));
		//给上一页最后一行数据的行键添加后缀
		byte[] POSTFIX = new byte[] { 0x00 };
		byte[] lastRow = null;
		
		Scan scan = new Scan();
		
		//设置过滤器
		Filter filter = new PageFilter(3);
		//查询表里的所有数据，分页显示
		while(true) {
			if(lastRow!=null) {
				//第二页以后的查询
				byte[] startRow = Bytes.add(lastRow, POSTFIX);
				scan.setStartRow(startRow);
			}
			scan.setFilter(filter);
			
			ResultScanner resultScanner = table.getScanner(scan);
			
			Iterator<Result> results = resultScanner.iterator();
			int row = 0;
			
			while(results.hasNext()) {
				Result result = results.next();
				//迭代当前页的数据，把最后条数据记录下来，用于下一页的查询
				lastRow = result.getRow();
				System.out.println(result);
				row ++;
			}
			if(row==0) {
				break;
			}
			System.out.println("-----------------------------");
		}
		
	}
	
	@Test
	public void testSingleValueFilter() throws Exception{
		Table table = conn.getTable(TableName.valueOf("user"));
		
		Scan scan = new Scan();
		//设置过滤器
		Filter filter = new SingleColumnValueFilter(Bytes.toBytes("info"),
				Bytes.toBytes("address"), CompareOp.EQUAL, Bytes.toBytes("tianjin"));
		
		scan.setFilter(filter);
		
		ResultScanner resultScanner = table.getScanner(scan);
		
		Iterator<Result> results = resultScanner.iterator();
		
		while(results.hasNext()) {
			System.out.println(results.next());
		}
	}
	
	@Test
	public void testValueFilter() throws Exception{
		
		Table table = conn.getTable(TableName.valueOf("user"));
		
		Scan scan = new Scan();
		//设置过滤器
		Filter filter = new ValueFilter(CompareFilter.CompareOp.EQUAL, 
				new BinaryComparator(Bytes.toBytes("tianjin12")));
		
		scan.setFilter(filter);
		
		ResultScanner resultScanner = table.getScanner(scan);
		
		Iterator<Result> results = resultScanner.iterator();
		
		while(results.hasNext()) {
			System.out.println(results.next());
		}
		
	}
	
	@Test
	public void testQualifierFilter() throws Exception{
		
		Table table = conn.getTable(TableName.valueOf("user"));
		
		Scan scan = new Scan();
		//设置过滤器
		Filter filter = new QualifierFilter(CompareFilter.CompareOp.EQUAL, 
				new BinaryComparator(Bytes.toBytes("address")));
		
		scan.setFilter(filter);
		
		ResultScanner resultScanner = table.getScanner(scan);
		
		Iterator<Result> results = resultScanner.iterator();
		
		while(results.hasNext()) {
			System.out.println(results.next());
		}
		
	}
	
	@Test
	public void testFamilyFilter() throws Exception{
		
		Table table = conn.getTable(TableName.valueOf("user"));
		
		Scan scan = new Scan();
		//Filter filter = new RowFilter(CompareOp.EQUAL, 
		//		new BinaryComparator(Bytes.toBytes("row-key-00001")));
		//设置过滤器
		Filter filter = new FamilyFilter(CompareFilter.CompareOp.EQUAL, 
				new BinaryComparator(Bytes.toBytes("info")));
		
		scan.setFilter(filter);
		
		ResultScanner resultScanner = table.getScanner(scan);
		
		Iterator<Result> results = resultScanner.iterator();
		
		while(results.hasNext()) {
			System.out.println(results.next());
		}
		
	}
	

	@Test
	public void testRowFilter() throws Exception{
		
		Table table = conn.getTable(TableName.valueOf("user"));
		
		Scan scan = new Scan();
		//Filter filter = new RowFilter(CompareOp.EQUAL, 
		//		new BinaryComparator(Bytes.toBytes("row-key-00001")));
		//设置过滤器
		Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator(".*-.5"));
		
		scan.setFilter(filter);
		
		ResultScanner resultScanner = table.getScanner(scan);
		
		Iterator<Result> results = resultScanner.iterator();
		
		while(results.hasNext()) {
			System.out.println(results.next());
		}
		
	}
	
	
}

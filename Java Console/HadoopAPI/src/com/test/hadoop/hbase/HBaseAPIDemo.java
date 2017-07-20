package com.test.hadoop.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Row;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HBaseAPIDemo {
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
	public void testScan2() throws Exception{
		Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
		Scan scan = new Scan(Bytes.toBytes("row-key-00001"), Bytes.toBytes("row-key-00002"));
		ResultScanner resultScanner = table.getScanner(scan);
		Iterator<Result> iter = resultScanner.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	@Test
	public void testScan() throws Exception{
		Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
		//全表扫描
		ResultScanner resultScanner = table.getScanner(Bytes.toBytes("info"));
		Iterator<Result> iter = resultScanner.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	
	
	@Test
	public void testBatch() throws Exception{
		Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
		
		List<Row> actions = new ArrayList<>();
		
		Delete delete = new Delete(Bytes.toBytes("row-key-00003"));
		Get get = new Get(Bytes.toBytes("row-key-00001"));
		Put put = new Put(Bytes.toBytes("row-key-00002"));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"), Bytes.toBytes("shenzhen2"));
		
		actions.add(delete);
		actions.add(get);
		actions.add(put);
		
		Object[] results = new Object[actions.size()];
		table.batch(actions, results);
		
		for (Object object : results) {
			System.out.println(object);
		}
	}
	
	@Test
	public void testDelete() throws Exception {
		Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
		
		Delete delete = new Delete(Bytes.toBytes("row-key-00003"));
		//delete.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"));
		
		table.delete(delete);
	}
	
	@Test
	public void testGet() throws Exception, IOException{
		Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
		
		Get get = new Get(Bytes.toBytes("row-key-00001"));
		//获取某个特定的列，如果不设置，则获取整行的内容
		get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"));
		Result result = table.get(get);
		List<Cell> cells = result.getColumnCells(Bytes.toBytes("info"), Bytes.toBytes("address"));
		for (Cell cell : cells) {
			//System.out.println(new String(cell.getValue()));
			System.out.println(new String(CellUtil.cloneValue(cell)));
		}
		System.out.println(result);
	}
	
	@Test
	public void testUpdate() throws Exception, IOException{
		Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
		
		Put put = new Put(Bytes.toBytes("row-key-00002"));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"), Bytes.toBytes("shenzhen"));
		
		/*
		 * 做修改的时候，第一，查询该值是否存在，第二， 进行修改。整个修改操作要保证原子性
		 * 1. check
		 * 2. update
		 * 
		 * 参数put来修改Bytes.toBytes("row-key-00002"), Bytes.toBytes("info"), Bytes.toBytes("address"), Bytes.toBytes("shanghai")
		 */
		table.checkAndPut(Bytes.toBytes("row-key-00002"), Bytes.toBytes("info"), Bytes.toBytes("address"), Bytes.toBytes("shanghai"), put);
		//table.checkAndPut(arg0, arg1, arg2, arg3, arg4)
		//table.put(put);
	}
	
	@Test
	public void testPuts() throws Exception {
		Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
		List<Put> puts = new ArrayList<>();
		
		Put put = new Put(Bytes.toBytes("row-key-00005"));
		//设置了一列
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes(22));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"), Bytes.toBytes("beijing"));
		
		Put put2 = new Put(Bytes.toBytes("row-key-00006"));
		//设置了一列
		put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes(32));
		put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"), Bytes.toBytes("shanghai"));
		
		puts.add(put);
		puts.add(put2);
		table.put(puts);
	}
	
	
	public static void main(String[] args) {
		Configuration conf = HBaseConfiguration.create();
		//zookeeper的主机地址
		conf.set("hbase.zookeeper.quorum", "jing");
		//hbase存储数据的路径
		conf.set("hbase.rootdir", "hdfs://jing:9000/hbase");

		try {
			Connection conn = ConnectionFactory.createConnection(conf);
			//获取hbase表对象
			Table table = conn.getTable(TableName.valueOf(Bytes.toBytes("user")));
			
			for (int i = 0; i < 5; i++) {
				Put put = new Put(Bytes.toBytes("row-key-000"+i));
				//设置了一列
				put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("啊"+i));
				put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("address"), Bytes.toBytes("哦"+i));
				table.put(put);
			}
			table.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package oracle.demo.oow.bd.util.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class HbaseDB {
	
	static String zookeeper=ConstantsHBase.ZOOKEEPER;
	static String rootDir=ConstantsHBase.HBASE_ROOT_DIR;
	
	private static Connection conn;
	//单例
	private static class HbaseDBInstance{
		private static final HbaseDB db = new HbaseDB();
	} 
	public static HbaseDB getInstance(){
		return HbaseDBInstance.db;	
	}
	private HbaseDB() {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", zookeeper);
		conf.set("hbase.rootdir", rootDir);
		try {
			conn = ConnectionFactory.createConnection(conf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeConn(){
		try {
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//创建表
	public void createTable(String tableName,String[] family,int num) { 
        try { 
            Admin admin = conn.getAdmin();
            //表存在则删除
            if(admin.tableExists(TableName.valueOf(tableName))){
            	deleteTable(tableName);
            }
            //设置表名
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));// 代表表的schema 
            //添加列族
            for (String strF : family) {
				tableDescriptor.addFamily(new HColumnDescriptor(strF));
			}
            admin.createTable(tableDescriptor); 
            System.out.println("表已创建"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
    //删除表
    public void deleteTable(String tableName){
    	try {
			Admin admin=conn.getAdmin();
			admin.disableTable(TableName.valueOf(tableName));
			admin.deleteTable(TableName.valueOf(tableName));
			System.out.println("表已删除"); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    //获取表
    public Table getTable(String tableName){
    	try {
			return conn.getTable(TableName.valueOf(tableName));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }
    //获取ID 使行键自增
	public Long getId(String tableName, String family, String qualifier) {

		Table table = getTable(tableName);
		try {
			return table.incrementColumnValue(Bytes.toBytes(ConstantsHBase.ROW_KEY_GID_ACTIVITY_ID), Bytes.toBytes(family), Bytes.toBytes(qualifier), 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0l;
	}
	
}

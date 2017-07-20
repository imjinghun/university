package com.jing.hadoop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

public class HadoopAPIDemo {
	FileSystem fileSystem;
	@Before
	public void init() throws IOException, URISyntaxException {
		//解析hadoop的配置文件，xxx-site.xml
		Configuration conf = new Configuration();
		fileSystem = FileSystem.newInstance(new URI("hdfs://jing:9000"), conf);
	}
	
	@Test
	public void list() throws FileNotFoundException, IllegalArgumentException, IOException {
		FileStatus[] filesStatuses  = fileSystem.listStatus(new Path("/"));
		for(FileStatus filesStatus : filesStatuses) {
			System.out.println(filesStatus);
		}
	}
	
	//创建文件或目录
	@Test
	public void testMkdir() throws Exception {
		/*
		 * 如果向HDFS写数据，需要有相应的权限
		 * 1.给HDFS的根目录/赋予普通用户权限
		 * 2.修改hdfs-site.xml文件，把权限检查给关闭
		 * 3.执行的时候，伪造hadoop用户
		 * 	-DHADOOP_USER_NAME=hadoop
		 */
		boolean result = fileSystem.mkdirs(new Path("/aa/bb"));
		System.out.println(result);
		
	}
	//删除文件或目录
	@Test
	public void testRMdir() throws IllegalArgumentException, IOException{
		boolean result=fileSystem.delete(new Path("/aa"));
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		//解析hadoop的配置文件，xxx-site.xml
		Configuration conf = new Configuration();
		try {
			/**
			 * 默认情况下，读取的是本机的文件。如果想读取HDFS的文件，需要设置下协议
			 * FileSystem支持很多种的文件系统的读取，如HDFS，本机，FTP等
			 * 
			 */
			FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://jing:9000"), conf);
			System.out.print(fileSystem);
			/*
			 * HDFS的协议在core-site.xml文件中进行设置
			 */
			Path path = new Path("/NOTICE.txt");
			FSDataInputStream inputStream = fileSystem.open(path);
			/*int c;
			while((c=inputStream.read())!=-1) {
				System.out.print((char)c);
			}*/
			IOUtils.copy(inputStream, System.out);
			
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

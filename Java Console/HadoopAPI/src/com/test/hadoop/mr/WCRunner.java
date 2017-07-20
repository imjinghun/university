package com.test.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class WCRunner {

	public static void main(String[] args) {
		
		try {
			Job job = new Job();
			
			job.setMapperClass(WCMapper.class);
			job.setReducerClass(WCReducer.class);
			
			//在map阶段执行一次reduce，减少中间数据的产生
			job.setCombinerClass(WCReducer.class);
			
			//f:/user/hdfs/input
			//f:/user/hdfs/output
			FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
//			FileInputFormat.setInputPaths(job, new Path("hdfs://hadoop:9000/wc/input"));
//			FileOutputFormat.setOutputPath(job, new Path("hdfs://hadoop:9000/wc/output4"));
			
			job.setJarByClass(WCRunner.class);
			//map輸出的數據類型
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(LongWritable.class);
			//reduce輸出的數據類型
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(LongWritable.class);
			//設置reduce的數量
			//job.setNumReduceTasks(2);
			//運行job
			job.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

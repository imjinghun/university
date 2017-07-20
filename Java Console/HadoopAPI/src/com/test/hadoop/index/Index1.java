package com.test.hadoop.index;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Index1 {

	public static void main(String[] args) {
		try {
			Job job = new Job();
			
			job.setMapperClass(Index1Mapper.class);
			job.setReducerClass(Index1Reducer.class);
			
			FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			job.setJarByClass(Index1.class);
			//map輸出的數據類型，如果map的输出和reduce的输出数据类型一致，map的输出可以不设置
			/*job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(LongWritable.class);*/
			//reduce輸出的數據類型
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(LongWritable.class);
			//運行job
			job.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Index1Mapper extends Mapper<LongWritable, Text, Text, LongWritable> {
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] words = line.split(" ");
		
		String fileName=((FileSplit)context.getInputSplit()).getPath().getName();
		
		for (String string : words) {
			if(string!=null&&string.length()>0) {
				context.write(new Text(string+"\t"+fileName), new LongWritable(1));
			}
		}
		
	}
}
class Index1Reducer extends Reducer<Text, LongWritable, Text, LongWritable> {
	@Override
	protected void reduce(Text key, Iterable<LongWritable> values,
			Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
		long sum = 0;
		for (LongWritable value : values) {
			sum += value.get();
		}
		context.write(key, new LongWritable(sum));
	}
}


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

public class Index2 {

	public static void main(String[] args) {
		try {
			Job job = new Job();
			
			job.setMapperClass(Index2Mapper.class);
			job.setReducerClass(Index2Reducer.class);
			
			FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			job.setJarByClass(Index2.class);
			//map輸出的數據類型，如果map的输出和reduce的输出数据类型一致，map的输出可以不设置
			/*job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(LongWritable.class);*/
			//reduce輸出的數據類型
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			//運行job
			job.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Index2Mapper extends Mapper<LongWritable, Text, Text, Text> {
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] words = line.split("\t");
		
		if(words!=null&&words.length==3) {
			context.write(new Text(words[0]), new Text(words[1]+"--"+words[2]));
		}
	}
}
class Index2Reducer extends Reducer<Text, Text, Text, Text> {
	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		String str = "";
		for (Text value : values) {
			if(str.length()>0) {
				str += ",";
			}
			str += value;
		}
		context.write(key, new Text(str));
	}
}


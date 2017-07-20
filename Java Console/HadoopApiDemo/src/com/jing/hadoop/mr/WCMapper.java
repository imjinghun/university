package com.jing.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable>{

	protected void map(LongWritable key, Text value, 
            Context context) throws IOException, InterruptedException {
		//把value切分为单词，写出去
		String line = value.toString();
		String[] words = line.split(" ");
		for(String word : words) {
			//把key，value写出
			context.write(new Text(word), new LongWritable(1));
		}
	}
}

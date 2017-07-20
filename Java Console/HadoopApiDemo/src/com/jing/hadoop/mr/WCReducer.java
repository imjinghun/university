package com.jing.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * hadoop2  org.apache.hadoop.mapreduce.* 类
 * hadoop1 org.apache.hadoop.mapred 接口
 * @author Administrator
 *
 */
public class WCReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
	protected void reduce(Text key, Iterable<LongWritable> values, Context context
            ) throws IOException, InterruptedException {
		
		long count = 0l;
		for(LongWritable value: values) {
			count += value.get();
		}
		context.write(key, new LongWritable(count));
	}
}

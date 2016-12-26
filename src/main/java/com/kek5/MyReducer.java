package com.kek5;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Arrays;

public class MyReducer extends Reducer<Text, IntWritable,
        Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int i = 0;
        for(IntWritable val : values) {
            i += val.get();
        }
        byte[] patientId = Arrays.copyOfRange(key.copyBytes(), 0, 16);
        context.write(new Text(com.lits.kundera.test.Util.toString(patientId, patientId.length)), new IntWritable(i));
    }
}

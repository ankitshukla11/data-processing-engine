package com.nagarro.spark.sparkApplication;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

public class TestSpark {
	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkContextCreator.getJavaSparkContext();
		List<String> list = Arrays.asList("abc", "d", "fd", "sadsa");
		JavaRDD<String> distData = javaSparkContext.parallelize(list);

		JavaRDD<Integer> linesRDD = distData
				.map(new Function<String, Integer>() {
					@Override
					public Integer call(String v1) throws Exception {
						return v1.length();
					}
				});

		int totalLength = linesRDD
				.reduce(new Function2<Integer, Integer, Integer>() {
					@Override
					public Integer call(Integer v1, Integer v2)
							throws Exception {
						return v1 + v2;
					}
				});

		System.out.println(totalLength);
	}
}

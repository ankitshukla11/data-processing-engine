package com.nagarro.spark.sparkApplication;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ApacheSparkGroupByExample {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkContextCreator.getJavaSparkContext();
		System.out.println(javaSparkContext.appName());
	        
	        // Parallelized with 2 partitions
	        JavaRDD<String> rddX = javaSparkContext.parallelize(
	                Arrays.asList("Joseph", "Jimmy", "Tina",
	                        "Thomas", "James", "Cory",
	                        "Christine", "Jackeline", "Juan"), 3);
	        
	        JavaPairRDD<Character, Iterable<String>> rddY = rddX.groupBy(word -> word.charAt(0));
	        
	        System.out.println(rddY.collect());
	}

}

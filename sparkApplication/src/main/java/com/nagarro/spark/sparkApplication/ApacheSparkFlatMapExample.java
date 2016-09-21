package com.nagarro.spark.sparkApplication;

import java.util.Arrays;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ApacheSparkFlatMapExample {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkContextCreator.getJavaSparkContext();
		JavaRDD<String> rddX = javaSparkContext.parallelize(Arrays.asList("java spark example","sample example"));
		
		System.out.println(rddX.flatMap(element->Arrays.asList(element.split(" "))).collect());
		javaSparkContext.close();
	}

}

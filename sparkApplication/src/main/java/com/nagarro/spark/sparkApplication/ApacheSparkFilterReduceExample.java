package com.nagarro.spark.sparkApplication;

import java.util.Arrays;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ApacheSparkFilterReduceExample {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkContextCreator.getJavaSparkContext();
		JavaRDD<Integer> x = javaSparkContext.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9));
		JavaRDD<Integer> y = x.filter(element->element%2==0);
		System.out.println("list after filtering: "+ y.collect());
		
		int filteredValuesSum = y.reduce((sum,element)->sum+element);
		System.out.println("Filtered Values Sum is: "+ filteredValuesSum);
		javaSparkContext.close();
	}

}

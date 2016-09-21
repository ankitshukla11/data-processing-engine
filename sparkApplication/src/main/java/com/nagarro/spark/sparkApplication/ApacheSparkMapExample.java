package com.nagarro.spark.sparkApplication;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class ApacheSparkMapExample {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkContextCreator.getJavaSparkContext();
		JavaRDD<String> x = javaSparkContext.parallelize(Arrays.asList("spark", "rdd", "example", "sample", "example"));
		
		 // Word Count Map Example
   /*     JavaRDD<Tuple2<String, Integer>> y1 = x.map(e -> new Tuple2<>(e, 1));
        List<Tuple2<String, Integer>> list1 = y1.collect();
        System.out.println(list1);*/
		
		JavaRDD<Integer> y = x.map(name->name.length());
		System.out.println(y.collect());
		javaSparkContext.close();
	}

}

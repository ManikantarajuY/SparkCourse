package com.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object word_count {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder().master("local").appName("Word Count").getOrCreate()

    val data = spark.sparkContext.textFile("C:\\Users\\91843\\Desktop\\Intro.txt")
    val words = data.flatMap(x => x.split(" ")).map(x=>(x,1)).reduceByKey((a,b) => a+b)
   words.collect().foreach(println)
  }
}

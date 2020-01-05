package com.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object sort_withoutMerge {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder().master("local").appName("Collapsing_records to Data Marts").getOrCreate()

    val x =List(1,3,5,7,9,11)
    val y =List(2,4,6,8,10,12)
    val z =x.union(y)
    println(z.sorted)

    val a = List("c","c","p","m","t")
    val b = List("c","m","k")

    println(a.intersect(b))
    println(a.union(b))
  }

}

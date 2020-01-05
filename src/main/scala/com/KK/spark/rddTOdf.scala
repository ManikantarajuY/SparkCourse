package com.KK.spark

import org.apache.spark.sql.SparkSession

object rddTOdf {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("RDD to DF").getOrCreate()

  }

}

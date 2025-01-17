package com.scala.traits

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

  trait SparkSessionWrapper extends Serializable {

    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    lazy val spark: SparkSession = {
      SparkSession.builder().master("local").appName("spark session").getOrCreate()
    }
}

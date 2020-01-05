package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object window_fun {
  Logger.getLogger("org").setLevel(Level.OFF)

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder().master("local").appName("Window Functions").getOrCreate()

    import spark.implicits._
    val data = spark.read.option("header", true).option("inferSchema", true)
      .csv("src/resource/csv/userdata1.csv")

    data.show()
    data.filter($"country".equalTo("Paraguay")).show()
    data.withColumn("gender",when(col("gender") === "Male","M").otherwise("F"))
      .show()
    val win = Window.partitionBy($"country").orderBy($"country".desc)
    val win_fun = data
      .withColumn("rank",rank().over(win))
      .withColumn("dens_ranked",dense_rank().over(win))
      .withColumn("Row_rank", row_number().over(win))
    win_fun.show()
//    val ranked = data.withColumn("rank",rank().over(win))
//    val dens_ranked  = data.withColumn("dens_ranked",dense_rank().over(win))
//    val row_num = data.withColumn("Row_rank", row_number().over(win))
//    row_num.show()
//    dens_ranked.show()
//    ranked.show()

//    data.filter("gender".equals("Male")).distinct().groupBy("country").count().show()
  }

}

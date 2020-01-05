package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.storage.StorageLevel

object sql_fun {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder().master("local").appName("SQL functions").getOrCreate()

    import spark.implicits._
    val dataset = Seq(
      ("Thin",       "cell phone", 6000),
      ("Normal",     "tablet",     1500),
      ("Mini",       "tablet",     5500),
      ("Ultra thin", "cell phone", 5000),
      ("Very thin",  "cell phone", 6000),
      ("Big",        "tablet",     2500),
      ("Bendable",   "cell phone", 3000),
      ("Foldable",   "cell phone", 3000),
      ("Pro",        "tablet",     4500),
      ("Pro2",       "tablet",     6500))
      .toDF("product", "category", "revenue")
    dataset.repartition(3)
    dataset.filter($"category".equalTo("tablet")).persist(StorageLevel.NONE)
    val win = Window.partitionBy("category").orderBy("revenue")
    val ranks = dataset
      .withColumn("ranked",rank().over(win))
      .withColumn("dens_ranked",dense_rank().over(win))
      .withColumn("row_rank",row_number().over(win))
      .withColumn("per_rank",percent_rank().over(win))
        .withColumn("Literal",lit("Hii"))
//      .withColumn("ntile_rank",ntile(0).over(win))
    ranks.show()
    dataset.groupBy("category").agg(count("*")as "total").show()
    dataset.withColumn("struct",struct("product","revenue"))
      .groupBy($"category")
      .agg(collect_list("struct")as "structs").show(false)
    /*when we pass FALSE in show then it will display all the fields present in Struct*/
  }

}

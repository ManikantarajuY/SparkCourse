package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Collapsing_records {

  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder().master("local").appName("Collapsing_records to Data Marts").getOrCreate()

    import spark.implicits._
    val playersDF = Seq(
      ("123", 11, "20180102", 0),
      ("123", 11, "20180102", 0),
      ("123", 13, "20180105", 3),
      ("555", 11, "20180214", 1),
      ("888", 22, "20180214", 2)
    ).toDF("player_id", "game_id", "game_date", "goals_scored")

    playersDF.show()

    playersDF.withColumn("as_struct",struct("game_id","game_date","goals_scored"))
      .groupBy("player_id")
      .agg(collect_list("as_struct")as "structs")
      .sort("player_id")
      .show(false)
  }
}

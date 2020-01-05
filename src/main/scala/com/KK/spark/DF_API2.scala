package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DF_API2 {

  Logger.getLogger("org").setLevel(Level.OFF)

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder().master("local").appName("Things can be done Using DF APIS").getOrCreate()

    import spark.implicits._
    val data = spark.read.option("header", true).option("inferSchema", true)
      .csv("src/resource/csv/userdata1.csv")

    println("This will give new column with true or false")
    data.withColumn(".com",$"email".endsWith(".com")).orderBy("country").show()

    println("Creates new Column with T/F in order by ")
    data.orderBy("country").withColumn("India",$"country".contains("India")).show()

    println("Creates new Column with existing column data using Substring we can use length/size")
    val time = data.
      withColumn("time",$"registration_dttm".substr(11,"registration_dttm".length))
    time.show()

    println("Bonus in new column with the help of Operations")
    val bonus = data.withColumn("Bonus",$"salary"/7)
    bonus.show()

    println("checking NULL or NOt in new column")
    val nulll = data.withColumn("IS_Null",$"birthdate".isNull)
    nulll.show()

    println("Fetching Not null Values from single column ")
    data.filter(($"comments").isNotNull).show()
    println("fetching Not Null records from multiple columns")
    data.filter($"comments".isNotNull || $"cc".isNotNull).show()
    data.filter($"comments".isNotNull && $"cc".isNotNull).show()
    data.groupBy("country").agg(collect_list("gender")).show()
    println("Using Sort Array")
    data.groupBy("country").agg(sort_array(collect_list("gender"))).show()
    println("Fetching columns in Array Set Asked in PEGA Interview")
    data.withColumn("List_col",struct("gender","country")).orderBy("title")
      .groupBy("title")
      .agg(collect_set("List_col") as "as_structs")
      .show(false)
    /*if it is true it doesn't show complete Struct type, if it is false it shows complete Struct*/

  }
}
/*
data.withColumn("as_struct", struct("game_id", "game_date", "goals_scored"))
         .groupBy("player_id")
          .agg(collect_set("as_struct") as "as_structs")
         .show(false)
data.withColumn("newCol", collect_list(struct("age","id","name")).over(Window.partitionBy("age").orderBy("id")))
*/

package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object win_f3 {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
//    val input = args(0)
    val spark = SparkSession
      .builder().master("local").appName("Window Functions").getOrCreate()

    import spark.implicits._
    val data = spark.read.option("delimiter","\t").option("header",true).option("inferSchema",true)
      .csv("src/resource/ls2014.tsv")

    println("Changing Column Name with column renamed")
//    val df = data.withColumnRenamed("sex","gender")
    println("Condition Statements")
//    val gender_change = df.withColumn("gender",when($"gender"==="M","Male")
//        .when($"gender" === "F","Female").when($"gender" === "O","Others")
//      .otherwise("Null"))
//    gender_change.show()
    println("Getting Unique records")
//    gender_change.select($"gender").distinct().show()
    println("Condition Statements")
//    val age_type = df.withColumn("age_type",when($"age" >=30 and $"age" <= 39 ,"Young")
//      .when($"age" >=40 && $"age" <= 49,"Best")
//      .when($"age" >=50 && $"age" <= 60,"Gold")
//      .otherwise("Roll_models"))
//    age_type.show()
    println("Fetching Data in Array Format with the help of 'agg(struct(collect_list/collect_set))' ")
//    val set_list = data.groupBy($"constituency").agg(struct(collect_set($"partyname"))as "parties_list").orderBy($"constituency")
//    val list = data.groupBy($"constituency").agg(collect_list($"partyname")as "parties_set").orderBy($"constituency")
//    set_list.show(false)
//    list.show(false)/*find the diff btw with struct and without struct*/

    println("Window Functions using with Column")
//    val win  = Window.partitionBy($"category").orderBy("partyname")
//    val randed = data.withColumn("rank",rank().over(win))
//    val dens_randed = data.withColumn("den_rank",dense_rank().over(win))
//    val row_randed = data.withColumn("row_rank",row_number().over(win))
//    randed.show()
//    dens_randed.show()
//    row_randed.show()
//
    println("Window Functions in Multiple Columns in a single Table using with Column")
//    val all_ranks = data
//      .withColumn("rank",rank().over(win))
//      .withColumn("den_rank",dense_rank().over(win))
//      .withColumn("row_rank",row_number().over(win))
//    all_ranks.show()
    println("Changing data Type using caste with the help of with column")
    data.withColumn("age",$"age".cast("Float")).show()

  }

}

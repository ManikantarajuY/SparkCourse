package com.KK.spark

import com.KK.spark.sparkSession.spark
import com.scala.traits.SparkSessionWrapper

object nth_HighestValue extends SparkSessionWrapper{
  /*
  select * from ( select e.*, row_number() over (order by salary desc) as row_num from Employee e )
   where row_num = 2;
   */

  def main(args: Array[String]): Unit = {
    import spark.implicits._
    val data = spark.read.option("header", true)
      .option("sep", "\t")
      .option("inferSchema", true)
      .csv("src/resource/ls2014.tsv")
    data.show()

    val t = data.createTempView("table")
    val nth = spark.sqlContext.sql("select *(select table.*, dense_rank() over(partition by postal order by partysymbol desc)as hig from table)where hig == 2")
    nth.show()

  }

}

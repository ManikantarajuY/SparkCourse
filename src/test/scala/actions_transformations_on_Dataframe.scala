import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object actions_transformations_on_Dataframe {
  Logger.getLogger("org").setLevel(Level.OFF)

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Actions & Transformation In DF")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    val df_data = spark.read.option("header",true).option("inferSchema",true)
      .csv("src/resource/csv/userdata1.csv")

    println("Fetching Schema")
    df_data.printSchema()

    println("Data Shown")
    df_data.show(3)

    println("Column names")
    df_data.columns.foreach(println)

    println("Select Columns")
    df_data.select($"last_name",$"email").show(3)

    println("Filter Condition")
    df_data.filter($"gender".equalTo("Male")).show(3)

  }

}

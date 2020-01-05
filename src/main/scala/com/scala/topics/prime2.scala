package com.scala.topics

object prime2 {
  def main(args: Array[String]): Unit = {
    println("enter range value")
    val r = scala.io.StdIn.readInt()
    for (p <-2 to r by 1){
      var c:Int = 0
      for (i <- 2 to p/2 by 1) {
        if (p % i == 0)
          c = c + 1
      }
        if(c==0)
          print("\t"+p)
      }
  }
}

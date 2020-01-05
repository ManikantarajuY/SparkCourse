package com.scala.KK.classes.Loops

object fibonacci {
  def main(args: Array[String]): Unit = {

    def fib (range:Int):Unit={
      var i = 0
      var j =1
      while (i+j <= range) {
        var res = i + j
        print("result is " + res)
        j = res
        i = j

      }
    }
  }

}

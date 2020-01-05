package com.scala.topics

object fib2 {
  def main(args: Array[String]): Unit = {
    def cache = scala.collection.mutable.Map[Int, Int]()
    def nthFibonacci(n: Int): Int = {
      // value cannot be negative
      if (n < 1)
        throw new RuntimeException

      // check if it already exist in the cache and return it
      if (cache.contains(n)) {
        return cache(n)
      }

      // if it doesnt exist yet, calculate it
      else {
        var retValue: Int = 0
        if (n == 1 || n == 2) {
          retValue = n
        } else {
          retValue = nthFibonacci(n - 1) + nthFibonacci(n - 2)
        }

        // update the cache
        cache(n) = retValue

        return retValue
      }
    }
  }

}

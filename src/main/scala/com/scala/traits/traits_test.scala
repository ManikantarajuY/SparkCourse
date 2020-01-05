package com.scala.traits

object traits_test {
  def main(args: Array[String]): Unit = {
    val obj = new developer
    obj.greetings
    obj.hello

    val obj_deg = new deginer
    obj_deg.div
    obj_deg.mul
  }

}

/*
Traits:-
1.Trairt is the keyword which is used for the class name.
2.Methods which are present in Trait class, all the methods must be implemented in the inherated classes.
3.we can inherate multiple traits for a class by using keyword extends and WITH.
4.we can have methods with and with out implementation in traits.
	if we have methods with implementation in traits class that can be override in a class with the key word OVERRIDE
 */

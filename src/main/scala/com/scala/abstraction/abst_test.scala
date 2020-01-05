package com.scala.abstraction

object abst_test {
  def main(args: Array[String]): Unit = {
    val obj = new deginer
    obj.name
    obj.age
    obj.job
    obj.status

    val obj1 = new developer
    obj1.name
    obj1.age
    obj1.job
    obj1.status
  }

}
/*Abstraction:-
1.Methods which are present in Abstract class, all the methods must be implemented in the inherated classes.
2.we can have methods with and with out implementation in traits.
3.we can not extend more than a class,
	this is the main diff b/w Traits and Abstract class.
4.if we have methods with implementation in traits class that can be override in a class with the key word OVERRIDE
	the result will be displayed from the parent class.
*If we want the result from the child class we should not have the implementation in parent class.*/
package com.scala.abstraction

abstract class abst_class {
  def name
  def age
  def job
  def status: Unit ={
    println("Parent Class")
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
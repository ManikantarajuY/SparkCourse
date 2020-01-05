package com.scala.abstraction

 class deginer extends abst_class {
  def name: Unit ={
    println("My name is Raju")
  }
  def age: Unit ={
    println("i am going to turn 29 this 2020")
  }
  def job: Unit ={
    println("I am s/w engg")
  }
  override def status: Unit ={
    println("Child Class")
  }

}

/*Abstraction:-
1.Methods which are present in Abstract class, all the methods must be implemented in the inherited classes.
2.we can have methods with and with out implementation in traits.
3.we can not extend more than a class,
	this is the main diff b/w Traits and Abstract class.
4.if we have methods with implementation in traits class that can be override in a class with the key word OVERRIDE
	the result will be displayed from the child class.
*If we want the result from the parent class we should not have the implementation in parent class.*/
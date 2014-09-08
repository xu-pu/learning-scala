package com.learningscala

object ScalaApp {

  def main(args: Array[String]){
    helloworld()
    complexVariableTest()
  }

  def helloworld(): Unit ={
    println("HelloWorld!")
  }

  def complexVariableTest(): Unit ={
    val cv1 = new Complex(1,1)
    println(cv1)
  }

}

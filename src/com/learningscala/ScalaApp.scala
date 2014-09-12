package com.learningscala

object ScalaApp {

  def main(args: Array[String]){
    helloworld()
    complexVariableTest()
    treeTest()
  }

  def helloworld(): Unit ={
    println("HelloWorld!")
  }

  def complexVariableTest(): Unit ={
    val cv1 = new Complex(1,1)
    println(cv1)
  }

  def arrayTest(): Unit ={
    val myarray = Array(6, 3, 4, 5, 6)
    val mapped = myarray.map(x => x + 3)
    val filtered = mapped.filter(x => x < 5)
    filtered
    val myrange = Array.range(10,20)
  }

  def treeTest(): Unit ={
    val mytree =
      Node(
        Node(
          Leaf(1),
          Leaf(1)
        ),
        Node(
          Leaf(1),
          Leaf(1)
        )
      )
    println(mytree.left)
  }

}

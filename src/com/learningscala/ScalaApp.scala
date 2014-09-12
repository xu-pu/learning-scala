package com.learningscala

object ScalaApp {

  def main(args: Array[String]){
    helloworld()
    complexVariableTest()
    treeTest()
  }

  def helloworld() = println("HelloWorld!")

  def complexVariableTest() = {
    val cv1 = new Complex(1,1)
    println(cv1)
  }

  def arrayTest(): Unit ={
    val myarray = Array(6, 3, 4, 5, 6)
    val mapped = myarray.map(x => x + 3)
    val filtered = mapped.filter(x => x < 5)
    val myrange = (1 to 20).map(x => x + 1)
    myrange
  }

  def treeTest() = {
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

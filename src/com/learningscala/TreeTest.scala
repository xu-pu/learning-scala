package com.learningscala

abstract class Tree()
case class Node(left: Tree, right: Tree) extends Tree
case class Leaf(value: Double) extends Tree

object TreeTest {

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

package com.learningscala


abstract class Tree()
case class Node(left: Tree, right: Tree) extends Tree
case class Leaf(value: Double) extends Tree


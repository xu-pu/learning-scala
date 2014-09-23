package com.learningscala

object CollectionTest {

  def arrayTest() = {
    val myarray = Array(6, 3, 4, 5, 6)
    val mapped = myarray.map(x => x + 3)
    val filtered = mapped.filter(x => x < 5)
    val myrange = (1 to 20).map(x => x + 1)
    myrange
  }

}

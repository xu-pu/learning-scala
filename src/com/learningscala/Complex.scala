package com.learningscala

class Complex (real: Double, imaginary: Double){

  def re = real
  def im = imaginary
  def modulus = real*real+imaginary*imaginary
  override def toString = real + "+" + imaginary + "i"

}

package com.adventofcode

import java.io.InputStream

/**
 * Created by mcastro on 25-04-2016.
 */
class DayTwo {
  def partOne(dimensions: String): Int = {
    val l = dimensions.split("x")(0).toInt
    val w = dimensions.split("x")(1).toInt
    val h = dimensions.split("x")(2).toInt
    val side1 = l * w
    val side2 = w * h
    val side3 = h * l

    2*side1 + 2*side2 + 2*side3 + List(side1, side2, side3).min
  }
}

object DayTwo {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DayTwoInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines

  def main(args: Array[String]): Unit = {
    val dayTwo = new DayTwo
    println("--- Day 2: I Was Told There Would Be No Math ---")
    val result = (for(line <- input) yield {dayTwo.partOne(line)}).foldLeft(0)((a,b) => a+b)
    println("Answer to Part One is: " + result)
  }
}

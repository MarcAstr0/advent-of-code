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

  def partTwo(dimensions: String): Int = {
    val l = dimensions.split("x")(0).toInt
    val w = dimensions.split("x")(1).toInt
    val h = dimensions.split("x")(2).toInt

    val ribbon = (List(l,w,h) diff List(List(l,w,h).max)).map(x => 2*x).foldLeft(0)((a,b) => a+b)
    val bow = List(l,w,h).foldLeft(1)((a,b) => a*b)

    ribbon + bow
  }
}

object DayTwo {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DayTwoInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines

  def main(args: Array[String]): Unit = {
    val dayTwo = new DayTwo
    println("--- Day 2: I Was Told There Would Be No Math ---")
    val inputList = (for(line <- input) yield line).toList
    val resultP1 = inputList.map(x => dayTwo.partOne(x)).foldLeft(0)((a,b) => a+b)
    println("Answer to Part One is: " + resultP1)
    val resultP2 = inputList.map(x => dayTwo.partTwo(x)).foldLeft(0)((a,b) => a+b)
    println("Answer to Part Two is: " + resultP2)
  }
}

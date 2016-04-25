package com.adventofcode

import java.io.InputStream
import scala.annotation.tailrec

/**
 * Created by mcastro on 04-04-2016.
 */
class DayOne {
  def partOne(input:String): Int = {
    input.toList.map{
      case '(' => 1
      case ')' => -1
    }.foldLeft(0)((a,b) => a+b)
  }

  def partTwo(input:String): Int = {
    @tailrec
    def partTwoRec(in: List[Int], acc: (Int, Int)): Int = {
      if (acc._1 + in.head == -1) acc._2
      else partTwoRec(in.tail, (acc._1 + in.head, acc._2 + 1))
    }
    partTwoRec(input.toList.map{
      case '(' => 1
      case ')' => -1}, (0, 1))
  }
}

object DayOne {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DayOneInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines.mkString

  def main(args: Array[String]): Unit = {
    val dayOne = new DayOne
    println("--- Day 1: Not Quite Lisp ---")
    println("Answer to Part One is: " + dayOne.partOne(input))
    println("Answer to Part Two is: " + dayOne.partTwo(input))
  }
}

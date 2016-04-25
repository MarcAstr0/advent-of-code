package com.adventofcode

import java.io.InputStream

import scala.annotation.tailrec

/**
 * Created by mcastro on 25-04-2016.
 */
class DayThree {
  def move(direction: Char, position: (Int, Int)): (Int, Int) = {
    direction match {
      case '^' => (position._1, position._2 + 1) // North
      case 'v' => (position._1, position._2 - 1) // South
      case '>' => (position._1 + 1, position._2) // East
      case '<' => (position._1 - 1, position._2) // West
      case _ => position
    }
  }

  def partOne(input: String): Int = {
    val visited = List((0,0))
    @tailrec
    def partOneRec(input: List[Char], visited: List[(Int, Int)], current: (Int, Int), acc: Int): Int = {
      if (input.length == 0) acc
      else {
        val newPos = move(input.head, current)
        if (visited.contains(newPos))
          partOneRec(input.tail, visited, newPos, acc)
        else
          partOneRec(input.tail, visited ++ List(newPos), newPos, acc + 1)
      }
    }
    partOneRec(input.toList, visited, visited(0), 1)
  }
}

object DayThree {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DayThreeInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines.mkString

  def main(args: Array[String]): Unit = {
    val dayThree = new DayThree
    println("--- Day 3: Perfectly Spherical Houses in a Vacuum ---")
    println("Answer to Part One is: " + dayThree.partOne(input))
  }
}
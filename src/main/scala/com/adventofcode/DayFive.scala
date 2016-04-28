package com.adventofcode

import scala.annotation.tailrec
import java.io.InputStream

/**
 * Created by mcastro on 28-04-2016.
 */
class DayFive {
  def partOne(string: String): Boolean = {
    hasAtLeast3Vowels(string) && hasDoubleLetter(string) && !containsSpecialStrings(string)
  }

  def hasAtLeast3Vowels(string: String): Boolean = {
    val vowels = List('a', 'e', 'i', 'o', 'u')
    if (vowels.map(v => string.toList.count(_ == v)).foldLeft(0)((a,b) => a+b) >= 3) true else false
  }

  @tailrec
  final def hasDoubleLetter(string: String): Boolean = {
    if (string == "" || string.length == 1) false
    else {
      if (string.toList.head == string.toList.tail.head)
        true
      else hasDoubleLetter(string.drop(1))
    }
  }

  def containsSpecialStrings(string: String): Boolean = {
    val pattern = "(ab)|(cd)|(pq)|(xy)".r
    pattern.findFirstIn(string) match {
      case None => false
      case _ => true
    }
  }
}

object DayFive {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DayFiveInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines

  def main(args: Array[String]): Unit = {
    val dayFive = new DayFive
    println("--- Day 5: Doesn't He Have Intern-Elves For This? ---")
    val inputList = (for(line <- input) yield line).toList
    val result = inputList.map(x => dayFive.partOne(x)).map(x => if (x) 1 else 0).foldLeft(0)((a,b) => a+b)
    println("Answer to Part One is: " + result)
  }
}

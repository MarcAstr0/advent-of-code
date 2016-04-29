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

  def partTwo(string: String): Boolean = {
    hasPairAtLeastTwice(string) && hasRepeatedLetter(string)
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

  def hasPairAtLeastTwice(string: String): Boolean = {
    val repeatedPairs = for {
      (letter, index) <- string.toList.zipWithIndex
      if (index + 1 < string.length && string.replace(letter.toString + string(index + 1), "").length == string.length - 4)
    } yield letter.toString + string(index + 1)
    if (repeatedPairs.distinct.length > 0) true else false
  }

  def hasRepeatedLetter(string: String): Boolean = {
    val repeatedLetters = for {
      (letter, index) <- string.toList.zipWithIndex
      if (index + 2 < string.length && letter == string(index + 2))
    } yield letter
    if (repeatedLetters.distinct.length > 0) true else false
  }
}

object DayFive {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DayFiveInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines

  def main(args: Array[String]): Unit = {
    val dayFive = new DayFive
    println("--- Day 5: Doesn't He Have Intern-Elves For This? ---")
    val inputList = (for(line <- input) yield line).toList
    val resultP1 = inputList.map(x => dayFive.partOne(x)).map(x => if (x) 1 else 0).foldLeft(0)((a,b) => a+b)
    println("Answer to Part One is: " + resultP1)
    val resultP2 = inputList.map(x => dayFive.partTwo(x)).map(x => if (x) 1 else 0).foldLeft(0)((a,b) => a+b)
    println("Answer to Part Two is: " + resultP2)
  }
}

package com.adventofcode

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
  	0
  }
}

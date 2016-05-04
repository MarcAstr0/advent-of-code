package com.adventofcode

import scala.annotation.tailrec

/**
 * Created by mcastro on 04-05-2016.
 */
class DaySeven {
  val MaxShort = 65535

  def executeInstruction(instruction: String): (String, Int) = {
    val parsed = instruction.split(" ").toList
    val result = parsed match {
      case List(v: String, "->", k: String) => (k, v.toInt)
      case List(x: String, op, y: String, "->", k: String) => {
        op match {
          case "AND" => (k, x.toInt & y.toInt)
          case "OR" => (k, x.toInt | y.toInt)
          case "LSHIFT" => (k, x.toInt << y.toInt)
          case "RSHIFT" => (k, x.toInt >> y.toInt)
        }
      }
      case List("NOT", v: String, "->", k: String) => (k, ~(v.toInt))
    }
    (result._1, signed2Unsigned(result._2))
  }

  def signed2Unsigned(n: Int): Int = {
    if (n > 0) n else MaxShort + n + 1
  }

}

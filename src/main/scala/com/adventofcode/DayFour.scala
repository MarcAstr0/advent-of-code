package com.adventofcode

import java.security.MessageDigest
import java.lang.Byte

/**
 * Created by mcastro on 27-04-2016.
 */
class DayFour {
  def partOne(secretKey: String): Int = {
    0
  }

  // Obtained from http://stackoverflow.com/questions/5992778/computing-the-md5-hash-of-a-string-in-scala
  def md5(s: String) = {
    MessageDigest.getInstance("MD5").digest(s.getBytes)
  }

  // Adapted from http://www.jroller.com/thebugslayer/entry/playing_with_bytes_and_hex
  def bytesToHex(bytes : List[Byte]) = {
    bytes.map{ b => String.format("%02X", Byte.valueOf(b)) }.mkString.toLowerCase
  }

}

object DayFour {
  val input = "ckczppom"

  def main(args: Array[String]): Unit = {
    val dayFour = new DayFour
    println("--- Day 4: The Ideal Stocking Stuffer ---")
    println("Answer to Part One is: " + dayFour.partOne(input))
  }
}

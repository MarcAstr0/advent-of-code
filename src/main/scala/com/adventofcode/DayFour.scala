package com.adventofcode

import java.security.MessageDigest

import scala.annotation.tailrec

/**
 * Created by mcastro on 27-04-2016.
 */
class DayFour {
  @tailrec
  final def partOne(secretKey: String, n: Int): Int = {
    // Brute force method
    val md5Hash = bytesToHex(md5(secretKey + n.toString).toList)
    if ((md5Hash take 5) == "00000") n else partOne(secretKey, n + 1)
  }

  @tailrec
  final def partTwo(secretKey: String, n: Int): Int = {
    // Brute force method
    val md5Hash = bytesToHex(md5(secretKey + n.toString).toList)
    if ((md5Hash take 6) == "000000") n else partTwo(secretKey, n + 1)
  }

  // Obtained from http://stackoverflow.com/questions/5992778/computing-the-md5-hash-of-a-string-in-scala
  def md5(s: String) = {
    MessageDigest.getInstance("MD5").digest(s.getBytes)
  }

  // Adapted from http://www.jroller.com/thebugslayer/entry/playing_with_bytes_and_hex
  def bytesToHex(bytes : List[Byte]) = {
    bytes.map{ b => String.format("%02X", java.lang.Byte.valueOf(b)) }.mkString.toLowerCase
  }

}

object DayFour {
  val input = "ckczppom"

  def main(args: Array[String]): Unit = {
    val dayFour = new DayFour
    println("--- Day 4: The Ideal Stocking Stuffer ---")
    println("Answer to Part One is: " + dayFour.partOne(input, 1))
    println("Answer to Part Two is: " + dayFour.partTwo(input, 1))
  }
}

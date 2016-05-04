package com.adventofcode

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by mcastro on 04-05-2016.
 */
class DaySevenSpec extends FlatSpec with Matchers {
  val daySeven = new DaySeven

  "signed2Unsigned()" should "convert signed values to their 16 bit unsigned values" in {
    daySeven.signed2Unsigned(1) shouldEqual 1
    daySeven.signed2Unsigned(-1) shouldEqual 65535
    daySeven.signed2Unsigned(~123) shouldEqual 65412
    daySeven.signed2Unsigned(~456) shouldEqual 65079
  }

  "executeInstruction()" should "execute the given instruction and return a tuple with the variable and its value" in {
    daySeven.executeInstruction("123 -> x") shouldEqual ("x", 123)
    daySeven.executeInstruction("456 -> y") shouldEqual ("y", 456)
    daySeven.executeInstruction("NOT 123 -> h") shouldEqual ("h", 65412)
    daySeven.executeInstruction("NOT 456 -> i") shouldEqual ("i", 65079)
    daySeven.executeInstruction("123 AND 456 -> d") shouldEqual ("d", 72)
    daySeven.executeInstruction("123 OR 456 -> e") shouldEqual ("e", 507)
    daySeven.executeInstruction("123 LSHIFT 2 -> f") shouldEqual ("f", 492)
    daySeven.executeInstruction("456 RSHIFT 2 -> g") shouldEqual ("g", 114)
  }
}

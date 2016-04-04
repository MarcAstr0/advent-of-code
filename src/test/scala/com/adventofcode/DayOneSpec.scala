package com.adventofcode
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by mcastro on 04-04-2016.
 */
class DayOneSpec extends FlatSpec with Matchers {
  val dayOne = new DayOne

  "partOne()" should "calculate the examples correctly" in {
    dayOne.partOne("(())") shouldEqual 0
    dayOne.partOne("()()") shouldEqual 0
    dayOne.partOne("(((") shouldEqual 3
    dayOne.partOne("(()(()(") shouldEqual 3
    dayOne.partOne("))(((((") shouldEqual 3
    dayOne.partOne("())") shouldEqual -1
    dayOne.partOne("))(") shouldEqual -1
    dayOne.partOne(")))") shouldEqual -3
    dayOne.partOne(")())())") shouldEqual -3
  }

  "partTwo()" should "calculate the examples correctly" in {
    dayOne.partTwo(")") shouldEqual 1
    dayOne.partTwo("()())") shouldEqual 5
  }
}

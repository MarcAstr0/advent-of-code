package com.adventofcode

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by mcastro on 25-04-2016.
 */
class DayTwoSpec  extends FlatSpec with Matchers {
  val dayTwo = new DayTwo

  "partOne()" should "calculate the examples correctly" in {
    dayTwo.partOne("2x3x4") shouldEqual 58
    dayTwo.partOne("1x1x10") shouldEqual 43
  }

}

package com.adventofcode

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by mcastro on 27-04-2016.
 */
class DayFourSpec extends FlatSpec with Matchers {
  val dayFour = new DayFour

  "partOne()" should "calculate the examples correctly" in {
    dayFour.partOne("abcdef", 1) shouldEqual 609043
    dayFour.partOne("pqrstuv", 1) shouldEqual 1048970
  }

}

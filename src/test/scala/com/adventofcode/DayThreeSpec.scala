package com.adventofcode

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by mcastro on 25-04-2016.
 */
class DayThreeSpec extends FlatSpec with Matchers {
  val dayThree = new DayThree()

  "partOne()" should "calculate the examples correctly" in {
    dayThree.partOne(">") shouldEqual 2
    dayThree.partOne("^>v<") shouldEqual 4
    dayThree.partOne("^v^v^v^v^v") shouldEqual 2
  }
}

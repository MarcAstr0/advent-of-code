package com.adventofcode

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by mcastro on 28-04-2016.
 */
class DayFiveSpec extends FlatSpec with Matchers {
  val dayFive = new DayFive

  "hasAtLeast3Vowels()" should "return true if string has 3 or more vowels and false if not" in {
    dayFive.hasAtLeast3Vowels("aei") shouldEqual true
    dayFive.hasAtLeast3Vowels("xazegov") shouldEqual true
    dayFive.hasAtLeast3Vowels("aeiouaeiouaeiou") shouldEqual true
    dayFive.hasAtLeast3Vowels("dvszwmarrgswjxmb") shouldEqual false
  }

  "hasDoubleLetter()" should "return true if string has at least letter appear twice in a row" in {
    dayFive.hasDoubleLetter("xx") shouldEqual true
    dayFive.hasDoubleLetter("abcdde") shouldEqual true
    dayFive.hasDoubleLetter("aabbccdd") shouldEqual true
    dayFive.hasDoubleLetter("jchzalrnumimnmhp") shouldEqual false
  }

  "containsSpecialStrings()" should "return true if the string contains \"ab\", \"cd\", \"pq\", or \"xy\"" in {
    dayFive.containsSpecialStrings("ugknbfddgicrmopn") shouldEqual false
    dayFive.containsSpecialStrings("aaa") shouldEqual false
    dayFive.containsSpecialStrings("haegwjzuvuyypxyu") shouldEqual true
  }

  "partOne()" should "calculate the examples correctly" in {
    dayFive.partOne("ugknbfddgicrmopn") shouldEqual true
    dayFive.partOne("aaa") shouldEqual true
    dayFive.partOne("jchzalrnumimnmhp") shouldEqual false
    dayFive.partOne("haegwjzuvuyypxyu") shouldEqual false
    dayFive.partOne("dvszwmarrgswjxmb") shouldEqual false
  }

}

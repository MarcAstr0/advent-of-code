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

  "hasPairAtLeastTwice()" should "return true if the string contains a pair of any two letters that appears at least twice in the string without overlapping" in {
    dayFive.hasPairAtLeastTwice("xyxy") shouldEqual true
    dayFive.hasPairAtLeastTwice("aabcdefgaa") shouldEqual true
    dayFive.hasPairAtLeastTwice("aaa") shouldEqual false
    dayFive.hasPairAtLeastTwice("qjhvhtzxzqqjkmpb") shouldEqual true
    dayFive.hasPairAtLeastTwice("xxyxx") shouldEqual true
    dayFive.hasPairAtLeastTwice("ieodomkazucvgmuy") shouldEqual false
  }

  "hasRepeatedLetter()" should "return true if the string contains at least one letter which repeats with exactly one letter between them" in {
    dayFive.hasRepeatedLetter("xyx") shouldEqual true
    dayFive.hasRepeatedLetter("abcdefeghi") shouldEqual true
    dayFive.hasRepeatedLetter("aaa") shouldEqual true
    dayFive.hasRepeatedLetter("uurcxstgmygtbstg") shouldEqual false
  }

  "partOne()" should "calculate the examples correctly" in {
    dayFive.partOne("ugknbfddgicrmopn") shouldEqual true
    dayFive.partOne("aaa") shouldEqual true
    dayFive.partOne("jchzalrnumimnmhp") shouldEqual false
    dayFive.partOne("haegwjzuvuyypxyu") shouldEqual false
    dayFive.partOne("dvszwmarrgswjxmb") shouldEqual false
  }

  "partTwo()" should "calculate the examples correctly" in {
    dayFive.partTwo("qjhvhtzxzqqjkmpb") shouldEqual true
    dayFive.partTwo("xxyxx") shouldEqual true
    dayFive.partTwo("uurcxstgmygtbstg") shouldEqual false
    dayFive.partTwo("ieodomkazucvgmuy") shouldEqual false
  }

}

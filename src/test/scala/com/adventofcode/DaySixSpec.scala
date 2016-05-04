package com.adventofcode

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by mcastro on 29-04-2016.
 */
class DaySixSpec extends FlatSpec with Matchers {
  val daySix = new DaySix

  "toggle()" should "turn off if light is on, turn on if it's off" in {
    daySix.toggle(daySix.Light(0,0,true)) shouldEqual daySix.Light(0,0,false)
    daySix.toggle(daySix.Light(0,0,false)) shouldEqual daySix.Light(0,0,true)
  }

  "toggle()" should "increase brightness of a BrightLight by 2" in {
    daySix.toggle(daySix.BrightLight(0, 0, 1)) shouldEqual daySix.BrightLight(0, 0, 3)
  }

  "turnOn()" should "turn on the light only if it's off" in {
    daySix.turnOn(daySix.Light(0,0,true)) shouldEqual daySix.Light(0,0,true)
    daySix.turnOn(daySix.Light(0,0,false)) shouldEqual daySix.Light(0,0,true)
  }

  "turnOn()" should "increase brightness of a BrightLight by 1" in {
    daySix.turnOn(daySix.BrightLight(0, 0, 1)) shouldEqual daySix.BrightLight(0, 0, 2)
  }

  "turnOff()" should "turn off the light only if it's on" in {
    daySix.turnOff(daySix.Light(0,0,true)) shouldEqual daySix.Light(0,0,false)
    daySix.turnOff(daySix.Light(0,0,false)) shouldEqual daySix.Light(0,0,false)
  }

  "turnOff()" should "decrease the brightness of a BrightLight by 1 until it reaches 0" in {
    daySix.turnOff(daySix.BrightLight(0,0,2)) shouldEqual daySix.BrightLight(0,0,1)
    daySix.turnOff(daySix.BrightLight(0,0,1)) shouldEqual daySix.BrightLight(0,0,0)
    daySix.turnOff(daySix.BrightLight(0,0,0)) shouldEqual daySix.BrightLight(0,0,0)
  }

  "initializeArray()" should "initialize an array of lights that are turned off" in {
    daySix.initializeArray(1, 1) shouldEqual Array(Array(daySix.Light(0,0, false)))
    daySix.initializeArray(2, 2) shouldEqual Array(Array(daySix.Light(0,0, false), daySix.Light(0,1, false)), Array(daySix.Light(1,0, false), daySix.Light(1,1, false)))
  }

  "initializeBrightArray()" should "initialize an array of lights that have zero brightness" in {
    daySix.initializeBrightArray(1, 1) shouldEqual Array(Array(daySix.BrightLight(0,0, 0)))
    daySix.initializeBrightArray(2, 2) shouldEqual Array(Array(daySix.BrightLight(0,0, 0), daySix.BrightLight(0,1, 0)), Array(daySix.BrightLight(1,0, 0), daySix.BrightLight(1,1, 0)))
  }

  "executeInstruction()" should "apply the instruction to the lights array" in {
    val lights = daySix.initializeArray(2, 2)

    daySix.executeInstruction("turn on 0,0 through 1,1", lights) shouldEqual Array(Array(daySix.Light(0,0, true), daySix.Light(0,1, true)), Array(daySix.Light(1,0, true), daySix.Light(1,1, true)))
    daySix.executeInstruction("turn off 0,1 through 1,1", lights) shouldEqual Array(Array(daySix.Light(0,0, true), daySix.Light(0,1, false)), Array(daySix.Light(1,0, true), daySix.Light(1,1, false)))
    daySix.executeInstruction("toggle 0,0 through 0,1", lights) shouldEqual Array(Array(daySix.Light(0,0, false), daySix.Light(0,1, true)), Array(daySix.Light(1,0, true), daySix.Light(1,1, false)))
  }

  "executeInstruction2()" should "apply the instruction to the lights array" in {
    val lights = daySix.initializeBrightArray(2, 2)

    daySix.executeInstruction2("turn on 0,0 through 1,1", lights) shouldEqual Array(Array(daySix.BrightLight(0,0, 1), daySix.BrightLight(0,1, 1)), Array(daySix.BrightLight(1,0, 1), daySix.BrightLight(1,1, 1)))
    daySix.executeInstruction2("turn off 0,1 through 1,1", lights) shouldEqual Array(Array(daySix.BrightLight(0,0, 1), daySix.BrightLight(0,1, 0)), Array(daySix.BrightLight(1,0, 1), daySix.BrightLight(1,1, 0)))
    daySix.executeInstruction2("toggle 0,0 through 0,1", lights) shouldEqual Array(Array(daySix.BrightLight(0,0, 3), daySix.BrightLight(0,1, 2)), Array(daySix.BrightLight(1,0, 1), daySix.BrightLight(1,1, 0)))
  }

  "countTurnedOnLights" should "correctly count the number of lights that are turned on" in {
    val lights = daySix.initializeArray(2, 2)
    daySix.executeInstruction("turn on 0,0 through 1,1", lights)
    daySix.countTurnedOnLights(lights) shouldEqual 4
    daySix.executeInstruction("turn off 0,1 through 1,1", lights)
    daySix.countTurnedOnLights(lights) shouldEqual 2
  }

  "countTotalBrightness" should "correctly calculate the total brightness of the lights array" in {
    val lights = daySix.initializeBrightArray(2, 2)
    daySix.executeInstruction2("turn on 0,0 through 1,1", lights)
    daySix.countTotalBrightness(lights) shouldEqual 4
    daySix.executeInstruction2("turn off 0,1 through 1,1", lights)
    daySix.countTotalBrightness(lights) shouldEqual 2
  }

}

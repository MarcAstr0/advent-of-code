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

  "turnOn()" should "turn on the light only if it's off" in {
    daySix.turnOn(daySix.Light(0,0,true)) shouldEqual daySix.Light(0,0,true)
    daySix.turnOn(daySix.Light(0,0,false)) shouldEqual daySix.Light(0,0,true)
  }

  "turnOff()" should "turn off the light only if it's on" in {
    daySix.turnOff(daySix.Light(0,0,true)) shouldEqual daySix.Light(0,0,false)
    daySix.turnOff(daySix.Light(0,0,false)) shouldEqual daySix.Light(0,0,false)
  }

  "initializeArray()" should "initialize an array of lights that are turned off" in {
    daySix.initializeArray(1, 1) shouldEqual Array(Array(daySix.Light(0,0, false)))
    daySix.initializeArray(2, 2) shouldEqual Array(Array(daySix.Light(0,0, false), daySix.Light(0,1, false)), Array(daySix.Light(1,0, false), daySix.Light(1,1, false)))
  }

  "executeInstruction()" should "apply the instruction to the lights array" in {
    val lights = daySix.initializeArray(2, 2)

    daySix.executeInstruction("turn on 0,0 through 1,1", lights) shouldEqual Array(Array(daySix.Light(0,0, true), daySix.Light(0,1, true)), Array(daySix.Light(1,0, true), daySix.Light(1,1, true)))
    daySix.executeInstruction("turn off 0,1 through 1,1", lights) shouldEqual Array(Array(daySix.Light(0,0, true), daySix.Light(0,1, false)), Array(daySix.Light(1,0, true), daySix.Light(1,1, false)))
    daySix.executeInstruction("toggle 0,0 through 0,1", lights) shouldEqual Array(Array(daySix.Light(0,0, false), daySix.Light(0,1, true)), Array(daySix.Light(1,0, true), daySix.Light(1,1, false)))
  }

  "countTurnedOnLights" should "correctly count the number of lights that are turned on" in {
    val lights = daySix.initializeArray(2, 2)
    daySix.executeInstruction("turn on 0,0 through 1,1", lights)
    daySix.countTurnedOnLights(lights) shouldEqual 4
    daySix.executeInstruction("turn off 0,1 through 1,1", lights)
    daySix.countTurnedOnLights(lights) shouldEqual 2
  }

}

package com.adventofcode

import java.io.InputStream

/**
 * Created by mcastro on 29-04-2016.
 */
class DaySix {
  case class Light(x: Int, y: Int, on: Boolean)
  case class BrightLight(x: Int, y: Int, brightness: Int)

  def executeInstruction(instruction: String, lights: Array[Array[Light]]): Array[Array[Light]] = {
    instruction.split(" ").toList match {
      case List("turn", "off", from, "through", to) => {
        for {
          i <- from.split(",")(0).toInt to to.split(",")(0).toInt
          j <- from.split(",")(1).toInt to to.split(",")(1).toInt
        } lights(i)(j) = turnOff(lights(i)(j))
      }
      case List("turn", "on", from, "through", to) => {
        for {
          i <- from.split(",")(0).toInt to to.split(",")(0).toInt
          j <- from.split(",")(1).toInt to to.split(",")(1).toInt
        } lights(i)(j) = turnOn(lights(i)(j))
      }
      case List("toggle", from, "through", to) => {
        for {
          i <- from.split(",")(0).toInt to to.split(",")(0).toInt
          j <- from.split(",")(1).toInt to to.split(",")(1).toInt
        } lights(i)(j) = toggle(lights(i)(j))
      }
    }
    lights
  }

  def executeInstruction2(instruction: String, lights: Array[Array[BrightLight]]): Array[Array[BrightLight]] = {
    instruction.split(" ").toList match {
      case List("turn", "off", from, "through", to) => {
        for {
          i <- from.split(",")(0).toInt to to.split(",")(0).toInt
          j <- from.split(",")(1).toInt to to.split(",")(1).toInt
        } lights(i)(j) = turnOff(lights(i)(j))
      }
      case List("turn", "on", from, "through", to) => {
        for {
          i <- from.split(",")(0).toInt to to.split(",")(0).toInt
          j <- from.split(",")(1).toInt to to.split(",")(1).toInt
        } lights(i)(j) = turnOn(lights(i)(j))
      }
      case List("toggle", from, "through", to) => {
        for {
          i <- from.split(",")(0).toInt to to.split(",")(0).toInt
          j <- from.split(",")(1).toInt to to.split(",")(1).toInt
        } lights(i)(j) = toggle(lights(i)(j))
      }
    }
    lights
  }

  def countTurnedOnLights(lights: Array[Array[Light]]): Int = {
    (for {
      i <- 0 until lights.size
      j <- 0 until lights(0).size
      if (lights(i)(j).on)
    } yield 1).foldLeft(0)((a, b) => a+b)
  }

  def countTotalBrightness(lights: Array[Array[BrightLight]]): Int = {
    (for {
      i <- 0 until lights.size
      j <- 0 until lights(0).size
    } yield lights(i)(j).brightness).foldLeft(0)((a, b) => a + b)
  }

  def toggle(light: Light): Light = {
    Light(light.x, light.y, !light.on)
  }

  def toggle(light: BrightLight): BrightLight = {
    BrightLight(light.x, light.y, light.brightness + 2)
  }


  def turnOn(light: Light): Light = {
    light match {
      case Light(_, _, false) => toggle(light)
      case _ => light
    }
  }

  def turnOn(light: BrightLight): BrightLight = {
    BrightLight(light.x, light.y, light.brightness + 1)
  }

  def turnOff(light: Light): Light = {
    light match {
      case Light(_, _, true) => toggle(light)
      case _ => light
    }
  }

  def turnOff(light: BrightLight): BrightLight = {
    light.brightness match {
      case 0 => light
      case _ => BrightLight(light.x, light.y, light.brightness - 1)
    }
  }

  def initializeArray(n: Int, m: Int): Array[Array[Light]] = {
    val lightArray = Array.ofDim[Light](n, m)
    for {
      i <- 0 until n
      j <- 0 until m
    } lightArray(i)(j) = Light(i, j, false)
    lightArray
  }

  def initializeBrightArray(n: Int, m: Int): Array[Array[BrightLight]] = {
    val lightArray = Array.ofDim[BrightLight](n, m)
    for {
      i <- 0 until n
      j <- 0 until m
    } lightArray(i)(j) = BrightLight(i, j, 0)
    lightArray
  }
}

object DaySix {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DaySixInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines

  def main(args: Array[String]): Unit = {
    val daySix = new DaySix
    val lights = daySix.initializeArray(1000, 1000)
    val brightLights = daySix.initializeBrightArray(1000, 1000)
    println("--- Day 6: Probably a Fire Hazard ---")
    for {
      line <- input
    } {
      daySix.executeInstruction(line, lights)
      daySix.executeInstruction2(line, brightLights)
    }
    println("Answer to Part One is: " + daySix.countTurnedOnLights(lights))
    println("Answer to Part Two is: " + daySix.countTotalBrightness(brightLights))
  }
}

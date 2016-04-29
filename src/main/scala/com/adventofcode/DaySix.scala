package com.adventofcode

import java.io.InputStream

/**
 * Created by mcastro on 29-04-2016.
 */
class DaySix {
  case class Light(x: Int, y: Int, on: Boolean)

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

  def countTurnedOnLights(lights: Array[Array[Light]]): Int = {
    (for {
      i <- 0 until lights.size
      j <- 0 until lights(0).size
      if (lights(i)(j).on)
    } yield 1).foldLeft(0)((a, b) => a+b)
  }

  def toggle(light: Light): Light = {
    Light(light.x, light.y, !light.on)
  }

  def turnOn(light: Light): Light = {
    light match {
      case Light(_, _, false) => toggle(light)
      case _ => light
    }
  }

  def turnOff(light: Light): Light = {
    light match {
      case Light(_, _, true) => toggle(light)
      case _ => light
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
}

object DaySix {
  val stream: InputStream = getClass.getClassLoader.getResourceAsStream("DaySixInput.txt")
  val input = scala.io.Source.fromInputStream(stream).getLines

  def main(args: Array[String]): Unit = {
    val daySix = new DaySix
    val lights = daySix.initializeArray(1000, 1000)
    println("--- Day 6: Probably a Fire Hazard ---")
    for {
      line <- input
    } daySix.executeInstruction(line, lights)
    println("Answer to Part One is: " + daySix.countTurnedOnLights(lights))
  }
}

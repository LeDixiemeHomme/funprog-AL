package fr.esgi.grp6
package model

import org.scalatest.funsuite.AnyFunSuite

class LawnTest extends AnyFunSuite {
  test("Lawn.initQuartering") {
    val lawn: Lawn = Lawn(xMax = 2, yMax = 3, listOfLawnmower = Nil)
    val expectedQuartering: List[Coordinate] = List(
      Coordinate(x = 0, y = 0),
      Coordinate(x = 0, y = 1),
      Coordinate(x = 0, y = 2),
      Coordinate(x = 1, y = 0),
      Coordinate(x = 1, y = 1),
      Coordinate(x = 1, y = 2)
    )
    val quarteringToTest: List[Coordinate] = lawn.quartering
    assert(expectedQuartering === quarteringToTest)
  }
}

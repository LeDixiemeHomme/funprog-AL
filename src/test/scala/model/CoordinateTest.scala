package fr.esgi.grp6
package model

import org.scalatest.funsuite.AnyFunSuite

class CoordinateTest extends AnyFunSuite {
  test("Coordinate.toString") {
    val coordinate = Coordinate(2, 2)
    assert(coordinate.toString() === "Coordinate: {x = 2, y = 2}")
  }
}

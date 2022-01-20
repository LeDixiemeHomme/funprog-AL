package refacto

import fr.esgi.grp6.model.{Coordinate, Orientation}
import org.scalatest.funsuite.AnyFunSuite

class CoordinateTest extends AnyFunSuite {
  test("Coordinate.isOut.false") {
    val coordinate = Coordinate(2, 2)
    val limite = Coordinate(5, 5)
    assert(!coordinate.isOut(limite = limite))
  }
  test("Coordinate.isOut.true.x") {
    val coordinate = Coordinate(8, 2)
    val limite = Coordinate(5, 5)
    assert(coordinate.isOut(limite = limite))
  }
  test("Coordinate.isOut.true.y") {
    val coordinate = Coordinate(2, 8)
    val limite = Coordinate(5, 5)
    assert(coordinate.isOut(limite = limite))
  }
  test("Coordinate.isOut.true.negative") {
    val coordinate = Coordinate(-1, -1)
    val limite = Coordinate(5, 5)
    assert(coordinate.isOut(limite = limite))
  }
  test("Coordinate.checkBoundaries.move") {
    val coordinate = Coordinate(2, 2)
    val coordinateToTest = Coordinate(4, 4)
    val limite = Coordinate(5, 5)
    assert(coordinate.checkBoundaries(cooToTest = coordinateToTest,limite = limite)
    === coordinateToTest)
  }
  test("Coordinate.checkBoundaries.dont.move") {
    val coordinate = Coordinate(2, 2)
    val coordinateToTest = Coordinate(6, 6)
    val limite = Coordinate(5, 5)
    assert(coordinate.checkBoundaries(cooToTest = coordinateToTest,limite = limite)
    === coordinate)
  }
  test("Coordinate.moveForward.N") {
    val coordinate = Coordinate(2, 2)
    val coordinateAfter = Coordinate(2, 3)
    val orientation = Orientation.N
    val limite = Coordinate(5, 5)
    assert(coordinate.moveForward(orientation = orientation, limite = limite)
    === coordinateAfter)
  }
  test("Coordinate.moveForward.E") {
    val coordinate = Coordinate(2, 2)
    val coordinateAfter = Coordinate(3, 2)
    val orientation = Orientation.E
    val limite = Coordinate(5, 5)
    assert(coordinate.moveForward(orientation = orientation, limite = limite)
    === coordinateAfter)
  }
  test("Coordinate.moveForward.S") {
    val coordinate = Coordinate(2, 2)
    val coordinateAfter = Coordinate(2, 1)
    val orientation = Orientation.S
    val limite = Coordinate(5, 5)
    assert(coordinate.moveForward(orientation = orientation, limite = limite)
    === coordinateAfter)
  }
  test("Coordinate.moveForward.W") {
    val coordinate = Coordinate(2, 2)
    val coordinateAfter = Coordinate(1, 2)
    val orientation = Orientation.W
    val limite = Coordinate(5, 5)
    assert(coordinate.moveForward(orientation = orientation, limite = limite)
    === coordinateAfter)
  }
  test("Coordinate.moveForward.N.dont") {
    val coordinate = Coordinate(5, 5)
    val orientation = Orientation.N
    val limite = Coordinate(5, 5)
    assert(coordinate.moveForward(orientation = orientation, limite = limite)
      === coordinate)
  }
}
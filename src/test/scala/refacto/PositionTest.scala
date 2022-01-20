package refacto

import fr.esgi.grp6.refacto.{Coordinate, Orientation, Position}
import org.scalatest.funsuite.AnyFunSuite

class PositionTest extends AnyFunSuite {
  test("Position.applyInstru.N.A") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.N)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,2), Orientation.N)
    assert(position.applyInstru("A",limite) === positionAfter)
  }
  test("Position.applyInstru.E.A") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.E)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(2,1), Orientation.E)
    assert(position.applyInstru("A",limite) === positionAfter)
  }
  test("Position.applyInstru.S.A") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.S)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,0), Orientation.S)
    assert(position.applyInstru("A",limite) === positionAfter)
  }
  test("Position.applyInstru.W.A") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.W)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(0,1), Orientation.W)
    assert(position.applyInstru("A",limite) === positionAfter)
  }


  test("Position.applyInstru.N.D") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.N)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.E)
    assert(position.applyInstru("D",limite) === positionAfter)
  }
  test("Position.applyInstru.E.D") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.E)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.S)
    assert(position.applyInstru("D",limite) === positionAfter)
  }
  test("Position.applyInstru.S.D") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.S)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.W)
    assert(position.applyInstru("D",limite) === positionAfter)
  }
  test("Position.applyInstru.W.D") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.W)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.N)
    assert(position.applyInstru("D",limite) === positionAfter)
  }


  test("Position.applyInstru.N.G") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.N)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.W)
    assert(position.applyInstru("G",limite) === positionAfter)
  }
  test("Position.applyInstru.E.G") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.E)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.N)
    assert(position.applyInstru("G",limite) === positionAfter)
  }
  test("Position.applyInstru.S.G") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.S)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.E)
    assert(position.applyInstru("G",limite) === positionAfter)
  }
  test("Position.applyInstru.W.G") {
    val position = Position(coordinate = Coordinate(1,1), orientation = Orientation.W)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(1,1), Orientation.S)
    assert(position.applyInstru("G",limite) === positionAfter)
  }


  test("Position.applyInstru.WALL.UP") {
    val position = Position(coordinate = Coordinate(5,5), orientation = Orientation.N)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(5,5), Orientation.N)
    assert(position.applyInstru("A",limite) === positionAfter)
  }
  test("Position.applyInstru.WALL.DOWN") {
    val position = Position(coordinate = Coordinate(0,0), orientation = Orientation.S)
    val limite = Coordinate(5,5)
    val positionAfter = Position(Coordinate(0,0), Orientation.S)
    assert(position.applyInstru("A",limite) === positionAfter)
  }
}

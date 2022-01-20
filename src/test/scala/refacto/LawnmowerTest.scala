package refacto

import fr.esgi.grp6.model.{Coordinate, Lawnmower, Orientation, Position}
import org.scalatest.funsuite.AnyFunSuite

class LawnmowerTest extends AnyFunSuite {
  test("Lawnmower.applyInstructions.work") {
    val cooStart = Coordinate(1, 1)
    val cooLimite = Coordinate(5, 5)
    val orientStart = Orientation.N
    val start = Position(cooStart, orientStart)
    val lawnmower = Lawnmower(start = start,
      instructions = List("A", "D", "G", "D"), limite = cooLimite)
    assert(lawnmower.end === Position(Coordinate(1, 2), Orientation.E))
  }
  test("Lawnmower.applyInstructions.wall.hit.up") {
    val cooStart = Coordinate(1, 1)
    val cooLimite = Coordinate(5, 5)
    val orientStart = Orientation.N
    val start = Position(cooStart, orientStart)
    val lawnmower = Lawnmower(start = start,
      instructions = List("A", "A", "A", "A", "A", "A", "A"), limite = cooLimite)
    assert(lawnmower.end === Position(Coordinate(1, 5), Orientation.N))
  }
  test("Lawnmower.applyInstructions.wall.hit.down") {
    val cooStart = Coordinate(1, 1)
    val cooLimite = Coordinate(5, 5)
    val orientStart = Orientation.N
    val start = Position(cooStart, orientStart)
    val lawnmower = Lawnmower(start = start,
      instructions = List("D", "D", "A", "A", "A"), limite = cooLimite)
    assert(lawnmower.end === Position(Coordinate(1, 0), Orientation.S))
  }
}

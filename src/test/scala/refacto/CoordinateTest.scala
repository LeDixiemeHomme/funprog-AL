package refacto

import fr.esgi.grp6.refacto.Coordinate
import org.scalatest.funsuite.AnyFunSuite

class CoordinateTest extends AnyFunSuite {
  test("Coordinate.toString") {
    val coordinate = Coordinate(2, 2)
    assert(coordinate.toString() === "Coordinate: {x = 2, y = 2}")
  }
}
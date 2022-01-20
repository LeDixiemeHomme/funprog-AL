package refacto

import fr.esgi.grp6.model.Orientation
import org.scalatest.funsuite.AnyFunSuite

class OrientationTest extends AnyFunSuite {
  test("Orientation.applyInstruction.N.D") {
    val id = 0
    assert(Orientation.applyInstruction("D", id) === Orientation.E)
  }
  test("Orientation.applyInstruction.E.D") {
    val id = 1
    assert(Orientation.applyInstruction("D", id) === Orientation.S)
  }
  test("Orientation.applyInstruction.S.D") {
    val id = 2
    assert(Orientation.applyInstruction("D", id) === Orientation.W)
  }
  test("Orientation.applyInstruction.W.D") {
    val id = 3
    assert(Orientation.applyInstruction("D", id) === Orientation.N)
  }

  test("Orientation.applyInstruction.N.G") {
    val id = 0
    assert(Orientation.applyInstruction("G", id) === Orientation.W)
  }
  test("Orientation.applyInstruction.E.G") {
    val id = 1
    assert(Orientation.applyInstruction("G", id) === Orientation.N)
  }
  test("Orientation.applyInstruction.S.G") {
    val id = 2
    assert(Orientation.applyInstruction("G", id) === Orientation.E)
  }
  test("Orientation.applyInstruction.W.G") {
    val id = 3
    assert(Orientation.applyInstruction("G", id) === Orientation.S)
  }

  test("Orientation.applyInstruction.big.id") {
    val id = 200
    assert(Orientation.applyInstruction("G", id) === Orientation.W)
  }

  test("Orientation.applyInstruction.negative.id") {
    val id = -200
    assert(Orientation.applyInstruction("G", id) === Orientation.W)
  }

}

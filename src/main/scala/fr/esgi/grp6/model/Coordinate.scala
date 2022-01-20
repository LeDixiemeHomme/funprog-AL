package fr.esgi.grp6.model

import fr.esgi.grp6.model.Orientation.Orientation
import play.api.libs.json.{Json, Writes}

case class Coordinate(x: Int, y: Int) {
  def moveForward(orientation: Orientation, limite: Coordinate): Coordinate = orientation.id match {
    case 0 => checkBoundaries(cooToTest = Coordinate(x = this.x, y = this.y+1), limite = limite)
    case 1 => checkBoundaries(cooToTest = Coordinate(x = this.x+1, y = this.y), limite = limite)
    case 2 => checkBoundaries(cooToTest = Coordinate(x = this.x, y = this.y-1), limite = limite)
    case 3 => checkBoundaries(cooToTest = Coordinate(x = this.x-1, y = this.y), limite = limite)
  }

  def checkBoundaries(cooToTest: Coordinate, limite: Coordinate): Coordinate = {
    if (cooToTest.isOut(limite = limite)) this else cooToTest
  }

  def isOut(limite: Coordinate): Boolean = {
    this.x > limite.x || this.y > limite.y || this.x < 0 || this.y < 0
  }
}

object Coordinate {
  implicit val jsonWrites: Writes[Coordinate] =
    (coordinate: Coordinate) => {
      Json.obj(
        "x" -> coordinate.x,
        "y" -> coordinate.y
      )
    }
}

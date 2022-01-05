package fr.esgi.grp6.writer

import fr.esgi.grp6.model.Orientation.Orientation
import play.api.libs.json._

object JSONWriter {

  case class Lawnmower(position: Coordinate, direction: Orientation)

  object Lawnmower {
    implicit val jsonWritesLawnmower: Writes[Lawnmower] = (lawnmower: Lawnmower) => {
      Json.obj(
        "position" -> lawnmower.position,
        "direction" -> lawnmower.direction
      )
    }
  }

  case class Coordinate(x: Int, y: Int)

  object Coordinate {
    implicit val jsonWritesCoordinate: Writes[Coordinate] = (coordinate: Coordinate) => {
      Json.obj(
        "x" -> coordinate.x,
        "y" -> coordinate.y
      )
    }
  }
}

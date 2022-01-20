package fr.esgi.grp6.model

import fr.esgi.grp6.model.Orientation.Orientation
import play.api.libs.json.{Json, Writes}

case class Position(coordinate: Coordinate, orientation: Orientation) {
  def applyInstru(instruction: String, limite: Coordinate): Position = instruction match {
    case "D" | "G" => Position(this.coordinate, Orientation.applyInstruction(instruction = instruction, id = this.orientation.id))
    case "A" => Position(this.coordinate.moveForward(orientation = this.orientation, limite = limite), this.orientation)
//    case _ => throw new InvalidDataException("Wrong instructions !")
  }
}

object Position {
  implicit val jsonWrites: Writes[Position] =
    (position: Position) => {
      Json.obj(
        "point"     -> position.coordinate,
        "direction"    -> position.orientation
      )
    }
}

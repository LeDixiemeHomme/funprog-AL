package fr.esgi.grp6.refacto

import play.api.libs.json.{Json, Writes}

import scala.annotation.tailrec

case class Lawnmower(start: Position, instructions: List[String], limite: Coordinate) {

  @tailrec
  private def applyInstructions(
      instructions: List[String], position: Position): Position = instructions match {
    case instruction :: rest =>
      this.applyInstructions(instructions = rest, position = position.applyInstru(instruction = instruction, limite = limite))
    case Nil => position
  }

  val end: Position =
    applyInstructions(instructions = this.instructions, position = start)
}

object Lawnmower {
  implicit val jsonWrites: Writes[Lawnmower] =
    (lawnmower: Lawnmower) => {
      Json.obj(
        "debut"        -> lawnmower.start,
        "instructions" -> lawnmower.instructions,
        "fin"          -> lawnmower.end
      )
    }
}

package fr.esgi.grp6.refacto

import play.api.libs.json.{Json, Writes}

case class Result(limite: Coordinate, lawnmowers: List[Lawnmower])

object Result {
  implicit val jsonWrites: Writes[Result] =
    (result: Result) => {
      Json.obj(
        "limite"    -> result.limite,
        "tondeuses" -> result.lawnmowers
      )
    }
}

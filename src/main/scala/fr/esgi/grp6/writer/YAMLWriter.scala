package fr.esgi.grp6.writer


object YAMLWriter {

  sealed trait YamlValue {
    def append(key: String, value: YamlValue): YamlObject = this match {
      case YamlObject(map) => YamlObject(map++ Map(key -> value))
      case _ => ???
    }
  }

  case object YamlNull extends YamlValue

  case class YamlObject(private val underlying: Map[String, YamlValue]) extends YamlValue

  case class YamlString(value: String) extends YamlValue

  case class YamlArray(value: IndexedSeq[YamlValue] = Array[YamlValue]()) extends YamlValue

  trait Writes[A] {
    def writes(value: A): YamlValue
  }

  object Writes {
    def of[A](implicit w: Writes[A]): Writes[A] = w
    implicit val writesInt: Writes[Int] = (value: Int) => YamlString(value.toString)
    implicit val writesChar: Writes[Char] = (value: Char) => YamlString(value.toString)
    implicit val writesString: Writes[String] = (value: String) => YamlString(value)
    implicit val writesArray: Writes[Array[Char]] = (value: Array[Char]) => ???
  }

  case class Limit(x: Int, y: Int)

  object Limit {
    implicit val writesLimit: Writes[Limit] = (value: Limit) => YamlObject(Map(
      "x" -> Writes.of[Int].writes(value.x),
      "y" -> Writes.of[Int].writes(value.y)
    ))
  }

  case class State(point: Limit, direction: Char)
  case class Mower(debut: State, instructions: Array[Char], fin: State)

  object State {
    implicit val writesState: Writes[State] = (value: State) => YamlObject(Map(
      "point" -> Writes.of[Limit].writes(value.point),
      "direction" -> Writes.of[Char].writes(value.direction)
    ))
  }

  object Mower {
    implicit val writesMower: Writes[Mower] = (mower: Mower) => YamlObject(Map(
      "debut" -> Writes.of[State].writes(mower.debut),
      //"instructions" -> Writes.of[Array],
      "fin" -> Writes.of[State].writes(mower.fin)
    ))
  }
}

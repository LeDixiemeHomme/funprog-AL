package funprog

import fr.esgi.grp6.model._

object Main extends App {
  val lawnmower = Lawnmower(
    position = Position(
      orientation = Orientations.North,
      coordinate = Coordinate(x = 1, y = 2)
    )
  )
  val lawnmowers: List[Lawnmower] = List(lawnmower)
  val lawn: Lawn = Lawn(xMax = 5, yMax = 5, listOfLawnmower = lawnmowers)
  println(lawn.quartering)
}

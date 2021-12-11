package funprog

import fr.esgi.grp6.model._

object Main extends App {
  val lawnmower = Lawnmower(
    position = Coordinate(1, 1),
    direction = Orientation.N
  )
  val lawnmowers: List[Lawnmower] = List(lawnmower)
  val lawn: Lawn = Lawn(xMax = 5, yMax = 5, listOfLawnmower = lawnmowers)
  println(lawn.quartering)
  lawnmower.move()
}

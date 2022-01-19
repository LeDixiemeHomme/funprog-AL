package funprog


object Main extends App {
  /**val lawnmower = Lawnmower(
    position = Coordinate(1, 1),
    direction = Orientation.N
  )
  val lawnmowers: List[Lawnmower] = List(lawnmower)
  val lawn: Lawn = Lawn(xMax = 5, yMax = 5, listOfLawnmower = lawnmowers)
  println(lawn.quartering)
  lawnmower.move()*/

  def timed[A](block: => A): A = {
    val t0 = System.currentTimeMillis()
    val result = block
    println("took" + (System.currentTimeMillis() - t0))
    result
  }

  val source = timed(scala.io.Source.fromFile("resources/input.txt"))
  val lines = timed(source.getLines())
  print(lines)
}

package fr.esgi.grp6.model

import scala.annotation.tailrec

case class Lawn(
                 xMax: Int,
                 yMax: Int,
                 listOfLawnmower: List[Lawnmower]
               ) {
  def inverse(max: Int, number: Int): Int = max - number

  @tailrec
  private def initQuartering(
                              currX: Int,
                              currY: Int,
                              list: List[Coordinate]
                            ): List[Coordinate] = (currX, currY) match {
    //    case (currX, currY) if currX <= 0 && currY <= 0 => throw DonneesIncorrectesException("Wrong value for quartering")
    case (currX: Int, currY: Int) if currY > 0 && currX > 0 =>
      initQuartering(
        currX = currX,
        currY = currY - 1,
        list = list :+ Coordinate(
          x = inverse(this.xMax, currX),
          y = inverse(this.yMax, currY)
        )
      )
    case (currX: Int, currY: Int) if currY == 0 && currX > 0 =>
      initQuartering(currX = currX - 1, currY = this.yMax, list = list)
    case _ => list
  }

  val quartering: List[Coordinate] =
    this.initQuartering(currX = this.xMax, currY = this.yMax, list = Nil)
  //  val quartering = (xMax: Int, yMax: Int, list: List[Coordinate]) => (xMax, yMax) match {
  //    case (currX, currY) if currX <= 0 && currY <= 0 => throw DonneesIncorrectesException("Wrong value for quartering")
  //    case (currX, currY) if currY > 0 && currX > 0 =>
  //      quartering(xMax, yMax - 1, list :+ Coordinate(x = inverse(this.xMax, yMax), y = inverse(this.yMax, currY)))
  //    case (currX, currY) if currY == 0 && currX > 0 => quartering(currX - 1, this.yMax, list)
  //    case _ => list
  //  }
  //
  //  val poarae: List[Coordinate] = quartering(this.xMax, this.yMax, Nil)

}

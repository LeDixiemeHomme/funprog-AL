package fr.esgi.grp6.refacto

import fr.esgi.grp6.exceptions.InvalidDataException
import fr.esgi.grp6.refacto.Orientation.Orientation

import scala.annotation.tailrec
import scala.io.BufferedSource
import scala.io.Source.fromFile

object ParserRefacto {

  val source: BufferedSource = fromFile("src/main/resources/input.txt")
  val lines: List[String] =
//    source.getLines().map(line => line.replace(" ", "")).toList
    source.getLines().toList
  try {
    println(lines(0).charAt(0).toInt - 48)
    println(lines(0).charAt(2).toInt - 48)
  } catch {
    case e: StringIndexOutOfBoundsException => println(e.getMessage)
    //          throw InvalidDataException("invalid position in input file")
  }
  val grid: Coordinate =
    Coordinate(lines(0).charAt(0).toInt - 48, lines(0).charAt(2).toInt - 48)

  def execute(): List[Lawnmower] = {
    val arraySize = (lines.length - 1) / 2
    val mowers: Array[Lawnmower] = new Array[Lawnmower](arraySize)
    try {
      parse(0, lines, mowers)
    } catch {
      case _: InvalidDataException => println("cc les devs")
    }
    source.close()
    mowers.toList
  }

  @tailrec
  def parse(start: Int, lines: List[String], mowers: Array[Lawnmower]): Unit = {
    if (start < lines.length) {
      if (start >= 1) {
        createMower(start, lines, mowers)
      }
      parse(start + 1, lines, mowers)
    }
  }

  private def createMower(
      start: Int,
      lines: List[String],
      mowers: Array[Lawnmower]
  ): Unit = {
    if (start % 2 != 0) {
      val listValue: List[String] = lines(start).split(" ").toList
      try {
        println(listValue(0).toInt)
        println(listValue(1).toInt)
        println(listValue(2))
      } catch {
        case _: NumberFormatException => println("exception")
//          throw InvalidDataException("invalid position in input file")
      }
      println(listValue)
      val coo = Coordinate(listValue(0).toInt, listValue(1).toInt)
      if (coo.x > grid.x || coo.y > grid.y || coo.x < 0 || coo.y < 0) {
        println("exception")
//        throw InvalidDataException("invalid position in input file")
      }
      val direction = charToDirection(listValue(2))
      val position = Position(coordinate = coo, orientation = direction)
      val instru: List[String] =
        lines(start + 1).toList.map(char => char.toString)
      val mowerIndex = (start + 1) / 2 - 1
      val lawnmower = Lawnmower(start = position, instructions = instru, limite = grid)
      mowers(mowerIndex) = lawnmower
    }
  }

  def charToDirection(char: String): Orientation = char match {
    case "N" => Orientation.N
    case "W" => Orientation.W
    case "E" => Orientation.E
    case "S" => Orientation.S
//    case _ => throw new InvalidDataException("Wrong instruction !")
  }
}

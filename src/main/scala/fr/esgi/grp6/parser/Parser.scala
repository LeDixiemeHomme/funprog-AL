package fr.esgi.grp6.parser

import fr.esgi.grp6.exceptions.InvalidDataException
import fr.esgi.grp6.parser.Parser.Direction.Direction

import scala.annotation.tailrec
import scala.io.BufferedSource
import scala.io.Source.fromFile

object Parser {

  val source: BufferedSource = fromFile("src/main/resources/input.txt")
  val lines: List[String] = source.getLines().map(line => line.replace(" ", "")).toList
//  val grid: Position = Position(lines.head.charAt(0) - 48, lines.head.charAt(1) - 48)

  def execute(): Unit = {

    val arraySize = (lines.length - 1 ) / 2
    val mowers: Array[Lawnmower] = new Array[Lawnmower](arraySize)
    try {
      parse(0, lines, mowers)
    } catch {
      case _: InvalidDataException => println("cc les devs")
    }
    for(mower <- mowers) {
      println(mower)
    }
//    print(grid)
    source.close()
  }

  object Direction extends Enumeration {
    type Direction = Value

    val N, S, E, W = Value
  }

  case class Position(x: Int, y: Int)
  case class Lawnmower(position: Position, direction: Direction)


  @tailrec
  def parse(start: Int, lines: List[String], mowers: Array[Lawnmower]): Unit = {
    if(start < lines.length) {
      if(start >= 1) {
        createMower(start, lines, mowers)
      }
      parse(start + 1, lines, mowers)
    }
  }


  private def createMower(start: Int, lines: List[String], mowers: Array[Lawnmower]): Unit = {
    if (start % 2 != 0) {
      val position = Position(lines(start).charAt(0) - 48, lines(start).charAt(1) - 48)
//      if(position.x > grid.x || position.y > grid.y || position.x < 0 || position.y < 0) {
////        throw InvalidDataException("invalid position in input file")
//      }
      val direction = charToDirection(lines(start).charAt(2))
      val mowerIndex = (start + 1) / 2 - 1
      val lawnmower = Lawnmower(position, direction)
      mowers(mowerIndex) = lawnmower
    }
  }

  def charToDirection(char: Char): Direction = char match {
    case 'N' => Direction.N
    case 'W' => Direction.W
    case 'E' => Direction.E
    case 'S' => Direction.S
  }

}
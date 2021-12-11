package fr.esgi.grp6.model


import fr.esgi.grp6.model.Orientation.Orientation

import scala.io.Source

case class Lawnmower(position: Coordinate, direction: Orientation) {

  def move(): Unit = {
    val bufferedResource = Source.fromFile("src/main/resources/input.txt")
    for (line <- bufferedResource.getLines()) {
      println(line.toLowerCase())
    }
    bufferedResource.close()
  }
}
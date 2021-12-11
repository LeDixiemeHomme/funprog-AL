package fr.esgi.grp6
package model

case class Coordinate(val x: Int, val y: Int) {
  override def toString: String =
    "Coordinate: {x = " + x.toString + ", y = " + y.toString + "}"

  override def equals(obj: Any): Boolean = obj match {
    case obj: Coordinate => this.x == obj.x && this.y == obj.y
    case _               => false
  }
}

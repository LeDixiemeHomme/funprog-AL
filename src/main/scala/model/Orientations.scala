package fr.esgi.grp6
package model

object Orientations extends Enumeration {
  type Orientation = Value

  val North: Orientations.Value = Value(1, "N")
  val East: Orientations.Value = Value(2, "E")
  val West: Orientations.Value = Value(3, "W")
  val South: Orientations.Value = Value(4, "S")
}

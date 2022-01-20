package fr.esgi.grp6.model

object Orientation extends Enumeration {
  type Orientation = Value

  val N, E, S, W = Value
  val size = Orientation.values.toList.length

  def applyInstruction(instruction: String, id: Int): Orientation = instruction match {
    case "D" => Orientation.values.toList((((id + 1) % this.size) + this.size) % this.size)
    case "G" => Orientation.values.toList((((id - 1) % this.size) + this.size) % this.size)
  }
}

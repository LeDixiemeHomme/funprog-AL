package fr.esgi.grp6.writer

import fr.esgi.grp6.model.Lawnmower

trait IWriter {
  def write(pathFile: String, mowerList: List[Lawnmower]): Unit
}

package fr.esgi.grp6.writer

import fr.esgi.grp6.model.Lawnmower

case class YAMLWriter() extends IWriter {

  override def write(pathFile: String, mowerList: List[Lawnmower]): Unit = ???

}

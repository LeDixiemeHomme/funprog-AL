package funprog

import better.files.File
import fr.esgi.grp6.refacto.{Coordinate, ParserRefacto, Result}
import play.api.libs.json.Json

import java.text.SimpleDateFormat
import java.util.Calendar

object Main extends App {
  //  val lawnmower = Lawnmower(
  //    position = Coordinate(1, 1),
  //    direction = Orientation.N
  //  )
  //
  //  val coordinate: Coordinate = Coordinate(x = 1, y = 2)
  //
  //  val coo = JSONWriter.Coordinate
  //
  //  val json = coo.jsonWritesCoordinate
  //
  //  print(json.writes(coo(1,2)))
  //
  //
  //  val lawnmowers: List[Lawnmower] = List(lawnmower)
  //  val lawn: Lawn = Lawn(xMax = 5, yMax = 5, listOfLawnmower = lawnmowers)
  ////  println(lawn.quartering)
  //  lawnmower.move()
  //
  //  def timed[A](block: => A): A = {
  ////    val t0 = System.currentTimeMillis()
  //    val result = block
  ////    println("took" + (System.currentTimeMillis() - t0))
  //    result
  //  }
  //
  //  val source = timed(scala.io.Source.fromFile("./src/main/resources/input.txt"))
  //  val lines = timed(source.getLines())
  //  print(lines)

  val mowers = ParserRefacto.execute()

  val result: Result = Result(
    limite = Coordinate(5, 5),
    lawnmowers = mowers
  )

  val resJson = Result.jsonWrites.writes(o = result)
  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
  val now = format.format(Calendar.getInstance().getTime)
  val f = File("src/main/resources/" + now + ".json") // using constructor

  // pour ajouter du contenu dans un fichier ligne par ligne
  f.createIfNotExists()
    .appendLines(Json.prettyPrint(resJson)) // on ajoute 2 nouvelles lignes

}
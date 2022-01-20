package funprog

import better.files.File
import fr.esgi.grp6.parser.Parser
import fr.esgi.grp6.model.{Coordinate, Result}
import play.api.libs.json.Json

import java.text.SimpleDateFormat
import java.util.Calendar

object Main extends App {

  val mowers = Parser.execute()

  val result: Result = Result(
    limite = Coordinate(5, 5),
    lawnmowers = mowers
  )

  val resJson = Result.jsonWrites.writes(o = result)

  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
  val now = format.format(Calendar.getInstance().getTime)

  val f = File("src/main/resources/" + now + ".json")
  f.createIfNotExists().appendLines(Json.prettyPrint(resJson))

}
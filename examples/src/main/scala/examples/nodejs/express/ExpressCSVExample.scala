package examples.nodejs.express

import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.express._
import org.scalajs.nodejs.express.csv._

import scala.scalajs.js

/**
  * Express CSV Example
  * @author lawrence.daniels@gmail.com
  */
class ExpressCSVExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val express = Express()
  val csv = ExpressCSV()
  val app = express()

  app.get("/", (req: Request, res: Response with CSVResponse) => {
    res.csv(js.Array(
      js.Array("a", "b", "c"),
      js.Array("d", "e", "f")
    ))
  })

  app.listen(3000)

}

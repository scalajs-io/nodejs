package examples.nodejs.net

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.express._
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Express Server Example
  * @author lawrence.daniels@gmail.com
  */
class ExpressServerExample(bootstrap: Bootstrap) {
  import bootstrap._

  val express = require[Express]("express")
  val app = express()

  app.get("/", (req: Request, res: Response) => {
    res.send("Hello World")
  })

  val server = app.listen(8081, connect)

  private def connect: js.Function = () => {
    val host = server.address().address
    val port = server.address().port

    console.log("Example app listening at http://%s:%s", host, port)
  }

}

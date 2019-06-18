package io.scalajs.npm.bodyparser

import io.scalajs.JSON
import io.scalajs.npm.express.{Express, Request, Response}
import org.scalatest.FunSpec

/**
  * BodyParser Test
  * @author lawrence.daniels@gmail.com
  */
class BodyParserTest extends FunSpec {

  describe("BodyParserTest") {

    it("is an Express.js middleware") {
      val app = Express()

      // parse application/x-www-form-urlencoded
      app.use(BodyParser.urlencoded(new UrlEncodedBodyOptions(extended = false)))

      // parse application/json
      app.use(BodyParser.json())

      app.use((req: Request, res: Response) => {
        res.setHeader("Content-Type", "text/plain")
        res.write("you posted:\n")
        res.end(JSON.stringify(req.body, null, 2))
      })
    }

  }

}

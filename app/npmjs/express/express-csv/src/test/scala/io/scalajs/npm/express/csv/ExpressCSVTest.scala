package io.scalajs.npm.express.csv

import io.scalajs.nodejs.http.ServerResponse._
import io.scalajs.nodejs.http.{Http, ServerResponse}
import io.scalajs.nodejs.{setTimeout, _}
import io.scalajs.npm.express.{Express, Request, Response}
import org.scalatest.funspec.AnyFunSpec

import scala.concurrent.duration._
import scala.scalajs.js

/**
  * Express-CSV Tests
  * @author lawrence.daniels@gmail.com
  */
class ExpressCSVTest extends AnyFunSpec {
  private val port = 4567

  describe("ExpressCSV") {

    // load the Express modules
    val app = Express()
    ExpressCSV

    it("should handle CSV responses") {

      // startup the server with a single route
      val server = app
        .get("/", { (_: Request, res: Response with CSVResponse) =>
          res.csv(js.Array(js.Array("a", "b", "c"), js.Array("d", "e", "f")))
        })
        .listen(port)

      // shutdown the server after 2 seconds
      setTimeout(() => server.close(), 2.seconds)

      // request the CSV data
      Http.get(s"http://localhost:$port/", { response: ServerResponse =>
        Assert.equal(response.statusCode, 200, s"Invalid response code - HTTP/${response.statusCode}")
        response.onData { chunk =>
          val data = chunk.toString().split('\n').map(_.trim).mkString("|")
          info(s"data: $data")
          Assert.equal(data, """"a","b","c"|"d","e","f"""")
        }
      })

    }

  }

}

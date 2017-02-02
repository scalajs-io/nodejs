package io.scalajs.npm.express

import io.scalajs.nodejs.http.{Http, RequestOptions, ServerResponse}
import io.scalajs.nodejs.{setTimeout, _}
import org.scalatest.FunSpec

import scala.concurrent.duration._

/**
  * Express Tests
  * @author lawrence.daniels@gmail.com
  */
class ExpressTest extends FunSpec {
  private val port = 4568

  describe("Express") {

    // load the Express modules
    val app = Express()

    // setup the server with routes
    val server = app
      .get("/", (_: Request, res: Response) => res.send("Hello GET"))
      .post("/", (_: Request, res: Response) => res.send("Hello POST"))
      .delete("/:id", (req: Request, res: Response) => res.send(s"Hello DELETE - ${req.params.get("id").orNull}"))
      .get("/list_user", (_: Request, res: Response) => res.send("Page Listing"))
      .get("/ab*de", (_: Request, res: Response) => res.send("Page Pattern Match"))
      .listen(port)
    setTimeout(() => server.close(), 3.seconds)

    it("should handle GET /") {
      Http.get(s"http://localhost:$port/", { response: ServerResponse =>
        assert(response.statusCode == 200)
        response.onData { chunk =>
          assert(chunk.toString() === "Hello GET")
        }
      })
    }

    it("should handle GET /ab*de") {
      Http.get(
        s"http://localhost:$port/abcde", { response: ServerResponse =>
          assert(response.statusCode == 200)
          response.onData { chunk =>
            assert(chunk.toString() === "Page Pattern Match")
          }
        }
      )
    }

    it("should handle DELETE /:id") {
      val options = new RequestOptions(host = "localhost", port = port, method = "DELETE", path = "/1234")
      Http.get(options, { response: ServerResponse =>
        assert(response.statusCode == 200)
        response.onData { chunk =>
          assert(chunk.toString() === "Hello DELETE - 1234")
        }
      })
    }

  }

}

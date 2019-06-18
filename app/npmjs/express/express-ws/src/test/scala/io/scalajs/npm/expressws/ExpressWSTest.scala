package io.scalajs.npm.expressws

import io.scalajs.nodejs._
import io.scalajs.npm.express._
import io.scalajs.util.JSONHelper._
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.scalajs.js

/**
  * ExpressWS Tests
  * @author lawrence.daniels@gmail.com
  */
class ExpressWSTest extends FunSpec {

  describe("ExpressWS") {

    it("adds WebSocket capabilities to Express Applications") {

      process.env.get("HTTP_PORT") map (_.toInt) match {
        case None =>
          info("No HTTP port is configured. Set 'HTTP_PORT' to run test (e.g. HTTP_PORT=8080)")

        case Some(port) =>
          val app = Express().withWsRouting
          val expressWs = ExpressWS(app)

          app.use((req: Request, res: Response, next: js.Function0[Unit]) => {
            info("middleware")
            req.dynamic.testing = "testing"
            next()
          })

          app.get("/", (ws: WS, req: Request, res: Response, next: js.Function0[Unit]) => {
            info(s"get route ${req.dynamic.testing}")
            res.end()
          })

          app.ws("/", (ws: WS, req: Request) => {
            ws.onMessage { msg =>
              info(msg.toJson)
            }
            info(s"socket: ${req.dynamic.testing}")
          })

          val server = app.listen(port)

          // setup shutdown
          val shutdownInterval = (process.env.get("HTTP_KEEP_ALIVE") map(_.toInt) getOrElse 3).seconds
          info(s"Shutting down in $shutdownInterval")
          setTimeout(() => server.close(), shutdownInterval)
      }
    }

  }

}

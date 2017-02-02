package io.scalajs.nodejs
package http

import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.scalajs.js

/**
  * Http Tests
  * @author lawrence.daniels@gmail.com
  */
class HttpTest extends FunSpec {

  describe("Http") {

    it("should provide an HTTP server") {

      val server = Http.createServer((request: ClientRequest, response: ServerResponse) => {
        response.writeHead(statusCode = 200, headers = js.Dictionary("Content-Type" -> "text/plain"))
        response.write("Hello World")
        response.end()
      })

      // don't listen on a port
      //server.listen(58888)
      //setTimeout(() => server.close(), 100.millis)

    }
  }

}

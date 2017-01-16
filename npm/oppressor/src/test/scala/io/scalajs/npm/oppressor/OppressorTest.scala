package io.scalajs.npm.oppressor

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.http.{ClientRequest, Http, ServerResponse}
import io.scalajs.nodejs.{setTimeout, _}
import org.scalatest.FunSpec

import scala.concurrent.duration._

/**
  * Oppressor Tests
  * @author lawrence.daniels@gmail.com
  */
class OppressorTest extends FunSpec {

  describe("Oppressor") {

    it("should provide a server with compression") {
      val server = Http.createServer((req: ClientRequest, res: ServerResponse) => {
        Fs.createReadStream("./npm/csv-parse/src/test/resources/data.txt")
          .pipe(Oppressor(req))
          .pipe(res)
      })
      server.listen(8000)

      // shutdown the server after 10 seconds...
      setTimeout(() => server.close(), 1.seconds)
    }

  }

}

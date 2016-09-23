package org.scalajs.nodejs.oppressor

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.{setTimeout, _}
import utest._

import scala.concurrent.duration._

/**
  * Oppressor Tests
  * @author lawrence.daniels@gmail.com
  */
object OppressorTests extends TestSuite {

  override val tests = this {
    val oppressor = Oppressor()

    /*
    "server with compression" - {
      val fs = Fs()
      val http = Http()

      val server = http.createServer((req: ClientRequest, res: ServerResponse) => {
        fs.createReadStream("./data.txt")
          .pipe(oppressor(req))
          .pipe(res)
      })
      server.listen(8000)

      // shutdown the server after 10 seconds...
      setTimeout(() => server.close(), 10.seconds)
    }*/

  }

}

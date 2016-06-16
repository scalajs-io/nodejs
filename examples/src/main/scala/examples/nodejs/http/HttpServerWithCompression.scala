package examples.nodejs.http

import org.scalajs.nodejs._
import org.scalajs.nodejs.http._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.http.{ClientRequest, Http, ServerResponse}
import org.scalajs.nodejs.oppressor.Oppressor

/**
  * HTTP Server With Compression
  * @author lawrence.daniels@gmail.com
  */
class HttpServerWithCompression(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require
  import bootstrap._

  val oppressor = Oppressor()
  val fs = Fs()
  val http = Http()

  val server = http.createServer((req: ClientRequest, res: ServerResponse) => {
    fs.createReadStream(__dirname + "/data.txt")
      .pipe(oppressor(req))
      .pipe(res)
  })
  server.listen(8000)

}

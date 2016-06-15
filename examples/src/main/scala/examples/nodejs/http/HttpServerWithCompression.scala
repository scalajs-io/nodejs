package examples.nodejs.http

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.http._
import com.github.ldaniels528.meansjs.nodejs.oppressor.Oppressor

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

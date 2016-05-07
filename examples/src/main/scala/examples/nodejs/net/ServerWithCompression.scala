package examples.nodejs.net

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.http._
import com.github.ldaniels528.meansjs.nodejs.oppressor.Oppressor

/**
  * Server With Compression
  */
class ServerWithCompression(bootstrap: Bootstrap) {
  import bootstrap._

  val oppressor = require[Oppressor]("oppressor")
  val fs = require[Fs]("fs")
  val http = require[Http]("http")

  val server = http.createServer((req: ClientRequest, res: ServerResponse) => {
    fs.createReadStream(__dirname + "/data.txt")
      .pipe(oppressor(req))
      .pipe(res)

  })
  server.listen(8000)

}

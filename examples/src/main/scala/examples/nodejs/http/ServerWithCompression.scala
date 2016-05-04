package examples.nodejs.http

import com.github.ldaniels528.meansjs.nodejs.oppressor.Oppressor
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.{Require, _}
import com.github.ldaniels528.meansjs.nodejs.http._

/**
  * Server With Compression
  */
class ServerWithCompression(require: Require) {

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

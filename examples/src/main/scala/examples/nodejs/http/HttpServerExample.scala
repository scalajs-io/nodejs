package examples.nodejs.http

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.http._

import scala.scalajs.js

/**
  * Http Server Example
  * @author lawrence.daniels@gmail.com
  */
class HttpServerExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val http = Http()
  http.createServer((request: ClientRequest, response: ServerResponse) => {
    response.writeHead(statusCode = 200, headers = js.Dictionary("Content-Type" -> "text/plain"))
    response.write("Hello World")
    response.end()
  }).listen(8888)

}

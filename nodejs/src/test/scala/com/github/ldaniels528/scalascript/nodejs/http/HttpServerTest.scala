package com.github.ldaniels528.nodesjs.nodejs.http

import com.github.ldaniels528.nodesjs.nodejs.NodeJsHelper._

import scala.scalajs.js

/**
  * Http Server Test
  * @author lawrence.daniels@gmail.com
  */
class HttpServerTest {

  val http = require[Http]("http") getOrElse (throw new IllegalArgumentException("Module not found"))
  http.createServer((request: HttpRequest, response: HttpResponse) => {
    response.writeHead(statusCode = 200, mimeType = js.Dictionary("Content-Type" -> "text/plain"))
    response.write("Hello World")
    response.end()
  }).listen(8888)

  /*
    var http = require("http");
    http.createServer(function(request, response) {
      response.writeHead(200, {"Content-Type": "text/plain"});
      response.write("Hello World");
      response.end();
    }).listen(8888);
 */

}

package com.github.ldaniels528.nodesjs.nodejs.express

import com.github.ldaniels528.nodesjs.nodejs.NodeJsHelper._
import com.github.ldaniels528.nodesjs.nodejs.http.{HttpRequest, HttpResponse}
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Express Test Server
  * @author lawrence.daniels@gmail.com
  */
class ExpressTest {

  val express = require[Express]("express") getOrElse (throw new IllegalArgumentException("Module not found"))
  val app = express()

  app.get("/", (req: HttpRequest, res: HttpResponse) => {
    res.send("Hello World")
  })

  val server = app.listen(8081, connect)

  private def connect: js.Function = () => {
    val host = server.address().address
    val port = server.address().port

    console.log("Example app listening at http://%s:%s", host, port)
  }

  /*
    var express = require('express');
    var app = express();

    app.get('/', function (req, res) {
       res.send('Hello World');
    })

    var server = app.listen(8081, function () {

      var host = server.address().address
      var port = server.address().port

      console.log("Example app listening at http://%s:%s", host, port)

    })
   */

}

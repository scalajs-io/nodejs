package com.github.ldaniels528.meansjs.nodejs.express

import com.github.ldaniels528.meansjs.nodejs.require
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Express Routing Test Server
  * @author lawrence.daniels@gmail.com
  */
object ExpressRoutingTest extends js.JSApp {

  val express = require[Express]("express")
  val app = express()
  val server = app.listen(8081, connect)

  @scala.scalajs.js.annotation.JSExport
  override def main(): Unit = {
    // This responds with "Hello World" on the homepage
    app.get("/", (req: Request, res: Response) => {
      console.log("Got a GET request for the homepage")
      res.send("Hello GET")
    })

    // This responds a POST request for the homepage
    app.post("/", (req: Request, res: Response) => {
      console.log("Got a POST request for the homepage")
      res.send("Hello POST")
    })

    // This responds a DELETE request for the /del_user page.
    app.delete("/del_user", (req: Request, res: Response) => {
      console.log("Got a DELETE request for /del_user")
      res.send("Hello DELETE")
    })

    // This responds a GET request for the /list_user page.
    app.get("/list_user", (req: Request, res: Response) => {
      console.log("Got a GET request for /list_user")
      res.send("Page Listing")
    })

    // This responds a GET request for abcd, abxcd, ab123cd, and so on
    app.get("/ab*cd", (req: Request, res: Response) => {
      console.log("Got a GET request for /ab*cd")
      res.send("Page Pattern Match")
    })
  }

  private def connect: js.Function = () => {
    val host = server.address().address
    val port = server.address().port

    console.log("Example app listening at http://%s:%s", host, port)
  }

}

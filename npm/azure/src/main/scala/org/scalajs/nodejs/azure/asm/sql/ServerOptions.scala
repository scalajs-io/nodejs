package org.scalajs.nodejs.azure.asm.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Server Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ServerOptions(var administratorUserName: String,
                    var administratorPassword: String,
                    var location: String) extends js.Object

/**
  * Server Options
  * @author lawrence.daniels@gmail.com
  */
object ServerOptions {

  def apply(administratorUserName: String, administratorPassword: String, location: String) = {
    new ServerOptions(administratorUserName, administratorPassword, location)
  }

}
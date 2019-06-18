package io.scalajs.npm.xml2js

import io.scalajs.nodejs.Error

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * XML2JS Parser
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("xml2js", "Parser")
class Parser(options: ParserOptions) extends js.Object {

  def this() = this(null)

  def parseString[T <: js.Any](xml: String, callback: js.Function2[Error, T, Any]): Unit = js.native

  def addListener(name: String, callback: js.Function): Unit = js.native

}

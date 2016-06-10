package com.github.ldaniels528.meansjs.nodejs.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * XML2JS Parser
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Parser extends js.Object {

  def parseString: js.Function2[String, js.Function, js.Any] = js.native

  def addListener: js.Function2[String, js.Function, Unit] = js.native

}

/**
  * XML2JS Parser Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Parser")
object Parser extends ParserClass
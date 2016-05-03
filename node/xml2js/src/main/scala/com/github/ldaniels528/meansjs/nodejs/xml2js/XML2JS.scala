package com.github.ldaniels528.meansjs.nodejs.xml2js

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * NodeJS/xml2js
  * @author lawrence.daniels@gmail.com
  * @see [[https://www.npmjs.com/package/xml2js]]
  */
@js.native
trait XML2JS extends NodeModule with Parser {

  def defaults: js.Dictionary[String] = js.native

  def Parser: ParserClass = js.native

}

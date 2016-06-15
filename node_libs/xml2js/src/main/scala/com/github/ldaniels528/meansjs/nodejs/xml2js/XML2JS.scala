package com.github.ldaniels528.meansjs.nodejs.xml2js

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * NodeJS/xml2js
  * @author lawrence.daniels@gmail.com
  * @see [[https://www.npmjs.com/package/xml2js]]
  * @version 0.4.16
  */
@js.native
trait XML2JS extends NodeModule with Parser {

  def defaults: js.Dictionary[String] = js.native

  def Parser: ParserClass = js.native

}


/**
  * XML2JS Companion
  * @author lawrence.daniels@gmail.com
  */
object XML2JS {

  /**
    * Convenience method for retrieving the 'xml2js' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the XML2JS instance
    */
  def apply()(implicit require: NodeRequire) = require[XML2JS]("xml2js")

}
package io.scalajs.npm.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Simple XML to JavaScript object converter.
  * @version 0.4.17
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/xml2js
  */
@js.native
@JSImport("xml2js", JSImport.Namespace)
object Xml2js extends Xml2js

/**
  * xml2js Type Definition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Xml2js extends Parser {

  def defaults: js.Dictionary[String] = js.native

}

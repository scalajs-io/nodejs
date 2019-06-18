package io.scalajs.npm.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * XML2JS Builder
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("xml2js", "Builder")
class Builder(options: BuilderOptions) extends js.Object {

  def this() = this(null)

  def buildObject: js.Function1[js.Any, String] = js.native

}

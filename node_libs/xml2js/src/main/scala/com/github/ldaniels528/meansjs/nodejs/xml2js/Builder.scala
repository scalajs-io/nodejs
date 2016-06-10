package com.github.ldaniels528.meansjs.nodejs.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * XML2JS Builder
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Builder extends js.Object {

  def buildObject: js.Function1[js.Any, String] = js.native

}

/**
  * XML2JS Builder Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Builder")
object Builder extends BuilderClass

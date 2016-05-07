package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Mongo Collection Retrieval Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class CollectionOptions extends js.Object {
  var strict: Boolean = _
}

/**
  * Mongo Collection Retrieval Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CollectionOptions {

  def apply(strict: Boolean) = {
    val options = new CollectionOptions()
    options.strict = strict
    options
  }

}
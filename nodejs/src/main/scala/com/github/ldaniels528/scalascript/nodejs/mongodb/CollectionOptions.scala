package com.github.ldaniels528.nodesjs.nodejs.mongodb

import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Mongo Collection Retrieval Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CollectionOptions extends js.Object {
  var strict: Boolean
}

/**
  * Mongo Collection Retrieval Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CollectionOptions {

  def apply(strict: Boolean) = {
    val options = makeNew[CollectionOptions]
    options.strict = strict
    options
  }

}
package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Mongo Collection Retrieval Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class CollectionOptions(var readPreference: js.UndefOr[String] = js.undefined,
                        var strict: js.UndefOr[Boolean] = js.undefined)
    extends js.Object

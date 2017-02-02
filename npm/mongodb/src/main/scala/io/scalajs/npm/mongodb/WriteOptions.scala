package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Write Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class WriteOptions(var w: js.UndefOr[Int] = js.undefined,
                   var wtimeout: js.UndefOr[Int] = js.undefined,
                   var j: js.UndefOr[Boolean] = js.undefined,
                   var upsert: js.UndefOr[Boolean] = js.undefined,
                   var multi: js.UndefOr[Boolean] = js.undefined,
                   var bypassDocumentValidation: js.UndefOr[Boolean] = js.undefined)
    extends js.Object

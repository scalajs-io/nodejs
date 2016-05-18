package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Write Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class WriteOptions(w: js.UndefOr[Int],
                   wtimeout: js.UndefOr[Int],
                   j: js.UndefOr[Boolean],
                   upsert: js.UndefOr[Boolean],
                   multi: js.UndefOr[Boolean],
                   bypassDocumentValidation: js.UndefOr[Boolean]) extends js.Object

/**
  * Write Options Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteOptions {

  def apply(w: js.UndefOr[Int] = js.undefined,
            wtimeout: js.UndefOr[Int] = js.undefined,
            j: js.UndefOr[Boolean] = js.undefined,
            upsert: js.UndefOr[Boolean] = js.undefined,
            multi: js.UndefOr[Boolean] = js.undefined,
            bypassDocumentValidation: js.UndefOr[Boolean] = js.undefined) = {
    new WriteOptions(w, wtimeout, j, upsert, multi, bypassDocumentValidation)
  }

}
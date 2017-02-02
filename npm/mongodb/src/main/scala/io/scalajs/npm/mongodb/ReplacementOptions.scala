package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Document Replacement Options
  * @param upsert                    Update operation is an upsert.
  * @param w                         The write concern
  * @param wtimeout                  The write concern timeout.
  * @param j                         Specify a journal write concern.
  * @param  bypassDocumentValidation Allow driver to bypass schema validation in MongoDB 3.2 or higher.
  */
@ScalaJSDefined
class ReplacementOptions(var upsert: js.UndefOr[Boolean],
                         var w: js.UndefOr[Int],
                         var wtimeout: js.UndefOr[Int],
                         var j: js.UndefOr[Boolean],
                         var bypassDocumentValidation: js.UndefOr[Boolean])
    extends js.Object

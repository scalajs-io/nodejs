package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Write Options
  * @author lawrence.daniels@gmail.com
  */
class WriteOptions(var w: js.UndefOr[Int | String] = js.undefined,
                   var wtimeout: js.UndefOr[Int] = js.undefined,
                   var j: js.UndefOr[Boolean] = js.undefined,
                   var ordered: js.UndefOr[Boolean] = js.undefined,
                   var upsert: js.UndefOr[Boolean] = js.undefined,
                   var multi: js.UndefOr[Boolean] = js.undefined,
                   var bypassDocumentValidation: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Write Options Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteOptions extends FlexibleOptions[WriteOptions]
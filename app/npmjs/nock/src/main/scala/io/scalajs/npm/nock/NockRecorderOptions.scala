package io.scalajs.npm.nock

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Nock Recorder Options
  * @author lawrence.daniels@gmail.com
  */
class NockRecorderOptions(var dont_print: js.UndefOr[Boolean] = js.undefined,
                          var enable_reqheaders_recording: js.UndefOr[Boolean] = js.undefined,
                          var logging: js.UndefOr[String] = js.undefined,
                          var output_objects: js.UndefOr[Boolean] = js.undefined,
                          var use_separator: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Nock Recorder Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NockRecorderOptions extends FlexibleOptions[NockRecorderOptions]

package io.scalajs.npm.aws.kinesis

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Kinesis Options
  * @param apiVersion the given API version
  */
class KinesisOptions(var apiVersion: js.UndefOr[String] = js.undefined) extends js.Object

/**
  * Kinesis Options Companion
  * @author lawrence.daniels@gmail.com
  */
object KinesisOptions extends FlexibleOptions[KinesisOptions]
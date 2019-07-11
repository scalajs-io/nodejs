package io.scalajs.npm.aws.sns

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * SNS Options
  * @param apiVersion the given API version
  */
class SNSOptions(var apiVersion: js.UndefOr[String] = js.undefined) extends js.Object

/**
  * SNS Options Companion
  * @author lawrence.daniels@gmail.com
  */
object SNSOptions extends FlexibleOptions[SNSOptions]
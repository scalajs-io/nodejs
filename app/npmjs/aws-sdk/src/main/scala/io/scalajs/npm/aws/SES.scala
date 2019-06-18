package io.scalajs.npm.aws

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * AWS.SES
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "SES")
class SES(options: RawOptions = js.native) extends js.Object {

  def cloneReceiptRuleSet[T](params: js.Dictionary[js.Any], callback: js.Function2[AWSError, T, Any]): Unit = js.native

}


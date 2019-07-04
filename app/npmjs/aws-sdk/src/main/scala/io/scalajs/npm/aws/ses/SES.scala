package io.scalajs.npm.aws.ses

import io.scalajs.npm.aws.AWSError

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * AWS.SES
  * @example {{{
  *
  *   var ses = new AWS.SES();
  *   ses.cloneReceiptRuleSet(params, function (err, data) {
  *     if (err) console.log(err, err.stack); // an error occurred
  *     else     console.log(data);           // successful response
  *   });
  *
  * }}}
  * @see [[https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/SES.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "SES")
class SES(options: js.Any = js.native) extends js.Object {

  def cloneReceiptRuleSet[T](params: js.Dictionary[js.Any], callback: js.Function2[AWSError, T, Any]): Unit = js.native

}


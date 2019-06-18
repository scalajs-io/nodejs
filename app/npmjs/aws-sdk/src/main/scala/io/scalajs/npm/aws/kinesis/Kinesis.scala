package io.scalajs.npm.aws.kinesis

import io.scalajs.RawOptions
import io.scalajs.npm.aws.{AWSCallback, AWSRequest, Service}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * AWS.Kinesis - Constructs a service interface object. Each API operation is exposed as a function on service.
  * @example {{{
  *
  *   var kinesis = new AWS.Kinesis();
  *   kinesis.addTagsToStream(params, function (err, data) {
  *     if (err) console.log(err, err.stack); // an error occurred
  *     else     console.log(data);           // successful response
  *   });
  *
  * }}}
  * @see [[https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Kinesis.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "Kinesis")
class Kinesis(options: KinesisOptions | RawOptions = js.native) extends Service {

  /**
    * Adds or updates tags for the specified Kinesis data stream. Each time you invoke this operation, you can specify
    * up to 10 tags. If you want to add more than 10 tags to your stream, you can invoke this operation multiple times.
    * In total, each stream can have up to 50 tags.
    *
    * If tags have already been assigned to the stream, AddTagsToStream overwrites any existing tags that correspond to
    * the specified tag keys.
    *
    * [[AddTagsToStream]] has a limit of five transactions per second per account.
    * @param params
    * @return
    */
  def addTagsToStream(params: AddTagsToStream | RawOptions): AWSRequest[Unit] = js.native

  def addTagsToStream(params: AddTagsToStream | RawOptions, callback: AWSCallback[Unit]): Unit = js.native

}


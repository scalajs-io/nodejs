package io.scalajs.npm.aws.kinesis

import scala.scalajs.js

/**
  * Delete Stream
  * @param EnforceConsumerDeletion If this parameter is unset (null) or if you set it to false, and the stream has
  *                                registered consumers, the call to DeleteStream fails with a ResourceInUseException.
  * @param StreamName              The name of the stream to delete.
  * @example {{{
  * {
  *    "EnforceConsumerDeletion": boolean,
  *    "StreamName": "string"
  * }
  * }}}
  * @see [[https://docs.aws.amazon.com/kinesis/latest/APIReference/API_DeleteStream.html]]
  */
class DeleteStream(var EnforceConsumerDeletion: js.UndefOr[Boolean] = js.undefined,
                   var StreamName: js.UndefOr[String] = js.undefined) extends js.Object
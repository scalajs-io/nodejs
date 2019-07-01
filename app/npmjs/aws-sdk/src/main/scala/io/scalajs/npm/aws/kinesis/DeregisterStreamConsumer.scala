package io.scalajs.npm.aws.kinesis

import scala.scalajs.js

/**
  * Deregister Stream Consumer
  * @param ConsumerARN  The ARN returned by Kinesis Data Streams when you registered the consumer. If you don't know
  *                     the ARN of the consumer that you want to deregister, you can use the ListStreamConsumers
  *                     operation to get a list of the descriptions of all the consumers that are currently registered
  *                     with a given data stream. The description of a consumer contains its ARN.
  * @param ConsumerName The name that you gave to the consumer.
  * @param StreamARN    The ARN of the Kinesis data stream that the consumer is registered with. For more information,
  *                     see Amazon Resource Names (ARNs) and AWS Service Namespaces.
  * @example {{{
  * {
  *    "ConsumerARN": "string",
  *    "ConsumerName": "string",
  *    "StreamARN": "string"
  * }
  * }}}
  * @see [[https://docs.aws.amazon.com/kinesis/latest/APIReference/API_DeregisterStreamConsumer.html]]
  */
class DeregisterStreamConsumer(var ConsumerARN: js.UndefOr[String] = js.undefined,
                               var ConsumerName: js.UndefOr[String] = js.undefined,
                               var StreamARN: js.UndefOr[String] = js.undefined) extends js.Object
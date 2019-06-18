package io.scalajs.npm.kafkanode

import scala.scalajs.js


/**
  * Produce Request
  * @param topic      the topic
  * @param messages   the message or messages to produce
  * @param key        the message key
  * @param partition  the topic partition (defaults to 0)
  * @param attributes the attributes controls compression of the message set. It supports the following values:
  *                   <ul>
  *                   <li>0: No compression</li>
  *                   <li>1: Compress using GZip</li>
  *                   <li>2: Compress using snappy</li>
  *                   </ul>
  * @author lawrence.daniels@gmail.com
  */

class ProduceRequest(var topic: String,
                     var messages: js.Any,
                     var key: js.Any = js.undefined,
                     var partition: js.UndefOr[Int] = js.undefined,
                     var attributes: js.UndefOr[Int] = js.undefined)
  extends js.Object
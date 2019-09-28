package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

package object dgram {
  type StringMessage = String | js.Array[String]
  type Message       = BufferMessage | StringMessage
  type BufferMessage = Uint8Array | js.Array[Uint8Array]
}

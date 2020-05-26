package io.scalajs.nodejs.util

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Uint8Array
@js.native
@JSImport("util", "TextEncoder")
// TODO: The class can be  available on the global object when Node.js v10 is drooped
class TextEncoder() extends js.Object {
  def this(encoding: String) = this()

  val encoding: String = js.native

  def encode(text: String): Uint8Array = js.native
}

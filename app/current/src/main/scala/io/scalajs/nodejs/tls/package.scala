package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.|

package object tls {
  type SecureContext = js.Any

  type SecureData = String | js.Array[String] | Buffer | js.Array[Buffer]

  type SecureDataObjectForm = js.Object
}

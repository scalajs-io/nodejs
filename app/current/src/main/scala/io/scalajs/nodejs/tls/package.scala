package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray}
import scala.scalajs.js.|

package object tls {
  type SecureContext = js.Any

  type SecureData = String | js.Array[String] | Buffer | js.Array[Buffer]

  type SecureDataObjectForm = js.Object

  type ALPNProtocols =
    Buffer | TypedArray[_, _] | DataView | js.Array[String] | js.Array[TypedArray[_, _]] | js.Array[DataView]
}

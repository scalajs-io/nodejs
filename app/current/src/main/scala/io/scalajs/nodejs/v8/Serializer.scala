package io.scalajs.nodejs.v8

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{ArrayBuffer, DataView, TypedArray}
import scala.scalajs.js.|

@js.native
@JSImport("v8", "Serializer")
class Serializer() extends js.Object {
  def writeHeader(): Unit = js.native

  def writeValue(value: js.Any): Unit = js.native

  def releaseBuffer(): Buffer = js.native

  def transferArrayBuffer(id: Int, arrayBuffer: ArrayBuffer): Unit = js.native

  def writeUint32(value: Int): Unit = js.native

  def writeUint32(hi: Int, lo: Int): Unit = js.native

  def writeDouble(value: Double): Unit = js.native

  def writeRawBytes(buffer: TypedArray[_, _]): Unit = js.native

  def writeRawBytes(buffer: DataView): Unit = js.native

  protected def _writeHostObject(obj: TypedArray[_, _] | DataView): Unit = js.native

  protected def _getDataCloneError(message: String): io.scalajs.nodejs.Error = js.native

  protected def _getSharedArrayBufferId(sharedArrayBuffer: SharedArrayBuffer): Int = js.native
}
@js.native
@JSImport("v8", "DefaultSerializer")
class DefaultSerializer extends Serializer

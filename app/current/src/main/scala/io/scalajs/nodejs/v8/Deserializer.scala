package io.scalajs.nodejs.v8

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{ArrayBuffer, DataView, TypedArray}
import scala.scalajs.js.|

@js.native
@JSImport("v8", "Deserializer")
class Deserializer() extends js.Object {
  def readHeader(): Unit = js.native

  def readValue(): Buffer = js.native

  def transferArrayBuffer(id: Int, arrayBuffer: ArrayBuffer): Unit = js.native

  def transferArrayBuffer(id: Int, arrayBuffer: SharedArrayBuffer): Unit = js.native

  def getWireFormatVersion(): Int = js.native

  def readUint32(): Int = js.native

  def readUint64(): js.Tuple2[Int, Int] = js.native

  def readDouble(): Double = js.native

  def readRawBytes(length: Int): Buffer = js.native

  protected def _readHostObject(): TypedArray[_, _] | DataView = js.native
}

@js.native
@JSImport("v8", "DefaultDeserializer")
class DefaultDeserializer extends Deserializer

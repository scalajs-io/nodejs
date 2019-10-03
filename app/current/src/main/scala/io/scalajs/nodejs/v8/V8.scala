package io.scalajs.nodejs.v8

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{DataView, TypedArray}

@js.native
trait V8 extends js.Object {
  def cachedDataVersionTag(): Int = js.native

  def getHeapSpaceStatistics(): js.Array[HeapSpaceStatistics] = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs12)
  def getHeapSnapshot(): io.scalajs.nodejs.stream.Readable = js.native

  def getHeapStatistics(): HeapStatistics = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs12)
  def getHeapCodeStatistics(): HeapCodeStatistics = js.native

  def setFlagsFromString(flags: String): Unit = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs12)
  def writeHeapSnapshot(filename: String = js.native): String = js.native

  def serialize(value: js.Any): Buffer = js.native

  def deserialize(value: TypedArray[_, _]): Buffer = js.native
  def deserialize(value: DataView): Buffer         = js.native
}

@js.native
@JSImport("v8", JSImport.Namespace)
object V8 extends V8

@js.native
trait HeapSpaceStatistics extends js.Object {
  def space_name: String = js.native
  def space_size: Double
  def space_used_size: Double
  def space_available_size: Double
  def physical_space_size: Double
}

@js.native
trait HeapStatistics extends js.Object {
  def total_heap_size: Double             = js.native
  def total_heap_size_executable: Double  = js.native
  def total_physical_size: Double         = js.native
  def total_available_size: Double        = js.native
  def used_heap_size: Double              = js.native
  def heap_size_limit: Double             = js.native
  def malloced_memory: Double             = js.native
  def peak_malloced_memory: Double        = js.native
  def does_zap_garbage: Double            = js.native
  def number_of_native_contexts: Double   = js.native
  def number_of_detached_contexts: Double = js.native
}

@js.native
trait HeapCodeStatistics extends js.Object {
  def code_and_metadata_size: Double      = js.native
  def bytecode_and_metadata_size: Double  = js.native
  def external_script_source_size: Double = js.native
}

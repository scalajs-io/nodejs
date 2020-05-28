package io.scalajs.nodejs.module

import com.thoughtworks.enableMembersIf
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@enableMembersIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
@JSImport("module", "SourceMap")
class SourceMap(payload: SourceMapPayload) extends js.Object {
  def payload: SourceMapPayload                                     = js.native
  def findEntry(lineNumber: Int, columnNumber: Int): SourceMapEntry = js.native
}

@Factory
trait SourceMapPayload extends js.Object {
  var file: String
  var version: Double
  var sources: js.Array[String]
  var sourcesContent: js.Array[String]
  var names: js.Array[String]
  var mappings: String
  var sourceRoot: String
}

@Factory
trait SourceMapEntry extends js.Object {
  var generatedLine: Int
  var generatedColumn: Int
  var originalSource: String
  var originalLine: Int
  var originalColumn: Int
}

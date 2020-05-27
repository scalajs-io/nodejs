package io.scalajs.nodejs.child_process

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.|

@Factory
trait SpawnSyncResult {
  var pid: Int
  var output: js.Array[Output]
  var stdout: Output
  var stderr: Output
  var status: Int | Null
  var signal: String | Null
  var error: js.UndefOr[js.Error] = js.undefined
}

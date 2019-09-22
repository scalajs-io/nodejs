package io.scalajs.nodejs.child_process

import scala.scalajs.js
import scala.scalajs.js.|

class SpawnSyncResult(
    val pid: Int,
    val output: js.Array[Output],
    val stdout: Output,
    val stderr: Output,
    val status: Int | Null,
    val signal: String | Null,
    val error: js.UndefOr[js.Error]
) extends js.Object

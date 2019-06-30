package io.scalajs.nodejs.child_process

import scala.scalajs.js

class SpawnResult(
    val pid: Int,
    val output: js.Array[Output],
    val stdout: Output,
    val stderr: Output,
    val status: js.UndefOr[Int],
    val signal: js.UndefOr[String],
    val error: js.UndefOr[js.Error]
) extends js.Object

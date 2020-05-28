package io.scalajs.nodejs.worker_threads

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait WorkerOptions extends js.Object {
  var env: js.UndefOr[js.Object]             = js.undefined
  var eval: js.UndefOr[Boolean]              = js.undefined
  var execArgv: js.UndefOr[js.Array[String]] = js.undefined
  var stdin: js.UndefOr[Boolean]             = js.undefined
  var stdout: js.UndefOr[Boolean]            = js.undefined
  var stderr: js.UndefOr[Boolean]            = js.undefined
  var workerData: js.UndefOr[js.Any]         = js.undefined
}

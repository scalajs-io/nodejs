package io.scalajs.npm.mongoose

import io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The Mongoose CastError constructor
  * @param `type` The name of the type
  * @param value  The value that failed to cast
  * @param path   The path a.b.c in the doc where this cast error occurred
  * @param reason The original error that was thrown
  */
@js.native
@JSImport("mongoose", "CastError")
class CastError(val `type`: String,
                val value: js.Any,
                val path: String,
                val reason: nodejs.Error = js.native)
  extends js.Object
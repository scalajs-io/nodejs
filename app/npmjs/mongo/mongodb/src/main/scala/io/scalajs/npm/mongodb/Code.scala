package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * A class representation of the BSON Code type.
  * @param code  a string or function.
  * @param scope an optional scope for the function.
  */
@js.native
@JSImport("mongodb", "Code")
class Code(code: String | js.Function, scope: js.Any = js.native) extends js.Object
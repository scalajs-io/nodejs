package io.scalajs.nodejs

import scala.scalajs.js

package object v8 {
  // TODO: SharedArrayBuffer is not supported in Scala.js yet
  type SharedArrayBuffer = js.Object
}

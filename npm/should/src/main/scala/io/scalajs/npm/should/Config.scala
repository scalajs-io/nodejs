package io.scalajs.npm.should

import scala.scalajs.js

@js.native
trait Config extends js.Object {

  /**
    * Affect if .eql will check objects prototypes
    */
  var checkProtoEql: Boolean = js.native

  /**
    * - Affect if .eql will treat +0 and -0 as equal
    */
  var plusZeroAndMinusZeroEqual: Boolean = js.native

}
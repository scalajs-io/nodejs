package io.scalajs.nodejs.stream

import scala.scalajs.js

/**
  * Transform streams are Duplex streams where the output is in some way computed from the input.
  * They implement both the Readable and Writable interfaces.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Transform extends Duplex

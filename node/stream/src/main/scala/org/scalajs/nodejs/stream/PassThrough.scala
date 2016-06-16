package org.scalajs.nodejs.stream

import scala.scalajs.js

/**
  * This is a trivial implementation of a Transform stream that simply passes the input bytes across to the output.
  * Its purpose is mainly for examples and testing, but there are occasionally use cases where it can come in handy
  * as a building block for novel sorts of streams.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait PassThrough extends Transform
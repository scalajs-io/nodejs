package com.github.ldaniels528.meansjs.nodejs.stream

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Duplex Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DuplexOptions extends js.Object {

  /**
    * Default = true. If set to false, then the stream will automatically end the readable side
    * when the writable side ends and vice versa.
    */
  var allowHalfOpen: js.UndefOr[Boolean] = js.native

  /**
    * Default = false. Sets objectMode for readable side of the stream. Has no effect if objectMode is true.
    */
  var readableObjectMode: js.UndefOr[Boolean] = js.native

  /**
    * Default = false. Sets objectMode for writable side of the stream. Has no effect if objectMode is true.
    */
  var writableObjectMode: js.UndefOr[Boolean] = js.native

}

/**
  * Duplex Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DuplexOptions {

  def apply(allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
            readableObjectMode: js.UndefOr[Boolean] = js.undefined,
            writableObjectMode: js.UndefOr[Boolean] = js.undefined) = {
    val options = makeNew[DuplexOptions]
    options.allowHalfOpen = allowHalfOpen
    options.readableObjectMode = readableObjectMode
    options.writableObjectMode = writableObjectMode
    options
  }

}

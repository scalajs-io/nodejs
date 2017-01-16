package io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Duplex Options
  * @param allowHalfOpen      If set to false, then the stream will automatically end the readable side
  *                           when the writable side ends and vice versa (Default: true).
  * @param readableObjectMode Sets objectMode for readable side of the stream. Has no effect if objectMode is true (Default: false).
  * @param writableObjectMode Sets objectMode for writable side of the stream. Has no effect if objectMode is true (Default: false).
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DuplexOptions(var allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
                    var readableObjectMode: js.UndefOr[Boolean] = js.undefined,
                    var writableObjectMode: js.UndefOr[Boolean] = js.undefined) extends js.Object
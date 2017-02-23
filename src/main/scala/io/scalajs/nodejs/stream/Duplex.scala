package io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

/**
  * A "duplex" stream is one that is both Readable and Writable, such as a TCP socket connection.
  * <p/><b>Note</b> that stream.Duplex is an abstract class designed to be extended with an underlying
  * implementation of the stream._read(size) and stream._write(chunk, encoding, callback) methods as you
  * would with a Readable or Writable stream class.
  *
  * Since JavaScript doesn't have multiple prototypal inheritance, this class prototypally inherits
  * from Readable, and then parasitically from Writable. It is thus up to the user to implement both
  * the low-level stream._read(n) method as well as the low-level stream._write(chunk, encoding, callback)
  * method on extension duplex classes.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Duplex")
class Duplex(options: DuplexOptions) extends Readable with Writable

/**
  * Duplex Options
  * @param allowHalfOpen      If set to false, then the stream will automatically end the readable side
  *                           when the writable side ends and vice versa (Default: true).
  * @param readableObjectMode Sets objectMode for readable side of the stream. Has no effect if objectMode is true (Default: false).
  * @param writableObjectMode Sets objectMode for writable side of the stream. Has no effect if objectMode is true (Default: false).
  */
@ScalaJSDefined
class DuplexOptions(val allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
                    val readableObjectMode: js.UndefOr[Boolean] = js.undefined,
                    val writableObjectMode: js.UndefOr[Boolean] = js.undefined)
  extends js.Object
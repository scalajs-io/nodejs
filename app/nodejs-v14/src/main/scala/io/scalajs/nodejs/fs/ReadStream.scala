package io.scalajs.nodejs
package fs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * fs.ReadStream - ReadStream is a Readable Stream.
  * @see https://nodejs.org/api/stream.html#stream_class_stream_readable
  */
@js.native
@JSImport("fs", "ReadStream")
class ReadStream(path: Path) extends stream.Readable {
  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The number of bytes read so far.
    */
  def bytesRead: js.UndefOr[Double] = js.native

  /**
    * The path to the file the stream is reading from as specified in the first argument to fs.createReadStream().
    * If path is passed as a string, then readStream.path will be a string. If path is passed as a Buffer, then
    * readStream.path will be a Buffer.
    */
  def path: Buffer | String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Undocumented method
    * @see https://github.com/nodejs/node-v0.x-archive/blob/cfcb1de130867197cbc9c6012b7e84e08e53d032/lib/fs.js#L1597-L1620
    */
  def close(callback: js.Function1[Unit, Any]): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  val pending: Boolean = js.native
}

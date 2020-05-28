package io.scalajs.nodejs
package fs

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * fs.WriteStream - WriteStream is a Writable Stream.
  * @see https://nodejs.org/api/fs.html#fs_class_fs_writestream
  */
@js.native
@JSImport("fs", "ReadStream")
class WriteStream(path: Path) extends stream.Writable {
  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The number of bytes written so far. Does not include data that is still queued for writing.
    */
  def bytesWritten: Double = js.native

  /**
    * The path to the file the stream is writing to as specified in the first argument to fs.createWriteStream().
    * If path is passed as a string, then writeStream.path will be a string. If path is passed as a Buffer, then
    * writeStream.path will be a Buffer.
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
}

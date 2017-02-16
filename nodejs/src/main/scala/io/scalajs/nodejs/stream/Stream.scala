package io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * A stream is an abstract interface for working with streaming data in Node.js. The stream module
  * provides a base API that makes it easy to build objects that implement the stream interface.
  *
  * There are many stream objects provided by Node.js. For instance, a request to an HTTP server
  * and process.stdout are both stream instances.
  *
  * Streams can be readable, writable, or both. All streams are instances of EventEmitter.
  * @see https://nodejs.org/api/stream.html#stream_stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("stream", JSImport.Namespace)
object Stream extends Stream

/**
  * Stream Type Definition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Stream extends js.Object {

  def PassThrough: js.Function0[PassThrough] = js.native

  def Readable: js.Function0[Readable] = js.native

  def Writable: js.Function0[Writable] = js.native

}

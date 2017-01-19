package io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

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
trait Duplex extends Readable with Writable

@js.native
@JSName("Duplex")
object Duplex extends DuplexClass
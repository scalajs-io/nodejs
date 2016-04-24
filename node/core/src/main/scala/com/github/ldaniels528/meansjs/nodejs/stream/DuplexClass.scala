package com.github.ldaniels528.meansjs.nodejs.stream

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

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
trait DuplexClass extends js.Object

/**
  * Duplex Class Companion
  * @author lawrence.daniels@gmail.com
  */
object DuplexClass {

  /**
    * Duplex Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class DuplexClassExtensions(val `class`: DuplexClass) extends AnyVal {

    /**
      * Creates a new Duplex instance
      * @param options the given [[DuplexOptions options]]
      * @return a new [[Duplex Duplex instance]]
      */
    def apply(options: DuplexOptions) = `class`.New[Duplex](options)

  }

}
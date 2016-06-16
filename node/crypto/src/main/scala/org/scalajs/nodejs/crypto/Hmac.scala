package org.scalajs.nodejs.crypto

import org.scalajs.nodejs.stream
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.stream.Duplex

import scala.scalajs.js

/**
  * The Hmac Class is a utility for creating cryptographic HMAC digests. It can be used in one of two ways:
  * <ul>
  * <li>As a stream that is both readable and writable, where data is written to produce a computed HMAC digest on the readable side, or</li>
  * <li>Using the hmac.update() and hmac.digest() methods to produce the computed HMAC digest.</li>
  * </ul>
  *
  * The crypto.createHmac() method is used to create Hmac instances. Hmac objects are not to be created directly using
  * the new keyword.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Hmac extends Duplex {

  /**
    * Calculates the HMAC digest of all of the data passed using hmac.update(). The encoding can be 'hex', 'binary'
    * or 'base64'. If encoding is provided a string is returned; otherwise a Buffer is returned;
    *
    * The Hmac object can not be used again after hmac.digest() has been called. Multiple calls to hmac.digest() will
    * result in an error being thrown.
    * @param encoding the given encoding (e.g. 'hex', 'binary' or 'base64')
    * @return the HMAC hash as a String
    */
  def digest(encoding: String): String = js.native

  /**
    * Calculates the HMAC digest of all of the data passed using hmac.update(). The encoding can be 'hex', 'binary'
    * or 'base64'. If encoding is provided a string is returned; otherwise a Buffer is returned;
    *
    * The Hmac object can not be used again after hmac.digest() has been called. Multiple calls to hmac.digest() will
    * result in an error being thrown.
    * @return the HMAC hash as a String
    */
  def digest(): Buffer = js.native

  /**
    * Updates the Hmac content with the given data, the encoding of which is given in input_encoding and can be 'utf8',
    * 'ascii' or 'binary'. If encoding is not provided, and the data is a string, an encoding of 'utf8' is enforced.
    * If data is a Buffer then input_encoding is ignored.
    *
    * This can be called many times with new data as it is streamed.
    * @param data the given [[String data]]
    */
  def update(data: String): Unit = js.native

  /**
    * Updates the Hmac content with the given data, the encoding of which is given in input_encoding and can be 'utf8',
    * 'ascii' or 'binary'. If encoding is not provided, and the data is a string, an encoding of 'utf8' is enforced.
    * If data is a Buffer then input_encoding is ignored.
    *
    * This can be called many times with new data as it is streamed.
    * @param data           the given [[String data]]
    * @param input_encoding the given encoding (e.g. 'utf8', 'ascii' or 'binary'
    */
  def update(data: String, input_encoding: String): Unit = js.native

  /**
    * Updates the Hmac content with the given data, the encoding of which is given in input_encoding and can be 'utf8',
    * 'ascii' or 'binary'. If encoding is not provided, and the data is a string, an encoding of 'utf8' is enforced.
    * If data is a Buffer then input_encoding is ignored.
    *
    * This can be called many times with new data as it is streamed.
    * @param data the given [[Buffer data]]
    */
  def update(data: Buffer): Unit = js.native

}

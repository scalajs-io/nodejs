package org.scalajs.nodejs.crypto

import org.scalajs.nodejs.stream
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.stream.Duplex

import scala.scalajs.js

/**
  * Instances of the Decipher class are used to decrypt data. The class can be used in one of two ways:
  * <ul>
  * <li>As a stream that is both readable and writable, where plain encrypted data is written to produce unencrypted data on the readable side, or</li>
  * <li>Using the decipher.update() and decipher.final() methods to produce the unencrypted data.</li>
  * </ul>
  *
  * The crypto.createDecipher() or crypto.createDecipheriv() methods are used to create Decipher instances.
  * Decipher objects are not to be created directly using the new keyword.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Decipher extends Duplex {

  /**
    * Returns any remaining deciphered contents. If output_encoding parameter is one of 'binary', 'base64' or 'hex',
    * a string is returned. If an output_encoding is not provided, a Buffer is returned.
    *
    * Once the decipher.final() method has been called, the Decipher object can no longer be used to decrypt data.
    * Attempts to call decipher.final() more than once will result in an error being thrown.
    * @example decipher.final([output_encoding])
    */
  def `final`(output_encoding: String = null): js.Any = js.native

  /**
    * When using an authenticated encryption mode (only GCM is currently supported), the cipher.setAAD() method sets
    * the value used for the additional authenticated data (AAD) input parameter.
    * @example decipher.setAAD(buffer)
    */
  def setAAD(buffer: Buffer): Unit = js.native

  /**
    * When using an authenticated encryption mode (only GCM is currently supported), the decipher.setAuthTag() method
    * is used to pass in the received authentication tag. If no tag is provided, or if the cipher text has been tampered
    * with, decipher.final() with throw, indicating that the cipher text should be discarded due to failed authentication.
    * @example decipher.setAuthTag(buffer)
    */
  def setAuthTag(buffer: Buffer): Unit = js.native

  /**
    * When data has been encrypted without standard block padding, calling decipher.setAutoPadding(false) will disable
    * automatic padding to prevent decipher.final() from checking for and removing padding.
    *
    * Turning auto padding off will only work if the input data's length is a multiple of the ciphers block size.
    * The decipher.setAutoPadding() method must be called before decipher.update().
    * @example decipher.setAutoPadding(auto_padding=true)
    */
  def setAutoPadding(auto_padding: Boolean = true): Unit = js.native

  /**
    * Updates the decipher with data. If the input_encoding argument is given, it's value must be one of 'binary',
    * 'base64', or 'hex' and the data argument is a string using the specified encoding. If the input_encoding
    * argument is not given, data must be a Buffer. If data is a Buffer then input_encoding is ignored.
    *
    * The output_encoding specifies the output format of the enciphered data, and can be 'binary', 'ascii' or 'utf8'.
    * If the output_encoding is specified, a string using the specified encoding is returned. If no output_encoding
    * is provided, a Buffer is returned.
    *
    * The decipher.update() method can be called multiple times with new data until decipher.final() is called.
    * Calling decipher.update() after decipher.final() will result in an error being thrown.
    * @example decipher.update(data[, input_encoding][, output_encoding])
    */
  def update(data: String, input_encoding: String, output_encoding: String = null): Unit = js.native

  /**
    * Updates the decipher with data. If the input_encoding argument is given, it's value must be one of 'binary',
    * 'base64', or 'hex' and the data argument is a string using the specified encoding. If the input_encoding
    * argument is not given, data must be a Buffer. If data is a Buffer then input_encoding is ignored.
    *
    * The output_encoding specifies the output format of the enciphered data, and can be 'binary', 'ascii' or 'utf8'.
    * If the output_encoding is specified, a string using the specified encoding is returned. If no output_encoding
    * is provided, a Buffer is returned.
    *
    * The decipher.update() method can be called multiple times with new data until decipher.final() is called.
    * Calling decipher.update() after decipher.final() will result in an error being thrown.
    * @example decipher.update(data[, input_encoding][, output_encoding])
    */
  def update(data: Buffer): Unit = js.native

}

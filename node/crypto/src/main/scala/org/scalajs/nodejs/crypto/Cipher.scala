package org.scalajs.nodejs.crypto

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.stream.Duplex

import scala.scalajs.js

/**
  * Instances of the Cipher class are used to encrypt data. The class can be used in one of two ways:
  * <ul>
  * <li>As a stream that is both readable and writable, where plain unencrypted data is written to produce encrypted
  * data on the readable side, or</li>
  * <li>Using the cipher.update() and cipher.final() methods to produce the encrypted data.</li>
  * </ul>
  * The crypto.createCipher() or crypto.createCipheriv() methods are used to create Cipher instances. Cipher objects
  * are not to be created directly using the new keyword.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Cipher extends Duplex {

  /**
    * Returns any remaining enciphered contents. If output_encoding parameter is one of 'binary', 'base64' or 'hex',
    * a string is returned. If an output_encoding is not provided, a Buffer is returned.
    *
    * Once the cipher.final() method has been called, the Cipher object can no longer be used to encrypt data.
    * Attempts to call cipher.final() more than once will result in an error being thrown.
    * @example cipher.final([output_encoding])
    */
  def `final`(output_encoding: String = null): js.Any = js.native

  /**
    * When using an authenticated encryption mode (only GCM is currently supported), the cipher.setAAD() method sets
    * the value used for the additional authenticated data (AAD) input parameter.
    * @example cipher.setAAD(buffer)
    */
  def setAAD(buffer: Buffer): Unit = js.native

  /**
    * When using an authenticated encryption mode (only GCM is currently supported), the cipher.getAuthTag() method
    * returns a Buffer containing the authentication tag that has been computed from the given data.
    *
    * The cipher.getAuthTag() method should only be called after encryption has been completed using the cipher.final() method.
    * @example cipher.getAuthTag()
    */
  def getAuthTag(): js.Any = js.native

  /**
    * When using block encryption algorithms, the Cipher class will automatically add padding to the input data to the
    * appropriate block size. To disable the default padding call cipher.setAutoPadding(false).
    *
    * When auto_padding is false, the length of the entire input data must be a multiple of the cipher's block size
    * or cipher.final() will throw an Error. Disabling automatic padding is useful for non-standard padding, for
    * instance using 0x0 instead of PKCS padding.
    *
    * The cipher.setAutoPadding() method must be called before cipher.final().
    * @example cipher.setAutoPadding(auto_padding=true)
    */
  def setAutoPadding(auto_padding: Boolean = true): Unit = js.native

  /**
    * Updates the cipher with data. If the input_encoding argument is given, it's value must be one of 'utf8', 'ascii',
    * or 'binary' and the data argument is a string using the specified encoding. If the input_encoding argument is not
    * given, data must be a Buffer. If data is a Buffer then input_encoding is ignored.
    *
    * The output_encoding specifies the output format of the enciphered data, and can be 'binary', 'base64' or 'hex'.
    * If the output_encoding is specified, a string using the specified encoding is returned. If no output_encoding is
    * provided, a Buffer is returned.
    *
    * The cipher.update() method can be called multiple times with new data until cipher.final() is called. Calling
    * cipher.update() after cipher.final() will result in an error being thrown.
    * @example cipher.update(data[, input_encoding][, output_encoding])
    */
  def update(data: String, input_encoding: String, output_encoding: String = null): Unit = js.native

  /**
    * Updates the cipher with data. If the input_encoding argument is given, it's value must be one of 'utf8', 'ascii',
    * or 'binary' and the data argument is a string using the specified encoding. If the input_encoding argument is not
    * given, data must be a Buffer. If data is a Buffer then input_encoding is ignored.
    *
    * The output_encoding specifies the output format of the enciphered data, and can be 'binary', 'base64' or 'hex'.
    * If the output_encoding is specified, a string using the specified encoding is returned. If no output_encoding is
    * provided, a Buffer is returned.
    *
    * The cipher.update() method can be called multiple times with new data until cipher.final() is called. Calling
    * cipher.update() after cipher.final() will result in an error being thrown.
    * @example cipher.update(data[, input_encoding][, output_encoding])
    */
  def update(data: Buffer): Unit = js.native

}

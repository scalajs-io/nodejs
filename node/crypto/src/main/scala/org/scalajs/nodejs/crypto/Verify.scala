package org.scalajs.nodejs.crypto

import org.scalajs.nodejs.stream
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.stream.Duplex

import scala.scalajs.js

/**
  * The Verify class is a utility for verifying signatures. It can be used in one of two ways:
  * <ul>
  * <li>As a writable stream where written data is used to validate against the supplied signature, or</li>
  * <li>Using the verify.update() and verify.verify() methods to verify the signature.</li>
  * </ul>
  * The crypto.createSign() method is used to create Sign instances. Sign objects are not to be created directly using
  * the new keyword.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Verify extends Duplex {

  /**
    * Updates the Verify content with the given data.
    * This can be called many times with new data as it is streamed.
    * @param data           with the given data
    * @param input_encoding the encoding of which is given in input_encoding and can be
    *                       'utf8', 'ascii' or 'binary'. If encoding is not provided, and the data is a string, an
    *                       encoding of 'utf8' is enforced. If data is a Buffer then input_encoding is ignored.
    */
  def update(data: String, input_encoding: String): Unit = js.native

  /**
    * Updates the Verify content with the given data.
    * This can be called many times with new data as it is streamed.
    * @param data with the given data
    */
  def update(data: Buffer): Unit = js.native

  /**
    * Verifies the provided data using the given object and signature.
    *
    * The verifier object can not be used again after verify.verify() has been called. Multiple calls to verify.verify()
    * will result in an error being thrown.
    * @param `object`         The object argument is a string containing a PEM encoded object, which can be one an
    *                         RSA public key, a DSA public key, or an X.509 certificate.
    * @param signature        The signature argument is the previously calculated signature for the data, in the
    *                         signature_format which can be 'binary', 'hex' or 'base64'.
    * @param signature_format If a signature_format is specified, the signature is expected to be a string; otherwise
    *                         signature is expected to be a Buffer.
    * @return true or false depending on the validity of the signature for the data and public key.
    */
  def verify(`object`: String, signature: String, signature_format: String): Boolean = js.native

  /**
    * Verifies the provided data using the given object and signature.
    *
    * The verifier object can not be used again after verify.verify() has been called. Multiple calls to verify.verify()
    * will result in an error being thrown.
    * @param `object`  The object argument is a string containing a PEM encoded object, which can be one an
    *                  RSA public key, a DSA public key, or an X.509 certificate.
    * @param signature The signature argument is the previously calculated signature for the data.
    * @return true or false depending on the validity of the signature for the data and public key.
    */
  def verify(`object`: String, signature: Buffer): Boolean = js.native

}

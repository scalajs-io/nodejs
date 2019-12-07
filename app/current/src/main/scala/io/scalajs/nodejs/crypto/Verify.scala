package io.scalajs.nodejs.crypto

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.stream.Writable

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The Verify class is a utility for verifying signatures. It can be used in one of two ways:
  * <ul>
  * <li>As a writable stream where written data is used to validate against the supplied signature, or</li>
  * <li>Using the verify.update() and verify.verify() methods to verify the signature.</li>
  * </ul>
  * The crypto.createSign() method is used to create Sign instances. Sign objects are not to be created directly using
  * the new keyword.
  */
@js.native
trait Verify extends Writable {

  /**
    * Updates the Verify content with the given data.
    * This can be called many times with new data as it is streamed.
    * @param data           with the given data
    * @param inputEncoding the encoding of which is given in input_encoding and can be
    *                       'utf8', 'ascii' or 'binary'. If encoding is not provided, and the data is a string, an
    *                       encoding of 'utf8' is enforced. If data is a Buffer then input_encoding is ignored.
    */
  def update(data: String, inputEncoding: String = js.native): Unit = js.native
  def update(data: BufferLike): Unit                                = js.native

  /**
    * Verifies the provided data using the given object and signature.
    *
    * The verifier object can not be used again after verify.verify() has been called. Multiple calls to verify.verify()
    * will result in an error being thrown.
    * @param obj         The object argument is a string containing a PEM encoded object, which can be one an
    *                         RSA public key, a DSA public key, or an X.509 certificate.
    * @param signature        The signature argument is the previously calculated signature for the data, in the
    *                         signature_format which can be 'binary', 'hex' or 'base64'.
    * @param signatureEncoding If a signatureEncoding is specified, the signature is expected to be a string; otherwise
    *                         signature is expected to be a Buffer.
    * @return true or false depending on the validity of the signature for the data and public key.
    */
  def verify(obj: String | Buffer, signature: String, signatureEncoding: String): Boolean = js.native
  def verify(obj: String | Buffer, signature: BufferLike): Boolean                        = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def verify(obj: KeyObject, signature: String, signatureEncoding: String): Boolean = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def verify(obj: KeyObject, signature: BufferLike): Boolean = js.native
}

package com.github.ldaniels528.meansjs.nodejs.crypto

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer

import scala.scalajs.js

/**
  * Crypto module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Crypto extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The default encoding to use for functions that can take either strings or buffers.
    * The default value is 'buffer', which makes methods default to Buffer objects.
    *
    * The crypto.DEFAULT_ENCODING mechanism is provided for backwards compatibility with legacy programs that
    * expect 'binary' to be the default encoding.
    */
  val DEFAULT_ENCODING: String = js.native

  /**
    * Property for checking and controlling whether a FIPS compliant crypto provider is currently in use.
    * Setting to true requires a FIPS build of Node.js.
    */
  var fips: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Classes
  /////////////////////////////////////////////////////////////////////////////////

  def Certificate: js.Function0[js.Dynamic] = js.native

  def Cipher: js.Function0[Cipher] = js.native

  def Decipher: js.Function0[Decipher] = js.native

  def DiffieHellman: js.Function0[js.Dynamic] = js.native

  def ECDH: js.Function0[js.Dynamic] = js.native

  def Hash: js.Function0[js.Dynamic] = js.native

  def Hmac: js.Function0[js.Dynamic] = js.native

  def Sign: js.Function0[js.Dynamic] = js.native

  def Verify: js.Function0[js.Dynamic] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Creates and returns a Cipher object that uses the given algorithm and password.
    * @param algorithm The algorithm is dependent on OpenSSL, examples are 'aes192', etc. On recent OpenSSL releases,
    *                  openssl list-cipher-algorithms will display the available cipher algorithms.
    * @param password  The password is used to derive the cipher key and initialization vector (IV). The value must be
    *                  either a 'binary' encoded string or a Buffer.
    * @example crypto.createCipher(algorithm, password)
    */
  def createCipher(algorithm: String, password: Buffer): Cipher = js.native

  /**
    * Creates and returns a Cipher object that uses the given algorithm and password.
    * @param algorithm The algorithm is dependent on OpenSSL, examples are 'aes192', etc. On recent OpenSSL releases,
    *                  openssl list-cipher-algorithms will display the available cipher algorithms.
    * @param password  The password is used to derive the cipher key and initialization vector (IV). The value must be
    *                  either a 'binary' encoded string or a Buffer.
    * @example crypto.createCipher(algorithm, password)
    */
  def createCipher(algorithm: String, password: String): Cipher = js.native

  /**
    * Creates and returns a Decipher object that uses the given algorithm and password (key).
    * The implementation of crypto.createDecipher() derives keys using the OpenSSL function EVP_BytesToKey with the
    * digest algorithm set to MD5, one iteration, and no salt. The lack of salt allows dictionary attacks as the same
    * password always creates the same key. The low iteration count and non-cryptographically secure hash algorithm
    * allow passwords to be tested very rapidly.
    *
    * In line with OpenSSL's recommendation to use pbkdf2 instead of EVP_BytesToKey it is recommended that developers
    * derive a key and IV on their own using crypto.pbkdf2() and to use crypto.createDecipheriv() to create the Decipher object.
    * @example crypto.createDecipher(algorithm, password)
    */
  def createDecipher(algorithm: String, password: Buffer): Decipher = js.native

  /**
    * Creates and returns a Decipher object that uses the given algorithm and password (key).
    * The implementation of crypto.createDecipher() derives keys using the OpenSSL function EVP_BytesToKey with the
    * digest algorithm set to MD5, one iteration, and no salt. The lack of salt allows dictionary attacks as the same
    * password always creates the same key. The low iteration count and non-cryptographically secure hash algorithm
    * allow passwords to be tested very rapidly.
    *
    * In line with OpenSSL's recommendation to use pbkdf2 instead of EVP_BytesToKey it is recommended that developers
    * derive a key and IV on their own using crypto.pbkdf2() and to use crypto.createDecipheriv() to create the Decipher object.
    * @example crypto.createDecipher(algorithm, password)
    */
  def createDecipher(algorithm: String, password: String): Decipher = js.native

}

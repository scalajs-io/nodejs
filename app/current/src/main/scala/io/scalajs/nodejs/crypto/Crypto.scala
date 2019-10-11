package io.scalajs.nodejs.crypto

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.stream.{TransformOptions, WritableOptions}

import scala.scalajs.js

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The crypto module provides cryptographic functionality that includes a set of wrappers
  * for OpenSSL's hash, HMAC, cipher, decipher, sign and verify functions.
  * @see https://nodejs.org/dist/latest-v7.x/docs/api/crypto.html#crypto_crypto
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
  @deprecated("New applications should expect the default to be 'buffer'.", "Node.js v10.0")
  val DEFAULT_ENCODING: String = js.native

  /**
    * Property for checking and controlling whether a FIPS compliant crypto provider is currently in use.
    * Setting to true requires a FIPS build of Node.js.
    */
  @deprecated("Please use crypto.setFips() and crypto.getFips() instead.", "Node.js v10.0")
  var fips: Boolean = js.native

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
  @deprecated("Use crypto.createCipheriv() instead.", "Node.js v10.0")
  def createCipher(algorithm: String, password: Buffer | String): Cipher = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def createCipheriv(algorithm: String,
                     key: String | BufferLike,
                     iv: String | BufferLike,
                     options: TransformOptions = js.native): Cipher = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createCipheriv(algorithm: String, key: KeyObject, iv: String | BufferLike, options: TransformOptions): Cipher =
    js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createCipheriv(algorithm: String, key: KeyObject, iv: String | BufferLike): Cipher = js.native

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
  @deprecated("Use crypto.createDecipheriv() instead.", "Node.js v10.0")
  def createDecipher(algorithm: String, password: Buffer | String): Decipher = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def createDecipheriv(algorithm: String,
                       key: String | BufferLike,
                       iv: String | BufferLike,
                       options: TransformOptions = js.native): Decipher = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createDecipheriv(algorithm: String,
                       key: KeyObject,
                       iv: String | BufferLike,
                       options: TransformOptions): Decipher = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createDecipheriv(algorithm: String, key: KeyObject, iv: String | BufferLike): Decipher = js.native

  def createDiffieHellman(prime: String, primeEncoding: String, generator: Int | BufferLike): DiffieHellman = js.native
  def createDiffieHellman(prime: String,
                          primeEncoding: String,
                          generator: String,
                          generatorEncoding: String): DiffieHellman                                       = js.native
  def createDiffieHellman(prime: BufferLike, generator: String, generatorEncoding: String): DiffieHellman = js.native
  def createDiffieHellman(prime: BufferLike, generator: Int | BufferLike): DiffieHellman                  = js.native
  def createDiffieHellman(primeLength: Int, generator: Int | String | BufferLike): DiffieHellman          = js.native

  def createDiffieHellmanGroup(name: String): DiffieHellman = js.native

  def createECDH(curveName: String): ECDH = js.native

  /**
    * Creates and returns a Hash object that can be used to generate hash digests using the given algorithm.
    *
    * The algorithm is dependent on the available algorithms supported by the version of OpenSSL on the platform.
    * Examples are 'sha256', 'sha512', etc. On recent releases of OpenSSL, openssl list-message-digest-algorithms
    * will display the available digest algorithms.
    * @param algorithm the given algorithm (e.g. 'sha256', 'sha512')
    */
  def createHash(algorithm: String, options: TransformOptions): Hash              = js.native
  def createHash(algorithm: String, options: CreateHashOptions = js.native): Hash = js.native

  /**
    * Creates and returns an Hmac object that uses the given algorithm and key.
    *
    * The algorithm is dependent on the available algorithms supported by the version of OpenSSL on the platform.
    * Examples are 'sha256', 'sha512', etc. On recent releases of OpenSSL, openssl list-message-digest-algorithms
    * will display the available digest algorithms.
    * @param algorithm the given algorithm (e.g. 'sha256', 'sha512')
    * @param key       The key is the HMAC key used to generate the cryptographic HMAC hash.
    */
  def createHmac(algorithm: String, key: String | BufferLike, options: TransformOptions = js.native): Hmac = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createHmac(algorithm: String, key: KeyObject, options: TransformOptions): Hmac = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createHmac(algorithm: String, key: KeyObject): Hmac = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createPrivateKey(key: String | Buffer | CreatePrivateKeyOptions): KeyObject = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createPublicKey(key: String | Buffer | KeyObject | CreatePublicKeyOptions): KeyObject = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def createSecretKey(key: Buffer): KeyObject = js.native

  /**
    * Creates and returns a Sign object that uses the given algorithm. On recent OpenSSL releases, openssl
    * list-public-key-algorithms will display the available signing algorithms. One example is 'RSA-SHA256'.
    * @param algorithm the given algorithm (e.g. 'RSA-SHA256')
    */
  def createSign(algorithm: String, options: WritableOptions = js.native): Sign = js.native

  /**
    * Creates and returns a Verify object that uses the given algorithm. On recent OpenSSL releases, openssl
    * list-public-key-algorithms will display the available signing algorithms. One example is 'RSA-SHA256'.
    * @param algorithm the given algorithm (e.g. 'RSA-SHA256')
    */
  def createVerify(algorithm: String, options: WritableOptions = js.native): Verify = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def generateKeyPair(
      `type`: String,
      options: GenerateKeyPairOptions,
      callback: Callback2[String | Buffer | KeyObject, String | Buffer | KeyObject]
  ): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def generateKeyPairSync(`type`: String, options: GenerateKeyPairOptions): KeyPair = js.native

  /**
    * Returns an array with the names of the supported cipher algorithms.
    * @return the names of the supported cipher algorithms. // ['aes-128-cbc', 'aes-128-ccm', ...]
    */
  def getCiphers(): js.Array[String] = js.native

  def getCurves(): js.Array[String] = js.native

  def getDiffieHellman(groupName: String): DiffieHellmanGroup = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def getFips(): Boolean = js.native

  def getHashes(): js.Array[String] = js.native

  def pbkdf2(password: String | BufferLike,
             salt: String | BufferLike,
             iterations: Int,
             keylen: Int,
             digest: String,
             callback: Callback1[Buffer]): Buffer = js.native

  /**
    * Provides a synchronous Password-Based Key Derivation Function 2 (PBKDF2) implementation. A selected HMAC digest
    * algorithm specified by digest is applied to derive a key of the requested byte length (keylen) from the password,
    * salt and iterations.
    *
    * If an error occurs an Error will be thrown, otherwise the derived key will be returned as a Buffer.
    *
    * The iterations argument must be a number set as high as possible. The higher the number of iterations, the more
    * secure the derived key will be, but will take a longer amount of time to complete.
    *
    * The salt should also be as unique as possible. It is recommended that the salts are random and their lengths are
    * greater than 16 bytes. See NIST SP 800-132 for details.
    *
    * (Doc source: https://nodejs.org/api/crypto.html#crypto_crypto_pbkdf2sync_password_salt_iterations_keylen_digest)
    */
  def pbkdf2Sync(password: String | BufferLike,
                 salt: String | BufferLike,
                 iterations: Int,
                 keylen: Int,
                 digest: String): Buffer = js.native

  def privateDecrypt(privateKey: String | Buffer, buffer: BufferLike): Buffer = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def privateDecrypt(privateKey: KeyObject, buffer: BufferLike): Buffer = js.native

  def privateEncrypt(privateKey: String | Buffer, buffer: BufferLike): Buffer = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def privateEncrypt(privateKey: KeyObject, buffer: BufferLike): Buffer = js.native

  def publicDecrypt(key: String | Buffer, buffer: BufferLike): Buffer = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def publicDecrypt(key: KeyObject, buffer: BufferLike): Buffer = js.native

  def publicEncrypt(key: String | Buffer, buffer: BufferLike): Buffer = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def publicEncrypt(key: KeyObject, buffer: BufferLike): Buffer = js.native

  def randomBytes(size: Int): Buffer                            = js.native
  def randomBytes(size: Int, callback: Callback1[Buffer]): Unit = js.native

  def randomFillSync(buffer: Buffer, offset: Int, size: Int): Buffer = js.native
  def randomFillSync(buffer: Buffer, offset: Int): Buffer            = js.native
  def randomFillSync(buffer: Buffer): Buffer                         = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFillSync(buffer: scala.scalajs.js.typedarray.DataView,
                     offset: Int,
                     size: Int): scala.scalajs.js.typedarray.DataView = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFillSync(buffer: scala.scalajs.js.typedarray.DataView, offset: Int): scala.scalajs.js.typedarray.DataView =
    js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFillSync(buffer: scala.scalajs.js.typedarray.DataView): scala.scalajs.js.typedarray.DataView = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFillSync[T <: scala.scalajs.js.typedarray.TypedArray[_, T]](buffer: T,
                                                                        offset: Int = js.native,
                                                                        size: Int = js.native): T = js.native

  def randomFill(buffer: Buffer, offset: Int, size: Int, callback: Callback1[Buffer]): Buffer = js.native
  def randomFill(buffer: Buffer, offset: Int, callback: Callback1[Buffer]): Buffer            = js.native
  def randomFill(buffer: Buffer, callback: Callback1[Buffer]): Buffer                         = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFill(buffer: scala.scalajs.js.typedarray.DataView,
                 offset: Int,
                 size: Int,
                 callback: Callback1[scala.scalajs.js.typedarray.DataView]): scala.scalajs.js.typedarray.DataView =
    js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFill(buffer: scala.scalajs.js.typedarray.DataView,
                 offset: Int,
                 callback: Callback1[scala.scalajs.js.typedarray.DataView]): scala.scalajs.js.typedarray.DataView =
    js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFill(buffer: scala.scalajs.js.typedarray.DataView,
                 callback: Callback1[scala.scalajs.js.typedarray.DataView]): scala.scalajs.js.typedarray.DataView =
    js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def randomFill[T <: scala.scalajs.js.typedarray.TypedArray[_, T]](buffer: T,
                                                                    offset: Int = js.native,
                                                                    size: Int = js.native,
                                                                    callback: Callback1[T]): T = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def scrypt(password: String | BufferLike,
             salt: String | BufferLike,
             keylen: Int,
             options: ScryptOptions = js.native,
             callback: Callback1[Buffer]): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def scryptSync(password: String | BufferLike,
                 salt: String | BufferLike,
                 keylen: Int,
                 options: ScryptOptions = js.native): Buffer = js.native

  def setEngine(engine: String, fips: Int = js.native): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def setFips(enable: Boolean): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def sign(algorithm: String = js.native, data: BufferLike, key: String | Buffer | KeyObject): Buffer = js.native

  def timingSafeEqual(a: BufferLike, b: BufferLike): Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def verify(algorithm: String = js.native, data: BufferLike, key: String | Buffer | KeyObject): Boolean = js.native
}

/**
  * Crypto Singleton
  */
@js.native
@JSImport("crypto", JSImport.Namespace)
object Crypto extends Crypto {
  type Certificate   = io.scalajs.nodejs.crypto.Certificate
  type Cipher        = io.scalajs.nodejs.crypto.Cipher
  type Decipher      = io.scalajs.nodejs.crypto.Decipher
  type DiffieHellman = io.scalajs.nodejs.crypto.DiffieHellman
  type ECDH          = io.scalajs.nodejs.crypto.ECDH
  type Hash          = io.scalajs.nodejs.crypto.Hash
  type Hmac          = io.scalajs.nodejs.crypto.Hmac
  type Sign          = io.scalajs.nodejs.crypto.Sign
  type Verify        = io.scalajs.nodejs.crypto.Verify

  val constants: Constants.type = js.native
}

@js.native
@JSImport("crypto", "constants")
object Constants extends js.Object {
  val SSL_OP_ALL: Int                                    = js.native
  val SSL_OP_ALLOW_UNSAFE_LEGACY_RENEGOTIATION: Int      = js.native
  val SSL_OP_CIPHER_SERVER_PREFERENCE: Int               = js.native
  val SSL_OP_CISCO_ANYCONNECT: Int                       = js.native
  val SSL_OP_COOKIE_EXCHANGE: Int                        = js.native
  val SSL_OP_CRYPTOPRO_TLSEXT_BUG: Int                   = js.native
  val SSL_OP_DONT_INSERT_EMPTY_FRAGMENTS: Int            = js.native
  val SSL_OP_EPHEMERAL_RSA: Int                          = js.native
  val SSL_OP_LEGACY_SERVER_CONNECT: Int                  = js.native
  val SSL_OP_MICROSOFT_BIG_SSLV3_BUFFER: Int             = js.native
  val SSL_OP_MICROSOFT_SESS_ID_BUG: Int                  = js.native
  val SSL_OP_MSIE_SSLV2_RSA_PADDING: Int                 = js.native
  val SSL_OP_NETSCAPE_CA_DN_BUG: Int                     = js.native
  val SSL_OP_NETSCAPE_CHALLENGE_BUG: Int                 = js.native
  val SSL_OP_NETSCAPE_DEMO_CIPHER_CHANGE_BUG: Int        = js.native
  val SSL_OP_NETSCAPE_REUSE_CIPHER_CHANGE_BUG: Int       = js.native
  val SSL_OP_NO_COMPRESSION: Int                         = js.native
  val SSL_OP_NO_QUERY_MTU: Int                           = js.native
  val SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION: Int = js.native
  val SSL_OP_NO_SSLv2: Int                               = js.native
  val SSL_OP_NO_SSLv3: Int                               = js.native
  val SSL_OP_NO_TICKET: Int                              = js.native
  val SSL_OP_NO_TLSv1: Int                               = js.native
  val SSL_OP_NO_TLSv1_1: Int                             = js.native
  val SSL_OP_NO_TLSv1_2: Int                             = js.native
  val SSL_OP_PKCS1_CHECK_1: Int                          = js.native
  val SSL_OP_PKCS1_CHECK_2: Int                          = js.native
  val SSL_OP_SINGLE_DH_USE: Int                          = js.native
  val SSL_OP_SINGLE_ECDH_USE: Int                        = js.native
  val SSL_OP_SSLEAY_080_CLIENT_DH_BUG: Int               = js.native
  val SSL_OP_SSLREF2_REUSE_CERT_TYPE_BUG: Int            = js.native
  val SSL_OP_TLS_BLOCK_PADDING_BUG: Int                  = js.native
  val SSL_OP_TLS_D5_BUG: Int                             = js.native
  val SSL_OP_TLS_ROLLBACK_BUG: Int                       = js.native

  val ENGINE_METHOD_RSA: Int             = js.native
  val ENGINE_METHOD_DSA: Int             = js.native
  val ENGINE_METHOD_DH: Int              = js.native
  val ENGINE_METHOD_RAND: Int            = js.native
  val ENGINE_METHOD_EC: Int              = js.native
  val ENGINE_METHOD_CIPHERS: Int         = js.native
  val ENGINE_METHOD_DIGESTS: Int         = js.native
  val ENGINE_METHOD_PKEY_METHS: Int      = js.native
  val ENGINE_METHOD_PKEY_ASN1_METHS: Int = js.native
  val ENGINE_METHOD_ALL: Int             = js.native
  val ENGINE_METHOD_NONE: Int            = js.native

  val DH_CHECK_P_NOT_SAFE_PRIME: Int    = js.native
  val DH_CHECK_P_NOT_PRIME: Int         = js.native
  val DH_UNABLE_TO_CHECK_GENERATOR: Int = js.native
  val DH_NOT_SUITABLE_GENERATOR: Int    = js.native
  val ALPN_ENABLED: Int                 = js.native
  val RSA_PKCS1_PADDING: Int            = js.native
  val RSA_SSLV23_PADDING: Int           = js.native
  val RSA_NO_PADDING: Int               = js.native
  val RSA_PKCS1_OAEP_PADDING: Int       = js.native
  val RSA_X931_PADDING: Int             = js.native
  val RSA_PKCS1_PSS_PADDING: Int        = js.native
  val RSA_PSS_SALTLEN_DIGEST: Int       = js.native
  val RSA_PSS_SALTLEN_MAX_SIGN: Int     = js.native
  val RSA_PSS_SALTLEN_AUTO: Int         = js.native

  val POINT_CONVERSION_COMPRESSED: Int   = js.native
  val POINT_CONVERSION_UNCOMPRESSED: Int = js.native
  val POINT_CONVERSION_HYBRID: Int       = js.native

  val defaultCoreCipherList: String = js.native
  val defaultCipherList: String     = js.native

}

class CreatePrivateKeyOptions(
    val key: String | Buffer,
    var format: js.UndefOr[String] = js.undefined,
    var `type`: js.UndefOr[String] = js.undefined,
    var passphrase: js.UndefOr[String | Buffer] = js.undefined
) extends js.Object

class CreatePublicKeyOptions(
    val key: String | Buffer,
    var format: js.UndefOr[String] = js.undefined,
    var `type`: js.UndefOr[String] = js.undefined
) extends js.Object

class GenerateKeyPairOptions(
    val modulusLength: Int,
    var publicExponent: js.UndefOr[Int] = js.undefined,
    var divisorLength: js.UndefOr[Int] = js.undefined,
    var namedCurve: js.UndefOr[String] = js.undefined,
    var publicKeyEncoding: js.UndefOr[KeyObjectExportOptions] = js.undefined,
    var privateKeyEncoding: js.UndefOr[KeyObjectExportOptions] = js.undefined
) extends js.Object

class ScryptOptions(
    var cost: js.UndefOr[Int] = js.undefined,
    var blockSize: js.UndefOr[Int] = js.undefined,
    var parallelization: js.UndefOr[Int] = js.undefined,
    var N: js.UndefOr[Int] = js.undefined,
    var r: js.UndefOr[Int] = js.undefined,
    var p: js.UndefOr[Int] = js.undefined,
    var maxmem: js.UndefOr[Int] = js.undefined
) extends js.Object

@js.native
trait KeyPair extends js.Object {
  val publicKey: String | Buffer | KeyObject
  val privateKey: String | Buffer | KeyObject
}

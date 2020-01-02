package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

// NOT inherit DiffieHellman
@js.native
trait ECDH extends js.Object {
  def computeSecret(otherPublicKey: String, inputEncoding: String, outputEncoding: String): String   = js.native
  def computeSecret(otherPublicKey: String, inputEncoding: String): Buffer                           = js.native
  def computeSecret(otherPublicKey: BufferLike, inputEncoding: Null, outputEncoding: String): String = js.native
  def computeSecret(otherPublicKey: BufferLike): Buffer                                              = js.native

  def generateKeys(): Buffer                                 = js.native
  def generateKeys(encoding: Null, format: String): Buffer   = js.native
  def generateKeys(encoding: String, format: String): String = js.native

  def getPrivateKey(): Buffer                 = js.native
  def getPrivateKey(encoding: String): String = js.native

  def getPublicKey(): Buffer                                 = js.native
  def getPublicKey(encoding: Null, format: String): Buffer   = js.native
  def getPublicKey(encoding: String): String                 = js.native
  def getPublicKey(encoding: String, format: String): String = js.native

  def setPrivateKey(privateKey: String, encoding: String): ECDH = js.native
  def setPrivateKey(privateKey: BufferLike): ECDH               = js.native
}

@js.native
@JSImport("crypto", "ECDH")
object ECDH extends js.Object {
  def convertKey(key: String, curve: String, inputEncoding: String, outputEncoding: String, format: String): String =
    js.native
  def convertKey(key: BufferLike, curve: String, inputEncoding: Null, outputEncoding: String, format: String): String =
    js.native
  def convertKey(key: String, curve: String, inputEncoding: String, outputEncoding: String): String   = js.native
  def convertKey(key: BufferLike, curve: String, inputEncoding: Null, outputEncoding: String): String = js.native
  def convertKey(key: String, curve: String, inputEncoding: String): Buffer                           = js.native
  def convertKey(key: BufferLike, curve: String, inputEncoding: Null): Buffer                         = js.native
  def convertKey(key: BufferLike, curve: String): Buffer                                              = js.native
  def convertKey(key: BufferLike): Buffer                                                             = js.native
}

package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray}
import scala.scalajs.js.|

@js.native
// TODO: Can be exposed as newable class when Node.js v10 dropped
sealed trait KeyObject extends js.Object {
  def export(options: KeyObjectExportOptions): Buffer | String = js.native
  def export(): Buffer                                         = js.native

  /**
    * For asymmetric keys, this property represents the type of the key.
    * This property is undefined for unrecognized KeyObject types and symmetric keys.
    */
  val asymmetricKeyType: js.UndefOr[String] = js.native

  /**
    * For secret keys, this property represents the size of the key in bytes.
    * This property is undefined for asymmetric keys.
    */
  val symmetricKeySize: js.UndefOr[Int] = js.native

  /**
    * Depending on the type of this KeyObject, this property is either 'secret' for secret (symmetric) keys,
    * 'public' for public (asymmetric) keys or 'private' for private (asymmetric) keys.
    */
  val `type`: String = js.native
}

class KeyObjectExportOptions(
    var `type`: js.UndefOr[String] = js.undefined,
    var format: js.UndefOr[String] = js.undefined,
    var cipher: js.UndefOr[String] = js.undefined,
    var passphrase: js.UndefOr[String | Buffer] = js.undefined
) extends js.Object

class PublicEncryptKeyObject(
    var key: String | Buffer | KeyObject,
    var oaepHash: String = "sha1",
    var oaepLabel: js.UndefOr[Buffer | TypedArray[_, _] | DataView] = js.undefined,
    var passphrase: js.UndefOr[String | Buffer] = js.undefined,
    var padding: js.UndefOr[Int] = js.undefined
) extends js.Object

class PublicDecryptKeyObject(
    var passphrase: js.UndefOr[String | Buffer] = js.undefined,
    var padding: js.UndefOr[Int] = js.undefined
) extends js.Object

class PrivateEncryptKeyObject(
    var key: String | Buffer | KeyObject,
    var passphrase: js.UndefOr[String | Buffer] = js.undefined,
    var padding: js.UndefOr[Int] = js.undefined
) extends js.Object

class PrivateDecryptKeyObject(
    var oaepHash: String = "sha1",
    var oaepLabel: js.UndefOr[Buffer | TypedArray[_, _] | DataView] = js.undefined,
    var padding: js.UndefOr[Int] = js.undefined
) extends js.Object

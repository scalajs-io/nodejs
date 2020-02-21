package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray}
import scala.scalajs.js.|

@js.native
sealed trait KeyObject extends js.Object {
  def export(options: KeyObjectExportOptions): Buffer | String = js.native
  def export(): Buffer                                         = js.native

  val symmetricKeySize: js.UndefOr[Int] = js.native
  val `type`: String                    = js.native
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

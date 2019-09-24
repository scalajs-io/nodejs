package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.|

@js.native
sealed trait KeyObject extends js.Object {
  def export(options: KeyObjectExportOptions): Buffer | String = js.native
  def export(): Buffer                                         = js.native

  val symmetricKeySize: js.UndefOr[Int] = js.native
  val `type`: String                    = js.native
}

class KeyObjectExportOptions(
    val `type`: js.UndefOr[String] = js.undefined,
    val format: js.UndefOr[String] = js.undefined,
    val cipher: js.UndefOr[String] = js.undefined,
    val passphrase: js.UndefOr[String | Buffer] = js.undefined
) extends js.Object

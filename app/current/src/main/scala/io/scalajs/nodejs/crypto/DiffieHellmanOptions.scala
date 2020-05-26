package io.scalajs.nodejs.crypto

import scala.scalajs.js

trait DiffieHellmanOptions {
  var privateKey: KeyObject
  var publicKey: KeyObject
}

object DiffieHellmanOptions {
  def apply(
      privateKey: KeyObject,
      publicKey: KeyObject
  ): DiffieHellmanOptions = {
    val obj = js.Dynamic.literal(
      "privateKey" -> privateKey,
      "publicKey"  -> publicKey
    )
    obj.asInstanceOf[DiffieHellmanOptions]
  }
}

package io.scalajs.nodejs

import io.scalajs.nodejs.{Error => NodeError}

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray}
import scala.scalajs.js.|

package object crypto {
  type BufferLike        = TypedArray[_, _] | DataView
  type Callback1[T]      = js.Function2[NodeError, T, Any]
  type Callback2[T1, T2] = js.Function3[NodeError, T1, T2, Any]

  implicit final class CryptoModuleEnrichment(private val crypto: Crypto.type) extends AnyVal {
    @inline def Certificate = io.scalajs.nodejs.crypto.Certificate
  }
}

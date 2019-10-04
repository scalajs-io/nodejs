package io.scalajs.nodejs.crypto

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("crypto", "Certificate")
class Certificate extends js.Object {
  def exportChallenge(spkac: String | BufferLike): Buffer                               = js.native
  def exportPublicKey(spkac: String | BufferLike, encoding: String = js.native): Buffer = js.native
  def verifySpkac(spkac: BufferLike): Boolean                                           = js.native
}

@js.native
@JSImport("crypto", "Certificate")
object Certificate extends js.Object {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def exportChallenge(spkac: String | BufferLike): Buffer = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def exportPublicKey(spkac: String | BufferLike, encoding: String = js.native): Buffer = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def verifySpkac(spkac: BufferLike): Boolean = js.native
}

package io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Transform streams are Duplex streams where the output is in some way computed from the input.
  * They implement both the Readable and Writable interfaces.
  */
@js.native
@JSImport("stream", "Transform")
class Transform(options: TransformOptions = js.native) extends IDuplex {
  def destroy(error: io.scalajs.nodejs.Error = js.native): Unit = js.native
}

class TransformOptions(val transform: js.UndefOr[js.Function] = js.undefined,
                       val flush: js.UndefOr[js.Function] = js.undefined)
    extends js.Object

package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.|

package object events {

  implicit final class EventEmitterExtensions[T <: EventEmitter](private val instance: T) extends AnyVal {
    @inline def onNewListener(listener: (String | js.Symbol, js.Function) => Any): T =
      instance.on("newListener", listener)

    @inline def onRemoveListener(listener: (String | js.Symbol, js.Function) => Any): T =
      instance.on("removeListener", listener)
  }

}

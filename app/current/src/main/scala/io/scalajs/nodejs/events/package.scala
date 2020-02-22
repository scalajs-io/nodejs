package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.|

package object events {

  implicit final class EventEmitterExtensions(val instance: EventEmitter) extends AnyVal {
    @inline def onNewListener(listener: (String | js.Symbol, js.Function) => Any): instance.type =
      instance.on("newListener", listener)

    @inline def onRemoveListener(listener: (String | js.Symbol, js.Function) => Any): instance.type =
      instance.on("removeListener", listener)
  }

}

package io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Transform streams are Duplex streams where the output is in some way computed from the input.
  * They implement both the Readable and Writable interfaces.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("stream", "Transform")
class Transform extends IDuplex

/**
  * Transform Interface
  */
@js.native
trait ITransform extends IDuplex

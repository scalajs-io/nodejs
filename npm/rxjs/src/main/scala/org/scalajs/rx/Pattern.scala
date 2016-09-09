package org.scalajs.rx

import scala.scalajs.js

/**
  * Pattern object that matches when a collection observable sequences have an available value.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Pattern[T] extends Observable[T]

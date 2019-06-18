package io.scalajs.npm.mongoose

import scala.scalajs.js

/**
  * A Promise-like object supporting "then(result => A)" construct
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongooseThenable[A] extends js.Object {

  def `then`(callback: js.Function1[A, Any]): this.type = js.native

}

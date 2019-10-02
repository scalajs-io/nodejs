package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
sealed trait Require extends js.Object {
  def apply(id: String): js.Any = js.native

  val cache: js.Dictionary[js.Any] = js.native
  val main: js.UndefOr[Module]     = js.native
  val resolve: RequireResolver     = js.native
}

@js.native
@JSGlobal("require")
object Require extends Require

@js.native
trait RequireResolver extends js.Object {
  def apply(request: String, options: ResolveOptions = js.native): js.Any = js.native

  def paths(requiest: String): js.Array[String] = js.native
}

class ResolveOptions(
    var paths: js.UndefOr[js.Array[String]] = js.undefined
) extends js.Object

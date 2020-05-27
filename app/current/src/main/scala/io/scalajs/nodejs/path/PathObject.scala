package io.scalajs.nodejs.path

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait PathObject extends js.Object {
  var root: js.UndefOr[String] = js.undefined
  var dir: js.UndefOr[String]  = js.undefined
  var base: js.UndefOr[String] = js.undefined
  var ext: js.UndefOr[String]  = js.undefined
  var name: js.UndefOr[String] = js.undefined
}

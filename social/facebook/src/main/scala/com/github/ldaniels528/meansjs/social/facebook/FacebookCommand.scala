package com.github.ldaniels528.meansjs.social.facebook

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Facebook Command
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FacebookCommand extends js.Object {
  var app_id: js.UndefOr[String] = _
  var caption: js.UndefOr[String] = _
  var method: js.UndefOr[String] = _
  var link: js.UndefOr[String] = _
  var href: js.UndefOr[String] = _
}

/**
  * Facebook Command Companion Object
  * @author lawrence.daniels@gmail.com
  */
object FacebookCommand {

  def apply(app_id: js.UndefOr[String],
            method: js.UndefOr[String],
            link: js.UndefOr[String] = js.undefined,
            href: js.UndefOr[String] = js.undefined,
            caption: js.UndefOr[String] = js.undefined) = {
    val command = new FacebookCommand()
    command.app_id = app_id
    command.method = method
    command.href = href
    command.link = link
    command
  }

}
package com.github.ldaniels528.nodesjs.social.facebook

import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Facebook Command
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookCommand extends js.Object {
  var app_id: js.UndefOr[String]
  var caption: js.UndefOr[String]
  var method: js.UndefOr[String]
  var link: js.UndefOr[String]
  var href: js.UndefOr[String]
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
    val command = makeNew[FacebookCommand]
    command.app_id = app_id
    command.method = method
    command.href = href
    command.link = link
    command
  }
}
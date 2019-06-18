package io.scalajs.social.facebook

import scala.scalajs.js


/**
  * Facebook Command
  * @author lawrence.daniels@gmail.com
  */
class FacebookCommand(var app_id: js.UndefOr[String],
                      var method: js.UndefOr[String],
                      var link: js.UndefOr[String] = js.undefined,
                      var href: js.UndefOr[String] = js.undefined,
                      var caption: js.UndefOr[String] = js.undefined) extends js.Object

/**
  * Facebook Command Companion Object
  * @author lawrence.daniels@gmail.com
  */
object FacebookCommand {

  def apply(app_id: js.UndefOr[String],
            method: js.UndefOr[String],
            link: js.UndefOr[String] = js.undefined,
            href: js.UndefOr[String] = js.undefined,
            caption: js.UndefOr[String] = js.undefined) = new FacebookCommand(
    app_id = app_id,
    method = method,
    href = href,
    link = link
  )

}

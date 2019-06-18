package io.scalajs.npm.githubapinode

import scala.scalajs.js

/**
  * Represents GitHub Content; a file or directory.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Content extends js.Object {
  val name: String = js.native
  val path: String = js.native
  val sha: String = js.native
  val size: Int = js.native
  val url: String = js.native
  val html_url: String = js.native
  val git_url: String = js.native
  val download_url: String = js.native
  val `type`: String = js.native
  val _links: ContentLinks = js.native
}

/**
  * Represents GitHub Content Links
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ContentLinks extends js.Object {
  val self: String = js.native
  val git: String = js.native
  val html: String = js.native
}

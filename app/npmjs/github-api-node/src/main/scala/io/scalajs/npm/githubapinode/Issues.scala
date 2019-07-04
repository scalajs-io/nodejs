package io.scalajs.npm.githubapinode

import scala.scalajs.js

/**
  * Issues Gist API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Issues extends js.Object {

  def  comment(issue: Issue, comment: String, callback: GitHubCallback1[String]): Unit = js.native

  def list(options: js.Any, callback: GitHubCallback1[js.Array[Issue]]): Unit = js.native

}

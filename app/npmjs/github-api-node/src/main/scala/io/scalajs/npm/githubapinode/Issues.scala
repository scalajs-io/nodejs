package io.scalajs.npm.githubapinode

import io.scalajs.RawOptions

import scala.scalajs.js

/**
  * Issues Gist API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Issues extends js.Object {

  def  comment(issue: Issue, comment: String, callback: GitHubCallback1[String]): Unit = js.native

  def list(options: RawOptions, callback: GitHubCallback1[js.Array[Issue]]): Unit = js.native

}

package io.scalajs.npm.githubapinode

import scala.scalajs.js

/**
  * GitHub Search API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Searches extends js.Object {

  /**
    *
    * @param options
    * @param callback
    */
  def code(options: js.Any, callback: GitHubCallback1[js.Any]): Unit = js.native

  /**
    *
    * @param options
    * @param callback
    */
  def issues(options: js.Any, callback: GitHubCallback1[js.Array[Issue]]): Unit = js.native

  /**
    *
    * @param options
    * @param callback
    */
  def repositories(options: js.Any, callback: GitHubCallback1[js.Array[Repository]]): Unit = js.native

  /**
    *
    * @param options
    * @param callback
    */
  def users(options: js.Any, callback: GitHubCallback1[js.Array[User]]): Unit = js.native

}

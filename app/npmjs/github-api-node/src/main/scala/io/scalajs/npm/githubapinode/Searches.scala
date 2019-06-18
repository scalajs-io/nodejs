package io.scalajs.npm.githubapinode

import io.scalajs.RawOptions

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
  def code(options: RawOptions, callback: GitHubCallback1[js.Any]): Unit = js.native

  /**
    *
    * @param options
    * @param callback
    */
  def issues(options: RawOptions, callback: GitHubCallback1[js.Array[Issue]]): Unit = js.native

  /**
    *
    * @param options
    * @param callback
    */
  def repositories(options: RawOptions, callback: GitHubCallback1[js.Array[Repository]]): Unit = js.native

  /**
    *
    * @param options
    * @param callback
    */
  def users(options: RawOptions, callback: GitHubCallback1[js.Array[User]]): Unit = js.native

}

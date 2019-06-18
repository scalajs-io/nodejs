package io.scalajs.npm.githubapinode

import io.scalajs.RawOptions

import scala.scalajs.js

/**
  * GitHub Gist API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Gists extends js.Object {

  /**
    * Read the contents of a Gist.
    * @param callback the callback containing either an [[GithubError error]] or the [[Gist gist]]
    */
  def read(callback: GitHubCallback1[Gist]): Unit = js.native

  /**
    * Updates the contents of a Gist.
    * @param delta the given delta
    * @param callback the callback
    */
  def update(delta: RawOptions, callback: GitHubCallback1[Gist]): Unit = js.native

}

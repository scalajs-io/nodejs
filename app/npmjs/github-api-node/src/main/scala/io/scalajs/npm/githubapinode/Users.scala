package io.scalajs.npm.githubapinode

import io.scalajs.RawOptions

import scala.scalajs.js

/**
  * GitHub User API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Users extends js.Object {

  /**
    * List organizations the authenticated user belongs to.
    * @param callback the callback
    */
  def orgs(callback: GitHubCallback1[js.Array[Organization]]): Unit = js.native

  /**
    * List repositories of the authenticated user, including private repositories and repositories
    * in which the user is a collaborator and not an owner.
    * @param options  the optional settings
    * @param callback the callback
    */
  def repos(options: RawOptions, callback: GitHubCallback1[js.Array[Repository]]): Unit = js.native

  /**
    * List authenticated user's gists.
    * @param callback the callback
    */
  def gists(callback: GitHubCallback1[Gist]): Unit = js.native

  /**
    * List unread notifications for the authenticated user.
    * @param options  the optional settings
    * @param callback the callback
    */
  def notifications(options: RawOptions, callback: GitHubCallback1[js.Array[Notification]]): Unit = js.native

  /**
    * Show user information for a particular username. Also works for organizations.
    * Pass in a falsy value (null, "", etc) for 'username' to retrieve user information for the currently authorized user.
    */
  def show(username: String, callback: GitHubCallback1[User]): Unit = js.native

  /**
    * List public repositories for a particular user.
    * @param username the user name
    * @param callback the callback
    */
  def userRepos(username: String, callback: GitHubCallback1[js.Array[Repository]]): Unit = js.native

  /**
    * List starred repositories for a particular user.
    * @param username the user name
    * @param callback the callback
    */
  def userStarred(username: String, callback: GitHubCallback1[js.Array[Repository]]): Unit = js.native

  /**
    * Create a new repo for the authenticated user
    * @param repo the given repo
    * @param callback the callback
    */
  def createRepo(repo: Repository, callback: GitHubCallback1[js.Array[Resource]]): Unit = js.native

  /**
    * List repositories for a particular organization. Includes private repositories if you are authorized.
    * @param orgName the organization name
    * @param callback the callback
    */
  def orgRepos(orgName: String, callback: GitHubCallback1[js.Array[Repository]]): Unit = js.native

  /**
    * List all gists of a particular user. If username is ommitted gists of the current authenticated user are returned.
    * @param username the user name
    * @param callback the callback
    */
  def userGists(username: String, callback: GitHubCallback1[js.Array[Gist]]): Unit = js.native

}

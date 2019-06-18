package io.scalajs.npm.githubapinode

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * github-api-node - A higher-level wrapper around the GitHub API.
  * @see https://www.npmjs.com/package/github-api-node
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("github-api-node", JSImport.Namespace)
class GitHub(options: GithubOptions) extends js.Object {

  def getGist(id: Int): Gists = js.native

  def getIssues(username: String, repoName: String): Issues = js.native

  def getRepo(username: String, repoName: String): Repositories = js.native

  def getSearch(query: String): Searches = js.native

  def getUser(): Users = js.native

}

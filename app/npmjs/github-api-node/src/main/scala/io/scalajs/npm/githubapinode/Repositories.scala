package io.scalajs.npm.githubapinode

import io.scalajs.RawOptions

import scala.scalajs.js

/**
  * GitHub Repository API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Repositories extends js.Object {

  /**
    * Create new branch for repo. You can omit oldBranchName to default to "master".
    * @param oldBranchName the old branch name
    * @param newBranchName the new branch name
    * @param callback      the callback
    */
  def branch(oldBranchName: String, newBranchName: String, callback: GitHubCallback0): Unit = js.native

  /**
    * Create new branch (from master) for repo.
    * @param newBranchName the new branch name
    * @param callback      the callback
    */
  def branch(newBranchName: String, callback: GitHubCallback0): Unit = js.native

  /**
    * Get contents at a particular path in a particular branch.
    * @param branch    the desired branch (e.g. "master")
    * @param pathToDir the "path to" directory
    * @param callback  the callback
    */
  def contents(branch: String, pathToDir: String, callback: GitHubCallback1[js.Array[Content]]): Unit = js.native

  /**
    * Get contributors list with additions, deletions, and commit counts.
    * @param callback the callback containing either an error or the array of [[Contributor contributors]]
    */
  def contributors(callback: GitHubCallback1[js.Array[Contributor]]): Unit = js.native

  /**
    * Create Pull Request.
    * @param pull     the [[Pull]]
    * @param callback the callback
    */
  def createPullRequest(pull: Pull, callback: GitHubCallback1[PullRequest]): Unit = js.native

  /**
    * Create a new reference.
    * @param refSpec  the [[RefSpec]]
    * @param callback the callback containing an error if one occurred
    */
  def createRef(refSpec: RefSpec, callback: GitHubCallback0): Unit = js.native

  /**
    * Delete a reference.
    * @param ref      the given reference name (e.g. "heads/gh-pages")
    * @param callback the callback containing an error if one occurred
    * @example {{{ repo.deleteRef('heads/gh-pages', function(err) {}) }}}
    */
  def deleteRef(ref: String, callback: GitHubCallback0): Unit = js.native

  /**
    * Delete a repository
    * @param callback the callback
    */
  def deleteRepo(callback: GitHubCallback1[Resource]): Unit = js.native

  /**
    * Fork repository. This operation runs asynchronously.
    * You may want to poll for repo.contents until the forked repo is ready.
    * @param callback the callback
    */
  def fork(callback: GitHubCallback0): Unit = js.native

  /**
    * Get information about a particular commit.
    * @param branch   the branch name (e.g. "master")
    * @param sha      the SHA key
    * @param callback the callback containing either an error or the [[Commit commit]]
    */
  def getCommit(branch: String, sha: String, callback: GitHubCallback1[Commit]): Unit = js.native

  /**
    *
    * @param branch     the branch name (e.g. "master")
    * @param pathToFile the path to the file
    * @param callback   the callback containing either an error or the [[SHA]]
    */
  def getSha(branch: String, pathToFile: String, callback: GitHubCallback1[SHA]): Unit = js.native

  /**
    * Get list of statuses for a particular commit.
    * @param sha      the SHA key
    * @param callback the callback containing either an error or the array of [[CommitStatus commit statuses]]
    */
  def getStatuses(sha: String, callback: GitHubCallback1[js.Array[CommitStatus]]): Unit = js.native

  /**
    * Exploring files of a repository is easy too by accessing the top level tree object.
    * @param branch   the branch name (e.g. "master")
    * @param callback the callback containing either an error or the [[Tree tree]]
    * @example {{{ repo.getTree('master', function(err, tree) {}) }}}
    */
  def getTree(branch: String, callback: GitHubCallback1[Tree]): Unit = js.native

  /**
    * Retrieve all available branches (aka heads) of a repository.
    * @param callback the callback
    */
  def listBranches(callback: GitHubCallback1[js.Array[String]]): Unit = js.native

  /**
    * List forks.
    * @param callback the callback
    */
  def listForks(callback: GitHubCallback1[js.Array[Fork]]): Unit = js.native

  /**
    * List Pull Requests.
    * @param state    the state of the Pull Request ('open', 'closed' or 'all')
    * @param callback the callback
    */
  def listPulls(state: String, callback: GitHubCallback1[js.Array[PullRequest]]): Unit = js.native

  /**
    * Move a file from A to B.
    * @param branch        the branch name
    * @param pathToFile    the path to the file to be moved
    * @param pathToNewFile the new path to the file
    * @param callback      the completion callback
    */
  def move(branch: String, pathToFile: String, pathToNewFile: String, callback: GitHubCallback0): Unit = js.native

  /**
    * Reads stored content
    * @param branch     the branch name
    * @param pathToFile the path to the content
    * @param callback   the callback
    */
  def read(branch: String, pathToFile: String, callback: GitHubCallback1[js.Any]): Unit = js.native

  /**
    * Remove a file.
    * @param branch     the branch name
    * @param pathToFile the path to the content
    * @param callback   the completion callback
    */
  def remove(branch: String, pathToFile: String, callback: GitHubCallback0): Unit = js.native

  /**
    * Show repository information
    * @param callback the callback
    */
  def show(callback: js.Function2[GithubError, Repository, Any]): Unit = js.native

  /**
    * Check if a repository is starred.
    * @param owner      the owner
    * @param repository the repository
    * @param callback   the completion callback
    */
  def isStarred(owner: String, repository: String, callback: GitHubCallback1[Boolean]): Unit = js.native

  /**
    * Star a repository.
    * @param owner      the owner
    * @param repository the repository name
    * @param callback   the completion callback
    */
  def star(owner: String, repository: String, callback: GitHubCallback0): Unit = js.native

  /**
    * Unstar a repository.
    * @param owner      the owner
    * @param repository the repository name
    * @param callback   the completion callback
    */
  def unstar(owner: String, repository: String, callback: GitHubCallback0): Unit = js.native

  /**
    * Store content at a certain path. If the file specified in the path exists, the content is updated.
    * If the file doesn't exist, it's created on the fly. You can also provide an optional object literal,
    * (options in the example below) containing information about the author and the committer.
    * @param branch        the branch name
    * @param pathToFile    the path to the content
    * @param contents      the user content
    * @param commitMessage the commit message
    * @param options       the optional settings
    * @param callback      the callback
    */
  def write(branch: String, pathToFile: String, contents: String, commitMessage: String, options: RawOptions, callback: GitHubCallback0): Unit = js.native

}

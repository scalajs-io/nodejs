package io.scalajs.npm

import io.scalajs.RawOptions
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js

/**
  * github-api-node package object
  * @author lawrence.daniels@gmail.com
  */
package object githubapinode {

  type GitHubCallback0 = js.Function1[GithubError, Any]

  type GitHubCallback1[A] = js.Function2[GithubError, A, Any]

  /**
    * Repository Enrichment
    * @param repo the given [[Repositories]] instance
    */
  implicit class RepositoryEnrichment(val repo: Repositories) extends AnyVal {

    /**
      * Create new branch for repo. You can omit oldBranchName to default to "master".
      * @param newBranchName the new branch name
      * @return a promise of [[Unit completion]]
      */
    @inline
    def branchFuture(newBranchName: String): Future[Unit] = {
      promiseWithError0[GithubError](repo.branch(newBranchName, _))
    }

    /**
      * Create new branch for repo. You can omit oldBranchName to default to "master".
      * @param oldBranchName the old branch name
      * @param newBranchName the new branch name
      * @return a promise of [[Unit completion]]
      */
    @inline
    def branchFuture(oldBranchName: String, newBranchName: String): Future[Unit] = {
      promiseWithError0[GithubError](repo.branch(oldBranchName, newBranchName, _))
    }

    /**
      * Get contents at a particular path in a particular branch.
      * @param branch    the desired branch (e.g. "master")
      * @param pathToDir the "path to" directory
      * @return a promise of the [[Content contents]]
      */
    @inline
    def contentsFuture(branch: String, pathToDir: String): Future[js.Array[Content]] = {
      promiseWithError1[GithubError, js.Array[Content]](repo.contents(branch, pathToDir, _))
    }

    /**
      * Get contributors list with additions, deletions, and commit counts.
      * @return a promise of the [[Contributor contributors]]
      */
    @inline
    def contributorsFuture: Future[js.Array[Contributor]] = {
      promiseWithError1[GithubError, js.Array[Contributor]](repo.contributors)
    }

    /**
      * Get information about a particular commit.
      * @param branch the branch name
      * @param sha    the SHA key
      * @return a promise of the [[Commit commit]]
      */
    @inline
    def getCommitFuture(branch: String, sha: String): Future[Commit] = {
      promiseWithError1[GithubError, Commit](repo.getCommit(branch, sha, _))
    }

    /**
      * Get list of statuses for a particular commit.
      * @param sha the SHA key
      * @return a promise of the array of [[CommitStatus commit statuses]]
      */
    @inline
    def getStatusesFuture(sha: String): Future[js.Array[CommitStatus]] = {
      promiseWithError1[GithubError, js.Array[CommitStatus]](repo.getStatuses(sha, _))
    }

    /**
      * Check if a repository is starred.
      * @param owner      the owner
      * @param repository the repository
      * @return the completion callback
      */
    @inline
    def isStarredFuture(owner: String, repository: String): Future[Boolean] = {
      promiseWithError1[GithubError, Boolean](repo.isStarred(owner, repository, _))
    }

    /**
      * Retrieve all available branches (aka heads) of a repository.
      * @return a promise of the array of [[Branch branches]]
      */
    @inline
    def listBranchesFuture: Future[js.Array[String]] = {
      promiseWithError1[GithubError, js.Array[String]](repo.listBranches)
    }

    /**
      * Reads stored content
      * @param branch     the branch name
      * @param pathToFile the path to the content
      * @return a promise of the content
      */
    @inline
    def readFuture(branch: String, pathToFile: String): Future[js.Any] = {
      promiseWithError1[GithubError, js.Any](repo.read(branch, pathToFile, _))
    }

    /**
      * Remove a file.
      * @param branch     the branch name
      * @param pathToFile the path to the content
      * @return a promise of [[Unit completion]]
      */
    @inline
    def removeFuture(branch: String, pathToFile: String): Future[Unit] = {
      promiseWithError0[GithubError](repo.remove(branch, pathToFile, _))
    }

    /**
      * Show repository information
      * @return a promise of a [[Repository]]
      */
    @inline
    def showFuture: Future[Repository] = promiseWithError1[GithubError, Repository](repo.show)

    /**
      * Store content at a certain path. If the file specified in the path exists, the content is updated.
      * If the file doesn't exist, it's created on the fly. You can also provide an optional object literal,
      * (options in the example below) containing information about the author and the committer.
      * @param branch        the branch name
      * @param pathToFile    the path to the content
      * @param contents      the user content
      * @param commitMessage the commit message
      * @param options       the optional settings
      * @return a promise of [[Unit completion]]
      */
    @inline
    def writeFuture(branch: String,
                   pathToFile: String,
                   contents: String,
                   commitMessage: String,
                   options: RawOptions): Future[Unit] = {
      promiseWithError0[GithubError](repo.write(branch, pathToFile, contents, commitMessage, options, _))
    }

  }

  /**
    * User Enrichment
    * @param user the given [[Users]] instance
    */
  implicit class UserEnrichment(val user: Users) extends AnyVal {

    /**
      * List organizations the authenticated user belongs to.
      * @return the array of organizations
      */
    @inline
    def orgsFuture: Future[js.Array[Organization]] = {
      promiseWithError1[GithubError, js.Array[Organization]](user.orgs)
    }

    /**
      * List repositories of the authenticated user, including private repositories and repositories
      * in which the user is a collaborator and not an owner.
      * @param options the optional settings
      * @return the array of repositories
      */
    @inline
    def reposFuture(options: RawOptions = null): Future[js.Array[Repository]] = {
      promiseWithError1[GithubError, js.Array[Repository]](user.repos(options, _))
    }

  }

}

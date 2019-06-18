package io.scalajs.npm.githubapinode

import io.scalajs.nodejs.util.Util
import io.scalajs.util.JSONHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Repositories API Test Suite
  * @author lawrence.daniels@gmail.com
  */
class RepositoriesTest extends FunSpec {

  describe("Repositories") {
    val gitHub = new GitHub(new GithubOptions())
    val repo = gitHub.getRepo("scalajs-io", "bignum")

    it("supports retrieving the branches for a repository") {
      repo.listBranchesFuture foreach { branches =>
        info(s"branches: ${branches.toJson}")
      }
    }

    it("supports retrieving contributors for a repository") {
      repo.contributorsFuture foreach { contributors =>
        info(s"contributors: ${Util.inspect(contributors)}")
      }
    }

    it("supports retrieving the contents of a repository") {
      repo.contentsFuture(branch = "master", pathToDir = ".") foreach { contents =>
        info(s"contents: ${Util.inspect(contents)}")
      }
    }

    it("supports retrieving files from a repository") {
      repo.readFuture(branch = "master", pathToFile = "package.json") foreach { data =>
        info(s"package.json: ${Util.inspect(data)}")
      }
    }

  }

}

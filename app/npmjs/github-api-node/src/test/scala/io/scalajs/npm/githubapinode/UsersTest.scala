package io.scalajs.npm.githubapinode

import io.scalajs.util.JSONHelper._
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * User API Test Suite
  * @author lawrence.daniels@gmail.com
  */
class UsersTest extends AnyFunSpec {

  describe("Users") {
    val gitHub = new GitHub(new GithubOptions())
    val user = gitHub.getUser()

    it("supports listing organizations the authenticated user belongs to.") {
      user.orgsFuture foreach { orgs =>
        info(s"orgs: ${orgs.toJson}")
      }
    }

    it("supports listing repositories of the authenticated user.") {
      user.reposFuture() foreach { repos =>
        info(s"repos: ${repos.toJson}")
      }
    }

  }

}

package io.scalajs.npm.nock

import io.scalajs.nodejs.console
import io.scalajs.npm.nock.NockTest.{AppBody, Item, Items, Person}
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.RegExp

/**
  * Nock Tests
  * @author lawrence.daniels@gmail.com
  */
class NockTest extends FunSpec {

  describe("Nock") {

    it("can intercept an HTTP GET request and reply with a status code") {
      Nock("http://myapp.iriscouch.com")
        .get("/users/1")
        .reply(200, js.Dictionary(
          "_id" -> "123ABC",
          "_rev" -> "946B7D1C",
          "username" -> "pgte",
          "email" -> "pedro.teixeira@gmail.com"
        ))
    }

    it("can provide information about active and pending mocks") {
      val scope = Nock("http://www.example.com")
        .get("/resource")
        .reply(200, "domain matched")

      if (!scope.isDone()) {
        console.info("active mocks: %j", scope.activeMocks())
        console.info("pending mocks: %j", scope.pendingMocks())
      }
    }

    it("supports using regular expressions") {
      val scope = Nock(RegExp("/example\\.com/"))
        .get("/resource")
        .reply(200, "domain regex matched")
    }

    it("supports using functions") {
      val scope = Nock("http://www.example.com")
        .get((uri: String) => uri.indexOf("cats") >= 0)
        .reply(200, "path using function matched")
    }

    it("allows you to specify the number of times to repeat the same response.") {
      Nock("http://zombo.com").get("/").times(4).reply(200, "Ok")
    }

    it("supports unmocked requests on a mocked hostname") {
      val scope = Nock("http://my.existing.service.com", new NockOptions(allowUnmocked = true))
        .get("/my/url")
        .reply(200, "OK!")

      // GET /my/url => goes through nock
      // GET /other/url => actually makes request to the server
    }

    it("supports posts which can return a JSON body") {
      val scope = Nock("http://myapp.iriscouch.com")
        .post("/users", js.Dictionary(
          "username" -> "pgte",
          "email" -> "pedro.teixeira@gmail.com"
        ))
        .reply(201, js.Dictionary(
          "ok" -> true,
          "id" -> "123ABC",
          "rev" -> "946B7D1C"
        ))
    }

    it("supports optional requests") {
      val example = Nock("http://example.com")
      example.pendingMocks() // []
      example.get("/pathA").reply(200)
      example.pendingMocks() // ["GET http://example.com:80/path"]

      // ...After a request to example.com/pathA:
      example.pendingMocks() // []

      example.get("/pathB").optionally().reply(200)
      example.pendingMocks() // []
    }

    it("supports the request body as a function") {
      val scope = Nock("http://myapp.iriscouch.com")
        .post("/users", (body: AppBody) => body.id === "123ABC")
        .reply(201, js.Dictionary(
          "ok" -> true,
          "id" -> "123ABC",
          "rev" -> "946B7D1C"
        ))
    }

    it("understands query strings. Instead of placing the entire URL") {
      Nock("http://example.com")
        .get("/users")
        .query(new Person(name = "pedro", surname = "teixeira"))
        .reply(200, new Items(results = js.Array(new Item(id = "pgte"))))
    }

    it("supports array-style/object-style query parameters") {
      Nock("http://example.com")
        .get("/users")
        .query(js.Dictionary(
          "names" -> js.Array("alice", "bob"),
          "tags" -> js.Dictionary(
            "alice" -> js.Array("admin", "tester"),
            "bob" -> js.Array("tester")
          )))
        .reply(200, js.Dictionary("results" -> js.Array(js.Dictionary("id" -> "pgte"))))
    }

    it("supports JSON error responses too") {
      Nock("http://www.google.com")
        .get("/cat-poems")
        .replyWithError(js.Dictionary("message" -> "something awful happened", "code" -> "AWFUL_ERROR"))
    }

    it("can log matches if you pass in a log function") {
      Nock("http://google.com").log(console.log _)
    }

  }

}

/**
  * Nock Test Companion
  * @author lawrence.daniels@gmail.com
  */
object NockTest {

  class AppBody(val id: String) extends js.Object

  class Person(val name: String, val surname: String) extends js.Object

  class Items(val results: js.Array[Item]) extends js.Object

  class Item(val id: String) extends js.Object

}

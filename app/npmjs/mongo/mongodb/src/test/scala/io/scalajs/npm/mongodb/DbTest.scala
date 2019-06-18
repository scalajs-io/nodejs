package io.scalajs.npm.mongodb

import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

import scala.concurrent.Future
import scala.scalajs.js

/**
  * Db Test Suites
  * @author lawrence.daniels@gmail.com
  */
class DbTest extends FunSpec with MongoDBTestSupport {

  describe("Db") {

    it("supports executing code on the server") {

      withMongo("Code") { db =>

        db.eval(new Code("i + 3;"), js.Dictionary("i" -> 2), (err, result) => {
          Assert.equal(5, result)
        })

        Future.successful({})
      }
    }
  }

}

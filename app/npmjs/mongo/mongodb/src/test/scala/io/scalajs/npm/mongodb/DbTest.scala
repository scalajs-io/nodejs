package io.scalajs.npm.mongodb

import io.scalajs.nodejs.Assert
import io.scalajs.util.PromiseHelper.Implicits._
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Db Test Suites
  * @author lawrence.daniels@gmail.com
  */
class DbTest extends AnyFunSpec with MongoDBTestSupport {

  describe("Db") {

    it("supports executing code on the server") {

      withMongo("Code") { db: Db =>
        db.eval(code = new Code("i + 3;"), parameters = js.Dictionary("i" -> 2), options = null) map { result =>
          Assert.equal(5, result)
        }
      }
    }
  }

}

package io.scalajs.npm.node_embedded_mongodb

import io.scalajs.nodejs.console
import io.scalajs.nodejs.process
import io.scalajs.nodejs.path.Path
import io.scalajs.npm.mongodb.MongoClient
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Node-Embedded-MongoDB Test
  * @author lawrence.daniels@gmail.com
  */
class NodeEmbeddedMongoDBTest extends FunSpec {

  describe("NodeEmbeddedMongoDB") {
    val dbPath = Path.join(process.cwd(), "npm", "node-embedded-mongodb", "src", "test", "resources", "db")
    val logPath = Path.join(process.cwd(), "npm", "node-embedded-mongodb", "src", "test", "resources", "log")

    it("can created an embedded MongoDB server") {
      NodeEmbeddedMongoDB.start(dbPath, logPath, { err =>
        assert(err == null, err)

        val url = "mongodb://localhost:27017/test"
        MongoClient.connect(url, (error, db) => {
          console.log("Connected to ", url)


          NodeEmbeddedMongoDB.stop { err =>
            console.log(s"shutting down: $err")
          }
        })
      })
    }

  }

  @ScalaJSDefined
  class Student(val name: String) extends js.Object

}

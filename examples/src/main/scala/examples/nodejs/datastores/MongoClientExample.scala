package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.mongodb.MongoDB
import org.scalajs.dom.console

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.util.{Failure, Success}

/**
  * Mongo Client Test
  * @author lawrence.daniels@gmail.com 
  */
class MongoClientExample(bootstrap: Bootstrap) {
  import bootstrap._

  // lets require/import the mongodb native drivers.
  val mongo = require[MongoDB]("mongodb")

  // We need to work with "MongoClient" interface in order to connect to a mongodb server.
  val mongoClient = mongo.MongoClient

  val replicas = mongo.ReplSetServers(js.Array(mongo.Server("localhost", 27017)))

  // Connection URL. This is where your mongodb server is running.
  val url = "mongodb://localhost:27017/test"

  // Use connect method to connect to the Server
  mongoClient.connectFuture(url) onComplete {
    case Success(db) =>
      //HURRAY!! We are connected. :)
      console.log("Connection established to: %s", url)

      // do some work here with the database.

      //Close connection
      db.close()
    case Failure(e) =>
      console.log("Unable to connect to the mongoDB server. Error:", e.getMessage)
  }

}

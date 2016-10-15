package examples.nodejs.datastores.mongodb

import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.mongodb.MongoDB

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.util.{Failure, Success}

/**
  * Mongo Client Test
  * @author lawrence.daniels@gmail.com 
  */
class MongoClientExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  // lets require/import the mongodb native drivers.
  val mongo = MongoDB()

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

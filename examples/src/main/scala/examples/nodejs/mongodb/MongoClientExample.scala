package examples.nodejs.mongodb

import com.github.ldaniels528.meansjs.mongodb.MongoDB
import com.github.ldaniels528.meansjs.nodejs._
import org.scalajs.dom.console

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

/**
  * Mongo Client Test
  * @author lawrence.daniels@gmail.com 
  */
class MongoClientExample(require: Require) {

  // lets require/import the mongodb native drivers.
  val mongodb = require[MongoDB]("mongodb")

  // We need to work with "MongoClient" interface in order to connect to a mongodb server.
  val mongoClient = mongodb.MongoClient

  // Connection URL. This is where your mongodb server is running.
  val url = "mongodb://localhost:27017/test"

  // Use connect method to connect to the Server
  mongoClient.connectAsync(url) onComplete {
    case Success(db) =>
      //HURRAY!! We are connected. :)
      console.log("Connection established to", url)

      // do some work here with the database.

      //Close connection
      db.close()
    case Failure(e) =>
      console.log("Unable to connect to the mongoDB server. Error:", e.getMessage)
  }

}

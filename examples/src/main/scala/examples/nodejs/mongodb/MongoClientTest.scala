package examples.nodejs.mongodb

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.mongodb.MongoDB.MongoError
import com.github.ldaniels528.meansjs.nodejs.mongodb.{MongoDB, MongoDatabase}
import org.scalajs.dom.console

/**
  * Mongo Client Test
  * @author lawrence.daniels@gmail.com 
  */
class MongoClientTest {

  // lets require/import the mongodb native drivers.
  val mongodb = require[MongoDB]("mongodb")

  // We need to work with "MongoClient" interface in order to connect to a mongodb server.
  val mongoClient = mongodb.MongoClient

  // Connection URL. This is where your mongodb server is running.
  val url = "mongodb://localhost:27017/test"

  // Use connect method to connect to the Server
  mongoClient.connect(url, (err: MongoError, db: MongoDatabase) => {
    if (err.isDefined) {
      console.log("Unable to connect to the mongoDB server. Error:", err)
    } else {
      //HURRAY!! We are connected. :)
      console.log("Connection established to", url)

      // do some work here with the database.

      //Close connection
      db.close()
    }
  })

}

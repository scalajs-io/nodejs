package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs.core.Assert
import com.github.ldaniels528.meansjs.nodejs.mongodb._
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}

import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  * MongoDB Stream Example
  * @author lawrence.daniels@gmail.com
  */
class MongoStreamExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val MongoClient = MongoDB().MongoClient
  val assert = Assert()

  // Connection URL
  val url = "mongodb://localhost:27017/test"

  // Use connect method to connect to the Server
  MongoClient.connect(url, (err: MongoError, db: Db) => {
    assert.equal(null, err)
    console.log("Connected correctly to server")

    val col = db.collection("streams")

    // Insert a single document
    col.insert(js.Array(doc("a" -> 1), doc("a" -> 2), doc("a" -> 3)), (err: MongoError, r: InsertWriteOpResult) => {
      assert.equal(null, err)
      assert.equal(3, r.result.n)

      // Get the results using a find stream
      val cursor = col.find(doc()).stream(StreamTransform((doc: js.Any) => JSON.stringify(doc)))

      cursor.onData((doc: js.Any) => console.log(doc))

      cursor.onOnce(() => db.close())
    })
  })

}

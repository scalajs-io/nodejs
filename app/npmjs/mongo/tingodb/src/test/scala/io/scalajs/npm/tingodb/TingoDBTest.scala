package io.scalajs.npm.tingodb

import io.scalajs.JSON
import io.scalajs.nodejs.console
import io.scalajs.nodejs.fs.Fs
import io.scalajs.npm.mongodb.{MongoError, doc}
import io.scalajs.npm.tingodb.TingoDBTest.Actor
import org.scalatest.FunSpec

import scala.scalajs.js


/**
  * TingoDB Test
  * @author lawrence.daniels@gmail.com
  */
class TingoDBTest extends FunSpec {
  val dbPath = "./src/test/resources"
  val collName = "actresses"
  val collPath = dbPath + "/" + collName

  describe("TingoDB") {

    it("supports creating a local MongoDB server") {
      // ensure the base directory
      if(!Fs.existsSync(dbPath)) Fs.mkdirSync(dbPath)

      // clear the test
      Fs.writeFileSync(collPath, "")

      // open a connection
      val tingoDB = TingoDB(new TingoDbOptions())
      val db = tingoDB.Db.apply(dbPath, new TingoDbOptions())
      val collection = db.collection(collName)

      // define some actors
      val actors = js.Array(
        new Actor(firstName = "Drew", lastName = "Barrymore", age = 41),
        new Actor(firstName = "Halle", lastName = "Berry", age = 50),
        new Actor(firstName = "Grace", lastName = "Park", age = 42)
      )

      // insert the actors into the database
      collection.insert(actors, (err, result) => {
        if (err != null) console.log("err =>", err)
        else {
          info(s"result => ${JSON.stringify(result)}")

          // read the data from the database
          collection.findOne(doc("firstName" -> "Grace"), (err: MongoError, actor: Actor) => {
            if (err != null) console.log("err =>", err)
            else {
              info(s"actor => ${JSON.stringify(actor)}")
            }
          })
        }
      })

    }

  }

}

/**
  * TingoDB Singleton
  * @author lawrence.daniels@gmail.com
  */
object TingoDBTest {


  class Actor(var firstName: js.UndefOr[String] = js.undefined,
              var lastName: js.UndefOr[String] = js.undefined,
              var age: js.UndefOr[Int] = js.undefined) extends js.Object

}
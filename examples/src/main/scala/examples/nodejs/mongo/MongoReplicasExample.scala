package examples.nodejs.mongo

import com.github.ldaniels528.meansjs.mongodb.{Db, DbOptions, MongoDB}
import com.github.ldaniels528.meansjs.nodejs.{Async, Require}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Mongo Replicas Example
  * @author lawrence.daniels@gmail.com
  */
class MongoReplicasExample(require: Require) {

  val async = require[Async]("async")
  val mongodb = require[MongoDB]("mongodb")
  val Db = mongodb.Db
  val Connection = mongodb.Connection
  val Server = mongodb.Server
  val ReplSetServers = mongodb.ReplSetServers

  async.waterfall(js.Array((callback: js.Function) => {
    val rls = ReplSetServers(js.Array(
      Server("localhost", 27017), // Just mongod instance
      Server("localhost", 27018), // Offline
      Server("localhost", 27019) // Offline
    ))

    Db("test", rls, DbOptions(w = 0)).open(callback)
  }),
    (err: String, db: Db) => {
      if (isDefined(err)) console.error(err)
      if (isDefined(db)) db.close()
    })

}

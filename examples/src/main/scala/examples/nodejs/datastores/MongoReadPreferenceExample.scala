package examples.nodejs.datastores

import org.scalajs.nodejs.{Bootstrap, console}
import org.scalajs.nodejs.mongodb.MongoDB

/**
  * Mongo Read Preference Example
  * @author lawrence.daniels@gmail.com
  */
class MongoReadPreferenceExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val mongo = MongoDB()
  val pref = mongo.ReadPreference(mongo.ReadPreference.PRIMARY)
  console.log("pref => ", pref)

}

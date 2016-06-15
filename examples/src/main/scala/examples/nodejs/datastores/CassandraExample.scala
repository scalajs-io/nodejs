package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.core.Assert
import com.github.ldaniels528.meansjs.nodejs.datastax._
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console, errors}
import examples.nodejs.datastores.CassandraExample.Customer

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * Cassandra Example
  * @author lawrence.daniels@gmail.com
  */
class CassandraExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val cassandra = CassandraDriver()
  val assert = Assert()

  dataTypes()

  def dataTypes() {
    // BigDecimal
    val value0 = cassandra.types.BigDecimal.fromNumber(Double.MaxValue)
    console.log("value0 =", value0, ", buffer =", cassandra.types.BigDecimal.toBuffer(value0), "\n")

    // Integer
    val value1 = cassandra.types.Integer.fromNumber(0xCAFEBABE)
    console.log("value1 =", value1, ", buffer =", cassandra.types.Integer.toBuffer(value1), "\n")

    // Long
    val value2 = cassandra.types.Long.fromNumber(0xDEADBEEFCAFEBABEL)
    console.log("value2 =", value2, ", buffer =", cassandra.types.Long.toBuffer(value2), "\n")

    val value3 = cassandra.types.Long(0xDEADBEEF, 0xCAFEBABE, unsigned = true)
    console.log("value3 =", value3, ", buffer =", cassandra.types.Long.toBuffer(value3), "\n")

    // Inet Address
    val ipAddressBuf = Buffer.from(js.Array(192, 168, 1, 5))
    val value4 = cassandra.types.InetAddress(ipAddressBuf)
    console.log("value4 =", value4,", buffer =", ipAddressBuf, "\n")

    // Local Date
    val value5 = cassandra.types.LocalDate.fromDate(new js.Date())
    console.log("value5 =", value5, ", now =", cassandra.types.LocalDate.now(), "\n")

    // Local Time
    val value6 = cassandra.types.LocalTime.fromDate(new js.Date())
    console.log("value6 =", value6, ", now =", cassandra.types.LocalTime.now(), "\n")

    // Time UUID
    val value7 = cassandra.types.TimeUuid.fromDate(new js.Date())
    console.log("value7 =", value7, ", now =", cassandra.types.TimeUuid.now(), "\n")

    // UUID
    val value8 = cassandra.types.Uuid.fromString("82effd01-2866-11e6-8cc9-4fb6522aae21")
    console.log("value8 =", value8, ", now =", cassandra.types.Uuid.random(), "\n")
  }

  def example1() {
    val client = cassandra.Client(new ClientOptions(contactPoints = js.Array("localhost"), keyspace = "ks1"))
    val query = "SELECT email, last_name FROM user_profiles WHERE key=?"
    val params = js.Array[js.Any]("guy")

    client.execute(query, params, (err: errors.Error, result: CassandraResultSet) => {
      assert.ifError(err)
      console.log("got user profile with email " + result.headOption[Customer].map(_.email).orUndefined)
    })
  }

  def example2() {
    val DCAwareRoundRobinPolicy = cassandra.policies.DCAwareRoundRobinPolicy
    val client = cassandra.Client(new ClientOptions(
      contactPoints = js.Array("localhost"),
      policies = new LoadBalancingPolicyOptions(loadBalancing = DCAwareRoundRobinPolicy("US_EAST"))
    ))
  }

  def example3() {
    val client = cassandra.Client(new ClientOptions(contactPoints = js.Array("localhost"), keyspace = "ks1"))

    val emailAddress = "john.doe@somewhere.com"
    val queries = js.Array(
      new BatchUpdate(query = "UPDATE user_profiles SET email=? WHERE key=?", params = js.Array(emailAddress, "hendrix")),
      new BatchUpdate(query = "INSERT INTO user_track (key, text, date) VALUES (?, ?, ?)", params = js.Array("hendrix", "Changed email", new js.Date()))
    )
    val queryOptions = new QueryOptions(prepare = true, consistency = cassandra.types.consistencies.quorum)
    client.batch(queries, queryOptions, (err: js.Error) => {
      assert.ifError(err)
      console.log("Data updated on cluster")
    })
  }

}

/**
  * Cassandra Example Companion
  * @author lawrence.daniels@gmail.com
  */
object CassandraExample {

  @js.native
  trait Customer extends js.Object {
    var email: js.UndefOr[String] = js.native
    var address: js.UndefOr[String] = js.native
  }

}
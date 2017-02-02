package io.scalajs.npm.cassandradriver

import io.scalajs.JSON
import io.scalajs.nodejs.{Assert, Error, console}
import io.scalajs.npm.cassandradriver.CassandraDriverTest.MyData
import io.scalajs.npm.cassandradriver.policies.{DCAwareRoundRobinPolicy, LoadBalancingPolicyOptions}
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Driver Tests
  * @author lawrence.daniels@gmail.com
  */
class CassandraDriverTest extends FunSpec {

  describe("CassandraDriver") {

    it("has policies") {
      info(s"policies: ${JSON.stringify(CassandraDriver.policies)}")
    }

    it("has types") {
      info(s"types: ${JSON.stringify(CassandraDriver.types)}")
    }

    it("has types.consistencies") {
      info(s"consistencies: ${JSON.stringify(CassandraDriver.types.consistencies, null, 4)}")
    }

    it("has types.dataTypes") {
      info(s"dataTypes: ${JSON.stringify(CassandraDriver.types.dataTypes)}")
    }

    it("has types.opcodes") {
      info(s"opcodes: ${JSON.stringify(CassandraDriver.types.opcodes)}")
    }

    it("supports CRUD operations") {
      val client = new Client(new ClientOptions(contactPoints = js.Array("localhost"), keyspace = "classroom"))
      val students = Seq(
        js.Array("123456", "Larry Sanders", "Operating Systems")
      )

      students foreach { params =>
        client.execute("INSERT INTO students (id, name, course) VALUES (?, ?, ?)", params, (err, student) => {
          console.log("student =>", student)
        })
      }
    }

    it("supports streaming results via readOption") {
      val client   = new Client(new ClientOptions(contactPoints = js.Array("localhost"), keyspace = "servo"))
      val readable = client.stream("select * from feed_types limit 1")
      readable
        .on(
          "readable",
          () => {
            var row_? : Option[MyData] = None
            do {
              row_? = readable.readOption[MyData]()
              row_? foreach { row =>
                info(s"row: ${JSON.stringify(row)}")
              }
            } while (row_?.nonEmpty)
          }
        )
        .on("end", () => {})
        .on("error", (err: Error) => console.error(err))
    }

    it("supports streaming results via iterator") {
      val client   = new Client(new ClientOptions(contactPoints = js.Array("localhost"), keyspace = "servo"))
      val readable = client.stream("select * from feed_types limit 1")
      readable
        .on("readable", () => {
          for (row <- readable.iterator[MyData]) {
            info(s"data: ${JSON.stringify(row)}")
          }
        })
        .on("end", () => {})
        .on("error", (err: Error) => console.error(err))
    }

  }

  it("supports queries") {
    val client = new Client(
      new ClientOptions(policies =
                          new LoadBalancingPolicyOptions(loadBalancing = new DCAwareRoundRobinPolicy("US_EAST")),
                        contactPoints = js.Array("localhost"),
                        keyspace = "ks1"))

    val query  = "SELECT email, last_name FROM user_profiles WHERE key = ?"
    val params = js.Array("guy")

    client.execute(query, params, (err, result) => {
      Assert.ifError(err)
      console.log("got user profile with email " + result.get("email").orUndefined)
    })
  }

  it("supports batch operations") {
    val client = new Client(new ClientOptions(contactPoints = js.Array("localhost"), keyspace = "ks1"))

    val emailAddress = "john.doe@somewhere.com"
    val queries = js.Array(
      new BatchUpdate(query = "UPDATE user_profiles SET email=? WHERE key=?",
                      params = js.Array(emailAddress, "hendrix")),
      new BatchUpdate(query = "INSERT INTO user_track (key, text, date) VALUES (?, ?, ?)",
                      params = js.Array("hendrix", "Changed email", new js.Date()))
    )
    val queryOptions = new QueryOptions(prepare = true, consistency = CassandraDriver.types.consistencies.quorum)
    client.batch(queries, queryOptions, (err: js.Error) => {
      Assert.ifError(err)
      console.log("Data updated on cluster")
    })
  }

}

/**
  * Cassandra Driver Tests
  * @author lawrence.daniels@gmail.com
  */
object CassandraDriverTest {

  @ScalaJSDefined
  class Student(val id: String, val name: String, val course: String) extends js.Object

  @js.native
  trait MyData extends js.Object {
    var feedtype: String      = js.native
    var createdby: String     = js.native
    var creationtime: js.Date = js.native
  }

}

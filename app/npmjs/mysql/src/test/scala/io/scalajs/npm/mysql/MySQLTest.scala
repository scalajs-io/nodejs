package io.scalajs.npm.mysql

import io.scalajs.JSON
import io.scalajs.nodejs._
import io.scalajs.npm.mysql.MySQLTest._
import org.scalatest.funspec.AnyFunSpec

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * MySQL Test Suite
  * @author lawrence.daniels@gmail.com
  */
class MySQLTest extends AnyFunSpec {

  describe("MySQL") {

    it("can execute queries via streaming") {
      getConnection foreach { conn =>
        val results = conn.query("SELECT * FROM activity LIMIT 1")
        results.onFields(fields => info(s"fields => ${JSON.stringify(fields.head)}"))
        results.onResult(result => info(s"row => ${JSON.stringify(result)}"))
      }
    }

    it("can execute queries via promises") {
      getConnection foreach { conn =>
        for {
          (rows, fields) <- conn.queryFuture[Activity]("SELECT * FROM activity LIMIT 1")
        } {
          info(s"fields => ${JSON.stringify(fields.head)}")
          info(s"rows => ${JSON.stringify(rows.head)}")
        }
      }
    }

    it("can execute queries via callbacks") {
      getConnection foreach { conn =>
        conn.query(
          "SELECT * FROM activity LIMIT 1", (err: js.Error, rows: js.Array[Activity], fields: js.Array[MySQLFieldPacket]) => {
            info(s"fields => ${JSON.stringify(fields.head)}")
            info(s"rows => ${JSON.stringify(rows.head)}")
          })
      }
    }

  }

  private def getConnection: Option[MySQLConnection] = {
    val conn_? = for {
      host <- process.env.get("MYSQL_HOST")
      database <- process.env.get("MYSQL_DB")
      user <- process.env.get("MYSQL_USER")
      password <- process.env.get("MYSQL_PASSWORD")
    } yield {
      // establish a connection
      val conn = MySQL.createConnection(
        new MySQLConnectionOptions(
          host = host,
          database = database,
          user = user,
          password = password
        ))

      // close connection after 60 seconds
      setTimeout(() => {
        info("Closing MySQL connection...")
        conn.destroy()
      }, 60.seconds)

      conn
    }

    if (conn_?.isEmpty) {
      info("No MySQL credentials were configured. Set MYSQL_HOST, MYSQL_DB, MYSQL_USER and MYSQL_PASSWORD.")
    }

    conn_?
  }

}

/**
  * MySQL Test Singleton
  * @author lawrence.daniels@gmail.com
  */
object MySQLTest {

  @js.native
  trait Activity extends RowDataPacket {
    var activity_id: String = js.native
    var activity_timestamp_start: js.Date = js.native
    var activity_timestamp_stop: js.Date = js.native
    var activity_boarding: js.Date = js.native
    var activity_unboarding: js.Date = js.native
    var activity_creator_user_id: Integer = js.native
    var activity_location_airport_id: Integer = js.native
    var activity_status: Integer = js.native
    var activity_inboundflightnumber: Integer = js.native
    var activity_inboundairport_airport_id: Integer = js.native
    var activity_outboundairport_airport_id: Integer = js.native
    var activity_outboundflightnumber: String = js.native
    var activity_aircraft_aircraft_id: Integer = js.native
    var activity_timestamp: js.Date = js.native
    var activity_closer_user_id: Integer = js.native
    var activity_mcccreated: Integer = js.native
    var activity_consumptiondone: Integer = js.native
    var activity_user_user_id: js.Any = js.native
  }

}

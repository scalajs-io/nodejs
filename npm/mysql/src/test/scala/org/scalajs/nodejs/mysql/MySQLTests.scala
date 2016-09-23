package org.scalajs.nodejs.mysql

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.{console, _}
import utest._

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * MySQL Tests
  * @author lawrence.daniels@gmail.com
  */
object MySQLTests extends TestSuite {

  override val tests = this {

    "query" - {
      // lets require/import the mysql native driver.
      val mysql = MySQL()

      // establish a connection
      val conn = mysql.createConnection(new ConnectionOptions(
        host = "localhost",
        database = "servo",
        user = "root",
        password = ""
      ))

      //console.log(conn)

      // close connection after 10 seconds
      setTimeout(() => {
        console.log("Closing connection...")
        conn.destroy()
      }, 10.seconds)

      // execute an example
      queryCallback()

      def queryStreaming() {
        val results = conn.query("SELECT * FROM activity LIMIT 1")
        results.onFields(fields => console.log("fields => %j", fields.head))
        results.onResult(console.log("row => %j", _))
      }

      def queryCallback() {
        conn.query("SELECT * FROM activity LIMIT 1", (err: js.Error, rows: js.Array[Activity], fields: js.Array[FieldPacket]) => {
          console.log("fields => %j", fields.head)
          console.log("rows => %j", rows.head)
        })
      }

      def queryFuture() {
        for {
          (rows, fields) <- conn.queryFuture[Activity]("SELECT * FROM activity LIMIT 1")
        } {
          console.log("fields => %j", fields.head)
          console.log("rows => %j", rows.head)
        }
      }
    }
  }

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

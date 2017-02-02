package io.scalajs.npm.mysql

import io.scalajs.nodejs.{console, _}
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * MySQL Tests
  * @author lawrence.daniels@gmail.com
  */
object MySQLTests extends FunSpec {

  describe("MySQL") {

    // establish a connection
    val conn = MySQL.createConnection(
      new ConnectionOptions(
        host = "localhost",
        database = "servo",
        user = "root",
        password = ""
      ))

    // close connection after 60 seconds
    setTimeout(() => {
      console.log("Closing connection...")
      conn.destroy()
    }, 60.seconds)

    it("can execute queries via streaming") {
      val results = conn.query("SELECT * FROM activity LIMIT 1")
      results.onFields(fields => console.log("fields => %j", fields.head))
      results.onResult(console.log("row => %j", _))
    }

    it("can execute queries via promises") {
      for {
        (rows, fields) <- conn.queryFuture[Activity]("SELECT * FROM activity LIMIT 1")
      } {
        console.log("fields => %j", fields.head)
        console.log("rows => %j", rows.head)
      }
    }

    it("can execute queries via callbacks") {
      conn.query(
        "SELECT * FROM activity LIMIT 1",
        (err: js.Error, rows: js.Array[Activity], fields: js.Array[FieldPacket]) => {
          console.log("fields => %j", fields.head)
          console.log("rows => %j", rows.head)
        }
      )
    }

  }

  @js.native
  trait Activity extends RowDataPacket {
    var activity_id: String                          = js.native
    var activity_timestamp_start: js.Date            = js.native
    var activity_timestamp_stop: js.Date             = js.native
    var activity_boarding: js.Date                   = js.native
    var activity_unboarding: js.Date                 = js.native
    var activity_creator_user_id: Integer            = js.native
    var activity_location_airport_id: Integer        = js.native
    var activity_status: Integer                     = js.native
    var activity_inboundflightnumber: Integer        = js.native
    var activity_inboundairport_airport_id: Integer  = js.native
    var activity_outboundairport_airport_id: Integer = js.native
    var activity_outboundflightnumber: String        = js.native
    var activity_aircraft_aircraft_id: Integer       = js.native
    var activity_timestamp: js.Date                  = js.native
    var activity_closer_user_id: Integer             = js.native
    var activity_mcccreated: Integer                 = js.native
    var activity_consumptiondone: Integer            = js.native
    var activity_user_user_id: js.Any                = js.native
  }

}

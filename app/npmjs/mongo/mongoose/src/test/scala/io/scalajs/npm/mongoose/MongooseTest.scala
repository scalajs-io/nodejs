package io.scalajs.npm.mongoose

import io.scalajs.JSON
import io.scalajs.nodejs.{Assert, buffer, process}
import io.scalajs.npm.mongodb.doc
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.util.{Failure, Success}

/**
  * Mongoose Tests
  * @author lawrence.daniels@gmail.com
  */
class MongooseTest extends FunSpec with MongoDBTestSupport {

  describe("Mongoose") {

    // set the promise type
    Mongoose.Promise = js.Dynamic.global.global.Promise

    it("support CRUD operations via dictionaries") {

      // define the schema
      val employeeSchema = {
        import Mongoose.Schema.Types._
        Schema[js.Dictionary[js.Any]](
          "name" -> SchemaField(`type` = String, default = "John Doe"),
          "age" -> SchemaField(`type` = Number, min = 18, c = true),
          "bio" -> SchemaField(`type` = String, `match` = js.RegExp("[a-z]")),
          "date" -> SchemaField(`type` = Date, default = js.Date.now),
          "buff" -> Buffer
        )
      }

      // define the model
      val Employees = Mongoose.model("Employee", employeeSchema)

      // create and populate an instance of the model
      val newEmployee = Employees()
      newEmployee("name") = "Tom Rowe"
      newEmployee("age") = 56
      newEmployee("bio") = "Lover of life"
      newEmployee("date") = js.Date.now()

      // connect to MongoDB, and perform CRUD on the employee
      withMongoURL { url =>
        val conn = Mongoose.connect(url, "contacts")
        Mongoose.connectFuture(url) foreach { conn =>
          val outcome = for {
          // save the employee
            saved <- newEmployee.save().toFuture
            _ = info(s"saved employee: ${JSON.stringify(saved)}")

            // retrieve the employee by ID
            employeeId = saved._id.orNull
            employeeById <- Employees.findById(employeeId).exec().toFuture
            _ = info(s"employee-by-Id: ${JSON.stringify(employeeById)}")

            // update the employee
            updateResult <- saved.increment().update(doc("name" -> "Tom Brady", "age" -> 39)).toFuture
            _ = info(s"updated employee: ${JSON.stringify(saved)}")
            _ = Assert.ok(updateResult.nModified == 1 && updateResult.isOk, JSON.stringify(updateResult))

            // retrieve a employee via where clause
            oneEmployeeWhere <- Employees.findOne(doc()).where("age").gt(35).exec().toFuture
            _ = info(s"employee-by-where: ${JSON.stringify(oneEmployeeWhere)}")

            // delete the employee
            deleted <- oneEmployeeWhere.remove().toFuture
            _ = info(s"deleted employee: ${JSON.stringify(deleted)}")
          } yield deleted

          outcome onComplete {
            case Failure(e) =>
              alert(e.getMessage)
              conn.close { err =>
                alert(err.message)
                process.exit(0)
              }
            case Success(_) =>
              info("Done.")
              conn.close { err =>
                alert(err.message)
                process.exit(0)
              }
          }
        }
      }
    }

    it("support CRUD operations via type-safe traits") {
      import io.scalajs.npm.mongoose.MongooseTest.ContactLike

      // define the schema
      val contactSchema = {
        import Mongoose.Schema.Types._
        Schema[ContactLike](
          "name" -> SchemaField(`type` = String, default = "John Doe"),
          "age" -> SchemaField(`type` = Number, min = 18, c = true),
          "bio" -> SchemaField(`type` = String, `match` = js.RegExp("[a-z]")),
          "date" -> SchemaField(`type` = Date, default = js.Date.now),
          "buff" -> Buffer
        )
      }

      // define the model
      val Contacts = Mongoose.model("Contact", contactSchema)

      // create and populate an instance of the model
      val newContact = Contacts()
      newContact.name = "John Doe"
      newContact.age = 21
      newContact.bio = "Lover of life"
      newContact.date = js.Date.now()

      // connect to MongoDB, and perform CRUD on the contact
      withMongoURL { url =>
        info(s"Connecting to '$url'...")
        Mongoose.connectFuture(url) foreach { conn =>
          val outcome = for {
          // save the contact
            saved <- newContact.save().toFuture
            _ = info(s"saved contact: ${JSON.stringify(saved)}")

            // retrieve the contact by ID
            contactId = saved._id.orNull
            contactById <- Contacts.findById(contactId).exec().toFuture
            _ = info(s"contact-by-Id: ${JSON.stringify(contactById)}")

            // update the contact
            updateResult <- saved.increment().update(doc("name" -> "John Travolta", "age" -> 63)).toFuture
            _ = info(s"updated contact: ${JSON.stringify(saved)}")
            _ = Assert.ok(updateResult.nModified == 1 && updateResult.isOk, JSON.stringify(updateResult))

            // retrieve a contact via where clause
            oneContactWhere <- Contacts.findOne(doc()).where("age").gt(60).exec().toFuture
            _ = info(s"contact-by-where: ${JSON.stringify(oneContactWhere)}")

            // delete the contact
            deleted <- oneContactWhere.remove().toFuture
            _ = info(s"deleted contact: ${JSON.stringify(deleted)}")
          } yield deleted

          outcome onComplete {
            case Failure(e) =>
              alert(e.getMessage)
              conn.close { err =>
                alert(err.message)
                process.exit(0)
              }
            case Success(_) =>
              info("Done.")
              conn.close { err =>
                alert(err.message)
                process.exit(0)
              }
          }
        }
      }
    }

  }

  process.onExit(exitCode => println(s"Process Ended (exit code = $exitCode)"))

}

/**
  * Mongoose Test Companion
  * @author lawrence.daniels@gmail.com
  */
object MongooseTest {

  @js.native
  trait ContactLike extends js.Object {
    var name: String = js.native
    var age: js.UndefOr[Int] = js.native
    var bio: js.UndefOr[String] = js.native
    var date: js.UndefOr[Double] = js.native
    var buff: js.UndefOr[buffer.Buffer] = js.native
  }

}
package examples.nodejs.concurrency

import org.scalajs.nodejs._
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.util.ScalaJsHelper
import org.scalajs.npm.async.Async

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.util.{Failure, Success, Try}

/**
  * Async ForEachOf Example
  * @author lawrence.daniels@gmail.com
  */
class AsyncForEachOfExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val async = Async()
  val fs = Fs()
  val localPath = fs.realpathSync("./src/test/resources")

  forEachOf_A()
  forEachOf_B()
  forEachOf_C()

  /**
    * Example of async.forEachOf, which closely mimics the original JavaScript version
    */
  def forEachOf_A(): Unit = {
    val obj = js.Dictionary("dev" -> "/dev.json", "test" -> "/test.json", "prod" -> "/prod.json")
    val configs = js.Dictionary[js.Any]()

    async.forEachOf(obj, (value: String, key: String, callback: js.Function1[Any, Any]) => {
      fs.readFile(localPath + value, "utf8", (err: Error, data: String) => {
        if (isDefined(err)) callback(err)
        else {
          Try {
            configs(key) = JSON.parse(data)
          } match {
            case Success(_) => callback(null)
            case Failure(e) => callback(e)
          }
        }
        console.log("Done A")
      })
    }, (err: Error) => {
      if (isDefined(err)) console.error(err.message)
      // configs is now a map of JSON data
      doSomethingWith("A", configs)
    })
  }

  /**
    * Example of async.forEachOf, which uses some Scala syntactic sugar and demonstrates the use of an Dictionary
    */
  def forEachOf_B(): Unit = {
    val envFiles = js.Dictionary("dev" -> "/dev.json", "test" -> "/test.json", "prod" -> "/prod.json")
    val configs = js.Dictionary[js.Any]()

    async.forEachOfFuture(envFiles) { (value: String, key: String, callback: js.Function1[Error, Any]) =>
      fs.readFile(localPath + value, "utf8", (err: Error, data: String) => {
        if (isDefined(err)) callback(err)
        else {
          Try {
            configs(key) = JSON.parse(data)
          } match {
            case Success(_) => callback(null)
            case Failure(e) => callback(nodejs.errors.Error(e.getMessage))
          }
        }
        console.log("Done B")
      })
    } foreach (_ => doSomethingWith("B", configs))
  }

  /**
    * Example of async.forEachOf, which some Scala syntactic sugar and demonstrates the use of an Array
    */
  def forEachOf_C(): Unit = {
    val envs = js.Array("dev", "test", "prod")
    val files = js.Array("/dev.json", "/test.json", "/prod.json")
    val configs = js.Dictionary[js.Any]()

    async.forEachOfFuture(files) { (value: String, index: Int, callback: js.Function1[Error, Any]) =>
      fs.readFile(localPath + value, "utf8", (err: Error, data: String) => {
        if (isDefined(err)) callback(err)
        else {
          Try {
            configs(envs(index)) = JSON.parse(data)
          } match {
            case Success(_) => callback(null)
            case Failure(e) => callback(nodejs.errors.Error(e.getMessage))
          }
        }
        console.log("Done C")
      })
    } foreach (_ => doSomethingWith("C", configs))
  }


  def doSomethingWith(label: String, configs: js.Any): Unit = {
    console.log("%s: configs = %j", label, configs)
  }

}

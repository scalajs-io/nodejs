package io.scalajs.npm.drama

import io.scalajs.nodejs.console
import io.scalajs.npm.drama.DramaTest._
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Drama Tests
  * @author lawrence.daniels@gmail.com
  */
class DramaTest extends FunSpec {

  describe("Drama") {
    val actorSystem = Drama("sys")

    it("should send messages to actors") {
      val actor = actorSystem.actor(new GreetingActor())
      actor ! "sayHello" -> "Hello"
      actor ! "sayHello" -> "Bon jour"
      actor ! "sayHello" -> "Buenos dias"
    }

    it("should receive messages from actors") {
      val actor = actorSystem.actor((initialState: String) => new StatefulActor(initialState))
      actor.init("Hello")

      for {
        state0 <- (actor ? "get").mapTo[String]
        _ = actor ! "set" -> "Bon jour"
        state1 <- (actor ? "get").mapTo[String]
        _ = actor ! "set" -> "Buenos dias"
        state2 <- (actor ? "get").mapTo[String]
      } {
        assert(state0 == "Hello")
        assert(state1 == "Bon jour")
        assert(state2 == "Buenos dias")
      }
    }

  }

}

/**
  * Drama Test Companion
  * @author lawrence.daniels@gmail.com
  */
object DramaTest {

  /**
    * Greeting Actor
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class GreetingActor() extends js.Object {

    def sayHello(message: String): Unit = console.log("Received: %s", message)

  }

  /**
    * Stateful Actor
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class StatefulActor(initialState: js.Any) extends StateDrivenActor(initialState)

}

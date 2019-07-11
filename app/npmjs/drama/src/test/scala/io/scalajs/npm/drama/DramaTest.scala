package io.scalajs.npm.drama

import io.scalajs.nodejs.console
import io.scalajs.npm.drama.DramaTest._
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Drama Tests
  * @author lawrence.daniels@gmail.com
  */
class DramaTest extends AnyFunSpec {

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

  class GreetingActor() extends js.Object {

    def sayHello(message: String): Unit = console.log(s"Received: '$message'")

  }

  /**
    * Stateful Actor
    * @author lawrence.daniels@gmail.com
    */

  class StatefulActor(initialState: js.Any) extends StateDrivenActor(initialState)

}

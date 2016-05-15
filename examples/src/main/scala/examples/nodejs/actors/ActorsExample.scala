package examples.nodejs.actors

import com.github.ldaniels528.meansjs.nodejs.drama.{Drama, StateDrivenActor}
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}
import examples.nodejs.actors.ActorsExample.{GreetingActor, StatefulActor}

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Actors Example
  * @author lawrence.daniels@gmail.com
  */
class ActorsExample(bootstrap: Bootstrap) {
  import bootstrap._

  val drama = require[Drama]("drama")
  val actorSystem = drama("sys")

  exampleA()
  exampleB()

  def exampleA(): Unit = {
    val actor = actorSystem.actor(new GreetingActor())
    actor ! "sayHello" -> "Hello"
    actor ! "sayHello" -> "Bon jour"
    actor ! "sayHello" -> "Buenos dias"
  }

  def exampleB(): Unit = {
    val actor = actorSystem.actor((initialState: String) => new StatefulActor(initialState))
    actor.init("Hello")

    for {
      state0 <- actor ? "get"
      _ = actor ! "set" -> "Bon jour"
      state1 <- actor ? "get"
      _ = actor ! "set" -> "Buenos dias"
      state2 <- actor ? "get"
    } {
      console.log("The state0 was: %s", state0)
      console.log("The state1 was: %s", state1)
      console.log("The state2 was: %s", state2)
    }
  }

}

/**
  * Actors Example Companion
  * @author lawrence.daniels@gmail.com
  */
object ActorsExample {

  /**
    * Greeting Actor
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class GreetingActor() extends js.Object {

    def sayHello(message: String) = console.log("Received: %s", message)

  }

  /**
    * Stateful Actor
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class StatefulActor(initialState: js.Any) extends StateDrivenActor(initialState)

}
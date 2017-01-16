package io.scalajs.npm.drama

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Actor model implementation for JavaScript and Node.js (work in progress)
  * Inspirations: Scala Actors, Akka, Pykka
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("drama", JSImport.Namespace)
object Drama extends js.Object {

  /**
    * Creates a new actor system
    * @param systemName the name of the actor system
    * @return a new actor system
    */
  def apply(systemName: String): ActorSystem = js.native

}

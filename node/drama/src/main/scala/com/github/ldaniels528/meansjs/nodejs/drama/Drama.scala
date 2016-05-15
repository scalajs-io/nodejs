package com.github.ldaniels528.meansjs.nodejs.drama

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Actor model implementation for JavaScript and Node.js (work in progress)
  * Inspirations: Scala Actors, Akka, Pykka
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Drama extends NodeModule {

  /**
    * Creates a new actor system
    * @param systemName the name of the actor system
    * @return a new actor system
    */
  def apply(systemName: String): ActorSystem = js.native

}

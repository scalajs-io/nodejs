package org.scalajs.nodejs
package drama

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

/**
  * Drama Companion
  * @author lawrence.daniels@gmail.com
  */
object Drama {

  /**
    * Convenience method for retrieving the drama module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Drama instance
    */
  def apply()(implicit require: NodeRequire) = require[Drama]("drama")

}
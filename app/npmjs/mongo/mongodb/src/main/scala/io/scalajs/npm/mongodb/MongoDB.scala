package io.scalajs.npm.mongodb

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * MongoDB Module for Node.js
  * @version 2.2
  * @see http://mongodb.github.io/node-mongodb-native/2.2/api/
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", JSImport.Namespace)
class MongoDB() extends IEventEmitter

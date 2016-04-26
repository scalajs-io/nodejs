package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Server Configuration
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */
@ScalaJSDefined
class ServerConfig extends js.Object {

}

/**
  * Server Configuration Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerConfig {

  def apply() = {
    val config = new ServerConfig()
    config
  }

}
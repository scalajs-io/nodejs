package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Server Configuration
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */
@js.native
trait ServerConfig extends js.Object {

}

/**
  * Server Configuration Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerConfig {

  def apply() = {
    val config = makeNew[ServerConfig]
    config
  }

}
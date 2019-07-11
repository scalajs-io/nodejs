package io.scalajs.npm.redis

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * redis - This is a complete and feature rich Redis client for node.js.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Redis extends js.Object {

  def createClient(): RedisClient = js.native

  def createClient(options: RedisClientOptions): RedisClient = js.native

  def createClient(redisUrl: String): RedisClient = js.native

  def createClient(redisUrl: String, options: RedisClientOptions): RedisClient = js.native

  def createClient(host: String, port: Int = js.native, options: RedisClientOptions = js.native): RedisClient = js.native

  /**
    * A handy callback function for displaying return values when testing.
    */
  def print: RedisCallback[js.Any] = js.native

}

/**
  * Redis Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("redis", JSImport.Namespace)
object Redis extends Redis

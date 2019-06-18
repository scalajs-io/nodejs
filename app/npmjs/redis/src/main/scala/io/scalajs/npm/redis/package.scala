package io.scalajs.npm

import scala.scalajs.js

/**
  * redis package object
  * @author lawrence.daniels@gmail.com
  */
package object redis {

  type RedisCallback[T] = js.Function2[RedisError, T, Any]

  type RedisChannel = String

  type RedisCommand = js.Any

  type RedisCount = Int

  type RedisMessage = String

  type RedisResponse = js.Object

  type RedisTime = String

  type RedisTLS = js.Object

}

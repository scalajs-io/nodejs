package io.scalajs.npm.redis

import scala.scalajs.js

/**
  * MULTI commands are queued up until an EXEC is issued, and then all commands are run atomically by Redis.
  * The interface in node_redis is to return an individual Multi object by calling client.multi(). If any command
  * fails to queue, all commands are rolled back and none is going to be executed (For further information look at
  * transactions).
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RedisMulti extends js.Object {

  def dbsize(): this.type = js.native

  /**
    * client.multi() is a constructor that returns a Multi object. Multi objects share all of the same command methods
    * as client objects do. Commands are queued up inside the Multi object until Multi.exec() is invoked.
    * @param callback the callback
    */
  def exec(callback: RedisCallback[js.Array[RedisResponse]]): Unit = js.native

  def execAsync(): js.Promise[js.Array[RedisResponse]] = js.native

  /**
    * Identical to Multi.exec but with the difference that executing a single command will not use transactions.
    * @param callback the callback
    */
  def exec_atomic(callback: RedisCallback[js.Array[RedisResponse]] = js.native): Unit = js.native

  def get(key: String): this.type = js.native

  /**
    *
    * @param key
    * @param callback
    * @example incr("incr thing", redis.print);
    */
  def incr(key: String, callback: RedisCallback[RedisResponse]): Unit = js.native

  def keys(key: String, callback: RedisCallback[js.Array[String]]): this.type = js.native

  /**
    *
    * @param key
    * @example scard("bigset")
    */
  def scard(key: String): this.type = js.native

  /**
    *
    * @param args
    * @example script('load', 'return 1')
    */
  def script(args: String*): this.type = js.native

  /**
    * @param key
    * @example smembers("bigset")
    */
  def smembers(key: String): this.type = js.native

}

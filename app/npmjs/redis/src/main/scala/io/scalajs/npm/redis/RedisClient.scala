package io.scalajs.npm.redis

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.fs.ReadStream
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.Dictionary

/**
  * Redis Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RedisClient extends IEventEmitter {

  //////////////////////////////////////////////////////////////////////////////
  //    Properties
  //////////////////////////////////////////////////////////////////////////////

  /**
    * The number of commands that have been sent to the Redis server but not yet replied to. You can use this to
    * enforce some kind of maximum queue depth for commands while connected.
    */
  def command_queue_length: Int = js.native

  /**
    * Boolean tracking the state of the connection to the Redis server.
    */
  def connected: Boolean = js.native

  /**
    * The number of commands that have been queued up for a future connection. You can use this to enforce some
    * kind of maximum queue depth for pre-connection commands.
    */
  def offline_queue_length: Int = js.native

  /**
    * After the ready probe completes, the results from the INFO command are saved in the client.server_info object.
    */
  def server_info: js.Dictionary[js.Any] = js.native

  /**
    * The client exposed the used stream in client.stream and if the stream or client had to buffer the command in
    * client.should_buffer. In combination this can be used to implement backpressure by checking the buffer state
    * before sending a command and listening to the stream drain event.
    */
  def stream: ReadStream = js.native

  //////////////////////////////////////////////////////////////////////////////
  //    Methods
  //////////////////////////////////////////////////////////////////////////////

  /**
    * When connecting to a Redis server that requires authentication, the AUTH command must be sent as the first
    * command after connecting. This can be tricky to coordinate with reconnections, the ready check, etc. To make
    * this easier, client.auth() stashes password and will send it after each connection, including reconnections.
    * callback is invoked only once, after the response to the very first AUTH command sent. NOTE: Your call to
    * client.auth() should not be inside the ready handler. If you are doing this wrong, client will emit an error
    * that looks something like this Error: Ready check failed: ERR operation not permitted.
    * @param password the user password
    * @param callback the optional callback
    */
  def auth(password: String, callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  /**
    * Identical to .multi without transactions. This is recommended if you want to execute many commands at once
    * but don't have to rely on transactions.
    * @example batch([commands])
    */
  def batch(commands: js.Array[RedisCommand] = js.native): RedisMulti = js.native

  /**
    * Deletes a key
    * @param key the given key
    */
  def del(key: String): Unit = js.native

  /**
    * Deletes a record by key
    * @param key      the given key
    * @param callback the given callback
    */
  def del(key: String, callback: RedisCallback[RedisResponse]): Unit = js.native

  /**
    * Deletes an array of records by their respective keys
    * @param keys     the given array of keys
    * @param callback the given callback
    */
  def del(keys: js.Array[String], callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  /**
    * Duplicate all current options and return a new redisClient instance. All options passed to the duplicate
    * function are going to replace the original option. If you pass a callback, duplicate is going to wait until
    * the client is ready and returns it in the callback. If an error occurs in the meanwhile, that is going to
    * return an error instead in the callback.
    * @param options  the optional settings
    * @param callback the optional callback
    * @return
    */
  def duplicate(options: RawOptions = js.native, callback: RedisCallback[RedisResponse]): js.Any = js.native

  /**
    * Dumps a record by key
    * @param key      the given key
    * @param callback the given callback
    */
  def dump(key: String, callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  /**
    * Forcibly close the connection to the Redis server. Note that this does not wait until all replies have been
    * parsed. If you want to exit cleanly, call client.quit() as mentioned above.
    *
    * You should set flush to true, if you are not absolutely sure you do not care about any other commands.
    * If you set flush to false all still running commands will silently fail.
    * @param flush indicates whether the want a flush to occur before closing the connection
    */
  def end(flush: Boolean = js.native): Unit = js.native

  /**
    * Indicates whether a key exists
    * @param key      the given key
    * @param callback the given callback <Error, Integer>
    */
  def exists(key: String, callback: RedisCallback[Int]): js.Any = js.native

  /**
    * Indicates whether a key exists
    * @param key      the given key
    * @param callback the given callback <Error, Integer>
    */
  def exists(key: js.Array[String], callback: RedisCallback[Int]): js.Any = js.native

  def get(key: Buffer, callback: RedisCallback[Buffer]): Unit = js.native

  def getAsync(key: Buffer): js.Promise[Buffer] = js.native

  def get(key: String, callback: RedisCallback[String]): Unit = js.native

  def getAsync(key: String): js.Promise[String] = js.native

  /**
    * Most Redis commands take a single String or an Array of Strings as arguments, and replies are sent back as a
    * single String or an Array of Strings. When dealing with hash values, there are a couple of useful exceptions to this.
    * @example
    * {{{
    *   client.hmset("hosts", "mjr", "1", "another", "23", "home", "1234");
    *   client.hgetall("hosts", function (err, obj) {
    *       console.dir(obj);
    *   });
    * }}}
    * @param key      the given hash key
    * @param callback the callback
    */
  def hgetall(key: String, callback: RedisCallback[js.Dictionary[String]]): Unit = js.native

  def hkeys(key: String, callback: RedisCallback[js.Array[String]]): Unit = js.native

  def hmset(key: String, keyValuePairs: String*): Unit = js.native

  def hmset(key: String, keyValuePairs: js.Array[String]): Unit = js.native

  def hmset(key: String, keyValuePairs: js.Array[String], callback: RedisCallback[RedisResponse]): Unit = js.native

  def hset(args: js.Array[String], callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  def hset(key: String, hashKey: String, hashValue: String, callback: RedisCallback[RedisResponse]): Unit = js.native

  /**
    * Redis supports the MONITOR command, which lets you see all commands received by the Redis server across all
    * client connections, including from other client libraries and other computers.
    *
    * A monitor event is going to be emitted for every command fired from any client connected to the server including
    * the monitoring client itself. The callback for the monitor event takes a timestamp from the Redis server, an
    * array of command arguments and the raw monitoring string.
    * @param callback the callback
    */
  def monitor(callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  def multi(args: js.Any*): RedisMulti = js.native

  def mset(args: js.Array[js.Any], callback: RedisCallback[RedisResponse]): Unit = js.native

  def publish(message: String*): Unit = js.native

  /**
    * This sends the quit command to the redis server and ends cleanly right after all running commands were properly
    * handled. If this is called while reconnecting (and therefor no connection to the redis server exists) it is going
    * to end the connection right away instead of resulting in further re-connections! All offline commands are going to
    * be flushed with an error in that case.
    */
  def quit(): Unit = js.native

  def rename(fromKey: String, toKey: String, callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  /**
    *
    * @param key
    * @param value
    * @example sadd("bigset", "a member");
    */
  def sadd(key: String, value: String): Unit = js.native

  def scan[T](cursor: Int, callback: RedisCallback[T]): Unit = js.native

  def scan[T](cursor: Int,
              command0: String, arg0: js.Any, callback: RedisCallback[T]): Unit = js.native

  def scan[T](cursor: Int,
              command0: String, arg0: js.Any,
              command1: String, arg1: js.Any, callback: RedisCallback[T]): Unit = js.native

  def scan[T](cursor: Int,
              command0: String, arg0: js.Any,
              command1: String, arg1: js.Any,
              command2: String, arg3: js.Any, callback: RedisCallback[T]): Unit = js.native

  /**
    *
    * @param args
    * @example script('load', 'return 1')
    */
  def script(args: String*): Unit = js.native

  /**
    * All Redis commands have been added to the client object. However, if new commands are introduced before this
    * library is updated, you can use send_command() to send arbitrary commands to Redis. The command_name has to
    * be lower case.
    *
    * All commands are sent as multi-bulk commands. args can either be an Array of arguments, or omitted / set to undefined.
    * @param commandName the command name
    * @param args        the optional command arguments
    * @param callback    the optional callback
    */
  def send_command(commandName: String,
                   args: js.Array[String] = js.native,
                   callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  /**
    * Sets a key-value pair
    * @param key      the given key
    * @param value    the given value
    * @param callback the callback
    * @example client.set("some key", "some val");
    */
  def set(key: String, value: String, callback: RedisCallback[RedisResponse] = js.native): Unit = js.native

  /**
    * Sets key-value pairs
    * @param args the collection of key-value pairs
    * @example client.set(["some other key", "some val"]);
    */
  def set(args: js.Array[String]): Unit = js.native

  /**
    * Sets key-value pairs
    * @param args     the collection of key-value pairs
    * @param callback the callback
    * @example client.set(["some other key", "some val"]);
    */
  def set(args: js.Array[String], callback: RedisCallback[RedisResponse]): Unit = js.native

  def subscribe(channel: RedisChannel): Unit = js.native

  def unsubscribe(): Unit = js.native

  def zadd(args: js.Array[js.Any], callback: RedisCallback[RedisResponse]): Unit = js.native

  def zrevrangebyscore(args: js.Array[js.Any], callback: RedisCallback[RedisResponse]): Unit = js.native

}

/**
  * Redis Client Companion
  * @author lawrence.daniels@gmail.com
  */
object RedisClient {

  /**
    * Redis Client Enrichment
    * @param client the given [[RedisClient Redis client]]
    */
  final implicit class RedisClientScalaEnrichment(val client: RedisClient) extends AnyVal {

    @inline
    def hgetallFuture(key: String): Future[Dictionary[String]] = {
      promiseWithError1[RedisError, js.Dictionary[String]](client.hgetall(key, _))
    }

    @inline
    def hsetFuture(key: String, dict: js.Dictionary[String]): Future[RedisResponse] = {
      val args = dict.foldLeft[js.Array[String]](js.Array(key)) { case (array, (hkey, hval)) =>
        array.push(hkey, hval)
        array
      }
      promiseWithError1[RedisError, RedisResponse](client.hset(args, _))
    }

    @inline
    def scanFuture[T](cursor: Int): Future[T] = {
      promiseWithError1[RedisError, T](client.scan(cursor, _))
    }

    @inline
    def scanCountFuture[T](cursor: Int, count: Int): Future[T] = {
      promiseWithError1[RedisError, T](client.scan(cursor, "COUNT", count, _))
    }

    @inline
    def scanMatchFuture[T](cursor: Int, regex: String): Future[T] = {
      promiseWithError1[RedisError, T](client.scan[T](cursor, "MATCH", regex, _))
    }

    @inline
    def scanMatchCountFuture[T](cursor: Int, regex: String, count: Int): Future[T] = {
      promiseWithError1[RedisError, T](client.scan[T](cursor, "COUNT", count, "MATCH", regex, _))
    }

  }

  /**
    * Redis Client Events
    * @param client the given [[RedisClient Redis client]]
    */
  final implicit class RedisClientEvents(val client: RedisClient) extends AnyVal {

    /**
      * client will emit connect as soon as the stream is connected to the server.
      */
    @inline
    def onConnect(callback: js.Function): client.type = client.on("connect", callback)

    /**
      * client will emit drain when the TCP connection to the Redis server has been buffering, but is now writable.
      * This event can be used to stream commands in to Redis and adapt to backpressure.
      *
      * If the stream is buffering client.should_buffer is set to true. Otherwise the variable is always set to false.
      * That way you can decide when to reduce your send rate and resume sending commands when you get drain.
      *
      * You can also check the return value of each command as it will also return the backpressure indicator
      * (deprecated). If false is returned the stream had to buffer.
      */
    @inline
    def onDrain(callback: js.Function): client.type = client.on("drain", callback)

    /**
      * client will emit end when an established Redis server connection has closed.
      */
    @inline
    def onEnd(callback: js.Function): client.type = client.on("end", callback)

    /**
      * client will emit error when encountering an error connecting to the Redis server or when
      * any other in node_redis occurs. If you use a command without callback and encounter a ReplyError
      * it is going to be emitted to the error listener.
      *
      * So please attach the error listener to node_redis.
      */
    @inline
    def onError(callback: js.Function1[RedisError, Any]): client.type = client.on("error", callback)

    /**
      * client will emit idle when there are no outstanding commands that are awaiting a response.
      */
    @inline
    def onIdle(callback: js.Function): client.type = client.on("idle", callback)

    /**
      * TODO add documentation
      */
    @inline
    def onMessage(callback: js.Function2[RedisChannel, RedisMessage, Any]): client.type = client.on("message", callback)

    @inline
    def onMonitor(callback: js.Function3[RedisTime, js.Array[String], js.Any, Any]): client.type = {
      client.on("monitor", callback)
    }

    /**
      * client will emit ready once a connection is established. Commands issued before the ready event are queued,
      * then replayed just before this event is emitted.
      */
    @inline
    def onReady(callback: js.Function): client.type = client.on("ready", callback)

    /**
      * client will emit reconnecting when trying to reconnect to the Redis server after losing the connection.
      * Listeners are passed an object containing delay (in ms) and attempt (the attempt #) attributes.
      */
    @inline
    def onReconnecting(callback: js.Function): client.type = client.on("reconnecting", callback)

    /**
      * When a client issues a SUBSCRIBE or PSUBSCRIBE, that connection is put into a "subscriber" mode. At that point,
      * only commands that modify the subscription set are valid and quit (and depending on the redis version ping as
      * well). When the subscription set is empty, the connection is put back into regular mode.
      *
      * If you need to send regular commands to Redis while in subscriber mode, just open another connection with a
      * new client (hint: use [[RedisClient.duplicate() client.duplicate()]]).
      */
    @inline
    def onSubscribe(callback: js.Function2[RedisChannel, RedisCount, Any]): client.type = client.on("subscribe", callback)

    /**
      * client will emit warning when password was set but none is needed and if a deprecated
      * option / function / similar is used.
      */
    @inline
    def onWarning(callback: js.Function): client.type = client.on("warning", callback)

  }

}
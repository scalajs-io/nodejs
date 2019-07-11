package io.scalajs.npm.redis

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Redis Connection Options
  * @param host                       127.0.0.1	IP address of the Redis server
  * @param port                       6379	Port of the Redis server
  * @param path                       null	The UNIX socket string of the Redis server
  * @param url                        null	The URL of the Redis server. Format:
  *                                   {{{ [redis:]//[[user][:password@]][host][:port][/db-number][?db=db-number[&password=bar[&option=value]]] }}}
  *                                   (More info avaliable at IANA).
  * @param parser                     javascript	Deprecated Use either the built-in JS parser javascript or the
  *                                   native hiredis parser. Note node_redis < 2.6 uses hiredis as default if installed.
  *                                   his changed in v.2.6.0.
  * @param string_numbers             null	Set to true, node_redis will return Redis number values as Strings instead
  *                                   of javascript Numbers. Useful if you need to handle big numbers
  *                                   (above Number.MAX_SAFE_INTEGER === {{{ 2^53 }}}). Hiredis is incapable of this behavior,
  *                                   so setting this option to true will result in the built-in javascript parser
  *                                   being used no matter the value of the parser option.
  * @param return_buffers             false	If set to true, then all replies will be sent to callbacks as Buffers
  *                                   instead of Strings.
  * @param detect_buffers             false	If set to true, then replies will be sent to callbacks as Buffers.
  *                                   This option lets you switch between Buffers and Strings on a per-command basis,
  *                                   whereas return_buffers applies to every command on a client. Note: This doesn't
  *                                   work properly with the pubsub mode. A subscriber has to either always return
  *                                   Strings or Buffers.
  * @param socket_keepalive           true	If set to true, the keep-alive functionality is enabled on the underlying socket.
  * @param no_ready_check             false	When a connection is established to the Redis server, the server might
  *                                   still be loading the database from disk. While loading, the server will not
  *                                   respond to any commands. To work around this, node_redis has a "ready check"
  *                                   which sends the INFO command to the server. The response from the INFO command
  *                                   indicates whether the server is ready for more commands. When ready, node_redis
  *                                   emits a ready event. Setting no_ready_check to true will inhibit this check.
  * @param enable_offline_queue       true	By default, if there is no active connection to the Redis server, commands
  *                                   are added to a queue and are executed once the connection has been established.
  *                                   Setting enable_offline_queue to false will disable this feature and the callback
  *                                   will be executed immediately with an error, or an error will be emitted if no
  *                                   callback is specified.
  * @param retry_max_delay            null	Deprecated Please use retry_strategy instead. By default, every time the
  *                                   client tries to connect and fails, the reconnection delay almost doubles. This
  *                                   delay normally grows infinitely, but setting retry_max_delay limits it to the
  *                                   maximum value provided in milliseconds.
  * @param connect_timeout            3600000	Deprecated Please use retry_strategy instead. Setting connect_timeout
  *                                   limits the total time for the client to connect and reconnect. The value is
  *                                   provided in milliseconds and is counted from the moment a new client is created
  *                                   or from the time the connection is lost. The last retry is going to happen
  *                                   exactly at the timeout time. Default is to try connecting until the default
  *                                   system socket timeout has been exceeded and to try reconnecting until 1h has
  *                                   elapsed.
  * @param max_attempts               0	Deprecated Please use retry_strategy instead. By default, a client will try
  *                                   reconnecting until connected. Setting max_attempts limits total amount of
  *                                   connection attempts. Setting this to 1 will prevent any reconnect attempt.
  * @param retry_unfulfilled_commands false	If set to true, all commands that were unfulfilled while the connection
  *                                   is lost will be retried after the connection has been reestablished. Use this
  *                                   with caution if you use state altering commands (e.g. incr). This is especially
  *                                   useful if you use blocking commands.
  * @param password                   null	If set, client will run Redis auth command on connect. Alias auth_pass
  *                                   Note node_redis < 2.5 must use auth_pass
  * @param db                         null	If set, client will run Redis select command on connect.
  * @param family                     IPv4	You can force using IPv6 if you set the family to 'IPv6'. See Node.js net
  *                                   or dns modules on how to use the family type.
  * @param disable_resubscribing      false	If set to true, a client won't resubscribe after disconnecting.
  * @param rename_commands            null	Passing an object with renamed commands to use instead of the original
  *                                   functions. For example, if you renamed the command KEYS to "DO-NOT-USE" then
  *                                   the rename_commands object would be: { KEYS : "DO-NOT-USE" } . See the Redis
  *                                   security topics for more info.
  * @param tls                        null	An object containing options to pass to tls.connect to set up a TLS
  *                                   connection to Redis (if, for example, it is set up to be accessible via a tunnel).
  * @param prefix                     null	A string used to prefix all used keys (e.g. namespace:test). Please be
  *                                   aware that the keys command will not be prefixed. The keys command has a
  *                                   "pattern" as argument and no key and it would be impossible to determine the
  *                                   existing keys in Redis if this would be prefixed.
  * @param retry_strategy             function	A function that receives an options object as parameter including the
  *                                   retry attempt, the total_retry_time indicating how much time passed since the
  *                                   last time connected, the error why the connection was lost and the number of
  *                                   times_connected in total. If you return a number from this function, the retry
  *                                   will happen exactly after that time in milliseconds. If you return a non-number,
  *                                   no further retry will happen and all offline commands are flushed with errors.
  *                                   Return an error to return that specific error to all offline commands.
  * @author lawrence.daniels@gmail.com
  */
class RedisClientOptions(var host: js.UndefOr[String] = js.undefined,
                         var port: js.UndefOr[Int] = js.undefined,
                         var path: js.UndefOr[String] = js.undefined,
                         var url: js.UndefOr[String] = js.undefined,
                         var parser: js.UndefOr[String] = js.undefined,
                         var string_numbers: js.UndefOr[Boolean] = js.undefined,
                         var return_buffers: js.UndefOr[Boolean] = js.undefined,
                         var detect_buffers: js.UndefOr[Boolean] = js.undefined,
                         var socket_keepalive: js.UndefOr[Boolean] = js.undefined,
                         var no_ready_check: js.UndefOr[Boolean] = js.undefined,
                         var enable_offline_queue: js.UndefOr[Boolean] = js.undefined,
                         var retry_max_delay: js.UndefOr[Int] = js.undefined,
                         var connect_timeout: js.UndefOr[Int] = js.undefined,
                         var max_attempts: js.UndefOr[Int] = js.undefined,
                         var retry_unfulfilled_commands: js.UndefOr[Boolean] = js.undefined,
                         var password: js.UndefOr[String] = js.undefined,
                         var db: js.UndefOr[String] = js.undefined,
                         var family: js.UndefOr[String] = js.undefined,
                         var disable_resubscribing: js.UndefOr[String] = js.undefined,
                         var rename_commands: js.UndefOr[js.Dictionary[String]] = js.undefined,
                         var tls: js.UndefOr[RedisTLS] = js.undefined,
                         var prefix: js.UndefOr[String] = js.undefined,
                         var retry_strategy: js.UndefOr[js.Function] = js.undefined)
  extends js.Object

/**
  * Redis Client Options
  * @author lawrence.daniels@gmail.com
  */
object RedisClientOptions extends FlexibleOptions[RedisClientOptions]

package io.scalajs.npm.mysql

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Pool Options
  * @param acquireTimeout     The milliseconds before a timeout occurs during the connection acquisition. This is slightly
  *                           different from connectTimeout, because acquiring a pool connection does not always involve
  *                           making a connection. (Default: 10000)
  * @param waitForConnections Determines the pool's action when no connections are available and the limit has been reached.
  *                           If true, the pool will queue the connection request and call it when one becomes available.
  *                           If false, the pool will immediately call back with an error. (Default: true)
  * @param connectionLimit    The maximum number of connections to create at once. (Default: 10)
  * @param queueLimit         The maximum number of connection requests the pool will queue before returning an error
  *                           from getConnection. If set to 0, there is no limit to the number of queued connection
  *                           requests. (Default: 0)
  */
@ScalaJSDefined
class PoolOptions(var acquireTimeout: js.UndefOr[Int] = js.undefined,
                  var waitForConnections: js.UndefOr[Boolean] = js.undefined,
                  var connectionLimit: js.UndefOr[Int] = js.undefined,
                  var queueLimit: js.UndefOr[Int] = js.undefined)
    extends js.Object

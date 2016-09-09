package org.scalajs.nodejs.mysql

import org.scalajs.nodejs.mysql.PoolClusterOptions.Selector

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

/**
  * Pool Cluster Options
  * @param canRetry             If true, PoolCluster will attempt to reconnect when connection fails. (Default: true)
  * @param removeNodeErrorCount If connection fails, node's errorCount increases. When errorCount is greater than
  *                             removeNodeErrorCount, remove a node in the PoolCluster. (Default: 5)
  * @param restoreNodeTimeout   If connection fails, specifies the number of milliseconds before another connection
  *                             attempt will be made. If set to 0, then node will be removed instead and never
  *                             re-used. (Default: 0)
  * @param defaultSelector      The default selector. (Default: RR)
  */
@ScalaJSDefined
class PoolClusterOptions(var canRetry: js.UndefOr[Boolean] = js.undefined,
                         var removeNodeErrorCount: js.UndefOr[Int] = js.undefined,
                         var restoreNodeTimeout: js.UndefOr[Int] = js.undefined,
                         var defaultSelector: js.UndefOr[Selector] = js.undefined) extends js.Object

/**
  * Pool Cluster Options
  * @author lawrence.daniels@gmail.com
  */
object PoolClusterOptions {
  type Selector = js.Any

  /**
    * Select one alternately. (Round-Robin)
    */
  @js.native
  @JSName("RR")
  object RR extends Selector

  /**
    * Select the node by random function.
    */
  @js.native
  @JSName("RANDOM")
  object RANDOM extends Selector

  /**
    * Select the first node available unconditionally.
    */
  @js.native
  @JSName("ORDER")
  object ORDER extends Selector


}
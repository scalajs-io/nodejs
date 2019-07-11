package io.scalajs.npm.mysql

import io.scalajs.FlexibleOptions
import io.scalajs.npm.mysql.MySQLPoolClusterOptions.Selector

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * MySQL Pool Cluster Options
  * @param canRetry             If true, PoolCluster will attempt to reconnect when connection fails. (Default: true)
  * @param removeNodeErrorCount If connection fails, node's errorCount increases. When errorCount is greater than
  *                             removeNodeErrorCount, remove a node in the PoolCluster. (Default: 5)
  * @param restoreNodeTimeout   If connection fails, specifies the number of milliseconds before another connection
  *                             attempt will be made. If set to 0, then node will be removed instead and never
  *                             re-used. (Default: 0)
  * @param defaultSelector      The default selector. (Default: RR)
  */
class MySQLPoolClusterOptions(var canRetry: js.UndefOr[Boolean] = js.undefined,
                              var removeNodeErrorCount: js.UndefOr[Int] = js.undefined,
                              var restoreNodeTimeout: js.UndefOr[Int] = js.undefined,
                              var defaultSelector: js.UndefOr[Selector] = js.undefined)
  extends js.Object

/**
  * Pool Cluster Options
  * @author lawrence.daniels@gmail.com
  */
object MySQLPoolClusterOptions extends FlexibleOptions[MySQLPoolClusterOptions] {
  type Selector = js.Any

  /**
    * Select one alternately. (Round-Robin)
    */
  @js.native
  @JSGlobal("RR")
  object RR extends Selector

  /**
    * Select the node by random function.
    */
  @js.native
  @JSGlobal("RANDOM")
  object RANDOM extends Selector

  /**
    * Select the first node available unconditionally.
    */
  @js.native
  @JSGlobal("ORDER")
  object ORDER extends Selector

}

package com.github.ldaniels528.meansjs.nodejs.cluster

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * A single instance of Node.js runs in a single thread. To take advantage of multi-core systems the user will
  * sometimes want to launch a cluster of Node.js processes to handle the load.
  *
  * The cluster module allows you to easily create child processes that all share server ports.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Cluster extends EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * True if the process is a master. This is determined by the process.env.NODE_UNIQUE_ID.
    * If process.env.NODE_UNIQUE_ID is undefined, then isMaster is true.
    */
  def isMaster: Boolean = js.native

  /**
    * True if the process is not a master (it is the negation of cluster.isMaster).
    */
  def isWorker: Boolean = js.native

  /**
    * The scheduling policy, either cluster.SCHED_RR for round-robin or cluster.SCHED_NONE to leave it to the operating
    * system. This is a global setting and effectively frozen once you spawn the first worker or call cluster.setupMaster(),
    * whatever comes first.
    *
    * SCHED_RR is the default on all operating systems except Windows. Windows will change to SCHED_RR once libuv is
    * able to effectively distribute IOCP handles without incurring a large performance hit.
    *
    * cluster.schedulingPolicy can also be set through the NODE_CLUSTER_SCHED_POLICY environment variable. Valid values
    * are "rr" and "none".
    * @return
    */
  def schedulingPolicy: String = js.native

  /**
    * After calling .setupMaster() (or .fork()) this settings object will contain the settings, including the default values.
    * It is effectively frozen after being set, because .setupMaster() can only be called once.
    * This object is not supposed to be changed or set manually, by you.
    */
  def settings: ClusterSettings = js.native

  /**
    * A reference to the current worker object. Not available in the master process.
    */
  def worker: Worker = js.native

  /**
    * A hash that stores the active worker objects, keyed by id field. Makes it easy to loop through all the workers.
    * It is only available in the master process.
    *
    * A worker is removed from cluster.workers after the worker has disconnected and exited. The order between these
    * two events cannot be determined in advance. However, it is guaranteed that the removal from the cluster.workers
    * list happens before last 'disconnect' or 'exit' event is emitted.
    * @return
    */
  def workers: js.Dictionary[Worker] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * When they are disconnected all internal handles will be closed, allowing the master process to die gracefully if
    * no other event is waiting.
    *
    * The method takes an optional callback argument which will be called when finished.
    *
    * This can only be called from the master process.
    * @example cluster.disconnect([callback])
    */
  def disconnect(callback: js.Function = null): Unit = js.native

  /**
    * Spawn a new worker process.
    * This can only be called from the master process.
    * @return a new worker
    * @example cluster.fork([env])
    */
  def fork(env: js.Any = null): Worker = js.native

  /**
    * setupMaster is used to change the default 'fork' behavior. Once called, the settings will be present in cluster.settings.
    * Note that:
    * <ul>
    * <li>any settings changes only affect future calls to .fork() and have no effect on workers that are already running</li>
    * <li>The only attribute of a worker that cannot be set via .setupMaster() is the env passed to .fork()</li>
    * <li>the defaults above apply to the first call only, the defaults for later calls is the current value at the
    * time of cluster.setupMaster() is called</li>
    * </ul>
    * @example cluster.setupMaster([settings])
    */
  def setupMaster(settings: ClusterSettings): Unit = js.native

}

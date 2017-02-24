package io.scalajs.nodejs

import io.scalajs.nodejs
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Promise
import scala.scalajs.js

/**
  * cluster package object
  */
package object cluster {

  type Message = js.Any

  /////////////////////////////////////////////////////////////////////////////////
  //      Cluster Events and Extensions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Cluster Events
    * @param cluster the given [[Cluster cluster]]
    */
  implicit class ClusterEvents(val cluster: Cluster) extends AnyVal {

    /**
      * Emitted after the worker IPC channel has disconnected. This can occur when a worker exits gracefully, is killed,
      * or is disconnected manually (such as with worker.disconnect()).
      *
      * There may be a delay between the 'disconnect' and 'exit' events. These events can be used to detect if the process
      * is stuck in a cleanup or if there are long-living connections.
      * @param callback the event handler
      */
    @inline
    def onDisconnect(callback: Worker => Any): cluster.type = cluster.on("disconnect", callback)

    /**
      * Similar to the cluster.on('exit') event, but specific to this worker.
      * @param callback the event handler
      *                 <ul>
      *                 <il>worker <Worker> the worker</li>
      *                 <li>code <Number> the exit code, if it exited normally.</li>
      *                 <li>signal <String> the name of the signal (eg. 'SIGHUP') that caused the process to be killed.</li>
      *                 </ul>
      */
    @inline
    def onExit(callback: (Worker, Int, String) => Any): cluster.type = cluster.on("exit", callback)

    /**
      * When a new worker is forked the cluster module will emit a 'fork' event. This can be used to log worker activity,
      * and create your own timeout.
      * @param callback the event handler
      */
    @inline
    def onFork(callback: Worker => Any): cluster.type = cluster.on("fork", callback)

    /**
      * After calling listen() from a worker, when the 'listening' event is emitted on the server, a 'listening' event
      * will also be emitted on cluster in the master.
      *
      * The event handler is executed with two arguments, the worker contains the worker object and the address object
      * contains the following connection properties: address, port and addressType. This is very useful if the worker
      * is listening on more than one address.
      * @param callback the event handler
      */
    @inline
    def onListening(callback: (Worker, Address) => Any): cluster.type = cluster.on("listening", callback)

    /**
      * Emitted when any worker receives a message.
      * See child_process event: 'message'.
      *
      * Before Node.js v6.0, this event emitted only the message and the handle, but not the worker object,
      * contrary to what the documentation stated.
      * @param callback the event handler
      */
    @inline
    def onMessage(callback: (Worker, Message, js.Any) => Any): cluster.type = cluster.on("message", callback)

    /**
      * After forking a new worker, the worker should respond with an online message. When the master receives an online
      * message it will emit this event. The difference between 'fork' and 'online' is that fork is emitted when the master
      * forks a worker, and 'online' is emitted when the worker is running.
      * @param callback the event handler
      */
    @inline
    def onOnline(callback: Worker => Any): cluster.type = cluster.on("online", callback)

    /**
      * Emitted every time .setupMaster() is called.
      * The settings object is the cluster.settings object at the time .setupMaster() was called and is advisory only,
      * since multiple calls to .setupMaster() can be made in a single tick.
      *
      * If accuracy is important, use cluster.settings.
      * @param callback the event handler
      */
    @inline
    def onSetup(callback: ClusterSettings => Any): cluster.type = cluster.on("setup", callback)

  }

  /////////////////////////////////////////////////////////////////////////////////
  //      Worker Events and Extensions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Worker Events and Extensions
    * @param worker the given [[Worker worker]]
    */
  implicit class WorkerEvents(val worker: Worker) extends AnyVal {

    /////////////////////////////////////////////////////////////////////////////////
    //      Worker Extensions
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Send a message to a worker or master, optionally with a handle.
      * In the master this sends a message to a specific worker. It is identical to ChildProcess.send().
      * In a worker this sends a message to the master. It is identical to process.send().
      * @example worker.send(message[, sendHandle][, callback])
      */
    @inline
    def sendFuture[T](message: Message): Promise[T] = promiseCallback1[T](worker.send(message, _))

    /////////////////////////////////////////////////////////////////////////////////
    //      Worker Events
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Similar to the cluster.on('disconnect') event, but specific to this worker.
      * @param callback the event handler
      */
    @inline
    def onDisconnect(callback: () => Any): worker.type = worker.on("disconnect", callback)

    /**
      * This event is the same as the one provided by child_process.fork().
      * In a worker you can also use process.on('error').
      * @param callback the error handler
      */
    @inline
    def onError(callback: nodejs.Error => Any): worker.type = worker.on("error", callback)

    /**
      * Similar to the cluster.on('exit') event, but specific to this worker.
      * @param callback the callback
      *                 <ul>
      *                 <il>worker <Worker> the worker</li>
      *                 <li>code <Number> the exit code, if it exited normally.</li>
      *                 <li>signal <String> the name of the signal (eg. 'SIGHUP') that caused the process to be killed.</li>
      *                 </ul>
      */
    @inline
    def onExit(callback: (Worker, Int, String) => Any): worker.type = worker.on("exit", callback)

    /**
      * Similar to the cluster.on('listening') event, but specific to this worker.
      * @param callback the event handler
      */
    @inline
    def onListening(callback: Address => Any): worker.type = worker.on("listening", callback)

    /**
      * Similar to the cluster.on('message') event, but specific to this worker.
      * This event is the same as the one provided by child_process.fork().
      * In a worker you can also use process.on('message').
      * @param callback the event handler
      */
    @inline
    def onMessage(callback: Message => Any): worker.type = worker.on("message", callback)

    /**
      * Similar to the cluster.on('online') event, but specific to this worker.
      * @param callback the event handler
      */
    @inline
    def onOnline(callback: () => Any): worker.type = worker.on("online", callback)

  }

}

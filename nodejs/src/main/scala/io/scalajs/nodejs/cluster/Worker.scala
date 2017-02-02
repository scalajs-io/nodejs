package io.scalajs.nodejs.cluster

import io.scalajs.nodejs.Process
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js

/**
  * A Worker object contains all public information and method about a worker. In the master it can be obtained using
  * cluster.workers. In a worker it can be obtained using cluster.worker.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Worker extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Set by calling .kill() or .disconnect(). Until then, it is undefined.
    *
    * The boolean worker.exitedAfterDisconnect lets you distinguish between voluntary and accidental exit, the master
    * may choose not to respawn a worker based on this value.
    */
  def exitedAfterDisconnect: Boolean = js.native

  /**
    * Each new worker is given its own unique id, this id is stored in the id.
    * While a worker is alive, this is the key that indexes it in cluster.workers
    */
  def id: Integer = js.native

  /**
    * All workers are created using child_process.fork(), the returned object from this function is stored as .process.
    * In a worker, the global process is stored.
    *
    * Note that workers will call process.exit(0) if the 'disconnect' event occurs on process and .exitedAfterDisconnect
    * is not true. This protects against accidental disconnection.
    */
  def process: Process = js.native

  /**
    * An alias to worker.exitedAfterDisconnect.
    *
    * Set by calling .kill() or .disconnect(). Until then, it is undefined.
    *
    * The boolean worker.suicide lets you distinguish between voluntary and accidental exit, the master may choose not
    * to respawn a worker based on this value.
    * @return
    */
  @deprecated("Deprecated: Use worker.exitedAfterDisconnect instead.", since = "6.0.0")
  def suicide: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * In a worker, this function will close all servers, wait for the 'close' event on those servers, and then
    * disconnect the IPC channel.
    *
    * In the master, an internal message is sent to the worker causing it to call .disconnect() on itself.
    * Causes .exitedAfterDisconnect to be set.
    *
    * Note that after a server is closed, it will no longer accept new connections, but connections may be accepted by
    * any other listening worker. Existing connections will be allowed to close as usual. When no more connections exist,
    * see server.close(), the IPC channel to the worker will close allowing it to die gracefully.
    *
    * The above applies only to server connections, client connections are not automatically closed by workers, and
    * disconnect does not wait for them to close before exiting.
    *
    * Note that in a worker, process.disconnect exists, but it is not this function, it is disconnect.
    *
    * Because long living server connections may block workers from disconnecting, it may be useful to send a message,
    * so application specific actions may be taken to close them. It also may be useful to implement a timeout, killing
    * a worker if the 'disconnect' event has not been emitted after some time.
    */
  def disconnect(): Unit = js.native

  /**
    * This function returns true if the worker is connected to its master via its IPC channel, false otherwise.
    * A worker is connected to its master after it's been created. It is disconnected after the 'disconnect' event is emitted.
    */
  def isConnected(): Boolean = js.native

  /**
    * This function returns true if the worker's process has terminated (either because of exiting or being signaled).
    * Otherwise, it returns false.
    */
  def isDead(): Boolean = js.native

  /**
    * This function will kill the worker. In the master, it does this by disconnecting the worker.process, and once
    * disconnected, killing with signal. In the worker, it does it by disconnecting the channel, and then exiting with code 0.
    *
    * Causes .exitedAfterDisconnect to be set.
    * This method is aliased as worker.destroy() for backwards compatibility.
    *
    * Note that in a worker, process.kill() exists, but it is not this function, it is kill.
    * @param signal the name of the kill signal to send to the worker process.
    * @example kill([signal='SIGTERM'])
    */
  def kill(signal: String = null): Unit = js.native

  /**
    * Send a message to a worker or master, optionally with a handle.
    * In the master this sends a message to a specific worker. It is identical to ChildProcess.send().
    * In a worker this sends a message to the master. It is identical to process.send().
    * @example worker.send(message[, sendHandle][, callback])
    */
  def send(message: Message, sendHandle: js.Function, callback: js.Function): Unit = js.native

  /**
    * Send a message to a worker or master, optionally with a handle.
    * In the master this sends a message to a specific worker. It is identical to ChildProcess.send().
    * In a worker this sends a message to the master. It is identical to process.send().
    * @example worker.send(message[, sendHandle][, callback])
    */
  def send(message: Message, callback: js.Function): Unit = js.native

  /**
    * Send a message to a worker or master, optionally with a handle.
    * In the master this sends a message to a specific worker. It is identical to ChildProcess.send().
    * In a worker this sends a message to the master. It is identical to process.send().
    * @example worker.send(message[, sendHandle][, callback])
    */
  def send(message: Message): Unit = js.native

}

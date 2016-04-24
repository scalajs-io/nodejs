package com.github.ldaniels528.meansjs.zookeeper

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Zookeeper Client
  * @author lawrence.daniels@gmail.com
  * @see https://github.com/alexguan/node-zookeeper-client
  */
@js.native
trait Client extends js.Object {

  /**
    * @example void addAuthInfo(scheme, auth)
    */
  def addAuthInfo(scheme: String, auth: Buffer): Unit = js.native

  /**
    * Close this client. Once the client is closed, its session becomes invalid. All the ephemeral nodes in
    * the ZooKeeper server associated with the session will be removed. The watchers left on those nodes
    * (and on their parents) will be triggered.
    * @example void close()
    */
  def close(): Unit = js.native

  /**
    * Initiate the connection to the provided server list (ensemble). The client will pick an arbitrary server
    * from the list and attempt to connect to it. If the establishment of the connection fails, another server
    * will be tried (picked randomly) until a connection is established or close method is invoked.
    * @example void connect()
    */
  def connect(): Unit = js.native

  /**
    * @example void create(path, [data], [acls], [mode], callback)
    */
  def create(path: String, data: js.Any, acls: String, mode: String, callback: js.Function): Unit = js.native

  /**
    * @example void create(path, [data], [acls], [mode], callback)
    */
  def create(path: String, data: js.Any, acls: String, callback: js.Function): Unit = js.native

  /**
    * @example void create(path, [data], [acls], [mode], callback)
    */
  def create(path: String, data: js.Any, callback: js.Function): Unit = js.native

  /**
    * @example void create(path, [data], [acls], [mode], callback)
    */
  def create(path: String, callback: js.Function): Unit = js.native

  /**
    * @example void exists(path, [watcher], callback)
    */
  def exists(path: String, watcher: Watcher, callback: js.Function): Unit = js.native

  /**
    * @example void exists(path, [watcher], callback)
    */
  def exists(path: String, callback: js.Function): Unit = js.native

  /**
    * @example void getACL(path, callback)
    */
  def getACL(path: String, callback: js.Function): Unit = js.native

  /**
    * @example void getChildren(path, [watcher], callback)
    */
  def getChildren(path: String, watcher: Watcher, callback: js.Function): Unit = js.native

  /**
    * @example void getChildren(path, [watcher], callback)
    */
  def getChildren(path: String, callback: js.Function): Unit = js.native

  /**
    * @example void getData(path, [watcher], callback)
    */
  def getData(path: String, watcher: Watcher, callback: js.Function): Unit = js.native

  /**
    * @example void getData(path, [watcher], callback)
    */
  def getData(path: String, callback: js.Function): Unit = js.native

  /**
    * @example Buffer getSessionId()
    */
  def getSessionId(): Buffer = js.native

  /**
    * @example Buffer getSessionPassword()
    */
  def getSessionPassword(): Buffer

  /**
    * @example Number getSessionTimeout()
    */
  def getSessionTimeout(): Number

  /**
    * @example State getState()
    */
  def getState(): State = js.native

  /**
    * @example void mkdirp(path, [data], [acls], [mode], callback)
    */
  def mkdirp(path: String, data: js.Any, acls: String, mode: String, callback: js.Function): Unit = js.native

  /**
    * @example void mkdirp(path, [data], [acls], [mode], callback)
    */
  def mkdirp(path: String, data: js.Any, acls: String, callback: js.Function): Unit = js.native

  /**
    * @example void mkdirp(path, [data], [acls], [mode], callback)
    */
  def mkdirp(path: String, data: js.Any, callback: js.Function): Unit = js.native

  /**
    * @example void mkdirp(path, [data], [acls], [mode], callback)
    */
  def mkdirp(path: String, callback: js.Function): Unit = js.native

  /**
    * By default, we will consume messages from the last committed offset of the current group
    * @param message  the given event message (e.g. "error")
    * @param callback callback when new message comes
    * @example consumer.on('message', function (message) { .. })
    */
  def on(message: String, callback: js.Function): Unit = js.native

  def once(message: String, callback: js.Function): Unit = js.native

  /**
    * @example void remove(path, [version], callback)
    */
  def remove(path: String, version: String, callback: js.Function): Unit = js.native

  /**
    * @example void remove(path, [version], callback)
    */
  def remove(path: String, callback: js.Function): Unit = js.native

  /**
    * @example void setACL(path, acls, [version], callback)
    */
  def setACL(path: String, acls: String, version: String, callback: js.Function): Unit = js.native

  /**
    * @example void setACL(path, acls, [version], callback)
    */
  def setACL(path: String, acls: String, callback: js.Function): Unit = js.native

  /**
    * @example void setData(path, data, [version], callback)
    */
  def setData(path: String, data: js.Any, version: String, callback: js.Function): Unit = js.native

  /**
    * @example void setData(path, data, [version], callback)
    */
  def setData(path: String, data: js.Any, callback: js.Function): Unit = js.native

  /**
    * @example transaction(): Transaction
    */
  def transaction(): Transaction = js.native

}

/**
  * Zookeeper Client Companion
  * @author lawrence.daniels@gmail.com
  */
object Client {

  /**
    * Client Extensions
    * @param client the given [[Client client]]
    */
  implicit class ClientExtensions(val client: Client) extends AnyVal {

    /**
      * @see [[Client.getChildren()]]
      */
    def getChildrenAsync(path: String, watcher: Watcher) = toFuture[js.Array[String]](client.getChildren(path, watcher, _))

    /**
      * @see [[Client.getChildren()]]
      */
    def getChildrenAsync(path: String) = toFuture[js.Any](client.getChildren(path, _))

    /**
      * @see [[Client.getData()]]
      */
    def getDataAsync[T](path: String, watcher: Watcher) = toFuture[js.Array[T]](client.getChildren(path, watcher, _))

    /**
      * @see [[Client.getData()]]
      */
    def getDataAsync[T](path: String) = toFuture[js.Array[T]](client.getChildren(path, _))

    /**
      * @see [[Client.on()]]
      */
    def onConnected(callback: js.Function) = client.on("connected", callback)

    /**
      * @see [[Client.once()]]
      */
    def onceConnected(callback: js.Function) = client.once("connected", callback)

    /**
      * @see [[Client.on()]]
      */
    def onState(callback: js.Function) = client.on("state", callback)

  }

}

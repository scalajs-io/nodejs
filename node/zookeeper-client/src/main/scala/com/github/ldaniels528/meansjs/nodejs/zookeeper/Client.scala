package com.github.ldaniels528.meansjs.nodejs.zookeeper

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Node Zookeeper Client (node-zookeeper-client)
  * @author lawrence.daniels@gmail.com
  * @see [[https://github.com/alexguan/node-zookeeper-client]]
  */
@js.native
trait Client extends js.Object {

  /**
    * Add the specified scheme:auth information to this client.
    * @param scheme The authentication scheme.
    * @param auth   The authentication [[Buffer data buffer]].
    * @example void addAuthInfo(scheme, auth)
    * @example zookeeper.addAuthInfo('ip', new Buffer('127.0.0.1'));
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
    * Returns the session id of this client instance. The value returned is not valid until the client connects to a
    * server and may change after a re-connect.
    *
    * The id returned is a long integer stored into an 8-byte Buffer since Javascript does not support long integer natively.
    * @return a long integer stored as an 8-byte Buffer
    */
  def getSessionId(): Buffer = js.native

  /**
    * Returns the session password of this client instance. The value returned is not valid until the client connects
    * to a server and may change after a re-connect.
    *
    * The value returned is an instance of Buffer.
    * @return the session password
    */
  def getSessionPassword(): Buffer

  /**
    * Returns the negotiated session timeout (in milliseconds) for this client instance. The value returned is not
    * valid until the client connects to a server and may change after a re-connect.
    * @return the negotiated session timeout (in milliseconds)
    */
  def getSessionTimeout(): Integer

  /**
    * Return the current client state.
    * @return the current client state.
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
    @inline
    def getChildrenAsync(path: String, watcher: Watcher) = callbackWithErrorToFuture[js.Array[String]](client.getChildren(path, watcher, _))

    /**
      * @see [[Client.getChildren()]]
      */
    @inline
    def getChildrenAsync(path: String) = callbackWithErrorToFuture[js.Any](client.getChildren(path, _))

    /**
      * @see [[Client.getData()]]
      */
    @inline
    def getDataAsync[T](path: String, watcher: Watcher) = callbackWithErrorToFuture[js.Array[T]](client.getChildren(path, watcher, _))

    /**
      * @see [[Client.getData()]]
      */
    @inline
    def getDataAsync[T](path: String) = callbackWithErrorToFuture[js.Array[T]](client.getChildren(path, _))

    /**
      * Client is connected and ready.
      */
    @inline
    def onConnected(callback: js.Function) = client.on("connected", callback)

    /**
      * Client is connected to a readonly server.
      */
    @inline
    def onConnectedReadOnly(callback: js.Function) = client.on("connectedReadOnly", callback)

    /**
      * The connection between client and server is dropped.
      */
    @inline
    def onDisconnected(callback: js.Function) = client.on("disconnected", callback)

    /**
      * The client session is expired.
      */
    @inline
    def onExpired(callback: js.Function) = client.on("expired", callback)

    /**
      * Failed to authenticate with the server.
      */
    @inline
    def onAuthenticationFailed(callback: js.Function) = client.on("authenticationFailed", callback)

    /**
      * @see [[Client.once()]]
      */
    @inline
    def onceConnected(callback: js.Function) = client.once("connected", callback)

    /**
      * @see [[Client.on()]]
      */
    @inline
    def onState(callback: js.Function) = client.on("state", callback)

  }

}

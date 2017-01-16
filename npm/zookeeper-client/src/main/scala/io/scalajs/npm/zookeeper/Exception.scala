package io.scalajs.npm.zookeeper

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * If the requested operation fails due to reason related to ZooKeeper, the error which is passed into callback
  * function will be an instance of Exception class.
  *
  * The exception can be identified through its error code, the following is the list of error codes that are
  * exported through Exception class.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Exception extends js.Object {

  /**
    * Return the error code of the exception.
    * @return the error code of the exception.
    */
  def getCode(): String = js.native

  /**
    * Return the exception name as defined in aforementioned list.
    * @return the exception name as defined in aforementioned list.
    */
  def getName(): String = js.native

  /**
    * Return the associated node path of the exception. The path can be undefined if the exception is not related to node.
    * @return the associated node path of the exception.
    */
  def getPath(): js.UndefOr[String] = js.native

  /**
    * Returns the stack trace for the error
    * @return the stack trace
    */
  def stack: js.Any = js.native

  /**
    * Return the exception in a readable string.
    * @return the exception in a readable string.
    */
  override def toString(): String = js.native

}

/**
  * Zookeeper Exception Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Exception")
object Exception extends js.Object {
  val OK: String = js.native
  val SYSTEM_ERROR: String = js.native
  val RUNTIME_INCONSISTENCY: String = js.native
  val DATA_INCONSISTENCY: String = js.native
  val CONNECTION_LOSS: String = js.native
  val MARSHALLING_ERROR: String = js.native
  val UNIMPLEMENTED: String = js.native
  val OPERATION_TIMEOUT: String = js.native
  val BAD_ARGUMENTS: String = js.native
  val API_ERROR: String = js.native
  val NO_NODE: String = js.native
  val NO_AUTH: String = js.native
  val BAD_VERSION: String = js.native
  val NO_CHILDREN_FOR_EPHEMERALS: String = js.native
  val NODE_EXISTS: String = js.native
  val NOT_EMPTY: String = js.native
  val SESSION_EXPIRED: String = js.native
  val INVALID_CALLBACK: String = js.native
  val INVALID_ACL: String = js.native
  val AUTH_FAILED: String = js.native

}
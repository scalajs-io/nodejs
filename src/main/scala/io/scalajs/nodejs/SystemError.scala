package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * System Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("errors", "SystemError")
class SystemError(message0: String = js.native) extends Error(message0) {

  /**
    * The error.code property is a string representing the error code,
    * which is always E followed by a sequence of capital letters.
    */
  val code: String = js.native

  /**
    * The error.errno property is a number or a string. The number is a negative value which corresponds
    * to the error code defined in libuv Error handling. See uv-errno.h header file (deps/uv/include/uv-errno.h
    * in the Node.js source tree) for details. In case of a string, it is the same as error.code.
    */
  val errno: String | Int = js.native

  /**
    * The error.syscall property is a string describing the syscall that failed.
    */
  val syscall: String = js.native

  /**
    * When present (e.g. in fs or child_process), the error.path property is a string containing
    * a relevant invalid pathname.
    */
  val path: String = js.native

  /**
    * When present (e.g. in net or dgram), the error.address property is a string describing the address
    * to which the connection failed.
    */
  val address: String = js.native

  /**
    * When present (e.g. in net or dgram), the error.port property is a number representing the connection's
    * port that is not available.
    */
  val port: Int = js.native

}

/**
  * System Error Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("errors", "SystemError")
object SystemError extends Error
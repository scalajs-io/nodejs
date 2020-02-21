package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * System Error
  */
@js.native
trait SystemError extends Error {

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

  val dest: String    = js.native
  val info: js.Object = js.native
}

object SystemErrorCodes {
  @inline final val E2BIG           = "E2BIG"
  @inline final val EACCES          = "EACCES"
  @inline final val EADDRINUSE      = "EADDRINUSE"
  @inline final val EADDRNOTAVAIL   = "EADDRNOTAVAIL"
  @inline final val EAFNOSUPPORT    = "EAFNOSUPPORT"
  @inline final val EAGAIN          = "EAGAIN"
  @inline final val EALREADY        = "EALREADY"
  @inline final val EBADE           = "EBADE"
  @inline final val EBADF           = "EBADF"
  @inline final val EBADFD          = "EBADFD"
  @inline final val EBADMSG         = "EBADMSG"
  @inline final val EBADR           = "EBADR"
  @inline final val EBADRQC         = "EBADRQC"
  @inline final val EBADSLT         = "EBADSLT"
  @inline final val EBUSY           = "EBUSY"
  @inline final val ECANCELED       = "ECANCELED"
  @inline final val ECHILD          = "ECHILD"
  @inline final val ECHRNG          = "ECHRNG"
  @inline final val ECOMM           = "ECOMM"
  @inline final val ECONNABORTED    = "ECONNABORTED"
  @inline final val ECONNREFUSED    = "ECONNREFUSED"
  @inline final val ECONNRESET      = "ECONNRESET"
  @inline final val EDEADLK         = "EDEADLK"
  @inline final val EDEADLOCK       = "EDEADLOCK"
  @inline final val EDESTADDRREQ    = "EDESTADDRREQ"
  @inline final val EDOM            = "EDOM"
  @inline final val EDQUOT          = "EDQUOT"
  @inline final val EEXIST          = "EEXIST"
  @inline final val EFAULT          = "EFAULT"
  @inline final val EFBIG           = "EFBIG"
  @inline final val EHOSTDOWN       = "EHOSTDOWN"
  @inline final val EHOSTUNREACH    = "EHOSTUNREACH"
  @inline final val EHWPOISON       = "EHWPOISON"
  @inline final val EIDRM           = "EIDRM"
  @inline final val EILSEQ          = "EILSEQ"
  @inline final val EINPROGRESS     = "EINPROGRESS"
  @inline final val EINTR           = "EINTR"
  @inline final val EINVAL          = "EINVAL"
  @inline final val EIO             = "EIO"
  @inline final val EISCONN         = "EISCONN"
  @inline final val EISDIR          = "EISDIR"
  @inline final val EISNAM          = "EISNAM"
  @inline final val EKEYEXPIRED     = "EKEYEXPIRED"
  @inline final val EKEYREJECTED    = "EKEYREJECTED"
  @inline final val EKEYREVOKED     = "EKEYREVOKED"
  @inline final val EL2HLT          = "EL2HLT"
  @inline final val EL2NSYNC        = "EL2NSYNC"
  @inline final val EL3HLT          = "EL3HLT"
  @inline final val EL3RST          = "EL3RST"
  @inline final val ELIBACC         = "ELIBACC"
  @inline final val ELIBBAD         = "ELIBBAD"
  @inline final val ELIBEXEC        = "ELIBEXEC"
  @inline final val ELIBMAX         = "ELIBMAX"
  @inline final val ELIBSCN         = "ELIBSCN"
  @inline final val ELNRANGE        = "ELNRANGE"
  @inline final val ELOOP           = "ELOOP"
  @inline final val EMEDIUMTYPE     = "EMEDIUMTYPE"
  @inline final val EMFILE          = "EMFILE"
  @inline final val EMLINK          = "EMLINK"
  @inline final val EMSGSIZE        = "EMSGSIZE"
  @inline final val EMULTIHOP       = "EMULTIHOP"
  @inline final val ENAMETOOLONG    = "ENAMETOOLONG"
  @inline final val ENETDOWN        = "ENETDOWN"
  @inline final val ENETRESET       = "ENETRESET"
  @inline final val ENETUNREACH     = "ENETUNREACH"
  @inline final val ENFILE          = "ENFILE"
  @inline final val ENOANO          = "ENOANO"
  @inline final val ENOBUFS         = "ENOBUFS"
  @inline final val ENODATA         = "ENODATA"
  @inline final val ENODEV          = "ENODEV"
  @inline final val ENOENT          = "ENOENT"
  @inline final val ENOEXEC         = "ENOEXEC"
  @inline final val ENOKEY          = "ENOKEY"
  @inline final val ENOLCK          = "ENOLCK"
  @inline final val ENOLINK         = "ENOLINK"
  @inline final val ENOMEDIUM       = "ENOMEDIUM"
  @inline final val ENOMEM          = "ENOMEM"
  @inline final val ENOMSG          = "ENOMSG"
  @inline final val ENONET          = "ENONET"
  @inline final val ENOPKG          = "ENOPKG"
  @inline final val ENOPROTOOPT     = "ENOPROTOOPT"
  @inline final val ENOSPC          = "ENOSPC"
  @inline final val ENOSR           = "ENOSR"
  @inline final val ENOSTR          = "ENOSTR"
  @inline final val ENOSYS          = "ENOSYS"
  @inline final val ENOTBLK         = "ENOTBLK"
  @inline final val ENOTCONN        = "ENOTCONN"
  @inline final val ENOTDIR         = "ENOTDIR"
  @inline final val ENOTEMPTY       = "ENOTEMPTY"
  @inline final val ENOTRECOVERABLE = "ENOTRECOVERABLE"
  @inline final val ENOTSOCK        = "ENOTSOCK"
  @inline final val ENOTSUP         = "ENOTSUP"
  @inline final val ENOTTY          = "ENOTTY"
  @inline final val ENOTUNIQ        = "ENOTUNIQ"
  @inline final val ENXIO           = "ENXIO"
  @inline final val EOPNOTSUPP      = "EOPNOTSUPP"
  @inline final val EOVERFLOW       = "EOVERFLOW"
  @inline final val EOWNERDEAD      = "EOWNERDEAD"
  @inline final val EPERM           = "EPERM"
  @inline final val EPFNOSUPPORT    = "EPFNOSUPPORT"
  @inline final val EPIPE           = "EPIPE"
  @inline final val EPROTO          = "EPROTO"
  @inline final val EPROTONOSUPPORT = "EPROTONOSUPPORT"
  @inline final val EPROTOTYPE      = "EPROTOTYPE"
  @inline final val ERANGE          = "ERANGE"
  @inline final val EREMCHG         = "EREMCHG"
  @inline final val EREMOTE         = "EREMOTE"
  @inline final val EREMOTEIO       = "EREMOTEIO"
  @inline final val ERESTART        = "ERESTART"
  @inline final val ERFKILL         = "ERFKILL"
  @inline final val EROFS           = "EROFS"
  @inline final val ESHUTDOWN       = "ESHUTDOWN"
  @inline final val ESOCKTNOSUPPORT = "ESOCKTNOSUPPORT"
  @inline final val ESPIPE          = "ESPIPE"
  @inline final val ESRCH           = "ESRCH"
  @inline final val ESTALE          = "ESTALE"
  @inline final val ESTRPIPE        = "ESTRPIPE"
  @inline final val ETIME           = "ETIME"
  @inline final val ETIMEDOUT       = "ETIMEDOUT"
  @inline final val ETOOMANYREFS    = "ETOOMANYREFS"
  @inline final val ETXTBSY         = "ETXTBSY"
  @inline final val EUCLEAN         = "EUCLEAN"
  @inline final val EUNATCH         = "EUNATCH"
  @inline final val EUSERS          = "EUSERS"
  @inline final val EWOULDBLOCK     = "EWOULDBLOCK"
  @inline final val EXDEV           = "EXDEV"
  @inline final val EXFULL          = "EXFULL"
}

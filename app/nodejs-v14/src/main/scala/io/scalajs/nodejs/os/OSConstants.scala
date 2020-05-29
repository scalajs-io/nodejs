package io.scalajs.nodejs.os

import scala.scalajs.js

@js.native
trait OSConstants extends js.Object {
  val UV_UDP_REUSEADDR: Int         = js.native
  val dlopen: OSDlopenConstants     = js.native
  val errno: OSErrnoConstants       = js.native
  val signals: OSSignalsConstants   = js.native
  val priority: OSPriorityConstants = js.native
}

@js.native
trait OSDlopenConstants extends js.Object {
  val RTLD_LAZY: Int     = js.native
  val RTLD_NOW: Int      = js.native
  val RTLD_GLOBAL: Int   = js.native
  val RTLD_LOCAL: Int    = js.native
  val RTLD_DEEPBIND: Int = js.native
}

@js.native
trait OSErrnoConstants extends js.Object {
  val E2BIG: Int           = js.native
  val EACCES: Int          = js.native
  val EADDRINUSE: Int      = js.native
  val EADDRNOTAVAIL: Int   = js.native
  val EAFNOSUPPORT: Int    = js.native
  val EAGAIN: Int          = js.native
  val EALREADY: Int        = js.native
  val EBADF: Int           = js.native
  val EBADMSG: Int         = js.native
  val EBUSY: Int           = js.native
  val ECANCELED: Int       = js.native
  val ECHILD: Int          = js.native
  val ECONNABORTED: Int    = js.native
  val ECONNREFUSED: Int    = js.native
  val ECONNRESET: Int      = js.native
  val EDEADLK: Int         = js.native
  val EDESTADDRREQ: Int    = js.native
  val EDOM: Int            = js.native
  val EDQUOT: Int          = js.native
  val EEXIST: Int          = js.native
  val EFAULT: Int          = js.native
  val EFBIG: Int           = js.native
  val EHOSTUNREACH: Int    = js.native
  val EIDRM: Int           = js.native
  val EILSEQ: Int          = js.native
  val EINPROGRESS: Int     = js.native
  val EINTR: Int           = js.native
  val EINVAL: Int          = js.native
  val EIO: Int             = js.native
  val EISCONN: Int         = js.native
  val EISDIR: Int          = js.native
  val ELOOP: Int           = js.native
  val EMFILE: Int          = js.native
  val EMLINK: Int          = js.native
  val EMSGSIZE: Int        = js.native
  val EMULTIHOP: Int       = js.native
  val ENAMETOOLONG: Int    = js.native
  val ENETDOWN: Int        = js.native
  val ENETRESET: Int       = js.native
  val ENETUNREACH: Int     = js.native
  val ENFILE: Int          = js.native
  val ENOBUFS: Int         = js.native
  val ENODATA: Int         = js.native
  val ENODEV: Int          = js.native
  val ENOENT: Int          = js.native
  val ENOEXEC: Int         = js.native
  val ENOLCK: Int          = js.native
  val ENOLINK: Int         = js.native
  val ENOMEM: Int          = js.native
  val ENOMSG: Int          = js.native
  val ENOPROTOOPT: Int     = js.native
  val ENOSPC: Int          = js.native
  val ENOSR: Int           = js.native
  val ENOSTR: Int          = js.native
  val ENOSYS: Int          = js.native
  val ENOTCONN: Int        = js.native
  val ENOTDIR: Int         = js.native
  val ENOTEMPTY: Int       = js.native
  val ENOTSOCK: Int        = js.native
  val ENOTSUP: Int         = js.native
  val ENOTTY: Int          = js.native
  val ENXIO: Int           = js.native
  val EOPNOTSUPP: Int      = js.native
  val EOVERFLOW: Int       = js.native
  val EPERM: Int           = js.native
  val EPIPE: Int           = js.native
  val EPROTO: Int          = js.native
  val EPROTONOSUPPORT: Int = js.native
  val EPROTOTYPE: Int      = js.native
  val ERANGE: Int          = js.native
  val EROFS: Int           = js.native
  val ESPIPE: Int          = js.native
  val ESRCH: Int           = js.native
  val ESTALE: Int          = js.native
  val ETIME: Int           = js.native
  val ETIMEDOUT: Int       = js.native
  val ETXTBSY: Int         = js.native
  val EWOULDBLOCK: Int     = js.native
  val EXDEV: Int           = js.native
}

@js.native
trait OSSignalsConstants extends js.Object {
  val SIGHUP: Int    = js.native
  val SIGINT: Int    = js.native
  val SIGQUIT: Int   = js.native
  val SIGILL: Int    = js.native
  val SIGTRAP: Int   = js.native
  val SIGABRT: Int   = js.native
  val SIGIOT: Int    = js.native
  val SIGBUS: Int    = js.native
  val SIGFPE: Int    = js.native
  val SIGKILL: Int   = js.native
  val SIGUSR1: Int   = js.native
  val SIGSEGV: Int   = js.native
  val SIGUSR2: Int   = js.native
  val SIGPIPE: Int   = js.native
  val SIGALRM: Int   = js.native
  val SIGTERM: Int   = js.native
  val SIGCHLD: Int   = js.native
  val SIGSTKFLT: Int = js.native
  val SIGCONT: Int   = js.native
  val SIGSTOP: Int   = js.native
  val SIGTSTP: Int   = js.native
  val SIGTTIN: Int   = js.native
  val SIGTTOU: Int   = js.native
  val SIGURG: Int    = js.native
  val SIGXCPU: Int   = js.native
  val SIGXFSZ: Int   = js.native
  val SIGVTALRM: Int = js.native
  val SIGPROF: Int   = js.native
  val SIGWINCH: Int  = js.native
  val SIGIO: Int     = js.native
  val SIGPOLL: Int   = js.native
  val SIGPWR: Int    = js.native
  val SIGSYS: Int    = js.native
  val SIGUNUSED: Int = js.native
}

@js.native
trait OSPriorityConstants extends js.Object {
  val PRIORITY_LOW: Int          = js.native
  val PRIORITY_BELOW_NORMAL: Int = js.native
  val PRIORITY_NORMAL: Int       = js.native
  val PRIORITY_ABOVE_NORMAL: Int = js.native
  val PRIORITY_HIGH: Int         = js.native
  val PRIORITY_HIGHEST: Int      = js.native
}

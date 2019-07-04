package io.scalajs.nodejs.os

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Provides a few basic operating-system related utility functions.
  * @see https://nodejs.org/api/os.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait OS extends js.Object with OSConstants {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns an object containing commonly used operating system specific constants for
    * error codes, process signals, and so on. The specific constants currently defined
    * are described in OS Constants.
    * @see https://nodejs.org/api/os.html#os_os_constants_1
    */
  def constants: js.Dictionary[js.Any] = js.native

  /**
    * A constant defining the appropriate End-of-line marker for the operating system.
    * <ul>
    * <li>\n on POSIX</li>
    * <li>\r\n on Windows</li>
    * </ul>
    * @example os.EOL
    */
  def EOL: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the operating system CPU architecture. Possible values are 'x64', 'arm' and 'ia32'.
    * Returns the value of process.arch.
    * @example os.arch()
    */
  def arch(): String = js.native

  /**
    * Returns an array of objects containing information about each CPU/core installed: model,
    * speed (in MHz), and times (an object containing the number of milliseconds the CPU/core
    * spent in: user, nice, sys, idle, and irq).
    * @example os.cpus()
    */
  def cpus(): js.Array[CPUInfo] = js.native

  /**
    * Returns the endianness of the CPU. Possible values are 'BE' for big endian or 'LE' for little endian.
    * @example os.endianness()
    */
  def endianness(): String = js.native

  /**
    * Returns the amount of free system memory in bytes.
    * @example os.freemem()
    */
  def freemem(): Double = js.native

  /**
    * Returns the home directory of the current user.
    * @example os.homedir()
    */
  def homedir(): String = js.native

  /**
    * Returns the hostname of the operating system.
    * @example os.hostname()
    */
  def hostname(): String = js.native

  /**
    * Returns an array containing the 1, 5, and 15 minute load averages.
    *
    * The load average is a measure of system activity, calculated by the operating system and expressed
    * as a fractional number. As a rule of thumb, the load average should ideally be less than the number
    * of logical CPUs in the system.
    *
    * The load average is a very UNIX-y concept; there is no real equivalent on Windows platforms. That is why
    * this function always returns [0, 0, 0] on Windows.
    * @example os.loadavg()
    */
  def loadavg(): js.Array[Int] = js.native

  /**
    * The os.networkInterfaces() method returns an object containing only network interfaces that have been
    * assigned a network address.
    *
    * Each key on the returned object identifies a network interface. The associated value is an array of objects
    * that each describe an assigned network address.
    * @example os.networkInterfaces()
    * @example {{{
    * {
    *   eth0: [
    *     {
    *       address: '192.168.1.108',
    *       netmask: '255.255.255.0',
    *       family: 'IPv4',
    *       mac: '01:02:03:0a:0b:0c',
    *       internal: false,
    *       cidr: '192.168.1.108/24'
    *     },
    *     {
    *       address: 'fe80::a00:27ff:fe4e:66a1',
    *       netmask: 'ffff:ffff:ffff:ffff::',
    *       family: 'IPv6',
    *       mac: '01:02:03:0a:0b:0c',
    *       scopeid: 1,
    *       internal: false,
    *       cidr: 'fe80::a00:27ff:fe4e:66a1/64'
    *     }
    *   ]
    * }
    * }}}
    */
  def networkInterfaces(): js.Dictionary[js.Array[NetworkInterface]] = js.native

  /**
    * Returns the operating system platform. Possible values are 'darwin', 'freebsd', 'linux', 'sunos' or 'win32'.
    * Returns the value of process.platform.
    * @example os.platform()
    */
  def platform(): String = js.native

  /**
    * Returns the operating system release.
    * @example os.release()
    */
  def release(): String = js.native

  /**
    * The os.setPriority() method attempts to set the scheduling priority for the process specified by pid.
    * If pid is not provided, or is 0, the priority of the current process is used.
    *
    * The priority input must be an integer between -20 (high priority) and 19 (low priority). Due to differences
    * between Unix priority levels and Windows priority classes, priority is mapped to one of six priority constants
    * in os.constants.priority. When retrieving a process priority level, this range mapping may cause the return
    * value to be slightly different on Windows. To avoid confusion, it is recommended to set priority to one of
    * the priority constants.
    *
    * On Windows setting priority to [[PRIORITY_HIGHEST]] requires elevated user, otherwise the set priority will be
    * silently reduced to [[PRIORITY_HIGH]].
    * @example os.setPriority([pid, ]priority)
    * @param pid      The process ID to set scheduling priority for. Default 0.
    * @param priority The scheduling priority to assign to the process.
    */
  def setPriority(pid: Int = js.native, priority: Priority): Unit = js.native

  /**
    * Returns the operating system's default directory for temporary files.
    * @example os.tmpdir()
    */
  def tmpdir(): String = js.native

  /**
    * Returns the total amount of system memory in bytes.
    * @example os.totalmem()
    */
  def totalmem(): Double = js.native

  /**
    * Returns the operating system name. For example 'Linux' on Linux, 'Darwin' on OS X and 'Windows_NT' on Windows.
    * @example os.type()
    */
  def `type`(): String = js.native

  /**
    * Returns the system uptime in seconds.
    * @example os.uptime()
    */
  def uptime(): Double = js.native

  /**
    * The os.userInfo() method returns information about the currently effective user -- on POSIX platforms,
    * this is typically a subset of the password file. The returned object includes the username, uid, gid,
    * shell, and homedir. On Windows, the uid and gid fields are -1, and shell is null.
    *
    * The value of homedir returned by os.userInfo() is provided by the operating system. This differs from
    * the result of os.[[homedir()]], which queries several environment variables for the home directory before
    * falling back to the operating system response.
    * @return a [[UserInfoObject user information object]]
    */
  def userInfo(options: UserInfoOptions = js.native): UserInfoObject = js.native

}

/**
  * Operating System Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("os", JSImport.Namespace)
object OS extends OS
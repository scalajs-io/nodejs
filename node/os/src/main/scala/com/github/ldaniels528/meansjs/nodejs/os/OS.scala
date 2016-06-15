package com.github.ldaniels528.meansjs.nodejs.os

import com.github.ldaniels528.meansjs.nodejs.NodeRequire

import scala.scalajs.js

/**
  * Provides a few basic operating-system related utility functions.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait OS extends js.Object {

  /**
    * A constant defining the appropriate End-of-line marker for the operating system.
    * @example os.EOL
    */
  def EOL: Boolean = js.native

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
  def cpus(): js.Array[js.Any] = js.native

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
    * Get a list of network interfaces
    * @example os.networkInterfaces()
    */
  def networkInterfaces(): js.Dictionary[NetworkInterface] = js.native

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
  def uptime(): Double

}

/**
  * OS Companion
  * @author lawrence.daniels@gmail.com
  */
object OS {

  /**
    * Convenience method for retrieving the OS module
    * @param require the implicit [[NodeRequire require function]]
    * @return the OS instance
    */
  def apply()(implicit require: NodeRequire) = require[OS]("os")

}
package io.scalajs.npm.ip

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * ip - IP address utilities for node.js
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait IP extends js.Object {

  def address(): String = js.native

  def cidr(ipWithNet: String): String = js.native

  def cidrSubnet(ipWithNet: String): js.Dictionary[String] = js.native

  def fromLong(value: Double): String = js.native

  def fromPrefixLen(length: Int): String = js.native

  def isEqual(ip0: String, ip1: String): Boolean = js.native

  def isPrivate(ip: String): Boolean = js.native

  def isV4Format(ip: String): Boolean = js.native

  def isV6Format(ip: String): Boolean = js.native

  def mask(ip: String, netMask: String): String = js.native

  def not(netMask: String): String = js.native

  def or(ip: String, netMask: String): String = js.native

  def subnet(ip: String, netMask: String): js.Dictionary[String] = js.native

  def toLong(ip: String): Double = js.native

  def toBuffer(ip: String): Buffer = js.native

  def toBuffer(ip: String, buffer: Buffer, offset: Int = js.native): Buffer = js.native

  def toString(buffer: Buffer, offset: Int = js.native, length: Int = js.native): String = js.native

}

/**
  * IP Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("ip", JSImport.Namespace)
object IP extends IP
package io.scalajs.nodejs.os

import scala.scalajs.js

/**
  * Represents a Network Interface
  * @param address  The assigned IPv4 or IPv6 address
  * @param netmask  The IPv4 or IPv6 network mask
  * @param family   Either IPv4 or IPv6
  * @param mac      The MAC address of the network interface
  * @param internal true if the network interface is a loopback or similar interface that is not remotely accessible; otherwise false
  * @param scopeid  The numeric IPv6 scope ID (only specified when family is IPv6)
  * @param cidr     The assigned IPv4 or IPv6 address with the routing prefix in CIDR notation. If the netmask is invalid, this property is set to null.
  * @author lawrence.daniels@gmail.com
  */
class NetworkInterface(var address: String,
                       var netmask: String,
                       var family: String,
                       var mac: String,
                       var internal: Boolean,
                       var scopeid: js.UndefOr[Int],
                       var cidr: String) extends js.Object

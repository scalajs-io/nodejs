package io.scalajs.npm.ip

import io.scalajs.JSON
import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * IP Test
  * @author lawrence.daniels@gmail.com
  */
class IPTest extends FunSpec {
  
  describe("IP") {

    it("provides a range of IP-based functionality") {
      IP.address() // my ip address
      IP.isEqual("::1", "::0:1") // true
      IP.toBuffer("127.0.0.1") // Buffer([127, 0, 0, 1])
      IP.toString(new Buffer(js.Array(127, 0, 0, 1))) // 127.0.0.1
      IP.fromPrefixLen(24) // 255.255.255.0
      IP.mask("192.168.1.134", "255.255.255.0") // 192.168.1.0
      IP.cidr("192.168.1.134/26") // 192.168.1.128
      IP.not("255.255.255.0") // 0.0.0.255
      IP.or("192.168.1.134", "0.0.0.255") // 192.168.1.255
      IP.isPrivate("127.0.0.1") // true
      IP.isV4Format("127.0.0.1") // true
      IP.isV6Format("::ffff:127.0.0.1") // true
    }
    
    it("can operate on buffers in-place") {
      val buf = new Buffer(128)
      val offset = 64
      IP.toBuffer("127.0.0.1", buf, offset)  // [127, 0, 0, 1] at offset 64
      IP.toString(buf, offset, 4)            // "127.0.0.1"
    }
    
    it("provide subnet information") {
      info(s"""IP.subnet("192.168.1.134", "255.255.255.192") => ${
        JSON.stringify(IP.subnet("192.168.1.134", "255.255.255.192"), null, 4)
      }""")
      // { networkAddress: "192.168.1.128", 
      //   firstAddress: "192.168.1.129", 
      //   lastAddress: "192.168.1.190", 
      //   broadcastAddress: "192.168.1.191", 
      //   subnetMask: "255.255.255.192", 
      //   subnetMaskLength: 26, 
      //   numHosts: 62, 
      //   length: 64, 
      //   contains: function(addr){...} }

      IP.cidrSubnet("192.168.1.134/26")
      // Same as previous. 

      // range checking 
      IP.cidrSubnet("192.168.1.134/26").contains("192.168.1.190") // true
    }
    
    it("supports ipv4 long conversion") {
      IP.toLong("127.0.0.1"); // 2130706433 
      IP.fromLong(2130706433); // "127.0.0.1"
    }
    
  }

}

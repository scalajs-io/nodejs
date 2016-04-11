package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.require
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Test Server
  * @author lawrence.daniels@gmail.com
  */
class NetServerTest {

  val net = require[Net]("net")
  val client = net.connect(Net.Options(port = 8124), connect)

  client.on("data", (data: js.Any) => {
    console.log(data.toString())
    client.end()
  })

  client.on("end", () => {
    console.log("disconnected from server")
  })

  private def connect: js.Function = () => {
    // "connect" listener
    console.log("connected to server!")
    client.write("world!\r\n")
  }

  /*
    const net = require('net');
    const client = net.connect({port: 8124}, () => {
      // 'connect' listener
      console.log('connected to server!');
      client.write('world!\r\n');
    });
    client.on('data', (data) => {
      console.log(data.toString());
      client.end();
    });
    client.on('end', () => {
      console.log('disconnected from server');
    });
   */

}

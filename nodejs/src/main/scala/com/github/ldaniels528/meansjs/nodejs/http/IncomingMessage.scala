package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.nodejs.stream

import scala.scalajs.js

/**
  * An IncomingMessage object is created by http.Server or http.ClientRequest and passed as the first argument
  * to the 'request' and 'response' event respectively. It may be used to access response status, headers and data.
  * It implements the Readable Stream interface, as well as the following additional events, methods, and properties.
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/http.html#http_class_http_incomingmessage]]
  */
@js.native
trait IncomingMessage extends stream.Readable {

}

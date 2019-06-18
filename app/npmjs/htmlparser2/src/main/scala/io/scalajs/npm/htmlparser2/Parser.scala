package io.scalajs.npm.htmlparser2

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * htmlparser2 Parser
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("htmlparser2", "Parser")
class Parser(handler: ParserHandler, options: ParserOptions = js.native) extends stream.Writable {

  /**
    * Parses a chunk of data and calls the corresponding callbacks.
    * @param chunk the chunk of data to parse
    * @see [[io.scalajs.nodejs.stream.Writable.write()]]
    */
  def parseChunk(chunk: String | Buffer): Unit = js.native

  /**
    * Parses the end of the buffer and clears the stack, calls onend.
    * @see [[io.scalajs.nodejs.stream.Writable.end()]]
    */
  def done(): Unit = js.native

  /**
    * Resets the parser, parses the data & calls end.
    */
  def parseComplete(): Unit = js.native

  /**
    * Resets buffer & stack, calls onreset.
    */
  def reset(): Unit = js.native

}

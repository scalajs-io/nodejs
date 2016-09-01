package org.scalajs.nodejs.htmlparser2

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * htmlparser2 Parser
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Parser extends stream.Writable {

  /**
    * Parses a chunk of data and calls the corresponding callbacks.
    * @param chunk the chunk of data to parse
    * @see [[org.scalajs.nodejs.stream.Writable.write()]]
    */
  def parseChunk(chunk: String | Buffer): Unit = js.native

  /**
    * Parses the end of the buffer and clears the stack, calls onend.
    * @see [[org.scalajs.nodejs.stream.Writable.end()]]
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

/**
  * Parser Companion
  * @author lawrence.daniels@gmail.com
  */
object Parser {

  implicit class ParserEnrichment(val parser: Parser) extends AnyVal {

    @inline
    def onEnd(listener: js.Function) = parser.on("end", listener)

  }

}
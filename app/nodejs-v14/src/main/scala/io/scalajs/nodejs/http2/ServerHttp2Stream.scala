package io.scalajs.nodejs.http2

import scala.scalajs.js

@js.native
trait ServerHttp2Stream extends Http2Stream {
  def additionalHeaders(headers: Http2Headers): Unit = js.native

  def headersSent: Boolean = js.native

  def pushAllowed: Boolean = js.native

  def pushStream(headers: Http2Headers,
                 options: Http2PushStreamOptions,
                 callback: js.Function3[io.scalajs.nodejs.Error, ServerHttp2Stream, Http2Headers, Any]
  ): Unit =
    js.native
  def pushStream(headers: Http2Headers,
                 callback: js.Function3[io.scalajs.nodejs.Error, ServerHttp2Stream, Http2Headers, Any]
  ): Unit =
    js.native

  def respond(headers: Http2Headers, options: Http2ResponseOptions): Unit = js.native
  def respond(headers: Http2Headers): Unit                                = js.native
  def respond(): Unit                                                     = js.native

  def respondWithFD(fd: Int, headers: Http2Headers, options: Http2RespondWithFDOptions): Unit = js.native
  def respondWithFD(fd: Int, headers: Http2Headers): Unit                                     = js.native
  def respondWithFD(fd: Int): Unit                                                            = js.native

  def respondWithFile(path: Path, headers: Http2Headers, options: Http2RespondWithFileOptions): Unit = js.native
  def respondWithFile(path: Path, headers: Http2Headers): Unit                                       = js.native
  def respondWithFile(path: Path): Unit                                                              = js.native
}

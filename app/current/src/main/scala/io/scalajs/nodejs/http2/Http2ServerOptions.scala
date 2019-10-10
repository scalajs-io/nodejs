package io.scalajs.nodejs.http2

import io.scalajs.nodejs.http

import scala.scalajs.js

class Http2ServerOptions(
    var maxDeflateDynamicTableSize: js.UndefOr[Int] = js.undefined,
    var maxSessionMemory: js.UndefOr[Int] = js.undefined,
    var maxHeaderListPairs: js.UndefOr[Int] = js.undefined,
    var maxOutstandingPings: js.UndefOr[Int] = js.undefined,
    var maxSendHeaderBlockLength: js.UndefOr[Int] = js.undefined,
    var paddingStrategy: js.UndefOr[Int] = js.undefined,
    var peerMaxConcurrentStreams: js.UndefOr[Int] = js.undefined,
    var selectPadding: js.UndefOr[js.Function2[Int, Int, Int]] = js.undefined,
    var settings: js.UndefOr[Http2Settings] = js.undefined,
    var Http1IncomingMessage: js.UndefOr[js.ConstructorTag[http.IncomingMessage]] = js.undefined,
    var Http1ServerResponse: js.UndefOr[js.ConstructorTag[http.ServerResponse]] = js.undefined,
    var Http2ServerRequest: js.UndefOr[js.ConstructorTag[Http2ServerRequest]] = js.undefined,
    var Http2ServerResponse: js.UndefOr[js.ConstructorTag[Http2ServerResponse]] = js.undefined,
    var allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
    var pauseOnConnect: js.UndefOr[Boolean] = js.undefined
) extends js.Object

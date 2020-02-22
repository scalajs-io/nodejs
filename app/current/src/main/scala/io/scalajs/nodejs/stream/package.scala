package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.|

package object stream {
  type Stream = IReadable | IWritable

  type ErrorCallback = js.Function1[io.scalajs.nodejs.Error, Any]
  type Wait          = js.Function0[js.Promise[Unit]]

  implicit final class StreamModuleExtensions(private val stream: Stream.type) extends AnyVal {
    def pipelineFromSeq(streams: Seq[Stream], errorCallback: ErrorCallback): Wait = {
      streams match {
        case Seq(a, b)             => stream.pipeline(a, b, errorCallback)
        case Seq(a, b, c)          => stream.pipeline(a, b, c, errorCallback)
        case Seq(a, b, c, d)       => stream.pipeline(a, b, c, d, errorCallback)
        case Seq(a, b, c, d, e)    => stream.pipeline(a, b, c, d, e, errorCallback)
        case Seq(a, b, c, d, e, f) => stream.pipeline(a, b, c, d, e, f, errorCallback)
        case _ =>
          import scala.scalajs.js.JSConverters._
          val arguments: js.Array[js.Any] = streams.toJSArray.asInstanceOf[js.Array[js.Any]]
          arguments.push(errorCallback)
          stream.asInstanceOf[js.Dynamic].finished.apply(null, arguments).asInstanceOf[Wait]
      }
    }
  }
}

package io.scalajs.npm

/**
  * winston package object
  * @author lawrence.daniels@gmail.com
  */
package object winston {

  type StreamingOptions = QueryOptions

  /**
    * Logger Streaming Enrichment
    * @param readable the given [[Readable]]
    */
  implicit class LoggerStreamingEnrichment(val readable: Readable) extends AnyVal {

    @inline
    def onLog(handler: LogMessage => Any): readable.type = readable.on("log", handler)

  }

}

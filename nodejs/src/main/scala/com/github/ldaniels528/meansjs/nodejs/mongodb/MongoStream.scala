package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js

/**
  * Mongo Stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoStream extends js.Object {

  /**
    * This is the preferred way if you have to retrieve a lot of data for streaming, as data is deserialized
    * a data event is emitted. This keeps the resident memory usage low as the documents are streamed to you.
    * Very useful if you are pushing documents out via websockets or some other streaming socket protocol.
    * Once there is no more document the driver will emit the end event to notify the application that it’s done.
    * <pre>
    * var stream = collection.find({mykey:{$ne:2}}).stream();
    * stream.on("data", function(item) {});
    * stream.on("end", function() {});
    * </pre>
    * @param eventName the given event name
    * @param callback  the given callback function
    */
  def on(eventName: String, callback: js.Function): Unit

}


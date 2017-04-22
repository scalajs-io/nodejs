package io.scalajs.nodejs.events

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport, JSName}

/**
  * Much of the Node.js core API is built around an idiomatic asynchronous event-driven architecture
  * in which certain kinds of objects (called "emitters") periodically emit named events that cause
  * Function objects ("listeners") to be called.
  *
  * The EventEmitter class is defined and exposed by the events module
  * @see https://nodejs.org/api/events.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("events", "EventEmitter")
class EventEmitter extends IEventEmitter

/**
  * EventEmitter Interface
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait IEventEmitter extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  var domain: String = js.native

  var usingDomains: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Alias for emitter.on(eventName, listener).
    * @example emitter.addListener(eventName, listener)
    * @see [[on()]]
    */
  def addListener(eventName: String, listener: js.Function): this.type = js.native

  /**
    * Synchronously calls each of the listeners registered for the event named eventName, in the order
    * they were registered, passing the supplied arguments to each.
    * <p/>Returns true if the event had listeners, false otherwise.
    * @param name the event name
    * @param args the event arguments
    * @example emitter.emit(name[, arg1][, arg2][, ...])
    */
  def emit(name: String, args: js.Any*): Any = js.native

  /**
    * Returns the current max listener value for the EventEmitter which is either set by
    * emitter.setMaxListeners(n) or defaults to EventEmitter.defaultMaxListeners.
    * @example emitter.getMaxListeners()
    * @see [[setMaxListeners()]]
    */
  def getMaxListeners(): Int = js.native

  /**
    * Returns the number of listeners listening to the event named eventName.
    * @example emitter.listenerCount(eventName)
    */
  def listenerCount(eventName: String): Int = js.native

  /**
    * Returns a copy of the array of listeners for the event named eventName.
    * @example emitter.listeners(eventName)
    */
  def listeners(eventName: String): js.Array[js.Function] = js.native

  /**
    * Adds the listener function to the end of the listeners array for the event named eventName.
    * No checks are made to see if the listener has already been added. Multiple calls passing
    * the same combination of eventName and listener will result in the listener being added,
    * and called, multiple times.
    * <p/>Returns a reference to the EventEmitter so calls can be chained.
    * @example emitter.on(eventName, listener)
    */
  def on(eventName: String, listener: js.Function): this.type = js.native

  /**
    * Adds a one time listener function for the event named eventName. This listener is
    * invoked only the next time eventName is triggered, after which it is removed.
    * @example emitter.once(eventName, listener)
    */
  def once(eventName: String, listener: js.Function): this.type = js.native

  /**
    * Removes all listeners, or those of the specified eventName.
    * <p/><b>Note</b> that it is bad practice to remove listeners added elsewhere in the code,
    * particularly when the EventEmitter instance was created by some other component or
    * module (e.g. sockets or file streams).
    * <p/>Returns a reference to the EventEmitter so calls can be chained.
    * @example emitter.removeAllListeners([eventName])
    */
  def removeAllListeners(eventName: String): this.type = js.native

  /**
    * Removes all listeners, or those of the specified eventName.
    * <p/><b>Note</b> that it is bad practice to remove listeners added elsewhere in the code,
    * particularly when the EventEmitter instance was created by some other component or
    * module (e.g. sockets or file streams).
    * <p/>Returns a reference to the EventEmitter so calls can be chained.
    * @example emitter.removeAllListeners([eventName])
    */
  def removeAllListeners(): this.type = js.native

  /**
    * Removes the specified listener from the listener array for the event named eventName.
    * removeListener will remove, at most, one instance of a listener from the listener array.
    * If any single listener has been added multiple times to the listener array for the specified
    * eventName, then removeListener must be called multiple times to remove each instance.
    * <p/><b>Note</b> that once an event has been emitted, all listeners attached to it at the time
    * of emitting will be called in order. This implies that any removeListener() or
    * removeAllListeners() calls after emitting and before the last listener finishes execution
    * will not remove them from emit() in progress. Subsequent events will behave as expected.
    * @example emitter.removeListener(eventName, listener)
    */
  def removeListener(eventName: String, listener: js.Function): this.type = js.native

  /**
    * By default EventEmitters will print a warning if more than 10 listeners are added for a
    * particular event. This is a useful default that helps finding memory leaks. Obviously,
    * not all events should be limited to just 10 listeners. The emitter.setMaxListeners()
    * method allows the limit to be modified for this specific EventEmitter instance.
    * The value can be set to Infinity (or 0) for to indicate an unlimited number of listeners.
    * <p/>Returns a reference to the EventEmitter so calls can be chained.
    * @example emitter.setMaxListeners(n)
    */
  def setMaxListeners(n: Int): this.type = js.native

}

/**
  * EventEmitter Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("EventEmitter")
object EventEmitter extends IEventEmitter {

  /**
    * By default, a maximum of 10 listeners can be registered for any single event. This limit can be changed
    * for individual EventEmitter instances using the emitter.setMaxListeners(n) method. To change the default
    * for all EventEmitter instances, the EventEmitter.defaultMaxListeners property can be used.
    * @example EventEmitter.defaultMaxListeners
    */
  var defaultMaxListeners: Int = js.native

  /**
    * A class method that returns the number of listeners for the given eventName registered on the given emitter.
    * @example EventEmitter.listenerCount(emitter, eventName)
    */
  @deprecated("Use emitter.listenerCount() instead.", since = "4.0.0")
  def listenerCount(emitter: IEventEmitter, eventName: String): Unit = js.native

}
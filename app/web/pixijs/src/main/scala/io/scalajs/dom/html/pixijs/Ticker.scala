package io.scalajs.dom.html.pixijs

import io.scalajs.dom.DOMHighResTimeStamp

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * A Ticker class that runs an update loop that other objects listen to. This class is composed around an
  * EventEmitter object to add listeners meant for execution on the next requested animation frame. Animation
  * frames are requested only when necessary, e.g. When the ticker is started and the emitter has listeners.
  */
@js.native
@JSGlobal("PIXI.Tickers.Ticker")
class Ticker extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Whether or not this ticker should invoke the method PIXI.ticker.Ticker#start automatically when a listener is added.
    */
  var autoStart: Boolean = js.native

  /**
    * Scalar time value from last frame to this frame. This value is capped by setting PIXI.ticker.Ticker#minFPS
    * and is scaled with PIXI.ticker.Ticker#speed. Note: The cap may be exceeded by scaling.
    */
  var deltaTime: Int = js.native

  /**
    * Time elapsed in milliseconds from last frame to this frame. Opposed to what the scalar PIXI.ticker.Ticker#deltaTime
    * is based, this value is neither capped nor scaled. If the platform supports DOMHighResTimeStamp, this value will
    * have a precision of 1 µs.
    */
  var elapsedMS: Double = js.native

  /**
    * The frames per second at which this ticker is running. The default is approximately 60 in most modern browsers.
    * Note: This does not factor in the value of PIXI.ticker.Ticker#speed, which is specific to scaling PIXI.ticker.Ticker#deltaTime.
    */
  def FPS: Double = js.native

  /**
    * The last time PIXI.ticker.Ticker#update was invoked. This value is also reset internally outside of invoking
    * update, but only when a new animation frame is requested. If the platform supports DOMHighResTimeStamp, this
    * value will have a precision of 1 µs.
    */
  var lastTime: Double = js.native

  /**
    * Manages the maximum amount of milliseconds allowed to elapse between invoking PIXI.ticker.Ticker#update.
    * This value is used to cap PIXI.ticker.Ticker#deltaTime, but does not effect the measured value of
    * PIXI.ticker.Ticker#FPS. When setting this property it is clamped to a value between 0 and PIXI.TARGET_FPMS * 1000.
    */
  var minFPS: Double = js.native

  /**
    * Factor of current PIXI.ticker.Ticker#deltaTime.
    */
  var speed: Int = js.native

  /**
    * Whether or not this ticker has been started. true if PIXI.ticker.Ticker#start has been called. false if
    * PIXI.ticker.Ticker#stop has been called. While false, this value may change to true in the event of
    * PIXI.ticker.Ticker#autoStart being true and a listener is added.
    */
  var started: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Calls module:eventemitter3.EventEmitter#on internally for the internal 'tick' event. It checks if the emitter
    * has listeners, and if so it requests a new animation frame at this point.
    * @param fn      The listener function to be added for updates
    * @param context The listener context
    * @return this
    */
  def add(fn: js.Function, context: js.Function = js.native): this.type = js.native

  /**
    * Calls module:eventemitter3.EventEmitter#once internally for the internal 'tick' event. It checks if the emitter
    * has listeners, and if so it requests a new animation frame at this point.
    * @param fn      The listener function to be added for one update
    * @param context The listener context
    * @return this
    */
  def addOnce(fn: js.Function, context: js.Function = js.native): this.type = js.native

  /**
    * Calls module:eventemitter3.EventEmitter#off internally for 'tick' event. It checks if the emitter has listeners
    * for 'tick' event. If it does, then it cancels the animation frame.
    * @param fn      The listener function to be added for one update
    * @param context The listener context
    * @return this
    */
  def remove(fn: js.Function, context: js.Function = js.native): this.type = js.native

  /**
    * Starts the ticker. If the ticker has listeners a new animation frame is requested at this point.
    */
  def start(): Unit = js.native

  /**
    * Stops the ticker. If the ticker has requested an animation frame it is canceled at this point.
    */
  def stop(): Unit = js.native

  /**
    * Triggers an update. An update entails setting the current PIXI.ticker.Ticker#elapsedMS, the current
    * PIXI.ticker.Ticker#deltaTime, invoking all listeners with current deltaTime, and then finally setting
    * PIXI.ticker.Ticker#lastTime with the value of currentTime that was provided. This method will be called
    * automatically by animation frame callbacks if the ticker instance has been started and listeners are added.
    * @param currentTime the current time of execution (Type: Number/DOMHighResTimeStamp, Default: performance.now())
    */
  def update(currentTime: Int | DOMHighResTimeStamp = js.native): Unit = js.native

}

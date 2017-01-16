package io.scalajs.jquery

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * jQuery Effects Functions
  * @author lawrence.daniels@gmail.com
  * @see http://www.w3schools.com/jquery/jquery_ref_events.asp
  */
@js.native
trait JQEffects extends js.Object {

  /**
    * The jQuery animate() method is used to create custom animations.
    * @param params   the given animation options / parameters
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def animate(params: AnimateOptions | js.Any, speed: String | Int = js.native, callback: js.Function): this.type = js.native

  /**
    * The jQuery fadeIn() method is used to fade in a hidden element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def fadeIn(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery fadeOut() method is used to fade out a visible element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def fadeOut(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery fadeToggle() method toggles between the fadeIn() and fadeOut() methods.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def fadeToggle(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Shows an invisible HTML element
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def hide(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Hides a visible HTML element
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def show(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery slideDown() method is used to slide down an element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def slideDown(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery slideUp() method is used to slide up an element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def slideUp(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery slideToggle() method toggles between the slideDown() and slideUp() methods.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def slideToggle(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Toggles between the hide() and show() methods.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def toggle(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

}
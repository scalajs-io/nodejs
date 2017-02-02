package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Events component is a collection of events fired by the parent Game Object.
  *
  * Phaser uses what are known as 'Signals' for all event handling. All of the events in
  * this class are signals you can subscribe to, much in the same way you'd "listen" for
  * an event.
  *
  * For example to tell when a Sprite has been added to a new group, you can bind a function
  * to the onAddedToGroup signal:
  *
  * `sprite.events.onAddedToGroup.add(yourFunction, this);`
  *
  * Where yourFunction is the function you want called when this event occurs.
  *
  * For more details about how signals work please see the Phaser.Signal class.
  *
  * The Input-related events will only be dispatched if the Sprite has had inputEnabled set to true
  * and the Animation-related events only apply to game objects with animations like Phaser.Sprite.
  * @param sprite A reference to the game object / Sprite that owns this Events object.
  * @see http://phaser.io/docs/2.6.2/Phaser.Events.html
  */
@js.native
@JSName("Phaser.Events")
class Events(val sprite: Phaser.Sprite) extends js.Object {

  /**
    * This signal is dispatched when this Game Object is added to a new Group.
    * It is sent two arguments:
    * {any} The Game Object that was added to the Group.
    * {Phaser.Group} The Group it was added to.
    */
  var onAddedToGroup: Phaser.Signal = js.native

  /**
    * This signal is dispatched if the Game Object has the AnimationManager component,
    * and an Animation has been stopped (via animation.stop() and the dispatchComplete argument has been set.
    * You can also listen to Animation.onComplete rather than via the Game Objects events.
    * It is sent two arguments:
    * {any} The Game Object that received the event.
    * {Phaser.Animation} The Phaser.Animation that was stopped.
    */
  var onAnimationComplete: Phaser.Signal = js.native

  /**
    * This signal is dispatched if the Game Object has the AnimationManager component,
    * and an Animation has looped playback.
    * You can also listen to Animation.onLoop rather than via the Game Objects events.
    * It is sent two arguments:
    * {any} The Game Object that received the event.
    * {Phaser.Animation} The Phaser.Animation that looped.
    */
  var onAnimationLoop: Phaser.Signal = js.native

  /**
    * This signal is dispatched if the Game Object has the AnimationManager component,
    * and an Animation has been played.
    * You can also listen to Animation.onStart rather than via the Game Objects events.
    * It is sent two arguments:
    * {any} The Game Object that received the event.
    * {Phaser.Animation} The Phaser.Animation that was started.
    */
  var onAnimationStart: Phaser.Signal = js.native

  /**
    * This signal is dispatched when the Game Object is destroyed.
    * This happens when Sprite.destroy() is called, or Group.destroy() with destroyChildren set to true.
    * It is sent one argument:
    * {any} The Game Object that was destroyed.
    */
  var onDestroy: Phaser.Signal = js.native

  /**
    * This signal is dispatched if the Game Object has been inputEnabled and enableDrag has been set.
    * It is sent when a Phaser.Pointer starts to drag the Game Object, taking into consideration the various
    * drag limitations that may be set.
    * It is sent four arguments:
    * {any} The Game Object that received the event.
    * {Phaser.Pointer} The Phaser.Pointer object that caused the event.
    * {number} The x coordinate that the drag started from.
    * {number} The y coordinate that the drag started from.
    */
  var onDragStart: Phaser.Signal = js.native


}

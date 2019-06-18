package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * A Video object that takes a previously loaded Video from the Phaser Cache and handles playback of it.
  *
  * Alternatively it takes a getUserMedia feed from an active webcam and streams the contents of that to
  * the Video instead (see startMediaStream method)
  *
  * The video can then be applied to a Sprite as a texture. If multiple Sprites share the same Video texture and playback
  * changes (i.e. you pause the video, or seek to a new time) then this change will be seen across all Sprites simultaneously.
  *
  * Due to a bug in IE11 you cannot play a video texture to a Sprite in WebGL. For IE11 force Canvas mode.
  *
  * If you need each Sprite to be able to play a video fully independently then you will need one Video object per Sprite.
  * Please understand the obvious performance implications of doing this, and the memory required to hold videos in RAM.
  *
  * On some mobile browsers such as iOS Safari, you cannot play a video until the user has explicitly touched the screen.
  * This works in the same way as audio unlocking. Phaser will handle the touch unlocking for you, however unlike with audio
  * it's worth noting that every single Video needs to be touch unlocked, not just the first one. You can use the changeSource
  * method to try and work around this limitation, but see the method help for details.
  *
  * Small screen devices, especially iPod and iPhone will launch the video in its own native video player,
  * outside of the Safari browser. There is no way to avoid this, it's a device imposed limitation.
  *
  * Note: On iOS if you need to detect when the user presses the 'Done' button (before the video ends)
  * then you need to add your own event listener
  * @param game A reference to the currently running game.
  * @param key  The key of the video file in the [[Phaser.Cache]] that this Video object will play.
  *             Set to null or leave undefined if you wish to use a webcam as the source.
  *             See startMediaStream to start webcam capture.
  * @param url  If the video hasn't been loaded then you can provide a full URL to the
  *             file here (make sure to set key to null)
  * @see http://phaser.io/docs/2.6.2/Phaser.Video.html
  */
@js.native
@JSGlobal
class Video(var game: Phaser.Game, var key: String, var url: String) extends js.Object {

}

package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.audio.AudioContext

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The Sound Manager is responsible for playing back audio via either the Legacy HTML Audio tag or via Web Audio if
  * the browser supports it. Note: On Firefox 25+ on Linux if you have media.gstreamer disabled in about:config then
  * it cannot play back mp3 or m4a files. The audio file type and the encoding of those files are extremely important.
  * Not all browsers can play all audio formats. There is a good guide to what's supported here: http://hpr.dogphilosophy.net/test/
  *
  * If you are reloading a Phaser Game on a page that never properly refreshes (such as in an AngularJS project) then
  * you will quickly run out of AudioContext nodes. If this is the case create a global var called PhaserGlobal on the
  * window object before creating the game. The active AudioContext will then be saved to window.PhaserGlobal.audioContext
  * when the Phaser game is destroyed, and re-used when it starts again.
  *
  * Mobile warning: There are some mobile devices (certain iPad 2 and iPad Mini revisions) that cannot play 48000 Hz audio.
  * When they try to play the audio becomes extremely distorted and buzzes, eventually crashing the sound system. The
  * solution is to use a lower encoding rate such as 44100 Hz. Sometimes the audio context will be created with a
  * sampleRate of 48000. If this happens and audio distorts you should re-create the context.
  * @param game the reference to the current game instance.
  * @author lawrence.daniels@gmail.com
  */
@js.native
class SoundManager(val game: Game) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The number of audio channels to use in playback (default: 32).
    */
  var channels: Int = js.native

  /**
    * Used in conjunction with Sound.externalNode this allows you to stop a Sound node being connected to the SoundManager
    * master gain node (default: true).
    */
  var connectToMaster: Boolean = js.native

  /**
    * The AudioContext being used for playback.
    */
  var context: AudioContext = js.native

  /**
    * Gets or sets the muted state of the SoundManager. This effects all sounds in the game.
    */
  var mute: Boolean = js.native

  /**
    * True if audio been disabled via the PhaserGlobal (useful if you need to use a 3rd party audio library) or the
    * device doesn't support any audio.
    */
  var muteOnPause: Boolean = js.native

  /**
    * True if audio been disabled via the PhaserGlobal (useful if you need to use a 3rd party audio library) or the
    * device doesn't support any audio.
    */
  var noAudio: Boolean = js.native

  /**
    * This signal is dispatched when the SoundManager is globally un-muted, either directly via game code or as a result
    * of the game resuming from a pause.
    */
  var onMute: Signal = js.native

  /**
    * The event dispatched when a sound decodes (typically only for mp3 files)
    */
  var onSoundDecode: Signal = js.native

  /**
    * This signal is dispatched when the SoundManager is globally un-muted, either directly via game code or as a result
    * of the game resuming from a pause.
    */
  var onUnMute: Signal = js.native

  /**
    * This signal is dispatched whenever the global volume changes. The new volume is passed as the only parameter to your callback.
    */
  var onVolumeChange: Signal = js.native

  /**
    * true if the audio system is currently locked awaiting a touch event.
    */
  var touchLocked: Boolean = js.native

  /**
    * True the SoundManager and device are both using the Audio tag instead of Web Audio.
    */
  def usingAudioTag: Boolean = js.native

  /**
    * True the SoundManager and device are both using Web Audio.
    */
  def usingWebAudio: Boolean = js.native

  /**
    * Gets or sets the global volume of the SoundManager, a value between 0 and 1. The value given is clamped to the range 0 to 1.
    */
  var volume: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a new Sound into the SoundManager.
    * @param key     Asset key for the sound.
    * @param volume  Default value for the volume.
    * @param loop    Whether or not the sound will loop.
    * @param connect Controls if the created Sound object will connect to the master gainNode of the SoundManager when
    *                running under WebAudio.
    * @return The new sound instance.
    */
  def add(key: String, volume: Int = js.native, loop: Boolean = js.native, connect: Boolean = js.native): Sound = js.native

  /**
    * Adds a new AudioSprite into the SoundManager.
    * @param key Asset key for the sound.
    * @return The new AudioSprite instance.
    */
  def addSprite(key: String): AudioSprite = js.native

  /**
    * This member is internal (protected) and may be modified or removed in the future.
    * Internal: This member is internal (protected) and may be modified or removed in the future.
    */
  protected def boot(): Unit = js.native

  /**
    * Decode a sound by its asset key.
    * @param key   Assets key of the sound to be decoded.
    * @param sound Optional: Its buffer will be set to decoded data.
    */
  def decode(key: String, sound: Sound = js.native): Unit = js.native

  /**
    * Stops all the sounds in the game, then destroys them and finally clears up any callbacks.
    */
  def destroy(): Unit = js.native

  /**
    * Pauses all the sounds in the game.
    */
  def pauseAll(): Unit = js.native

  /**
    * Adds a new Sound into the SoundManager and starts it playing.
    * @param key    Asset key for the sound.
    * @param volume Optional: Default value for the volume (default: 1).
    * @param loop   Optional: Whether or not the sound will loop (default: false).
    * @return The new sound instance.
    */
  def play(key: String, volume: Int = js.native, loop: Boolean = js.native): Sound = js.native

  /**
    * Removes a Sound from the SoundManager. The removed Sound is destroyed before removal.
    * @param sound The sound object to remove.
    * @return True if the sound was removed successfully, otherwise false.
    */
  def remove(sound: Sound): Boolean = js.native

  /**
    * Removes all Sounds from the SoundManager that have an asset key matching the given value. The removed Sounds
    * are destroyed before removal.
    * @param key The key to match when removing sound objects.
    * @return The number of matching sound objects that were removed.
    */
  def removeByKey(key: String): Int = js.native

  /**
    * Resumes every sound in the game.
    */
  def resumeAll(): Unit = js.native

  /**
    * This method allows you to give the SoundManager a list of Sound files, or keys, and a callback. Once all of the
    * Sound files have finished decoding the callback will be invoked. The amount of time spent decoding depends on the
    * codec used and file size. If all of the files given have already decoded the callback is triggered immediately.
    * @param files           An array containing either Phaser.Sound objects or their key strings as found in the Phaser.Cache.
    * @param callback        The callback which will be invoked once all files have finished decoding.
    * @param callbackContext The context in which the callback will run.
    */
  def setDecodedCallback(files: String | js.Array[String], callback: js.Function, callbackContext: js.Any): Unit = js.native

  /**
    * Sets the Input Manager touch callback to be SoundManager.unlock. Required for iOS audio device unlocking.
    * Mostly just used internally.
    */
  def setTouchLock(): Unit = js.native

  /**
    * Stops all the sounds in the game.
    */
  def stopAll(): Unit = js.native

  /**
    * Enables the audio, usually after the first touch.
    */
  def unlock(): Boolean = js.native

  /**
    * Updates every sound in the game, checks for audio unlock on mobile and monitors the decoding watch list.
    * Internal: This member is internal (protected) and may be modified or removed in the future.
    */
  protected def update(): Unit = js.native

}

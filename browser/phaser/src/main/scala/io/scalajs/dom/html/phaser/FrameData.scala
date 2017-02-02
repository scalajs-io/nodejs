package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * FrameData is a container for [[Frame]] objects, which are the internal representation of animation data in Phaser.
  * @see https://phaser.io/docs/2.6.2/Phaser.FrameData.html
  */
@js.native
@JSName("Phaser.FrameData")
class FrameData() extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The total number of frames in this FrameData set.
    */
  def total: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a new Frame to this FrameData collection. Typically called by the Animation.Parser and not directly.
    * @param frame The frame to add to this FrameData set.
    * @return The frame that was just added.
    */
  def addFrame(frame: Phaser.Frame): Phaser.Frame = js.native

  /**
    * Check if there is a Frame with the given name.
    * @param name The name of the frame you want to check.
    * @return True if the frame is found, otherwise false.
    */
  def checkFrameName(name: String): Boolean = js.native

  /**
    * Makes a copy of this FrameData including copies (not references) to all of the Frames it contains.
    * @return A clone of this object, including clones of the Frame objects it contains.
    */
  override def clone(): this.type = js.native

  /**
    * Destroys this FrameData collection by nulling the _frames and _frameNames arrays.
    */
  def destroy(): Unit = js.native

  /**
    * Get a Frame by its numerical index.
    * @param index The index of the frame you want to get.
    * @return The frame, if found.
    */
  def getFrame(index: Int): Phaser.Frame = js.native

  /**
    * Get a Frame by its frame name.
    * @param name The name of the frame you want to get.
    * @return The frame, if found.
    */
  def getFrameByName(name: String): Phaser.Frame = js.native

  /**
    * Returns all of the Frame indexes in this FrameData set.
    * The frames indexes are returned in the output array, or if none is provided in a new Array object.
    * @param frames          An Array containing the indexes of the frames to retrieve. If undefined or the array is empty then all frames in the FrameData are returned.
    * @param useNumericIndex Are the given frames using numeric indexes (default) or strings? (false)
    * @param output          If given the results will be appended to the end of this array otherwise a new array will be created.
    * @return An array of all Frame indexes matching the given names or IDs.
    */
  def getFrameIndexes(frames: js.Array[Int] = js.native, useNumericIndex: Boolean = js.native, output: js.Array[Int] = js.native): js.Array[Int] = js.native

  /**
    * Returns a range of frames based on the given start and end frame indexes and returns them in an Array.
    * @param start  The starting frame index.
    * @param end    The ending frame index.
    * @param output If given the results will be appended to the end of this array otherwise a new array will be created.
    * @return An array of Frames between the start and end index values, or an empty array if none were found.
    */
  def getFrameRange(start: Int, end: Int, output: js.Array[Phaser.Frame] = js.native): js.Array[Phaser.Frame] = js.native

  /**
    * Returns all of the Frames in this FrameData set where the frame index is found in the input array.
    * The frames are returned in the output array, or if none is provided in a new Array object.
    * @param frames          An Array containing the indexes of the frames to retrieve. If the array is empty
    *                        or undefined then all frames in the FrameData are returned.
    * @param useNumericIndex Are the given frames using numeric indexes (default) or strings? (false)
    * @param output          If given the results will be appended to the end of this array otherwise a new array will be created.
    * @return An array of all [[Frame]]s in this FrameData set matching the given names or IDs.
    */
  def getFrames(frames: js.Array[Int] = js.native, useNumericIndex: Boolean = js.native, output: js.Array[Frame] = js.native): js.Array[Frame] = js.native

}

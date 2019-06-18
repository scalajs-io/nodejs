package io.scalajs.npm.amcharts.events

import io.scalajs.dom.event.MouseEvent
import io.scalajs.npm.amcharts.Slice

import scala.scalajs.js

/**
  * Click Slice Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ClickSliceEvent extends AmSliceEvent {

  def event: MouseEvent = js.native

  def dataItem: Slice = js.native

  def `type`: String = js.native

}
package io.scalajs.npm.amcharts

import io.scalajs.npm.amcharts.events.ClickSliceEvent

/**
  * Slice Event Shortcuts
  * @author lawrence.daniels@gmail.com
  */
trait SliceEventShortcuts {

  @inline
  def onClickSlice(f: ClickSliceEvent => Any) = new EventListener("clickSlice", (e: ClickSliceEvent) => f(e))

}

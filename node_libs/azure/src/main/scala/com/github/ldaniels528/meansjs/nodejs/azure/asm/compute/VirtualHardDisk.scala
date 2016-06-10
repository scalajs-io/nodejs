package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Virtual Hard Disk
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class VirtualHardDisk(var sourceImageName: js.UndefOr[String],
                      var mediaLink: js.UndefOr[String]) extends js.Object

/**
  * Virtual Hard Disk Companion
  * @author lawrence.daniels@gmail.com
  */
object VirtualHardDisk {

  def apply(sourceImageName: js.UndefOr[String] = js.undefined, mediaLink: js.UndefOr[String] = js.undefined) = {
    new VirtualHardDisk(sourceImageName, mediaLink)
  }

}
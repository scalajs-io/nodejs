package io.scalajs.nodejs

import scala.scalajs.js

/**
  * os package object
  * @author lawrence.daniels@gmail.com
  */
package object os {

  /**
    * CPU Info Enrichment
    * @param cpuInfo the given [[CPUInfo CPU Info]]
    */
  final implicit class CPUInfoEnrichment(val cpuInfo: CPUInfo) extends AnyVal {

    @inline
    def timesObject: js.Array[CPUTime] = cpuInfo.times.asInstanceOf[js.Array[CPUTime]]

  }

}

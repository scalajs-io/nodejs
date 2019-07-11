package io.scalajs.npm.moment

/**
  * moment range package object
  * @author lawrence.daniels@gmail.com
  */
package object range {

  /**
    * Moment Range Enrichment
    * @param range0 the given [[Range range]]
    */
  final implicit class MomentRangeEnrichment(val range0: Range) extends AnyVal {

    @inline def +(range1: Range): range0.type = range0.add(range1)

    @inline def -(range1: Range): range0.type = range0.subtract(range1)

  }

}

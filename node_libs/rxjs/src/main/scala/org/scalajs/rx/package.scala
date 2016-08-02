package org.scalajs

import com.cognitect.transducers.ITransformer

/**
  * rx package object
  * @author lawrence.daniels@gmail.com
  */
package object rx {

  /**
    * Represents a Transducer
    */
  type Transducer = ITransformer

  /**
    * Represents an absolute time
    */
  type AbsoluteTime = Int

  /**
    * Represents a period in time
    */
  type Period = Int

  /**
    * Represents a relative time
    */
  type RelativeTime = Int

  /**
    * Represents a time span; the value is always >= 0
    */
  type TimeSpan = Int

}

package io.scalajs.npm.brake

import io.scalajs.RawOptions
import io.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * brake - throttle a stream with backpressure
  * @see https://www.npmjs.com/package/brake
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Brake extends js.Object {

  /**
    * Return a transform stream b that applies backpressure when more data than the rate allows is written.
    * @param rate    the throttle rate
    * @param options the throttle options
    * @return a [[Readable]] / [[Writable]] instance
    */
  def apply(rate: Double, options: ThrottleOptions | RawOptions = js.native): Readable with Writable = js.native

}

/**
  * Brake Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("brake", JSImport.Namespace)
object Brake extends Brake

/**
  * Throttle Options
  * @param rate   How many bytes to emit for each interval of length period
  * @param period How often to check the output length in milliseconds. Default value: 1000.
  */

class ThrottleOptions(var rate: js.UndefOr[Double] = js.undefined,
                      var period: js.UndefOr[Int] = js.undefined) extends js.Object
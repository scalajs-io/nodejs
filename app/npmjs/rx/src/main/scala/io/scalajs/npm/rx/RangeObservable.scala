package io.scalajs.npm.rx

import scala.scalajs.js

/**
  * Range Observable
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RangeObservable[T] extends Observable[T] {

  /**
    * The value of the first integer in the sequence.
    * @return the first integer in the sequence.
    */
  def start: T = js.native

  /**
    * The number of sequential integers to generate.
    * @return the number of sequential integers to generate.
    */
  def count: T = js.native

  /**
    * Scheduler to run the generator loop on.
    * @return the scheduler
    */
  def scheduler: Scheduler = js.native

}

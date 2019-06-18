package io.scalajs.npm.minimist

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * minimist - parse argument options
  * @see https://www.npmjs.com/package/minimist
  * @author lawrence.danils@gmail.com
  */
@js.native
trait Minimist extends js.Object {

  /**
    * Return an argument object argv populated with the array arguments from args.
    * @param args    the array arguments
    * @param options the optional settings
    * @return an argument object argv populated with the array arguments from args.
    */
  def apply(args: js.Array[String], options: MinimistOptions | RawOptions = js.native): js.Dictionary[js.Any] = js.native

}

/**
  * Minimist Singleton
  * @author lawrence.danils@gmail.com
  */
@js.native
@JSImport("minimist", JSImport.Namespace)
object Minimist extends Minimist

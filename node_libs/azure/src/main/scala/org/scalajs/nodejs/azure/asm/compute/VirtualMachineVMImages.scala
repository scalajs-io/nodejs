package org.scalajs.nodejs.azure.asm.compute

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Virtual Machine VM Images
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait VirtualMachineVMImages extends js.Object {

  def list: js.Function1[js.Function, Unit] = js.native

}

/**
  * Virtual Machine VM Images
  * @author lawrence.daniels@gmail.com
  */
object VirtualMachineVMImages {

  /**
    * Virtual Machine VM Images Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class VirtualMachineVMImagesExtensions(val vm: VirtualMachineVMImages) extends AnyVal {

    @inline
    def listFuture = futureCallbackE1[errors.Error, js.Array[VMImage]](vm.list(_))

  }

}
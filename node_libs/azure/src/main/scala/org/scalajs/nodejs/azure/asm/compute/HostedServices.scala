package org.scalajs.nodejs.azure.asm.compute

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Hosted Services
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HostedServices extends js.Object {

  def create(options: HostedServicesOptions, callback: js.Function): Unit = js.native

}

object HostedServices {

  /**
    * Hosted Services Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class HostedServicesExtensions(val hostedServices: HostedServices) extends AnyVal {

    @inline
    def createFuture(options: HostedServicesOptions) = {
      futureCallbackE1[errors.Error, ComputeManagementClient](hostedServices.create(options, _))
    }

  }

}
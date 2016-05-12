package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Virtual Machines
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait VirtualMachines extends js.Object {

  def createDeployment(serviceName: String, options: DeploymentOptions, callback: js.Function): Unit = js.native

}

/**
  * Virtual Machines
  * @author lawrence.daniels@gmail.com
  */
object VirtualMachines {

  /**
    * Virtual Machines Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class VirtualMachinesExtensions(val virtualMachines: VirtualMachines) extends AnyVal {

    @inline
    def createDeploymentFuture(serviceName: String, options: DeploymentOptions) = {
      futureCallbackE1[js.Error, Deployment](virtualMachines.createDeployment(serviceName, options, _))
    }

  }

}
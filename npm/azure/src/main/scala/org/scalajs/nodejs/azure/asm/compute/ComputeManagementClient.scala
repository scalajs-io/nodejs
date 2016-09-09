package org.scalajs.nodejs.azure.asm.compute

import scala.scalajs.js

/**
  * Azure Compute Management Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ComputeManagementClient extends js.Object {

  def hostedServices: HostedServices = js.native

  def virtualMachines: VirtualMachines = js.native

  def virtualMachineVMImages: VirtualMachineVMImages = js.native

}

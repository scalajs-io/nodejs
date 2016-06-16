package examples.nodejs.azure

import org.scalajs.nodejs.azure.asm.compute._
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.azure.asm.CertificateCloudCredentialsOptions
import org.scalajs.nodejs.azure.asm.compute._
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Compute Management Client Example
  * @author lawrence.daniels@gmail.com
  */
class ComputeManagementClientExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val fs = Fs()
  val computeManagement = AzureAsmCompute()

  // create the compute management client
  val computeManagementClient = computeManagement.createComputeManagementClient(
    computeManagement.createCertificateCloudCredentials(CertificateCloudCredentialsOptions(
      subscriptionId = "<your subscription id>",
      pem = fs.readFileSync("<your pem file>", "utf-8")
    )))

  val serviceName = "cloudservice01"
  val deploymentName = "deployment01"
  val virualMachineName = "vm01"
  val storageAccountName = "storage01"
  val diskContainerName = "vhds"

  val deploymentOptions = DeploymentOptions(
    name = deploymentName,
    deploymentSlot = "Production",
    label = "deployment 01",
    roles = js.Array(
      Role(
        roleName = virualMachineName,
        roleType = Role.PersistentVMRole,
        label = "virtual machine 01",
        oSVirtualHardDisk = VirtualHardDisk(
          sourceImageName = "a699494373c04fc0bc8f2bb1389d6106__Windows-Server-2012-R2-201312.01-en.us-127GB.vhd",
          mediaLink = s"http://$storageAccountName.blob.core.windows.net/$diskContainerName/$serviceName-$virualMachineName-${Math.floor((Math.random() * 100) + 1)}.vhd"
        ),
        dataVirtualHardDisks = js.Array(),
        configurationSets = js.Array(
          ConfigurationSet(
            configurationSetType = ConfigurationSet.WindowsProvisioningConfiguration,
            adminUserName = "<your admin user name>",
            adminPassword = "<your admin password>",
            computerName = virualMachineName,
            enableAutomaticUpdates = true,
            resetPasswordOnFirstLogon = false,
            storedCertificateSettings = js.Array[js.Any](),
            inputEndpoints = js.Array[Endpoint](),
            windowsRemoteManagement = WindowsRemoteManagement(listeners = js.Array(ListenerType(listenerType = "Https")))
          ),
          ConfigurationSet(
            configurationSetType = ConfigurationSet.NetworkConfiguration,
            subnetNames = js.Array[String](),
            storedCertificateSettings = js.Array[js.Any](),
            inputEndpoints = js.Array(
              Endpoint(localPort = 3389, protocol = "tcp", name = "RemoteDesktop"),
              Endpoint(localPort = 5986, protocol = "tcp", name = "WinRmHTTPS"))
          ))
      ))
  )

  for {
  // List all the virtual machine images you can use.
    vmImages <- computeManagementClient.virtualMachineVMImages.listFuture

    // Create a cloud service.
    computeManagementClient <- computeManagementClient.hostedServices.createFuture(
      HostedServicesOptions(serviceName = serviceName, label = "cloud service 01", location = "West US"))

    // Create a virtual machine in the cloud service
    deployment <- computeManagementClient.virtualMachines.createDeploymentFuture(serviceName, deploymentOptions)
  } {
    console.info(deployment)
  }

}

package examples.nodejs.azure

import org.scalajs.nodejs.{Bootstrap, console}
import org.scalajs.nodejs.adal.{AdalNode, AuthenticationResponse}
import org.scalajs.nodejs.azure.arm.keyvault.AzureArmKeyVault
import org.scalajs.nodejs.azure.common.{AzureCommon, KeyVaultParameters, TokenCloudCredentialOptions}
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.globals.process
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Key Vault Example
  * @author lawrence.daniels@gmail.com
  */
class KeyVaultExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val azureCommon = AzureCommon()
  val azureMgmtKeyVault = AzureArmKeyVault()
  val adalNode = AdalNode() // Used for authentication

  val userName = "someone@myorg.com"
  val password = "123"
  val clientId = "<client GUID>"
  val resourceUri = "https://management.core.windows.net/"

  val resourceId = process.argv.drop(3).headOption getOrElse ""

  val context = adalNode.AuthenticationContext("https://login.windows.net/myorg.com")
  context.acquireTokenWithUsernamePassword(resourceId, userName, password, clientId, (err: Error, response: AuthenticationResponse) => {
    if (isDefined(err)) {
      throw new RuntimeException("Unable to authenticate: " + err.stack)
    }

    val credentials = azureCommon.TokenCloudCredentials(TokenCloudCredentialOptions(
      subscriptionId = "<subscription GUID>",
      authorizationScheme = response.tokenType,
      token = response.accessToken
    ))

    // Creates an Azure Key Vault Management client.
    // The Azure Resource Manager URI must also be passed to this constructor for the
    // China, Germany, and US Government Azure environments
    val client = azureMgmtKeyVault.KeyVaultManagementClient(credentials)

    val resourceGroup = "myResourceGroup"
    val vaultName = "myNewVault"
    val parameters = new KeyVaultParameters(
      location = "East US",
      properties = new KeyVaultParameters.Properties(
        sku = new KeyVaultParameters.SKU(family = "A", name = "standard"),
        accessPolicies = js.Array[js.Any](),
        enabledForDeployment = false,
        tenantId = "<tenant GUID>"
      ),
      tags = js.Dictionary[String]()
    )

    console.info("Creating vault...")
    client.vaults.createOrUpdate(resourceGroup, vaultName, parameters, (err: Error, result: js.Any) => {
      if (isDefined(err)) throw new IllegalStateException(err.message)
      console.info("Vault created: %j", result)
    })

  })

}

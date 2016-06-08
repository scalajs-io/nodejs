package examples.nodejs.azure

import com.github.ldaniels528.meansjs.nodejs.adal.{AdalNode, AuthenticationResponse}
import com.github.ldaniels528.meansjs.nodejs.azure.arm.keyvault.AzureArmKeyVault
import com.github.ldaniels528.meansjs.nodejs.azure.common.{AzureCommon, KeyVaultParameters, TokenCloudCredentialOptions}
import com.github.ldaniels528.meansjs.nodejs.global.process
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console, errors}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Key Vault Example
  * @author lawrence.daniels@gmail.com
  */
class KeyVaultExample(bootstrap: Bootstrap) {

  import bootstrap._

  val AzureCommon = require[AzureCommon]("azure-common")
  val AzureMgmtKeyVault = require[AzureArmKeyVault]("azure-arm-keyvault")
  val AdalNode = require[AdalNode]("adal-node") // Used for authentication

  val userName = "someone@myorg.com"
  val password = "123"
  val clientId = "<client GUID>"
  val resourceUri = "https://management.core.windows.net/"

  val resourceId = process.argv.drop(3).headOption getOrElse ""

  val context = AdalNode.AuthenticationContext("https://login.windows.net/myorg.com")
  context.acquireTokenWithUsernamePassword(resourceId, userName, password, clientId, (err: errors.Error, response: AuthenticationResponse) => {
    if (isDefined(err)) {
      throw new RuntimeException("Unable to authenticate: " + err.stack)
    }

    val credentials = AzureCommon.TokenCloudCredentials(TokenCloudCredentialOptions(
      subscriptionId = "<subscription GUID>",
      authorizationScheme = response.tokenType,
      token = response.accessToken
    ))

    // Creates an Azure Key Vault Management client.
    // The Azure Resource Manager URI must also be passed to this constructor for the
    // China, Germany, and US Government Azure environments
    val client = AzureMgmtKeyVault.KeyVaultManagementClient(credentials)

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
    client.vaults.createOrUpdate(resourceGroup, vaultName, parameters, (err: errors.Error, result: js.Any) => {
      if (isDefined(err)) throw new IllegalStateException(err.message)
      console.info("Vault created: %j", result)
    })

  })

}

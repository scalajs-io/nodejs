package examples.nodejs.azure

import com.github.ldaniels528.meansjs.nodejs.azure.asm.CertificateCloudCredentialsOptions
import com.github.ldaniels528.meansjs.nodejs.azure.asm.sql._
import com.github.ldaniels528.meansjs.nodejs.azure.common.AzureCommon
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console, process}

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * SQL Management Client Example
  * @author lawrence.daniels@gmail.com
  */
class SqlManagementClientExample(bootstrap: Bootstrap) {
  import bootstrap._

  val fs = require[Fs]("fs")
  val common = require[AzureCommon]("azure-common")
  val sqlManagement = require[AzureAsmSQL]("azure-asm-sql")

  val (subscription, pemFile, administratorUserName, administratorPassword) = process.argv.drop(3).toList match {
    case aSubscription :: aPemFile :: userName :: password :: Nil => (aSubscription, aPemFile, userName, password)
    case _ =>
      throw new IllegalArgumentException(s"${getClass.getName} <subscription> <pemFile> <administratorUserName> <administratorPassword>")
  }

  val sqlManagementClient = sqlManagement.createSqlManagementClient(sqlManagement.createCertificateCloudCredentials(
    CertificateCloudCredentialsOptions(
      subscriptionId = subscription,
      pem = fs.readFileSync(pemFile)
    )))

  val sqlDatabaseName = "database01"

  for {
    // Create a SQL database server.
    server <- sqlManagementClient.servers.createFuture(ServerOptions(
      administratorUserName = administratorUserName,
      administratorPassword = administratorPassword,
      location = "West US"
    ))

    // Create a SQL database.
    database <- sqlManagementClient.databases.createFuture(server.serverName, DatabaseOptions(
      name = sqlDatabaseName,
      edition = common.Constants.SqlAzureConstants.WEB_EDITION,
      collationName = common.Constants.SqlAzureConstants.DEFAULT_COLLATION_NAME,
      maximumDatabaseSizeInGB = common.Constants.SqlAzureConstants.WEB_1GB
    ))

  } {
    console.log("server => %j", server)
    console.log("database => %j", database)
  }

}

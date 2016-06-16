package examples.nodejs.azure

import org.scalajs.nodejs.azure.asm.sql._
import org.scalajs.nodejs.global.process
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.azure.asm.CertificateCloudCredentialsOptions
import org.scalajs.nodejs.azure.asm.sql.{AzureAsmSQL, DatabaseOptions, ServerOptions}
import org.scalajs.nodejs.azure.common.AzureCommon
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * SQL Management Client Example
  * @author lawrence.daniels@gmail.com
  */
class SqlManagementClientExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val fs = Fs()
  val common = AzureCommon()
  val sqlManagement = AzureAsmSQL()

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

package examples.nodejs.net

import org.scalajs.nodejs.{console, errors}
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.adal.AdalNode
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Server to Server via Client Credentials
  * @author lawrence.daniels@gmail.com
  */
class ServerToServerViaClientCredentials(bootstrap: Bootstrap) {

  implicit val require = bootstrap.require

  val adal = require[AdalNode]("adal-node")
  val AuthenticationContext = adal.AuthenticationContext

  val authorityHostUrl = "https://login.windows.net"
  val tenant = "myTenant"
  val authorityUrl = authorityHostUrl + "/" + tenant
  val clientId = "yourClientIdHere"
  val clientSecret = "yourAADIssuedClientSecretHere"
  val resource = "00000002-0000-0000-c000-000000000000"

  val context = AuthenticationContext(authorityUrl)

  context.acquireTokenWithClientCredentials(resource, clientId, clientSecret, (err: Error, tokenResponse: js.Any) => {
    if (isDefined(err)) {
      console.log("well that didn't work: " + err.stack)
    } else {
      console.log(tokenResponse)
    }
  })

}

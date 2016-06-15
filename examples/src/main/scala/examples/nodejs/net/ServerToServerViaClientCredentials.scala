package examples.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.adal.AdalNode
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console, errors}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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

  context.acquireTokenWithClientCredentials(resource, clientId, clientSecret, (err: errors.Error, tokenResponse: js.Any) => {
    if (isDefined(err)) {
      console.log("well that didn't work: " + err.stack)
    } else {
      console.log(tokenResponse)
    }
  })

}

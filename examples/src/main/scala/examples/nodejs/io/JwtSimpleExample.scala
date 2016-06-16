package examples.nodejs.io

import org.scalajs.nodejs.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.jwtsimple.JwtSimple

import scala.scalajs.js

/**
  * jwt-simple Example
  * @author lawrence.daniels@gmail.com
  */
class JwtSimpleExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val jwt = JwtSimple()
  val payload = js.Dictionary("foo" -> "bar")
  val secret = "scalajs"

  // encode 
  val token = jwt.encode(payload, secret)
  console.log("token = %s", token)

  // decode 
  val decoded = jwt.decode(token, secret)
  console.log("payload = %j", decoded) //=> { foo: "bar" }

}

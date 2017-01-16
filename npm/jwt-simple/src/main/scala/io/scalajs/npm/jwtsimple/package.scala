package io.scalajs.npm

import scala.scalajs.js

/**
  * jwtsimple package object
  * @author lawrence.daniels@gmail.com
  */
package object jwtsimple {

  type JwtToken = String

  /**
    * By default the algorithm to encode is HS256.
    * The supported algorithms for encoding and decoding are HS256, HS384, HS512 and RS256.
    */
  type Algorithm = String

  val HS256: Algorithm = "HS256"
  val HS384: Algorithm = "HS384"
  val HS512: Algorithm = "HS512"
  val RS256: Algorithm = "RS256"

  /**
    * JwtSimple Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class JwtSimpleExtensions(val jwt: JwtSimple) extends AnyVal {

    def decodeAs[T <: js.Any](token: JwtToken, secret: String, skipVerification: Boolean = false, algorithm: Algorithm = HS256): T = {
      jwt.decode(token, secret, skipVerification, algorithm).asInstanceOf[T]
    }

  }

}

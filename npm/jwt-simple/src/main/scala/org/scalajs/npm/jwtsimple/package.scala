package org.scalajs.npm

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

}

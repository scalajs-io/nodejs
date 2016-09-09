package org.scalajs.nodejs
package adal

import scala.scalajs.js

/**
  * The ADAL for node.js library makes it easy for node.js applications to authenticate to AAD in order to access AAD
  * protected web resources.
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/adal-node
  * @version 0.1.19
  */
@js.native
trait AdalNode extends NodeModule {

  def AuthenticationContext: js.Function1[String, AuthenticationContext] = js.native

}

/**
  * AdalNode Companion
  * @author lawrence.daniels@gmail.com
  */
object AdalNode {

  /**
    * Convenience method for retrieving the adal-node module
    * @param require the implicit [[NodeRequire require function]]
    * @return the AdalNode instance
    */
  def apply()(implicit require: NodeRequire) = require[AdalNode]("adal-node")

}
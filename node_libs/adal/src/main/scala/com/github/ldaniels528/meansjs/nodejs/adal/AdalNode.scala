package com.github.ldaniels528.meansjs.nodejs.adal

import com.github.ldaniels528.meansjs.nodejs.NodeModule

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

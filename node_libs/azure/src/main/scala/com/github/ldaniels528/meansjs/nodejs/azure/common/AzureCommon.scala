package com.github.ldaniels528.meansjs.nodejs.azure.common

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.azure.common.AzureCommon.Constants

import scala.scalajs.js

/**
  * Azure Common node module
  * @author lawrence.daniels@gmail.com
  * @example {{{ val common = require[AzureCommon]("azure-common") }}}
  */
@js.native
trait AzureCommon extends NodeModule {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  def Constants: Constants = js.native

  def js2xml: js.Dynamic = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Classes
  /////////////////////////////////////////////////////////////////////////////////

  def ServiceManagementClient: js.Dynamic = js.native

  def ServiceManagementSettings: js.Dynamic = js.native

  def TokenCloudCredentials: js.Function1[TokenCloudCredentialOptions, TokenCloudCredentials] = js.native

  def WebResource: js.Dynamic = js.native

}

/**
  * Azure Common Companion
  * @author lawrence.daniels@gmail.com
  */
object AzureCommon {

  /**
    * Constants Container
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Constants extends js.Object {
    val SqlAzureConstants: SqlAzureConstants = js.native

  }

  /**
    * SQL Azure Constants
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait SqlAzureConstants extends js.Object {
    val DEFAULT_COLLATION_NAME: String = js.native
    val WEB_1GB: String = js.native
    val WEB_EDITION: String = js.native

  }

}
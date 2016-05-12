package com.github.ldaniels528.meansjs.nodejs.azure

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Azure Role Environment
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RoleEnvironment extends js.Object {

  /**
    * Obtains values from the role's .cscfg file.
    * @param callback the result call back
    */
  def getConfigurationSettings(callback: js.Function): js.Any = js.native

  /**
    * Obtains information about endpoints defined for the current role instance.
    * @param callback the result call back
    */
  def getCurrentRoleInstance(callback: js.Function): js.Any = js.native

  /**
    * Finds the path to defined local storage resources for the current role.
    * For example, the DiagnosticStore resource which is defined for every role provides a location for runtime
    * diagnostics and logs.
    * @param callback the result call back
    */
  def getLocalResources(callback: js.Function): js.Any = js.native

  /**
    * Obtains information about endpoints in role instances running on other machines
    * @param callback the result call back
    */
  def getRoles(callback: js.Function): js.Any = js.native

  /**
    * Determines whether the service runtime endpoint is running on the local machine.
    * It is good practice to enclose any code that uses service runtime in the isAvailable callback.
    * @param callback the result call back
    */
  def isAvailable(callback: js.Function): js.Any = js.native

}

/**
  * Role Environment
  * @author lawrence.daniels@gmail.com
  */
object RoleEnvironment {

  type Role = js.Any
  type Resource = js.Any

  /**
    * Role Environment Extensions
    * @param roleEnvironment the [[RoleEnvironment role environment]]
    */
  implicit class RoleEnvironmentExtensions(val roleEnvironment: RoleEnvironment) extends AnyVal {

    /**
      * Obtains values from the role's .cscfg file.
      */
    @inline
    def getConfigurationSettingsFuture = futureCallbackE1[js.Error, js.Dictionary[String]](roleEnvironment.getConfigurationSettings(_))

    /**
      * Obtains information about endpoints defined for the current role instance.
      */
    @inline
    def getCurrentRoleInstanceFuture = futureCallbackE1[js.Error, Role](roleEnvironment.getCurrentRoleInstance(_))

    /**
      * Finds the path to defined local storage resources for the current role.
      * For example, the DiagnosticStore resource which is defined for every role provides a location for runtime
      * diagnostics and logs.
      */
    @inline
    def getLocalResourcesFuture = futureCallbackE1[js.Error, js.Array[Resource]](roleEnvironment.getLocalResources(_))

    /**
      * Obtains information about endpoints in role instances running on other machines
      */
    @inline
    def getRolesFuture = futureCallbackE1[js.Error, js.Array[Role]](roleEnvironment.getRoles(_))

    /**
      * Determines whether the service runtime endpoint is running on the local machine.
      * It is good practice to enclose any code that uses service runtime in the isAvailable callback.
      */
    @inline
    def isAvailableFuture = futureCallbackE1[js.Error, Boolean](roleEnvironment.isAvailable(_))

  }

}

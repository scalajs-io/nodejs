package io.scalajs.npm.aws

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * AWS.ConfigBase
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "ConfigBase")
class ConfigBase(val options: ConfigurationOptions = js.native) extends ConfigurationOptions {

  /**
    * Loads credentials from the configuration object.
    */
  def getCredentials(callback: AWSError => Any): Unit = js.native

  /**
    * Loads configuration data from a JSON file into this config object.
    * Loading configuration will reset all existing configuration on the object.
    * This feature is not supported in the browser environment of the SDK.
    * @param path the path relative to your process's current working directory to load configuration from.
    */
  def loadFromPath(path: String): ConfigBase = js.native

  /**
    * Updates the current configuration object with new options.
    * @param options          a map of option keys and values.
    * @param allowUnknownKeys Whether unknown keys can be set on the configuration object.
    */
  def update(options: ConfigurationOptions | RawOptions, allowUnknownKeys: Boolean = js.native): Unit = js.native

  /**
    * Gets the promise dependency the SDK will use wherever Promises are returned.
    */
  def getPromisesDependency(): js.Function = js.native

  /**
    * Sets the promise dependency the SDK will use wherever Promises are returned.
    * @param dep - (function) a reference to a Promise constructor
    */
  def setPromisesDependency(dep: js.Function): Unit = js.native

}

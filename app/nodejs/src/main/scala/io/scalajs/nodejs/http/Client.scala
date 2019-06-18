package io.scalajs.nodejs.http

import scala.scalajs.js

/**
  * NodeJS HTTP Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Client extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The client's domain name
    */
  def domain: String = js.native

  /**
    * The client's host name
    */
  def host: String = js.native

  /**
    * The client's port number
    */
  def port: Int = js.native

  /**
    * The client's agent
    */
  def agent: Agent = js.native

}

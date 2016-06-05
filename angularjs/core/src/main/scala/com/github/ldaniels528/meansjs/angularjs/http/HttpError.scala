package com.github.ldaniels528.meansjs.angularjs.http

/**
  * HTTP Error
  * @author lawrence.daniels@gmail.com
  */
case class HttpError(status: Integer, message: String) extends RuntimeException(message)

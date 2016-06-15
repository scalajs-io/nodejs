package com.github.ldaniels528.meansjs.nodejs.escapehtml

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * escape-html - Escape string for use in HTML
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/escape-html
  * @version 1.0.3
  */
@js.native
trait EscapeHtml extends js.Function1[String, String] with NodeModule

/**
  * EscapeHtml Companion
  * @author lawrence.daniels@gmail.com
  */
object EscapeHtml {

  /**
    * Convenience method for retrieving the 'escape-html' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the EscapeHtml instance
    */
  def apply()(implicit require: NodeRequire) = require[EscapeHtml]("escape-html")

}
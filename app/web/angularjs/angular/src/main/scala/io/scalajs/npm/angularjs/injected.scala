package io.scalajs.npm.angularjs

import scala.annotation.StaticAnnotation

/**
  * Annotation for explicitly setting (overriding) the name of a component to be injected.
  * @param name the given name to use when injecting
  * @author lawrence.daniels@gmail.com
  */
@annotation.meta.param
case class injected(name: String) extends StaticAnnotation
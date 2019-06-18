package io.scalajs.npm.githubapinode

import scala.scalajs.js


/**
  * Represents a GitHub Pull
  * @author lawrence.daniels@gmail.com
  */

class Pull(val title: String,
           val body: String,
           val base: String,
           val head: String) extends js.Object
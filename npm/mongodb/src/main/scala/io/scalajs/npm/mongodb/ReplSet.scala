package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * MongoDB Replica Set Servers
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "ReplSet")
class ReplSet(val replicas: js.Array[Server]) extends js.Object

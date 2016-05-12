package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Role
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class Role(roleName: String,
           roleType: String,
           label: String,
           oSVirtualHardDisk: VirtualHardDisk,
           dataVirtualHardDisks: js.Array[VirtualHardDisk],
           configurationSets: js.Array[ConfigurationSet]) extends js.Object

/**
  * Role Companion
  * @author lawrence.daniels@gmail.com
  */
object Role {
  type VMRole = String
  val PersistentVMRole: VMRole = "PersistentVMRole"

  def apply(roleName: String,
            roleType: String,
            label: String,
            oSVirtualHardDisk: VirtualHardDisk,
            dataVirtualHardDisks: js.Array[VirtualHardDisk],
            configurationSets: js.Array[ConfigurationSet]) = {
    new Role(roleName, roleType, label, oSVirtualHardDisk, dataVirtualHardDisks, configurationSets)
  }

}
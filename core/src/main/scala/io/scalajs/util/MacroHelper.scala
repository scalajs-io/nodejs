package io.scalajs.util

import scala.reflect.macros.blackbox

/**
  * Macro Helper
  * @author lawrence.daniels@gmail.com
  */
object MacroHelper {

  def showDeclAndParams(c: blackbox.Context)(decl: c.universe.DefDef) {
    c.info(c.enclosingPosition, s"decl = $decl", force = true)
    c.info(c.enclosingPosition, s"mods = ${decl.mods}", force = true)
    c.info(c.enclosingPosition, s"name = ${decl.name}", force = true)
    c.info(c.enclosingPosition, s"tparams = ${decl.tparams}", force = true)
    c.info(c.enclosingPosition, s"vparamss = ${decl.vparamss}", force = true)
    c.info(c.enclosingPosition, s"tpt = ${decl.tpt}", force = true)
    c.info(c.enclosingPosition, s"rhs = ${decl.rhs}", force = true)
  }

  def showParams(c: blackbox.Context)(decl: c.universe.DefDef) {
    c.info(c.enclosingPosition, s"mods = ${decl.mods}", force = true)
    c.info(c.enclosingPosition, s"name = ${decl.name}", force = true)
    c.info(c.enclosingPosition, s"tparams = ${decl.tparams}", force = true)
    c.info(c.enclosingPosition, s"vparamss = ${decl.vparamss}", force = true)
    c.info(c.enclosingPosition, s"tpt = ${decl.tpt}", force = true)
    c.info(c.enclosingPosition, s"rhs = ${decl.rhs}", force = true)
  }

  def showTree(c: blackbox.Context)(tree: c.universe.Tree) = {
    import c.universe._
    c.info(c.enclosingPosition, showCode(tree), force = true)
    tree
  }

}

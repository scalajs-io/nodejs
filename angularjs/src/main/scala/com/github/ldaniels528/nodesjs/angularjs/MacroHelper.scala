package com.github.ldaniels528.nodesjs.angularjs

import scala.reflect.macros.blackbox

/**
 * Macro Helper
 */
object MacroHelper {

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

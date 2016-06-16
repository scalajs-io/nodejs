package org.scalajs.angularjs

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.language.experimental.macros
import scala.reflect.macros.blackbox

/**
  * Scope Method Macro Annotation
  * @author lawrence.daniels@gmail.com
  */
@compileTimeOnly("enable macro paradise to expand macro annotations")
@annotation.meta.param
class scoped extends StaticAnnotation {

  def macroTransform(annottees: Any*): Any = macro scoped.impl

}

/**
  * Scope Method Macro Annotation Implementation
  * @author lawrence.daniels@gmail.com
  */
object scoped {

  def impl(c: blackbox.Context)(annottees: c.Expr[Any]*) = {
    import c.universe._

    annottees map (_.tree) match {
      case (decl@DefDef(mods, name, tparams, vparamss, tpt, rhs)) :: Nil =>
        vparamss.headOption match {
          case Some(params) =>
            val args = params.map(_.name)
            q"""
            $decl
            $$scope.asInstanceOf[scala.scalajs.js.Dynamic].${decl.name} = (..$params) => ${decl.name}(..$args)"""
          case None =>
            q"""
            $decl
            $$scope.asInstanceOf[scala.scalajs.js.Dynamic].${decl.name} = () => ${decl.name}"""
        }

      case others =>
        others.foreach(other => c.info(c.enclosingPosition, s"other - class type: ${other.getClass.getName}", force = true))
        c.abort(c.enclosingPosition, "A method declaration is required")
    }
  }

}
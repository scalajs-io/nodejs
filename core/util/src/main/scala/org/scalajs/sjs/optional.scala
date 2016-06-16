package org.scalajs.sjs

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.language.experimental.macros
import scala.reflect.macros.blackbox

/**
  * Macro annotation for optional fields
  * @author lawrence.daniels@gmail.com
  */
@compileTimeOnly("enable macro paradise to expand macro annotations")
@annotation.meta.param
class optional(fields: Seq[String]) extends StaticAnnotation {

  def macroTransform(annottees: Any*): Any = macro optional.impl

}

/**
  * optional macro
  * @author lawrence.daniels@gmail.com
  */
object optional {

  def impl(c: blackbox.Context)(annottees: c.Expr[Any]*) = {
    import c.universe._

    // get the annotation's value
    val annotation = c.prefix.tree match {
      case q"""new optional($value)""" => value
      case _ => c.abort(c.enclosingPosition, "No values set in annotation")
    }
    //c.info(c.enclosingPosition, s"annotation = $annotation (${annotation.getClass.getName})", force = true)

    // parse the annotation value
    // TODO Nasty hack... figure out the right way to do this...
    val args = {
      val seqArgs = annotation.toString()
      val (start, end) = (seqArgs.indexOf("Seq("), seqArgs.indexOf(")"))
      if (start == -1 || end == -1) c.abort(c.enclosingPosition, "No arguments found in @optional(...)")
      seqArgs.substring(start + 4, end).replaceAllLiterally("\"", "").split(",").map(_.trim).toSeq
    }
    //c.info(c.enclosingPosition, s"args = $args", force = true)

    annottees map (_.tree) match {
      case (decl@DefDef(mods, name, tparams, vparamss, tpt, rhs)) :: Nil =>
        //MacroHelper.showDeclAndParams(c)(decl)
        vparamss.headOption match {
          case Some(params) =>
            // get the sequences of parameters for each call
            val argsList = args.foldLeft[List[List[ValDef]]](List(params)) { (list, name) =>
              list.last.filterNot(_.name == name) :: list
            }
            //c.info(c.enclosingPosition, s"argsList = $argsList", force = true)

            argsList map { params =>
              q"""def ${decl.name}(..$params): ${decl.tpt} = ${decl.rhs}"""
            }

            q"""def ${decl.name}(..$params): ${decl.tpt} = ${decl.rhs}"""
          case None =>
            c.abort(c.enclosingPosition, "The method has no parameters")
        }

      case others =>
        others.foreach(other => c.info(c.enclosingPosition, s"other - class type: ${other.getClass.getName}", force = true))
        c.abort(c.enclosingPosition, "A method declaration is required")
    }
  }

}
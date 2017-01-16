package io.scalajs.npm.angularjs

import scala.language.postfixOps
import scala.reflect.macros.blackbox

/**
  * AngularJS Module Macros
  * @author lawrence.daniels@gmail.com
  */
case class ModuleMacro(c: blackbox.Context) {

  import c.universe._

  val injectedType = typeOf[injected]

  //////////////////////////////////////////////////////////////////////////
  //    Controller Macro
  //////////////////////////////////////////////////////////////////////////

  def controllerOf[T <: Controller : c.WeakTypeTag] = generateController(weakTypeOf[T], q"${weakTypeOf[T].toString}")

  def namedControllerOf[T <: Controller : c.WeakTypeTag](name: c.Expr[String]) = generateController(weakTypeOf[T], q"$name")

  private def generateController(classType: Type, name: Tree) = {
    val module = Select(c.prefix.tree, TermName("self"))
    val constructor = makeConstructorArray(classType)
    q"""{
      import scala.scalajs.js
      $module.controller($name,$constructor)
    }"""
  }

  //////////////////////////////////////////////////////////////////////////
  //    Directive Macro
  //////////////////////////////////////////////////////////////////////////

  def namedDirectiveOf[T: c.WeakTypeTag](name: c.Tree) = {
    val module = Select(c.prefix.tree, TermName("self"))
    val constructor = makeDirectiveConstructorArray(weakTypeOf[T])
    q"""{
      import scala.scalajs.js
      import js.Dynamic.literal
      $module.directive($name,$constructor)
    }"""
  }

  private def makeDirectiveConstructorArray(classType: c.Type) = {
    val methods = classType.decls.filter(m => m.isMethod && !m.isConstructor && !m.isPrivate) map (_.asMethod)
    val attributes = methods map (ms => ms.name.toString -> ms) map {
      case (id, symbol) if symbol.isGetter => q"$id->d1r3ctive.${symbol.name}"
      case (id, symbol) => q"$id->(d1r3ctive.${symbol.name} _:js.Function)"
    }

    // build directive constructor
    val cons = classType.members.filter(_.isConstructor).map(_.asMethod).head
    val (params, args) = makeArgumentList(cons)
    val dependencies = getDependencyInjectedNames(cons)
    q"""js.Array(..$dependencies, ({(..$params) =>
          val d1r3ctive = new $classType(..$args)
          literal(..$attributes)
        }: js.Function))"""
  }

  //////////////////////////////////////////////////////////////////////////
  //    Factory Macro
  //////////////////////////////////////////////////////////////////////////

  def factoryOf[T: c.WeakTypeTag] = generateFactory(weakTypeOf[T], q"${getIdentifierName(weakTypeOf[T])}")

  def namedFactoryOf[T: c.WeakTypeTag](name: c.Tree) = generateFactory(weakTypeOf[T], q"$name")

  private def generateFactory(classType: c.Type, name: c.Tree) = {
    val module = Select(c.prefix.tree, TermName("self"))
    val constructor = makeConstructorArray(classType)
    q"""{
      import scala.scalajs.js
      $module.factory($name,$constructor)
    }"""
  }

  //////////////////////////////////////////////////////////////////////////
  //    Service Macro
  //////////////////////////////////////////////////////////////////////////

  def serviceOf[T: c.WeakTypeTag] = generateService(weakTypeOf[T], q"${getIdentifierName(weakTypeOf[T])}")

  def namedServiceOf[T: c.WeakTypeTag](name: c.Tree) = generateService(weakTypeOf[T], q"$name")

  private def generateService(classType: c.Type, name: c.Tree) = {
    val module = Select(c.prefix.tree, TermName("self"))
    val constructor = makeConstructorArray(classType)
    q"""{
      import scala.scalajs.js
      $module.service($name,$constructor)
    }"""
  }

  //////////////////////////////////////////////////////////////////////////
  //    Internal/Shared Functions
  //////////////////////////////////////////////////////////////////////////

  private def getDependencyInjectedNames(ms: MethodSymbol) = {
    ms.paramLists.head.map { symbol =>
      symbol.annotations.find(_.tree.tpe =:= injectedType) match {
        case Some(a) => a.tree.children.tail.head.toString().drop(1).dropRight(1)
        case None => symbol.name.toString
      }
    }
  }

  private def getIdentifierName(factoryType: Type): String = getIdentifierName(factoryType.toString.split('.').last)

  private def getIdentifierName(name: String): String = name.head.toLower + name.tail

  private def makeArgumentList(ms: MethodSymbol) = {
    if (ms.paramLists.isEmpty) (Nil, Nil)
    else
      ms.paramLists.head.map { symbol =>
        val name = TermName(c.freshName("x"))
        (q"$name: ${symbol.typeSignature}", q"$name")
      } unzip
  }

  private def makeConstructorArray(classType: c.Type) = {
    val cons = classType.members.filter(_.isConstructor).map(_.asMethod).head
    val (params, args) = makeArgumentList(cons)
    val dependencies = getDependencyInjectedNames(cons)

    // AngularJS service construction array
    q"js.Array(..$dependencies, ((..$params) => new $classType(..$args)):js.Function)"
  }

}


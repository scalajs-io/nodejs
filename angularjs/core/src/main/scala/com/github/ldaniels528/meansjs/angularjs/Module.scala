package com.github.ldaniels528.meansjs.angularjs

import scala.language.experimental.macros
import scala.language.{implicitConversions, postfixOps}
import scala.reflect.macros.blackbox
import scala.scalajs.js

/**
  * AngularJS Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Module extends js.Object {

  def name: String

  def animation(name: String, dependencies: js.Array[Any]): this.type

  def config(dependencies: js.Array[Any]): this.type

  def constant(name: String, value: js.Any): this.type

  def controller(name: String, constructor: js.Array[Any]): this.type

  def directive(name: String, constructor: js.Array[Any]): this.type

  def factory(name: String, constructor: js.Array[Any]): this.type

  def filter(name: String, fn: js.Function): this.type

  def provider(name: String, constructor: js.Array[Any]): this.type

  def run(initialization: js.Array[Any]): this.type

  def service(name: String, constructor: js.Array[Any]): this.type

}

/**
  * AngularJS Module Singleton
  * @author lawrence.daniels@gmail.com
  */
object Module {

  @inline
  implicit def unwrapEnrichedModule(m: EnrichedModule): Module = m.self

  /**
    * Enriched Module
    * @param self the given [[Module module]]
    */
  implicit class EnrichedModule(val self: Module) extends AnyVal {

    @inline def animation(name: String, dependencySet: DependencySet): Module = self.animation(name, dependencySet.dependencies)

    @inline def config(dependencySet: DependencySet): Module = self.config(dependencySet.dependencies)

    @inline def controller(name: String, constructor: DependencySet): Module = self.controller(name, constructor.dependencies)

    @inline def controllerOf[T <: Controller]: Module = macro ModuleMacro.controllerOf[T]

    @inline def controllerOf[T <: Controller](name: String): Module = macro ModuleMacro.namedControllerOf[T]

    @inline def directiveOf[T <: Directive[_]](name: String): Module = macro ModuleMacro.namedDirectiveOf[T]

    @inline def factory(name: String, constructor: DependencySet): Module = self.factory(name, constructor.dependencies)

    @inline def factoryOf[T <: Factory]: Module = macro ModuleMacro.factoryOf[T]

    @inline def factoryOf[T <: Factory](name: String): Module = macro ModuleMacro.namedFactoryOf[T]

    @inline def provider(name: String, constructor: DependencySet): Module = self.provider(name, constructor.dependencies)

    @inline def run(initializationFn: DependencySet): Module = self.run(initializationFn.dependencies)

    @inline def service(name: String, constructor: DependencySet): Module = self.service(name, constructor.dependencies)

    @inline def serviceOf[T <: Service]: Module = macro ModuleMacro.serviceOf[T]

    @inline def serviceOf[T <: Service](name: String): Module = macro ModuleMacro.namedServiceOf[T]

  }

}

/**
  * AngularJS Module Macros
  * @author lawrence.daniels@gmail.com
  */
private[meansjs] case class ModuleMacro(c: blackbox.Context) {

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

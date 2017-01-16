package io.scalajs.npm.angularjs

import scala.language.experimental.macros
import scala.language.{implicitConversions, postfixOps}
import scala.scalajs.js

/**
  * AngularJS Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Module extends js.Object {

  def name: String = js.native

  def animation(name: String, dependencies: js.Array[Any]): this.type = js.native

  def config(dependencies: js.Array[Any]): this.type = js.native

  def constant(name: String, value: js.Any): this.type = js.native

  def controller(name: String, constructor: js.Array[Any]): this.type = js.native

  def directive(name: String, constructor: js.Array[Any]): this.type = js.native

  def factory(name: String, constructor: js.Array[Any]): this.type = js.native

  def filter(name: String, fn: js.Function): this.type = js.native

  def provider(name: String, constructor: js.Array[Any]): this.type = js.native

  def run(initialization: js.Array[Any]): this.type = js.native

  def service(name: String, constructor: js.Array[Any]): this.type = js.native

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

    @inline
    def animation(name: String, dependencySet: DependencySet): Module = self.animation(name, dependencySet.dependencies)

    @inline
    def config(dependencySet: DependencySet): Module = self.config(dependencySet.dependencies)

    @inline
    def controller(name: String, constructor: DependencySet): Module = self.controller(name, constructor.dependencies)

    @inline
    def controllerOf[T <: Controller]: Module = macro ModuleMacro.controllerOf[T]

    @inline
    def controllerOf[T <: Controller](name: String): Module = macro ModuleMacro.namedControllerOf[T]

    @inline
    def directiveOf[T <: Directive](name: String): Module = macro ModuleMacro.namedDirectiveOf[T]

    @inline
    def factory(name: String, constructor: DependencySet): Module = self.factory(name, constructor.dependencies)

    @inline
    def factoryOf[T <: Factory]: Module = macro ModuleMacro.factoryOf[T]

    @inline
    def factoryOf[T <: Factory](name: String): Module = macro ModuleMacro.namedFactoryOf[T]

    @inline
    def provider(name: String, constructor: DependencySet): Module = self.provider(name, constructor.dependencies)

    @inline
    def run(initializationFn: DependencySet): Module = self.run(initializationFn.dependencies)

    @inline
    def service(name: String, constructor: DependencySet): Module = self.service(name, constructor.dependencies)

    @inline
    def serviceOf[T <: Service]: Module = macro ModuleMacro.serviceOf[T]

    @inline
    def serviceOf[T <: Service](name: String): Module = macro ModuleMacro.namedServiceOf[T]

  }

}


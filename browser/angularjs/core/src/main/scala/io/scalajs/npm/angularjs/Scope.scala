package io.scalajs.npm.angularjs

import scala.language.experimental.macros
import scala.language.{implicitConversions, postfixOps}
import scala.scalajs.js

/**
  * Represents an AngularJS Scope
  * @see [[https://docs.angularjs.org/api/ng/type/\$rootScope.Scope]]
  */
@js.native
trait Scope extends js.Object {

  /**
    * Creates a new child scope.
    * The parent scope will propagate the $digest() event. The scope can be removed from the scope hierarchy using $destroy().
    * $destroy() must be called on a scope when it is desired for the scope and its child scopes to be permanently
    * detached from the parent and thus stop participating in model change detection and listener notification by invoking.
    * @param isolate If true, then the scope does not prototypically inherit from the parent scope. The scope is isolated,
    *                as it can not see parent scope properties. When creating widgets, it is useful for the widget to not
    *                accidentally read parent state.
    * @param parent  The Scope that will be the $parent of the newly created scope. Defaults to this scope if not provided.
    *                This is used when creating a transclude scope to correctly place it in the scope hierarchy while
    *                maintaining the correct prototypical inheritance.
    * @return The newly created child scope.
    */
  def $new(isolate: Boolean, parent: Scope = js.native): Scope = js.native

  /**
    * Registers a listener callback to be executed whenever the watchExpression changes.
    * @param watchExpression The watchExpression is called on every call to $digest() and should return the value that
    *                        will be watched. (Since $digest() reruns when it detects changes the watchExpression can
    *                        execute multiple times per $digest() and should be idempotent.)
    * @param listener        The listener is called only when the value from the current watchExpression and the previous call
    *                        to watchExpression are not equal (with the exception of the initial run, see below). Inequality is
    *                        determined according to reference inequality, strict comparison via the !== Javascript operator,
    *                        unless objectEquality == true (see next point)
    * @param objectEquality  When objectEquality == true, inequality of the watchExpression is determined according to the
    *                        angular.equals function. To save the value of the object for later comparison, the
    *                        angular.copy function is used. This therefore means that watching complex objects will have
    *                        adverse memory and performance implications.
    * @return
    */
  def $watch(watchExpression: js.Any, listener: js.Function = js.native, objectEquality: Boolean = js.native): js.Function = js.native

  /**
    * A variant of $watch() where it watches an array of watchExpressions. If any one expression in the collection
    * changes the listener is executed.
    * @param watchExpressions The items in the watchExpressions array are observed via standard $watch operation and are
    *                         examined on every call to $digest() to see if any items changes.
    * @param listener         The listener is called whenever any expression in the watchExpressions array changes.
    * @return Returns a de-registration function for all listeners.
    */
  def $watchGroup(watchExpressions: js.Array[js.Any], listener: js.Function): js.Function = js.native

  /**
    * Shallow watches the properties of an object and fires whenever any of the properties change (for arrays, this
    * implies watching the array items; for object maps, this implies watching the properties). If a change is detected,
    * the listener callback is fired.
    * @param obj      The obj collection is observed via standard $watch operation and is examined on every call to $digest()
    *                 to see if any items have been added, removed, or moved.
    * @param listener The listener is called whenever anything within the obj has changed. Examples include adding,
    *                 removing, and moving items belonging to an object or array.
    * @return Returns a de-registration function for this listener. When the de-registration function is executed, the
    *         internal watch operation is terminated.
    */
  def $watchCollection(obj: js.Any, listener: js.Function): js.Function = js.native

  /**
    * Processes all of the watchers of the current scope and its children. Because a watcher's listener can change the
    * model, the $digest() keeps calling the watchers until no more listeners are firing. This means that it is possible
    * to get into an infinite loop. This function will throw 'Maximum iteration limit exceeded.' if the number of
    * iterations exceeds 10.
    */
  def $digest(): Unit = js.native

  /**
    * Removes the current scope (and all of its children) from the parent scope. Removal implies that calls to $digest()
    * will no longer propagate to the current scope and its children. Removal also implies that the current scope is
    * eligible for garbage collection.
    *
    * The \$destroy() is usually used by directives such as ngRepeat for managing the unrolling of the loop.
    *
    * Just before a scope is destroyed, a $destroy event is broadcasted on this scope. Application code can register a
    * \$destroy event handler that will give it a chance to perform any necessary cleanup.
    *
    * Note that, in AngularJS, there is also a $destroy jQuery event, which can be used to clean up DOM bindings before
    * an element is removed from the DOM.
    */
  def $destroy(): Unit = js.native

  /**
    * Executes the expression on the current scope and returns the result. Any exceptions in the expression are
    * propagated (uncaught). This is useful when evaluating Angular expressions.
    * @param expression An angular expression to be executed.
    *                   <ul>
    *                   <li>string: execute using the rules as defined in expression.</li>
    *                   <li>function(scope): execute the function with the current scope parameter.</li>
    *                   </ul>
    * @param locals     Local variables object, useful for overriding values in scope.
    * @return The result of evaluating the expression.
    */
  def $eval[T](expression: js.Any = js.native, locals: js.Object = js.native): T = js.native

  /**
    * Executes the expression on the current scope at a later point in time.
    * The $evalAsync makes no guarantees as to when the expression will be executed, only that:
    * <ul>
    * <li>it will execute after the function that scheduled the evaluation (preferably before DOM rendering).</li>
    * <li>at least one $digest cycle will be performed after expression execution.</li>
    * </ul>
    * @param expression An angular expression to be executed.
    * @param locals     Local variables object, useful for overriding values in scope.
    * @return
    */
  def $evalAsync(expression: js.Any = js.native, locals: js.Object = js.native): Unit = js.native

  /**
    * apply() is used to execute an expression in angular from outside of the angular framework. (For example from
    * browser DOM events, setTimeout, XHR or third party libraries). Because we are calling into the angular framework
    * we need to perform proper scope life cycle of exception handling, executing watches.
    * @param exp An angular expression to be executed.
    *            <ul>
    *            <li>string: execute using the rules as defined in expression.</li>
    *            <li>function(scope): execute the function with current scope parameter.</li>
    *            </ul>
    * @return The result of evaluating the expression.
    */
  def $apply(exp: js.Any = js.native): js.Any = js.native

  /**
    * Schedule the invocation of $apply to occur at a later time. The actual time difference varies across browsers,
    * but is typically around ~10 milliseconds.
    *
    * This can be used to queue up multiple expressions which need to be evaluated in the same digest.
    * @param exp An angular expression to be executed.
    *            <ul>
    *            <li>string: execute using the rules as defined in expression.</li>
    *            <li>function(scope): execute the function with current scope parameter.</li>
    *            <ul>
    * @return
    */
  def $applyAsync(exp: js.Any = js.native): js.Any = js.native

  /**
    * Listens on events of a given type. See $emit for discussion of event life cycle.
    * The event listener function format is: function(event, args...). The event object passed into the listener has the
    * following attributes:
    * @param name     Event name to listen on.
    * @param listener Function to call when the event is emitted.
    * @return Returns a deregistration function for this listener.
    */
  def $on(name: String, listener: js.Function): js.Function = js.native

  /**
    * Dispatches an event name upwards through the scope hierarchy notifying the registered $rootScope.Scope listeners.
    *
    * The event life cycle starts at the scope on which $emit was called. All listeners listening for name event on this
    * scope get notified. Afterwards, the event traverses upwards toward the root scope and calls all registered
    * listeners along the way. The event will stop propagating if one of the listeners cancels it.
    *
    * Any exception emitted from the listeners will be passed onto the $exceptionHandler service.
    * @param name Event name to emit.
    * @param args Optional one or more arguments which will be passed onto the event listeners.
    * @return
    */
  def $emit(name: String, args: js.Any*): js.Object = js.native

  /**
    * Dispatches an event name downwards to all child scopes (and their children) notifying the registered
    * \$rootScope.Scope listeners.
    *
    * The event life cycle starts at the scope on which $broadcast was called. All listeners listening for name event
    * on this scope get notified. Afterwards, the event propagates to all direct and indirect scopes of the current
    * scope and calls all registered listeners along the way. The event cannot be canceled.
    *
    * Any exception emitted from the listeners will be passed onto the $exceptionHandler service.
    * @param name Event name to broadcast.
    * @param args Optional one or more arguments which will be passed onto the event listeners.
    * @return
    */
  def $broadcast(name: String, args: js.Any*): js.Object = js.native

  /**
    * Returns the unique scope ID (monotonically increasing) useful for debugging.
    * @return Unique scope ID (monotonically increasing) useful for debugging.
    */
  def $id: Int = js.native

  /**
    * Returns the reference to the parent scope.
    * @return Reference to the parent scope.
    */
  def $parent: Scope = js.native

  /**
    * Returns the reference to the root scope.
    * @return Reference to the root scope.
    */
  def $root: Scope = js.native

}

/**
  * Scope Singleton
  * @author lawrence.daniels@gmail.com
  */
object Scope {

  /**
    * Enriched Scope
    * @author lawrence.daniels@gmail.com
    */
  implicit class EnrichedScope(val scope: Scope) extends AnyVal {

    @inline
    def dynamic: js.Dynamic = scope.asInstanceOf[js.Dynamic]

    @inline
    def $watchScala[A <: js.Any, B <: js.Any](watchExpression: Scope => js.Any, listener: (A, B) => Any = null, objectEquality: Boolean = false): js.Function = {
      scope.$watch(watchExpression, listener, objectEquality)
    }

  }

}



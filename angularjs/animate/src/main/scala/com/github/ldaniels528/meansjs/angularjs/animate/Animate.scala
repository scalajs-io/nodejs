package com.github.ldaniels528.meansjs.angularjs.animate

import org.scalajs.dom.Element
import org.w3c.dom.events.Event

import scala.scalajs.js

/**
  * Animate Service - The \$animate service exposes a series of DOM utility methods that provide support for animation hooks.
  * @see [[https://docs.angularjs.org/api/ng/service/\$animate]]
  */
@js.native
trait Animate extends js.Object {

  /**
    * Sets up an event listener to fire whenever the animation event (enter, leave, move, etc...) has fired on
    * the given element or among any of its children. Once the listener is fired, the provided callback is fired
    * with the following params:
    * @param event     the animation event that will be captured (e.g. enter, leave, move, addClass, removeClass, etc...)
    * @param container the container element that will capture each of the animation events that are fired on itself as
    *                  well as among its children
    * @param callback  the callback function that will be fired when the listener is triggered
    *                  <ul>
    *                  The arguments present in the callback function are:
    *                  <li>element - The captured DOM element that the animation was fired on.</li>
    *                  <li>phase - The phase of the animation. The two possible phases are start (when the animation starts)
    *                  and close (when it ends).</li>
    *                  </ul>
    */
  def on(event: Event, container: js.Any, callback: js.Function): Unit = js.native

  /**
    * Deregisters an event listener based on the event which has been associated with the provided element.
    * This method can be used in three different ways depending on the arguments:
    * @param event     the animation event (e.g. enter, leave, move, addClass, removeClass, etc...)
    * @param container the container element the event listener was placed on
    * @param callback  the container element the event listener was placed on
    */
  def off(event: Event, container: js.Any = js.native, callback: js.Function = js.native): Unit = js.native

  /**
    * Associates the provided element with a host parent element to allow the element to be animated even
    * if it exists outside of the DOM structure of the Angular application. By doing so, any animation
    * triggered via $animate can be issued on the element despite being outside the realm of the application
    * or within another application. Say for example if the application was bootstrapped on an element that
    * is somewhere inside of the <body> tag, but we wanted to allow for an element to be situated as a direct
    * child of document.body, then this can be achieved by pinning the element via $animate.pin(element).
    * Keep in mind that calling $animate.pin(element, parentElement) will not actually insert into the DOM anywhere;
    * it will just create the association.
    * @param element       the external element that will be pinned
    * @param parentElement the host parent element that will be associated with the external element
    */
  def pin(element: Element, parentElement: Element): Unit = js.native

  /**
    * Used to get and set whether animations are enabled or not on the entire application or on an
    * element and its children.
    * @param element the element that will be considered for checking/setting the enabled state
    * @param enabled whether or not the animations will be enabled for the element
    * @return whether or not animations are enabled
    */
  def enabled(element: Element = js.native, enabled: Boolean = js.native): Boolean = js.native

  /**
    * Cancels the provided animation.
    * @param animationPromise The animation promise that is returned when an animation is started.
    */
  def cancel(animationPromise: js.Promise[js.Any]): Unit = js.native

  /**
    * Inserts the element into the DOM either after the after element (if provided) or as the first child
    * within the parent element and then triggers an animation. A promise is returned that will be resolved
    * during the next digest once the animation has completed.
    * @param element the element which will be inserted into the DOM
    * @param parent  the parent element which will append the element as a child (so long as the after element is not present)
    * @param after   the sibling element after which the element will be appended
    * @param options an optional collection of options/styles that will be applied to the element
    * @return the animation [[js.Promise callback promise]]
    */
  def enter(element: Element, parent: Element, after: Element = js.native, options: js.Object = js.native): js.Promise[js.Any] = js.native

  /**
    * Inserts (moves) the element into its new position in the DOM either after the after element (if provided)
    * or as the first child within the parent element and then triggers an animation. A promise is returned
    * that will be resolved during the next digest once the animation has completed.
    * @param element the element which will be moved into the new DOM position
    * @param parent  the parent element which will append the element as a child (so long as the after element is not present)
    * @param after   the sibling element after which the element will be appended
    * @param options an optional collection of options/styles that will be applied to the element
    * @return the animation [[js.Promise[js.Any] callback promise]]
    */
  def move(element: Element, parent: Element, after: Element, options: js.Object = js.native): js.Promise[js.Any] = js.native

  /**
    * Triggers an animation and then removes the element from the DOM. When the function is called a
    * promise is returned that will be resolved during the next digest once the animation has completed.
    * @param element the element which will be removed from the DOM
    * @param options an optional collection of options/styles that will be applied to the element
    * @return the animation [[js.Promise[js.Any] callback promise]]
    */
  def leave(element: Element, options: js.Object = js.native): js.Promise[js.Any] = js.native

  /**
    * Triggers an addClass animation surrounding the addition of the provided CSS class(es). Upon execution,
    * the addClass operation will only be handled after the next digest and it will not trigger an animation
    * if element already contains the CSS class or if the class is removed at a later step. Note that class-based
    * animations are treated differently compared to structural animations (like enter, move and leave) since the
    * CSS classes may be added/removed at different points depending if CSS or JavaScript animations are used.
    * @param element   the element which the CSS classes will be applied to
    * @param className the CSS class(es) that will be added (multiple classes are separated via spaces)
    * @param options   an optional collection of options/styles that will be applied to the element
    * @return the animation [[js.Promise[js.Any] callback promise]]
    */
  def addClass(element: Element, className: String, options: js.Object = js.native): js.Promise[js.Any] = js.native

  /**
    * Triggers a removeClass animation surrounding the removal of the provided CSS class(es). Upon execution,
    * the removeClass operation will only be handled after the next digest and it will not trigger an animation
    * if element does not contain the CSS class or if the class is added at a later step. Note that class-based
    * animations are treated differently compared to structural animations (like enter, move and leave) since
    * the CSS classes may be added/removed at different points depending if CSS or JavaScript animations are used.
    * @param element   the element which the CSS classes will be applied to
    * @param className the CSS class(es) that will be removed (multiple classes are separated via spaces)
    * @param options   an optional collection of options/styles that will be applied to the element
    * @return the animation [[js.Promise[js.Any] callback promise]]
    */
  def removeClass(element: Element, className: String, options: js.Object = js.native): js.Promise[js.Any] = js.native

  /**
    * Performs both the addition and removal of a CSS classes on an element and (during the process)
    * triggers an animation surrounding the class addition/removal. Much like $animate.addClass
    * and $animate.removeClass, setClass will only evaluate the classes being added/removed once a
    * digest has passed. Note that class-based animations are treated differently compared to structural
    * animations (like enter, move and leave) since the CSS classes may be added/removed at different
    * points depending if CSS or JavaScript animations are used.
    * @param element the element which the CSS classes will be applied to
    * @param add     the CSS class(es) that will be added (multiple classes are separated via spaces)
    * @param remove  the CSS class(es) that will be removed (multiple classes are separated via spaces)
    * @param options an optional collection of options/styles that will be applied to the element
    * @return the animation [[js.Promise[js.Any] callback promise]]
    */
  def setClass(element: Element, add: String, remove: String, options: js.Object = js.native): js.Promise[js.Any] = js.native

  /**
    * Performs an inline animation on the element which applies the provided to and from CSS styles to the element.
    * If any detected CSS transition, keyframe or JavaScript matches the provided className value then the animation
    * will take on the provided styles. For example, if a transition animation is set for the given className then
    * the provided from and to styles will be applied alongside the given transition. If a JavaScript animation is
    * detected then the provided styles will be given in as function paramters into the animate method (or as apart
    * of the options parameter).
    * @param element   the element which the CSS styles will be applied to
    * @param from      the from (starting) CSS styles that will be applied to the element and across the animation.
    * @param to        the to (destination) CSS styles that will be applied to the element and across the animation.
    * @param className an optional CSS class that will be applied to the element for the duration of the animation.
    *                  If this value is left as empty then a CSS class of ng-inline-animate will be applied to the element.
    *                  (Note that if no animation is detected then this value will not be appplied to the element.)
    * @param options   an optional collection of options/styles that will be applied to the element
    * @return the animation [[js.Promise[js.Any] callback promise]]
    */
  def animate(element: Element, from: js.Object, to: js.Object, className: String, options: js.Object = js.native): js.Promise[js.Any] = js.native

}

/**
  * Animate Service Singleton
  * @author lawrence.daniels@gmail.com
  */
object Animate {

  /**
    * Enriched Animate Service
    * @author lawrence.daniels@gmail.com
    */
  implicit class EnrichedAnimate(val animate: Animate) extends AnyVal {

    @inline
    def dynamic: js.Dynamic = animate.asInstanceOf[js.Dynamic]

  }

}
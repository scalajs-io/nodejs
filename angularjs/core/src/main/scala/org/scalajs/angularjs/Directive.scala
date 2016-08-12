package org.scalajs.angularjs

import scala.scalajs.js

/**
  * AngularJS Directive
  * @author lawrence.daniels@gmail.com
  */
trait Directive {

  /**
    * Specifies what the template should replace. Defaults to false.
    * <ul>
    * <li>true - the template will replace the directive's element.</li>
    * <li>false - the template will replace the contents of the directive's element.</li>
    * </ul>
    */
  @deprecated("replace will be removed in next major release (i.e. v2.0)", "1.4.x")
  def replace: Boolean = false

  /**
    * The scope property can be true, an object or a falsy value.
    */
  def scope: js.Any = js.undefined //new js.Object()

  /**
    * Extract the contents of the element where the directive appears and make it available to the directive.
    * The contents are compiled and provided to the directive as a transclusion function.
    */
  def transclude: Boolean = false

}

/**
  * Directive Companion
  * @author lawrence.daniels@gmail.com
  */
object Directive {

  /////////////////////////////////////////////////////////////////////////////////
  //      Attribute, Class, Element, and Comment Restriction Support
  /////////////////////////////////////////////////////////////////////////////////

  trait AttributeRestriction extends RestrictionSupport {
    self: Directive =>

    override val restrict = "A"
  }

  trait AttributeElementRestriction extends RestrictionSupport {
    self: Directive =>

    override val restrict = "AE"
  }

  trait ClassRestriction extends RestrictionSupport {
    self: Directive =>

    override val restrict = "C"
  }

  trait CommentRestriction extends RestrictionSupport {
    self: Directive =>

    override val restrict = "M"
  }

  trait ElementRestriction extends RestrictionSupport {
    self: Directive =>

    override val restrict = "E"
  }

  trait RestrictionSupport {
    self: Directive =>

    def restrict: String

  }

  /////////////////////////////////////////////////////////////////////////////////
  //      Controller Support
  /////////////////////////////////////////////////////////////////////////////////

  trait ControllerSupport[A] extends LinkWithController[A] {
    self: Directive =>

    def controller: String

  }

  trait RequireController[A] extends LinkWithController[A] {
    self: Directive =>

    def require: String

  }

  trait RequireControllers[A] {
    self: Directive =>

    def require: js.Array[String]

    /**
      * Directives that want to modify the DOM typically use the link option to register DOM listeners as well as update
      * the DOM. It is executed after the template has been cloned and is where directive logic will be put.
      * @param scope       is an Angular scope object.
      * @param element     is the jqLite-wrapped element that this directive matches.
      * @param attrs       is a hash object with key-value pairs of normalized attribute names and their corresponding attribute values.
      * @param controllers the array of controllers
      */
    def link(scope: A, element: JQLite, attrs: Attributes, controllers: js.Array[_ <: Controller]): Unit

  }

  /////////////////////////////////////////////////////////////////////////////////
  //      Pre-Link and Link Support
  /////////////////////////////////////////////////////////////////////////////////

  trait LinkSupport[A] {
    self: Directive =>

    /**
      * Directives that want to modify the DOM typically use the link option to register DOM listeners as well as update
      * the DOM. It is executed after the template has been cloned and is where directive logic will be put.
      * @param scope   is an Angular scope object.
      * @param element is the jqLite-wrapped element that this directive matches.
      * @param attrs   is a hash object with key-value pairs of normalized attribute names and their corresponding attribute values.
      */
    def link(scope: A, element: JQLite, attrs: Attributes): Unit

  }

  trait LinkWithController[A] {
    self: Directive =>

    /**
      * Directives that want to modify the DOM typically use the link option to register DOM listeners as well as update
      * the DOM. It is executed after the template has been cloned and is where directive logic will be put.
      * @param scope      is an Angular scope object.
      * @param element    is the jqLite-wrapped element that this directive matches.
      * @param attrs      is a hash object with key-value pairs of normalized attribute names and their corresponding attribute values.
      * @param controller the given controller
      */
    def link(scope: A, element: JQLite, attrs: Attributes, controller: Controller): Unit

  }

  trait PreLinkSupport {
    self: Directive =>

    /**
      * The compile function is used to perform any DOM transformation before the link function runs.
      * @param element The element on which the directive is applied.
      * @param attrs   The normalized list of attributes declared on the element.
      */
    def compile(element: JQLite, attrs: Attributes): js.Function3[_ <: Scope, JQLite, Attributes, Any]

  }

  /////////////////////////////////////////////////////////////////////////////////
  //      Template Support
  /////////////////////////////////////////////////////////////////////////////////

  trait TemplateSupport {
    self: Directive =>

    def template: String

  }

  /**
    * @example { templateUrl: function(elem, attr) { return 'customer-' + attr.type + '.html' } }
    */
  trait TemplateURLFunction {
    self: Directive =>

    def templateUrl: js.Function2[JQLite, Attributes, String]

  }

  /**
    * @example { templateUrl: 'my-customer.html' }
    */
  trait TemplateURLSupport {
    self: Directive =>

    def templateUrl: String

  }

}
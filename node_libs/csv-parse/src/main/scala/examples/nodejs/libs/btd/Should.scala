package examples.nodejs.libs.btd

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * should
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Should extends NodeModule {

  def eql(value: js.Any): Boolean = js.native

}

/**
  * Should Companion
  * @author lawrence.daniels@gmail.com
  */
object Should {

  /**
    * Convenience method for retrieving the 'should' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Should instance
    */
  def apply()(implicit require: NodeRequire) = require[Should]("should")

  /**
    * Should Extensions
    * @param value the given value
    */
  implicit class ShouldExtensions(val value: js.Object) extends AnyVal {

    def should: Should = {
      value.dynamic.should = new js.Object()
      value.dynamic.should.asInstanceOf[Should]
    }

  }

}
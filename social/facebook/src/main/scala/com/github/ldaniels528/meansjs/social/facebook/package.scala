package com.github.ldaniels528.meansjs.social

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Facebook package object
  * @author lawrence.daniels@gmail.com
  */
package object facebook {

  /**
    * Facebook Singleton
    */
  @js.native
  @JSName("FB")
  object FB extends Facebook

}

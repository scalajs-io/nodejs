package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Basic FXAA implementation based on the code on geeks3d.com with the modification that the texture2DLod stuff was
  * removed since it's unsupported by WebGL.
  */
@js.native
@JSName("FXAAFilter")
class FXAAFilter extends AbstractFilter()

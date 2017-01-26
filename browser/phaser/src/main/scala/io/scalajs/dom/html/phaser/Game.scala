package io.scalajs.dom.html.phaser

import scala.scalajs.js

@js.native
class Game(val width: Int = js.native,
           val height: Int = js.native,
           val renderer: Int = js.native,
           val name: String = js.native)
  extends js.Object {

  val load: Loader = js.native
  val state: State = js.native
  val physics: Physics = js.native
  val add: GameObjectFactory = js.native
  val world: World = js.native
  val input: Input = js.native
  val time: Time = js.native
  val rnd: RandomDataGenerator = js.native
}

package examples.nodejs.terminal

import org.scalajs.nodejs._
import org.scalajs.nodejs.colors._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.colors.Colors

import scala.scalajs.js

/**
  * Colors Example
  * @author lawrence.daniels@gmail.com
  */
class ColorsExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  implicit val colors = require[Colors]("colors")

  console.log("supports color?", colors.supportsColor)

  console.log("hello".green) // outputs green text
  console.log("i like cake and pies".underline.red) // outputs red underlined text
  console.log("inverse the color".inverse) // inverses the color
  console.log("OMG Rainbows!".rainbow) // rainbow
  console.log("Run the trap".trap) // Drops the bass

  console.log(colors.green("hello")) // outputs green text 
  console.log(colors.red.underline("i like cake and pies")) // outputs red underlined text
  console.log(colors.inverse("inverse the color")) // inverses the color 
  console.log(colors.rainbow("OMG Rainbows!")) // rainbow 
  console.log(colors.trap("Run the trap")) // Drops the bass

  colors.setTheme(js.Dictionary(
    "silly" -> "rainbow",
    "input" -> "grey",
    "verbose" -> "cyan",
    "prompt" -> "grey",
    "info" -> "green",
    "data" -> "grey",
    "help" -> "cyan",
    "warn" -> "yellow",
    "debug" -> "blue",
    "error" -> "red",
    "test" -> js.Array("blue", "underline")
  ))

  // outputs red text
  console.log("this is an error" <<= "error")

  // outputs yellow text
  console.log("this is a warning" <<= "warn")

  // should output blue underlined text -- does not currently work
  //console.log("this is a test" <<= "test")

}

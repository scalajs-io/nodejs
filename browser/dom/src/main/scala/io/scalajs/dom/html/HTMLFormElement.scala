package io.scalajs.dom.html

import scala.scalajs.js

/**
  * The HTMLFormElement interface provides methods to create and modify <form> elements.
  * document.forms - returns an array of HTMLFormElement objects referencing all forms on the page.
  * document.forms[index] - returns an HTMLFormElement object referencing the form at the specified index.
  * document.forms['id'] - returns an HTMLFormElement object referencing the form with the specified id.
  * document.forms['name'] - returns an HTMLFormElement object referencing the form with the specified name.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HTMLFormElement extends HTMLElement {

}

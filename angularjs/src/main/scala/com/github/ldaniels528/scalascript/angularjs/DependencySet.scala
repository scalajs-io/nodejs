package com.github.ldaniels528.nodesjs.angularjs

import scala.language.experimental.macros
import scala.language.implicitConversions
import scala.reflect.macros.blackbox
import scala.scalajs.js

/**
 * Dependency Set: an array of dependencies and an injection function
 * @example ["\$http", "\$log", "toaster", function(\$http, \$log, toaster) { ... }]
 * @author lawrence.daniels@gmail.com
 */
@inline
case class DependencySet(dependencies: js.Array[Any]) extends AnyVal

/**
 * Dependency Set Singleton
 * @author lawrence.daniels@gmail.com
 */
object DependencySet {

  @inline
  implicit def fn[R](f: => R): DependencySet = macro generate

  @inline
  implicit def fn[A, R](f: A => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, R](f: (A, B) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, R](f: (A, B, C) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, R](f: (A, B, C, D) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, R](f: (A, B, C, D, E) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, R](f: (A, B, C, D, E, F) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, R](f: (A, B, C, D, E, F, G) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, R](f: (A, B, C, D, E, F, G, H) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, R](f: (A, B, C, D, E, F, G, H, I) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, R](f: (A, B, C, D, E, F, G, H, I, J) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, R](f: (A, B, C, D, E, F, G, H, I, J, K) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, R](f: (A, B, C, D, E, F, G, H, I, J, K, L) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, T, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, T) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, T, U, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, T, U) => R): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, T, U, V, R](f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, S, T, U, V) => R): DependencySet = macro generate

  def generate(c: blackbox.Context)(f: c.Tree) = {
    import c.universe._

    val dpSetType = typeOf[DependencySet]
    val diArray = createFunctionDIArray(c)(f)
    q"""{
       import scala.scalajs.js
       new $dpSetType($diArray)
    }"""
  }

  private def createFunctionDIArray(c: blackbox.Context)(tree: c.Tree) = {
    import c.universe._

    val (f, params) = decodeFunction(c)(tree)
    val diNames = params.map(_._2.toString)
    q"js.Array(..$diNames, $f:js.Function)"
  }

  private def decodeFunction(c: blackbox.Context)(tree: c.Tree) = {
    import c.universe._

    val (m: Tree, params: List[ValDef]) = tree match {
      case q"(..$params) => $body" => (tree, params)
      case q"{(..$params) => $body}" => (tree.children.head, params)
    }
    val args = params.map { p =>
      val q"$mods val $name: $tpe = $rhs" = p
      (mods, name, tpe, rhs)
    }
    (m, args)
  }

}

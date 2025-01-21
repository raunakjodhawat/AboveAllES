package com.raunakjodhawat
package effect

trait EffectSystem[Effect[_]] {
  def apply[A](a: A): EffectSystem[Effect] = this
}

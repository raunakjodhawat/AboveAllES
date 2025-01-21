package com.raunakjodhawat
package effect.individual

import effect.EffectSystem

object Mixins {
  trait FlatMap[Effect[_], A] extends EffectSystem[Effect] {
    def flatMap[B](
        a: A,
        f: A => EffectSystem[Effect]
    ): EffectSystem[Effect]
  }

  trait Map[Effect[_], A] extends EffectSystem[Effect] {
    def map[B](a: A, f: A => B): EffectSystem[Effect]
  }
}

package com.raunakjodhawat
package effect.individual

import effect.EffectSystem

object Mixins {
  trait FlatMap[Effect[_], A] extends EffectSystem[Effect, A] {
    def flatMap[B](
        a: A,
        f: A => EffectSystem[Effect, B]
    ): EffectSystem[Effect, B]
  }

  trait Map[Effect[_], A] extends EffectSystem[Effect, A] {
    def map[B](a: A, f: A => EffectSystem[Effect, B]): EffectSystem[Effect, B]
  }
}

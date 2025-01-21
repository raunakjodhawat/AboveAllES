package com.raunakjodhawat

import com.raunakjodhawat.effect.EffectSystem
import monix.eval.Task
import com.raunakjodhawat.effect.individual.Mixins.*

@main
def main(): Unit = {
  trait myCustomEffectSystem[A] extends FlatMap[Task, A] with Map[Task, A]

  def monixEffectSystem[A] = new myCustomEffectSystem[A] {
    override def flatMap[B](a: A, f: A => EffectSystem[Task]): EffectSystem[Task] = f(a)

    override def map[B](a: A, f: A => B): EffectSystem[Task] = apply(f(a))
  }
}


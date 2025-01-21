package com.raunakjodhawat
package effect.individual

import effect.EffectSystem

object Mixins {
  trait FlatMap[Effect[_]] extends EffectSystem[Effect] {
    def flatMap[A, B](fa: Effect[A], f: A => B): Effect[B]
  }

  trait Map[Effect[_]] extends EffectSystem[Effect] {
    def map[A, B](fa: Effect[A], f: A => Effect[B]): Effect[B]
  }
  trait ParMap2[Effect[_]] extends EffectSystem[Effect] {
    def parMap2[A, B, C](
        fa: Effect[A],
        fb: Effect[B],
        f: (A, B) => C
    ): Effect[C]
  }
  trait Now[Effect[_]] extends EffectSystem[Effect] {
    def now[A](a: A): Effect[A]
  }
  trait Void[Effect[_]] extends EffectSystem[Effect] {
    def void[A](fa: Effect[A]): Effect[Unit]
  }
  trait RaiseError[Effect[_]] extends EffectSystem[Effect] {
    def raiseError[A](e: Throwable): Effect[A]
  }
  trait Apply[Effect[_]] extends EffectSystem[Effect] {
    def apply[A, B](fab: Effect[A => B], fa: Effect[A]): Effect[B]
  }
  trait Flatten[Effect[_]] extends EffectSystem[Effect] {
    def flatten[A](ffa: Effect[Effect[A]]): Effect[A]
  }
  trait ParSequenceUnordered[Effect[_]] extends EffectSystem[Effect] {
    def parSequenceUnordered[A](fas: Seq[Effect[A]]): Effect[Seq[A]]
  }
  trait RedeemWith[Effect[_]] extends EffectSystem[Effect] {
    def redeemWith[A, B](
        fa: Effect[A],
        recover: Throwable => Effect[B],
        bind: A => Effect[B]
    ): Effect[B]
  }

  trait When[Effect[_]] extends EffectSystem[Effect] {
    def when[A](cond: Boolean)(f: => Effect[A]): Effect[Unit]
  }

  trait RunToFuture[Effect[_], Future[_]] extends EffectSystem[Effect] {
    def runToFuture[A](fa: Effect[A]): Future[A]
  }
  trait RunSyncUnsafe[Effect[_]] extends EffectSystem[Effect] {
    def runSyncUnsafe[A](fa: Effect[A]): A
  }
  trait RunAsyncAndForget[Effect[_]] extends EffectSystem[Effect] {
    def runAsyncAndForget[A](fa: Effect[A]): Unit
  }

}

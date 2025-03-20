package com.raunakjodhawat
package effect

import scala.util.Try

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

  trait AndThen[Effect[_]] extends EffectSystem[Effect] {
    def andThen[A, B](fa: Effect[A], fb: Effect[B]): Effect[B]
  }

  trait AndThenLeft[Effect[_]] extends EffectSystem[Effect] {
    def andThenLeft[A, B](fa: Effect[A], fb: Effect[B]): Effect[A]
  }

  trait As[Effect[_]] extends EffectSystem[Effect] {
    def as[A, B](fa: Effect[A], b: B): Effect[B]
  }

  trait AsyncBoundary[Effect[_]] extends EffectSystem[Effect] {
    def asyncBoundary[A](fa: Effect[A]): Effect[A]
  }

  trait Attempt[Effect[_]] extends EffectSystem[Effect] {
    def attempt[A](fa: Effect[A]): Effect[Either[Throwable, A]]
  }

  trait Bracket[Effect[_]] extends EffectSystem[Effect] {
    def bracket[A, B](acquire: Effect[A])(use: A => Effect[B])(
        release: A => Effect[Unit]
    ): Effect[B]
  }

  trait Delay[Effect[_]] extends EffectSystem[Effect] {
    def delay[A](duration: Long)(fa: Effect[A]): Effect[A]
  }

  trait Materialize[Effect[_]] extends EffectSystem[Effect] {
    def materialize[A](fa: Effect[A]): Effect[Try[A]]
    def dematerialize[A](fa: Effect[Try[A]]): Effect[A]
  }

  trait DoOnCancel[Effect[_]] extends EffectSystem[Effect] {
    def doOnCancel[A](fa: Effect[A], callback: Effect[Unit]): Effect[A]
  }

  trait OnError[Effect[_]] extends EffectSystem[Effect] {
    def onErrorHandle[A](fa: Effect[A], f: Throwable => A): Effect[A]
    def onErrorFallbackTo[A](fa: Effect[A], fallback: Effect[A]): Effect[A]
  }

  trait Guarantee[Effect[_]] extends EffectSystem[Effect] {
    def guarantee[A](fa: Effect[A], finalizer: Effect[Unit]): Effect[A]
  }

  trait Memoize[Effect[_]] extends EffectSystem[Effect] {
    def memoize[A](fa: Effect[A]): Effect[A]
  }

  trait Timeout[Effect[_]] extends EffectSystem[Effect] {
    def timeout[A](fa: Effect[A], after: Long): Effect[A]
    def timeoutTo[A](fa: Effect[A], after: Long, backup: Effect[A]): Effect[A]
  }

  trait Restart[Effect[_]] extends EffectSystem[Effect] {
    def restart[A](fa: Effect[A], maxRetries: Long): Effect[A]
    def restartUntil[A](fa: Effect[A], p: A => Boolean): Effect[A]
  }

  trait Start[Effect[_], Fiber[_]] extends EffectSystem[Effect] {
    def start[A](fa: Effect[A]): Effect[Fiber[A]]
    def startAndForget[A](fa: Effect[A]): Effect[Unit]
  }

  trait Tap[Effect[_]] extends EffectSystem[Effect] {
    def tap[A, B](fa: Effect[A], f: A => Effect[B]): Effect[A]
    def tapError[A, B](fa: Effect[A], f: Throwable => Effect[B]): Effect[A]
  }

  trait Timed[Effect[_]] extends EffectSystem[Effect] {
    def timed[A](fa: Effect[A]): Effect[(Long, A)]
  }

  trait Uncancelable[Effect[_]] extends EffectSystem[Effect] {
    def uncancelable[A](fa: Effect[A]): Effect[A]
  }

  trait Redeem[Effect[_]] extends EffectSystem[Effect] {
    def redeem[A, B](
        fa: Effect[A],
        recover: Throwable => B,
        map: A => B
    ): Effect[B]
  }
}

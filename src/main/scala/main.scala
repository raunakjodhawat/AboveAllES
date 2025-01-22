package com.raunakjodhawat

//import monix.eval.Task
//import effect.Mixins.*
//
//@main
//def main(): Unit = {
//  trait MyEffectSystem[Effect[_]] extends FlatMap[Effect] with Map[Effect]
//
//  implicit val es: MyEffectSystem[Task] = new MyEffectSystem {
//    def flatMap[A, B](fa: Task[A], f: A => B): Task[B] = fa.map(f)
//    def map[A, B](fa: Task[A], f: A => Task[B]): Task[B] = fa.flatMap(f)
//  }
//}
//

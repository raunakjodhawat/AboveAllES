package com.raunakjodhawat

//import com.raunakjodhawat.effect.EffectSystem
//import monix.eval.Task
//import com.raunakjodhawat.effect.individual.Mixins.*
//
//@main
//def main(): Unit = {
//  trait MyEffectSystem[Effect[_]] extends FlatMap[Effect] with Map[Effect]
//
//  implicit class MonixTestClass[A](fa: Task[A])(implicit myEffectSystem: MyEffectSystem[Task]) {
//    def testMethod[B](f: A => B): Task[B] = myEffectSystem.flatMap(fa, f)
//  }
//  implicit val es: MyEffectSystem[Task] = new MyEffectSystem {
//    def flatMap[A, B](fa: Task[A], f: A => B): Task[B] = fa.map(f)
//    def map[A, B](fa: Task[A], f: A => Task[B]): Task[B] = fa.flatMap(f)
//  }
//  val a: Task[Int] = Task(1)
//  val b: Task[String] = Task("Hello")
//  import monix.execution.Scheduler.Implicits.global
//  a.testMethod(_ + 1).runAsync(s => println(s))
//}

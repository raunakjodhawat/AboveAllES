## Above All Event System

PS: This project is still in development, and the documentation and functionality is not complete.
> If you're creating a library based on scala. You shouldn't be limiting the users of your library to one of the three famous Event based system:
- Monix
- Cats Effect
- ZIO

Rather you can use AAES (Above All Event System) and perform a high-level mixins.

For example:
> As a library you can define the minimum number of mixins you want to support
```scala
  trait MyEffectSystem[Effect[_]] extends FlatMap[Effect] with Map[Effect]
```

> End user could create an implicit class but would need to provide implementation of required effect system
```scala
  implicit class MonixTestClass[A](fa: Task[A])(implicit myEffectSystem: MyEffectSystem[Task]) {
    def testMethod[B](f: A => B): Task[B] = myEffectSystem.flatMap(fa, f)
  }
  implicit val es: MyEffectSystem[Task] = new MyEffectSystem {
    def flatMap[A, B](fa: Task[A], f: A => B): Task[B] = fa.map(f)
    def map[A, B](fa: Task[A], f: A => Task[B]): Task[B] = fa.flatMap(f)
  }
  val a: Task[Int] = Task(1)
  import monix.execution.Scheduler.Implicits.global
  a.testMethod(_ + 1).runAsync(s => println(s))
```

That way, who ever is using your libary can individually select the Mixin they want to use.

### Contribution
PR's are welcome, if you want to connect with me, you can do so on [LinkedIn](https://www.linkedin.com/in/jodhawat/)



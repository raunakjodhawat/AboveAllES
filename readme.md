## Above All Event System

PS: This project is still in development, and the documentation and functionality is not complete.
> If you're creating a library based on scala. You shouldn't be limiting the users of your library to one of the three famous Event based system:
- Monix
- Cats Effect
- ZIO

Rather you can use AAES (Above All Event System) and perform a high-level mixins.

For example:
```scala
  trait myCustomEffectSystem[A] extends FlatMap[Task, A] with Map[Task, A]

  def monixEffectSystem[A] = new myCustomEffectSystem[A] {
    override def flatMap[B](a: A, f: A => EffectSystem[Task]): EffectSystem[Task] = f(a)

    override def map[B](a: A, f: A => B): EffectSystem[Task] = apply(f(a))
  }
```

That way, who ever is using your libary can individually select the Mixin they want to use.

### Contribution
PR's are welcome, if you want to connect with me, you can do so on [LinkedIn](https://www.linkedin.com/in/jodhawat/)



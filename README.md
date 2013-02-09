scala-macro-delegate
====================
scala-macro-delegate makes it possible to delegate to other methods without actually writing the delegation code.

The idea came up during a Scala User Group meetup after JFokus where we were discussing how Akka has
to maintain 2 APIs at the same time - an example would be `tell` and `!` (where `tell` is referred to as "Java API").
√ictor jokingly said that a `@delegate` annotation would be fun, I came back to this idea while me and my friend were waiting for our plane back home to Poland. Turns out it's doable and doesn't even look all too bad - see for yourself.

Usage
=====
The code will be on Maven central soon...

Examples
========

def ! = aliasFor { }
------------
There are two ways to delegate using macro-delegate. One of them is the `aliasFor` method:
```scala
// delegation code will be generated automatically

def tell(name: String) = ???

def !(name: String) = aliasFor { tell _ }```

![](docs/delegate1.png)

![](docs/delegate2.png)

@aliasFor(it _) def ! = delegated[ReturnType]
--------------------------------------

![](docs/delegate3.png)

![](docs/delegate4.png)

Nice error messages
-------------------
I tried to make it as safe as possible - thus the macro will abort compilation if it detects the types of the
delegator and delegate don't match, or if you forget to include the annotation when using `delegated` mode:

![](docs/compile_error.png)


Requirements
============

* Scala 2.10

Shameless plug
==============
I'm one of the leads of the Kraków Scala User Group (as well as JUG) - check out our meetups! http://krakowscala.pl

License
=======
I hereby release this under the **Apache 2 License**.

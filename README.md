Scala Zurich Meetup laboratory on PureConfig
===============

The laboratory consists of three exercises plus a special one (see at the end) ordered by difficulty.
The exercises can be found at [](src/test/scala/pureconfig/exercises/Spec.scala)
and are coded as scalatest tests. The goal of the exercises is to have all green tests
when `sbt test` is run.
The configuration file is provided under [](src/test/resources/references.conf) and
it's automatically loaded when `sbt test` is run.

For any information, please refer to [PureConfig README.md](https://github.com/pureconfig/pureconfig/blob/master/README.md).

### Contribute to the library, aka "the special exercise"

If you are interested in contributing to PureConfig, there are a couple of small issues to add support for
some datatypes:

1. Support for `java.time.Duration` [#210](https://github.com/pureconfig/pureconfig/issues/210)
2. Support for `java.io.File` [#211](https://github.com/pureconfig/pureconfig/issues/211)

To work on one of the issues:

- fork `https://github.com/pureconfig/pureconfig` on github
- clone the repository locally
- add the `ConfigReader` to `core/src/main/scala/pureconfig/BasicReaders.scala`
- add the `ConfigWriter` to `core/src/main/scala/pureconfig/BasicWriters.scala`
- add some tests
- make a PR :-)

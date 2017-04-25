import org.scalatest.{FlatSpec, Matchers}

import java.time.LocalDate

import pureconfig._

class Lab1 extends FlatSpec with Matchers {

  /* ==== Laboratory 1: try pureconfig  ====
  
   - create a configuration class with fields
     - name of type String
     - url of type java.net.URL
     - release of type String
   - load the configuration with loadConfigOrThrow and assign it to a conf value
   - uncomment all the tests and check that they pass
   */

  "loaded configuration" should "have name=pureconfig" in {
    // conf.name shouldEqual "pureconfig"
    ???
  }


  it should "have url=https://github.com/pureconfig/pureconfig" in {
    // conf.url shouldEqual new java.net.URL("https://github.com/pureconfig/pureconfig")
    ???
  }

  it should "have release=0.7.0" in {
    // conf.release shouldEqual "0.7.0"
    ???
  }
}

class Lab2 extends FlatSpec with Matchers {

  /* ==== Laboratory 2: configure reader for Date ====
     
     Some ConfigReaders require to be configured before they can be used.
     Those configurable ConfigReaders can be found in pureconfig.configurable._
     Try to configure the ConfigConvert for java.time.LocalDate and then use it.
     To do it, create an implicit val dateReader and assign to it the configured
     value. See https://github.com/pureconfig/pureconfig/blob/master/docs/configurable-converters.md#configurable-converters for more details about configurable instances.

     tip: formats for parsing LocalDate can be found in java.time.format.DateTimeFormatter.
          use ISO_LOCAL_DATE in this case
   */

  final case class Config(date: LocalDate)

  implicit val dateReader: ConfigConvert[LocalDate] = ???

  lazy val conf = loadConfigOrThrow[Config]("pureconfig.example")

  it should "have date=2017-04-02" in {
    conf.date shouldEqual LocalDate.of(2017, 4, 2)
  }
}

class Lab3 extends FlatSpec with Matchers {

  /* ==== Laboratory 3: create a custom config reader ====

     PureConfig behaviour can be customized by overriding the ConfigReader instances
     for a given class. In this laboratory we want to load the release into a special
     class called Release, defined below. The default behavior for case classes of
     PureConfig is to search for one key for each field, but we want to load a Version
     from a string with format "<major_version>.<minor_version>.<point_version>".
     Define a ConfigReader to read each part of the release such that the tests are green
   */

  final case class Release(major: Int, minor: Int, point: Int)
  final case class Config(release: Release)

  lazy val conf = loadConfigOrThrow[Config]("pureconfig.example")

  "conf" should "have release.major=0" in {
    conf.release.major shouldEqual 0
  }

  it should "have release.minor=7" in {
    conf.release.minor shouldEqual 7
  }

  it should "have release.point=0" in {
    conf.release.point shouldEqual 0
  }
}

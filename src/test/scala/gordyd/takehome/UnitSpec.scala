package gordyd.takehome

import org.scalatest._
import org.typelevel.scalatest.ValidationMatchers
import org.scalamock.scalatest.MockFactory

abstract class UnitSpec extends FlatSpec with Matchers with
OptionValues with Inside with Inspectors with ValidationMatchers with MockFactory

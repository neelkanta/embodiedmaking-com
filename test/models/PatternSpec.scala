package models

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class PatternSpec extends Specification {
  "Patterns" should {

    "be loaded without exceptions" in {
      running(FakeApplication()) {
        Pattern.all() must not be empty
      }
    }
  }
}

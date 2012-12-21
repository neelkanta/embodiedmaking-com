package controllers

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import models.{MethodSection, Pattern}

class ApplicationTest extends Specification {
  "respond to the index Action" in {
    val result = controllers.Application.index()(FakeRequest())

    status(result) must equalTo(OK)
  }

  "respond to the patterns action" in {
    running(FakeApplication()) {
      val result = controllers.Application.patterns()(FakeRequest())

      status(result) must equalTo(OK)
    }
  }

  "respond to the patterns detail action" in {
    running(FakeApplication()) {
      val result = controllers.Application.pattern(Pattern.all().head.id)(FakeRequest())

      status(result) must equalTo(OK)
    }
  }

  "respond to the method action" in {
    running(FakeApplication()) {
      val result = controllers.Application.method()(FakeRequest())

      status(result) must equalTo(OK)
    }
  }

  "respond to the method section action" in {
    running(FakeApplication()) {
      val result = controllers.Application.methodSection(MethodSection.all().head.id)(FakeRequest())

      status(result) must equalTo(OK)
    }
  }
}

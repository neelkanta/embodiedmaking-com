package controllers

import play.api.mvc._
import models.{MethodSlide, MethodSection, Pattern}

object Application extends Controller {

  def index = Action {
    Ok(views.html.index.render())
  }

  def ventures = Action {
    Ok(views.html.comingSoon.render("ventures"))
  }

  def method = Action {
    Ok(views.html.method.render(MethodSection.all()))
  }

  def methodSection(id: String) = Action {
    try {
      Ok(views.html.methodSection.render(MethodSection.all(), MethodSection.get(id), MethodSlide.all(id)))
    } catch {
      case e: Exception => Redirect("/method")
    }
  }

  def patterns = Action {
    Ok(views.html.patterns.render(Pattern.all()))
  }

  def pattern(id: String) = Action {
    try {
      Ok(views.html.pattern.render(Pattern.all(), Pattern.get(id)))
    } catch {
      case e: Exception => Redirect("/patterns")
    }
  }

  def vision = Action {
    Ok(views.html.comingSoon.render("vision"))
  }

  def contact = Action {
    Ok(views.html.comingSoon.render("contact"))
  }
}
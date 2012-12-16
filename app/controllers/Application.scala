package controllers

import play.api.mvc._
import models.Pattern

object Application extends Controller {

  def index = Action {
    Ok(views.html.index.render())
  }

  def ventures = Action {
    Ok(views.html.comingSoon.render("ventures"))
  }

  def method = Action {
    Ok(views.html.method.render())
  }

  def patterns = Action {
    Ok(views.html.patterns.render(Pattern.all()))
  }

  def pattern(id: String) = Action {
    Ok(views.html.pattern.render(Pattern.all(), Pattern.get(id)))
  }

  def vision = Action {
    Ok(views.html.comingSoon.render("vision"))
  }

  def contact = Action {
    Ok(views.html.comingSoon.render("contact"))
  }
}
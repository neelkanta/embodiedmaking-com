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

  def vision = Action {
    Ok(views.html.comingSoon.render("vision"))
  }

  def contact = Action {
    Ok(views.html.comingSoon.render("contact"))
  }
}
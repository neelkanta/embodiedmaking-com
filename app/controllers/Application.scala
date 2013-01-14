package controllers

import play.api.mvc._
import models._

object Application extends Controller with ProvidesRequestInfo {

  def index = UserAwareAction { implicit request =>
    Ok(views.html.index())
  }

  def ventures = UserAwareAction { implicit request =>
    Ok(views.html.comingSoon("ventures"))
  }

  def method = UserAwareAction { implicit request =>
    Ok(views.html.method(MethodSection.all()))
  }

  def methodSection(id: String) = UserAwareAction { implicit request =>
    try {
      Ok(views.html.methodSection(MethodSection.all(), MethodSection.get(id), MethodSlide.all(id)))
    } catch {
      case e: Exception => Redirect("/method")
    }
  }

  def patterns = UserAwareAction { implicit request =>
    Ok(views.html.patterns(Pattern.all()))
  }

  def pattern(id: String) = UserAwareAction { implicit request =>
    try {
      Ok(views.html.pattern(Pattern.all(), Pattern.get(id)))
    } catch {
      case e: Exception => Redirect("/patterns")
    }
  }

  def vision = UserAwareAction { implicit request =>
    Ok(views.html.comingSoon("vision"))
  }

  def contact = UserAwareAction { implicit request =>
    Ok(views.html.comingSoon("contact"))
  }
}
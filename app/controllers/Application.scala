package controllers

import play.api.mvc._
import models._
import securesocial.core.SecureSocial

object Application extends Controller with ProvidesRequestInfo {

  def index = UserAwareAction { implicit request =>
    Ok(views.html.index()).withSession(storeUri(request))
  }

  def ventures = UserAwareAction { implicit request =>
    Ok(views.html.comingSoon("ventures")).withSession(storeUri(request))
  }

  def method = UserAwareAction { implicit request =>
    Ok(views.html.method(MethodSection.all())).withSession(storeUri(request))
  }

  def methodSection(id: String) = UserAwareAction { implicit request =>
    try {
      Ok(views.html.methodSection(MethodSection.all(), MethodSection.get(id), MethodSlide.all(id))).withSession(storeUri(request))
    } catch {
      case e: Exception => Redirect("/method").withSession(storeUri(request))
    }
  }

  def patterns = UserAwareAction { implicit request =>
    Ok(views.html.patterns(Pattern.all())).withSession(storeUri(request))
  }

  def pattern(id: String) = UserAwareAction { implicit request =>
    try {
      Ok(views.html.pattern(Pattern.all(), Pattern.get(id))).withSession(storeUri(request))
    } catch {
        case e: Exception => Redirect("/patterns").withSession(storeUri(request))
    }
  }

  def vision = UserAwareAction { implicit request =>
    Ok(views.html.comingSoon("vision")).withSession(storeUri(request))
  }

  def contact = UserAwareAction { implicit request =>
    Ok(views.html.comingSoon("contact")).withSession(storeUri(request))
  }

  private def storeUri(request: Request[Any]) : Session = {
    request.session + (SecureSocial.OriginalUrlKey -> request.uri)
  }
}
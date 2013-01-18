package controllers

import play.api.mvc._
import models._
import securesocial.core.SecureSocial

object Application extends Controller with SecureSocial {

  def index = UserAwareAction { implicit request =>
    Ok(views.html.index())
  }

  def ventures = UserAwareAction { implicit request =>
    Ok(views.html.ventures()).withSession(storeUri(request))
  }

  def method = UserAwareAction { implicit request =>
    Ok(views.html.method(MethodSection.all())).withSession(storeUri(request))
  }

  def methodSection(id: String) = UserAwareAction { implicit request =>
    Ok(views.html.methodSection(MethodSection.all(), MethodSection.get(id), MethodSlide.all(id))).withSession(storeUri(request))
  }

  def patterns = UserAwareAction { implicit request =>
    Ok(views.html.patterns(Pattern.all())).withSession(storeUri(request))
  }

  def pattern(id: String) = SecuredAction { implicit request =>
    Ok(views.html.pattern(Pattern.all(), Pattern.get(id))).withSession(storeUri(request))
  }

  def contact = UserAwareAction { implicit request =>
    Ok(views.html.contact()).withSession(storeUri(request))
  }

  private def storeUri(request: Request[Any]) : Session = {
    request.session + (SecureSocial.OriginalUrlKey -> request.uri)
  }
}
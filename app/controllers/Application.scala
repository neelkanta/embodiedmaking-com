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

  def venture(id: String) = UserAwareAction { implicit request =>
    Ok(views.html.venture(Venture.get(id))).withSession(storeUri(request))
  }

  def method = UserAwareAction { implicit request =>
    Ok(views.html.method(MethodSection.all())).withSession(storeUri(request))
  }

  def methodSection(id: String) = UserAwareAction { implicit request =>
    Ok(views.html.methodSection(MethodSection.all(), MethodSection.get(id), MethodSlide.all(id))).withSession(storeUri(request))
  }

  def patternsOverview = UserAwareAction { implicit request =>
    Ok(views.html.patternLanguages(PatternLanguage.get("plm"))).withSession(storeUri(request))
  }

  def patterns(language: String) = UserAwareAction { implicit request =>
    Ok(views.html.patterns(PatternLanguage.get(language))).withSession(storeUri(request))
  }

  def pattern(language: String, id: String) = SecuredAction { implicit request =>
    val patternLanguage: PatternLanguage = PatternLanguage.get(language)
    Ok(views.html.pattern(patternLanguage, patternLanguage.getPattern(id))).withSession(storeUri(request))
  }

  def contact = UserAwareAction { implicit request =>
    Ok(views.html.contact()).withSession(storeUri(request))
  }

  private def storeUri(request: Request[Any]) : Session = {
    request.session + (SecureSocial.OriginalUrlKey -> request.uri)
  }
}
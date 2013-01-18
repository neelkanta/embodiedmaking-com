package views.auth

import play.api.mvc.Request
import play.api.templates.Html
import play.api.Application
import play.api.data.Form
import securesocial.controllers.DefaultTemplatesPlugin

class AuthViews(application: Application) extends DefaultTemplatesPlugin(application) {
  override def getLoginPage[A](implicit request: Request[A], form: Form[(String, String)], msg: Option[String] = None): Html = {
    views.html.login(form, msg)
  }
}
package controllers

import play.api._
import play.api.mvc._

object Pages extends Controller {

  def privacyPolicy = Action { request =>
    Ok(views.html.pages.privacyPolicy())
  }

  def about = Action { request =>
    Ok(views.html.pages.about())
  }

  def contact = Action { request =>
    Ok(views.html.pages.contact())
  }

  def fontAttribution = Action { request =>
    Ok(views.html.pages.fontAttribution())
  }
}

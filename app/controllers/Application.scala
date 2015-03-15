package controllers

import play.api._
import play.api.mvc._
import models.MobileApplication

object Application extends Controller {

  def index = Action {
//    val latest = models.MobileApplication.find.all().get(0)
//    TODO: stub data
    var app = MobileApplication.apps
    Ok(views.html.index("Enye Interactive",app.get(0)))
  }

}

package controllers

import play.api.mvc.{Action, Controller}
import models._
import play.api.db.slick.Config.driver.simple._

object SeedController extends Controller {
  def ask = Action { request =>
    Ok(views.html.extras.ask)
  }
}

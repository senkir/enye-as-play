package controllers

import play.api.mvc.{Action, Controller}
import models._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import scala.util.Random
import play.api.mvc.Flash
import java.sql.Timestamp
import play.api.Logger

object SeedController extends Controller {

  def ask = Action { request =>
    Ok(views.html.extras.ask(request.flash))
  }

  def apply = DBAction { implicit request =>
    val rand = new Random()
    val count = Model.platforms.list.size
    if (rand.nextBoolean() || count > 0) {
      Logger.debug(s"seed apply success")
      // Models.platforms += Platform(None, "Android", None, None)
      // Models.platforms += Platform(None, "iOS", None, None)
      Redirect(routes.SeedController.ask()).flashing("success" -> "done!")
    } else {
      Logger.debug(s"seed apply faliure")
      Redirect(routes.SeedController.ask()).flashing("error" -> "seed data has already been applied!")
    }
  }
}

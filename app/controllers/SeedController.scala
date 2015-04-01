package controllers

import play.api.mvc.{Action, Controller}
import models._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.mvc.Flash
import java.sql.Timestamp
import play.api.Logger

object SeedController extends Controller {

  def ask = Action { request =>
    Ok(views.html.extras.ask(request.flash))
  }

  def apply = DBAction { implicit request =>
    val list = Model.platforms.list
    Logger.debug(s"seed count $list ")
    if (list.isEmpty) {
      Logger.debug(s"seed apply success")
      val now = System.currentTimeMillis
      val time = new Timestamp(now)
      val nowStamp = Some(time)
      Model.platforms += Platform(None, "Android", nowStamp, nowStamp)
      Model.platforms += Platform(None, "iOS", nowStamp, nowStamp)
      Redirect(routes.SeedController.ask()).flashing("success" -> "done!")
    } else {
      Logger.debug(s"seed apply faliure")
      Redirect(routes.SeedController.ask()).flashing("error" -> "seed data has already been applied!")
    }
  }
}

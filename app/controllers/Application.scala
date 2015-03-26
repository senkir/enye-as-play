package controllers

import play.api._
import play.api.mvc._
import models._
import scala.slick.lifted.TableQuery
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.Play.current


object Application extends Controller {

  def home = DBAction { implicit rs =>
    val app = Model.products.list
    Ok(views.html.index("Enye Interactive",app))
  }


}

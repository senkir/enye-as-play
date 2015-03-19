package controllers

import play.api._
import play.api.mvc._
import models.Products
import scala.slick.lifted.TableQuery
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.Play.current


object Application extends Controller {

  val products = TableQuery[Products]
  
  def home = DBAction { implicit rs =>
    val app = products.list
    Ok(views.html.index("Enye Interactive",app))
  }


}

package controllers

import play.api._
import play.api.mvc._
import models.database.Products
import scala.slick.lifted.TableQuery

object Application extends Controller {

  def home = Action { implicit rs =>
    val products = TableQuery[Products]
    var app = products.find
    Ok(views.html.index("Enye Interactive",app(0)))
  }

}

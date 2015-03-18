package controllers

import play.api._
import play.api.mvc._
import models.database.Products
import scala.slick.lifted.TableQuery

object Application extends Controller {

  def home = Action { request =>
    val products = TableQuery[Products]
    var app = products.all
    Ok(views.html.index("Enye Interactive",app(0)))
  }

}

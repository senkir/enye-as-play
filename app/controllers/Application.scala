package controllers

import play.api._
import play.api.mvc._
import models._
import scala.slick.lifted.TableQuery
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.Play.current
import java.sql.Timestamp


object Application extends Controller {

  def home = DBAction { implicit rs =>
    val app = Model.products.list
    var stamp = new Timestamp(System.currentTimeMillis)
    val featured = Product(None,"Kelvim", 0, "1.0.2", 
      Some("Kelvim is an easy way to show the weather in <a href=”http://en.wikipedia.org/wiki/Kelvin”>Kelvin</a>.  Featuring friendly weather indicators and color coding to help you transition to a Kelvin world.  Designed in collaboration with <a href=http://ramiro.mx>Ramiro Franco</a> with weather data provided by <a href=http://www.wunderground.com/>Weather Undeground</a>.  "), "https://play.google.com/store/apps/details?id=com.spidermuffin.kelvim", None, None)

    Ok(views.html.index("Enye Interactive",featured, app))
  }


}

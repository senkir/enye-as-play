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
      Some("Cupcake ipsum dolor. Sit amet ice cream wafer pudding marshmallow tiramisu jujubes. Jujubes cotton candy cotton candy tart sweet roll. Pastry sweet chocolate cake bonbon bonbon pie. Croissant marzipan cookie carrot cake fruitcake marshmallow. Chocolate dragée gummies chocolate cake icing gingerbread powder biscuit. Powder candy ice cream. Donut ice cream pudding cake muffin marshmallow pastry topping. \t Liquorice jelly chocolate bar sugar plum gingerbread sugar plum jelly-o. Brownie jelly-o gingerbread caramels. Sugar plum powder bonbon. Lollipop gummi bears bear claw candy chocolate sweet macaroon. Tootsie roll pastry lemon drops. Ice cream pie jelly beans sesame snaps pie marshmallow cupcake jelly beans."), "https://play.google.com/store/apps/details?id=com.spidermuffin.kelvim", None, None)

    Ok(views.html.index("Enye Interactive",featured, app))
  }


}

package controllers

import play.api.mvc.{Action, Controller}
import scala.collection.JavaConverters._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import scala.slick.lifted.TableQuery
import views.html.helper._
import play.api.data._
import play.api.data.Forms._
import models._
import play.api.Play.current

/**
 * Created by tcastillo on 2/26/15.
 */
object ProductsController extends Controller {
  case class ProductData(name: String, platform: String, version: String, desc: String)

  val productForm = Form(
    mapping(
      "name" -> text,
      "platform" -> text,
      "version" -> text,
      "description" -> text
    )(ProductData.apply)(ProductData.unapply)
  )

  val products = TableQuery[Products]

  def list = DBAction { implicit request =>
    val allProducts = products.list
    Ok(views.html.products.list(allProducts))
  }

  def create = Action {request =>
    Ok(views.html.products.create(productForm))
  }

  def submit = DBAction { implicit request =>
    //bind form request
    productForm.bindFromRequest().fold(
      formWithErrors => {
        BadRequest(views.html.products.create(formWithErrors))
      },
      productData => {
        //success
        val newProduct = Product(None, productData.name, productData.platform, productData.version, productData.desc, "2014-07-09", "2014-07-09")
        products += newProduct
        Redirect(routes.ProductsController.list)
      })
  }

  def show(id: Long) = DBAction { implicit request =>
    val product = products.filter(_.id === id).first
    Ok(views.html.products.show(product))
  }

  def edit(id: Long) = Action{ request =>
    NotImplemented
  }

  def update(id: Long) = Action {request =>

    NotImplemented
  }

  def delete(id: Long) = Action { request =>

    NotImplemented 
  }
}

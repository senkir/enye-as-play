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
import play.api.mvc.Flash

/**
 * Created by tcastillo on 2/26/15.
 */
object ProductsController extends Controller {
  case class ProductData(name: String, platform: String, version: String, desc: String)

  val productForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "platform" -> nonEmptyText,
      "version" -> nonEmptyText,
      "description" -> nonEmptyText
    )(ProductData.apply)(ProductData.unapply)
  )

  val products = TableQuery[Products]

  def list = DBAction { implicit request =>
    val allProducts = products.list
    Ok(views.html.products.list(allProducts))
  }

  def create = Action { request =>
    val form = if (request.flash.get("error").isDefined)
      productForm.bind(request.flash.data)
    else
      productForm
    Ok(views.html.products.create(form)(request.flash))
  }

  def submit = DBAction { implicit request =>
    //bind form request
    val newForm = productForm.bindFromRequest()
    newForm.fold(
      hasErrors = { form =>
        Redirect(routes.ProductsController.create()).flashing(Flash(form.data) +
          ("error" -> "something bad happened"))
      },
      success = { productData =>
        //success
        val newProduct = Product(None, productData.name, productData.platform, productData.version, productData.desc, "2014-07-09", "2014-07-09")
        products += newProduct
        Redirect(routes.ProductsController.list).
          flashing("success" -> "success!")
      })
  }

  def show(id: Long) = DBAction { implicit request =>
    val product = products.filter(_.id === id).first
    Ok(views.html.products.show(product))
  }

  def edit(id: Long) = DBAction{ implicit request =>
    val product = products.filter(_.id === id).first
    val filledData = new ProductData(product.name, product.platform, product.version, product.description)
    val filledForm = productForm.fill(filledData)
    Ok(views.html.products.edit(product,filledForm))
  }

  def update(id: Long) = DBAction {implicit request =>
    productForm.fold(
    hasErrors = { form =>
      Redirect(routes.ProductsController.edit(id)).flashing(Flash(form.data) +
        ("error" -> "something bad happened"))
    }, 
    success = { productData =>
      var product = products.filter(_.id === id).first
      product.name = productData.name
      products.save(product)
      Ok(views.html.products.show(product.id))
    })
      
  }

  def delete(id: Long) = Action { request =>

    NotImplemented 
  }
}

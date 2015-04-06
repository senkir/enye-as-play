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
import java.sql.Timestamp
import play.api.Logger

/**
 * Created by tcastillo on 2/26/15.
 */
object ProductsController extends Controller {
  case class ProductData(name: String, platformId: Seq[(String)], version: String, desc: Option[String])

  val productForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "platformId[]" -> seq(text),
      "version" -> nonEmptyText,
      "description" -> optional(text)
    )(ProductData.apply)(ProductData.unapply)
  )

  def list = DBAction { implicit request =>
    val allProducts = Model.products.list
    Ok(views.html.products.list(allProducts))
  }

  def getPlatformsSeq(implicit session:Session) = {
    val platforms = Model.platforms.list
    var toReturn = Seq[(String,String)]()
    var x = 0
    for ( x <- 0 to platforms.size - 1) {
      var platform = platforms(x)
      toReturn = toReturn :+ x.toString -> platforms(x).name
    }
    toReturn
  }

  def create = DBAction { implicit request =>
    val platforms = getPlatformsSeq

    val form = if (request.flash.get("error").isDefined)
      productForm.bind(request.flash.data)
    else
      productForm
    Ok(views.html.products.create(form,platforms)(request.flash))
  }

  def submit = DBAction { implicit request =>
    //bind form request
    val newForm = productForm.bindFromRequest()
    Logger.debug(s"Forms newForm=${newForm.toString}")
    newForm.fold(
      hasErrors = { form =>
        val firstError = newForm.errors(0)
        Logger.debug(s"Form Errors: ${firstError.key} ${firstError.message}")
        val message = "something bad happened" + newForm.errors.toString
        Redirect(routes.ProductsController.create()).flashing(Flash(form.data) +
          ("error" -> message))
      },
      success = { productData =>
        //success
        Logger.debug(s"Form Platform Seq ${productData.platformId.toString}")
        val newProduct = Product(None, productData.name, productData.platformId(0).toInt, productData.version, productData.desc, None, None)
        Model.products += newProduct
        Redirect(routes.ProductsController.list).
          flashing("success" -> "success!")
      })
  }

  def show(id: Long) = DBAction { implicit request =>
    val product = Model.products.filter(_.id === id).first
    val platform = Model.platforms.filter(_.id === product.platformId).first
    Ok(views.html.products.show(product, platform))
  }

  def edit(id: Long) = DBAction{ implicit request =>
    val product = Model.products.filter(_.id === id).first
    val filledData = new ProductData(product.name, Seq(product.platformId.toString), product.version, product.description)
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
      Model.products.filter(_.id === id)
        .map(p => ( p.name, p.platformId, p.version, p.description, p.updatedAt, p.createdAt))
        .update(productData.name, productData.platformId(0).toInt, productData.version, productData.desc, Some(new Timestamp(System.currentTimeMillis)), None)
      Redirect(routes.ProductsController.show(id))
    })
      
  }

  def delete(id: Long) = Action { request =>

    NotImplemented 
  }
}

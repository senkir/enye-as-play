package controllers

import play.api.mvc.{Action, Controller}
import scala.collection.JavaConverters._
import views.html.helper._
import play.api.data._
import play.api.data.Forms._
import models.Product

/**
 * Created by tcastillo on 2/26/15.
 */
object Products extends Controller {
  case class ProductFormModel(name: String, platform: String, description: String)

  val productForm = Form(
    mapping(
      "name" -> text,
      "platform" -> text,
      "description" -> text
    )(ProductFormModel.apply)(ProductFormModel.unapply)
  )

  def list = Action { request =>
//    val apps = models.MobileApplication.find.all().asScala
   NotImplemented
  }

  def show(id: Long) = Action {request =>

    NotImplemented
  }

  def create = Action {request =>
    Ok(views.html.products.create(productForm))
  }

  def submit = Action {
    println("submit")
    NotImplemented
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

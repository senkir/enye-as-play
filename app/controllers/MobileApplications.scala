package controllers

import play.api.mvc.{Action, Controller}
import scala.collection.JavaConverters._

/**
 * Created by tcastillo on 2/26/15.
 */
object MobileApplications extends Controller {

  def list = Action { request =>
//    val apps = models.MobileApplication.find.all().asScala
   NotImplemented
  }

  def show(id: Long) = Action {request =>

    NotImplemented
  }

  def create = Action {request =>

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

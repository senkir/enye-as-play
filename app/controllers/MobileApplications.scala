package controllers

import play.api.mvc.{Action, Controller}
import scala.collection.JavaConverters._

/**
 * Created by tcastillo on 2/26/15.
 */
object MobileApplications extends Controller {

  def list = Action {
//    val apps = models.MobileApplication.find.all().asScala
    Ok{views.html.mobileApplicationsList("MobileApplication", null)}
  }

  def show(id: Long) = Action {
    Ok{views.html.mobileApplicationsList("MobileApplication", null)}
      
  }

  def create = Action {
 Ok{views.html.mobileApplicationsList("MobileApplication", null)}
    
  }

  def update(id: Long) = Action {
 Ok{views.html.mobileApplicationsList("MobileApplication", null)}
    
  }

  def delete(id: Long) = Action {
  Ok{views.html.mobileApplicationsList("MobileApplication", null)}
       
  }
}

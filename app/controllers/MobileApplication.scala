package controllers

import play.api.mvc.{Action, Controller}
import scala.collection.JavaConverters._

/**
 * Created by tcastillo on 2/26/15.
 */
object MobileApplication extends Controller {

  def index = Action {
//    val apps = models.MobileApplication.find.all().asScala
    Ok{views.html.mobileApplicationsList("MobileApplication", null)}
  }

  def show = Action {
    Ok{views.html.mobileApplicationsList("MobileApplication", null)}
      
  }

  def create = Action {
 Ok{views.html.mobileApplicationsList("MobileApplication", null)}
    
  }

  def update = Action {
 Ok{views.html.mobileApplicationsList("MobileApplication", null)}
    
  }

  def delete = Action {
  Ok{views.html.mobileApplicationsList("MobileApplication", null)}
       
  }
}

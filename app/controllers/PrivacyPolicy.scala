package controllers

object PrivacyPolicy extends Controller {
  def index = Action {
    Ok(views.html.index())
  }
}

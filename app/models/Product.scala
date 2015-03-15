package models

import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB
import models.database.Products

object Product extends TableQuery(new Products(_)) {

}

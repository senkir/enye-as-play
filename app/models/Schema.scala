package models

import play.api.db.slick.Config.driver.simple._
import scala.slick.jdbc.JdbcBackend

object Model {
  val platforms = TableQuery[Platforms]
  val products = TableQuery[Products]
}

package models

import models.Products

import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB
import scala.slick.session.Session

case class Product(id: Option[Long], name: String)


object Product {

  val table = new Products

  def find: List[(Long, String)] = DB.withSession { implicit session: Session =>
    Query(table).list
  }

  def findNames: List[String] = Db.withSession { implicit session: Session =>
    Query(table).map(_.name).list
  }
}

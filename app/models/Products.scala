package models

import play.api.db.slick.Config.driver.simple._
import scala.slick.jdbc.JdbcBackend

case class Product(id: Long, name: String, platform: String, version: String, description: Option[String], updatedAt: String, createdAt: String)

/**
 * A released application
 * Created by tcastillo on 2/12/15.
 */
class Products(tag: Tag) extends Table[Product](tag, "PRODUCTS") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  def platform = column[String]("PLATFORM")
  def version = column[String]("VERSION")
  def description = column[Option[String]]("DESCRIPTION")
  def updatedAt = column[String]("UPDATED_AT")
  def createdAt = column[String]("CREATED_AT")
  def * = (id, name, platform, version, description,updatedAt,createdAt) <> (Product.tupled, Product.unapply)
}


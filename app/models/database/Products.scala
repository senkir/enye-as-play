package models.database

import play.api.db.slick.Config.driver.simple._
import models.Product

/**
 * A released application
 * Created by tcastillo on 2/12/15.
 */
case class Product(id: Option[Long], name: String)

class Products(tag: Tag) extends Table[Product](tag, "PRODUCTS") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  def platform = column[String]("PLATFORM")
  def versionName = column[String]("VERSION")
  def description = column[Option[String]]("DESCRIPTION")
  def updatedAt = column[String]("UPDATED_AT")
  def createdAt = column[String]("CREATED_AT")
  def * = (id, name, platform, versionName, description)
}

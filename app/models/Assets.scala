package models

import play.api.db.slick.Config.driver.simple._

case class Asset(id: Long, name: String, productId: Long, url: String, updatedAt: String, createdAt: String)

class Assets(tag: Tag) extends Table[Asset](tag, "ASSETS") {
  def id = column[Long]("ID")
  def name = column[String]("NAME")
  def productId = column[Long]("PRODUCT_ID")
  def url = column[String]("URL")
  def updatedAt = column[String]("UPDATED_AT")
  def createdAt = column[String]("CREATED_AT")
  def * = (id, name, productId, url, updatedAt, createdAt) <> (Asset.tupled, Asset.unapply)
}

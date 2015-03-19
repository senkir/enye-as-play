package models

import play.api.db.slick.Config.driver.simple._

case class Platform(id: Long, name: String, updatedAt: String, createdAt: String)

class Platforms(tag: Tag) extends Table[Platform](tag, "PLATFORMS") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  def updatedAt = column[String]("UPDATED_AT")
  def createdAt = column[String]("CREATED_AT")
  def * = (id, name, updatedAt, createdAt) <> (Platform.tupled, Platform.unapply)
}


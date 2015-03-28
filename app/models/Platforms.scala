package models

import play.api.db.slick.Config.driver.simple._
import java.sql.Timestamp

case class Platform(id: Option[Long], name: String, updatedAt: Option[Timestamp], createdAt: Option[Timestamp])

class Platforms(tag: Tag) extends Table[Platform](tag, "PLATFORMS") {
  def id = column[Option[Long]]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  def updatedAt = column[Option[Timestamp]]("UPDATED_AT", O.NotNull, O.DBType("timestamp default now()"))
  def createdAt = column[Option[Timestamp]]("CREATED_AT", O.NotNull, O.DBType("timestamp default now()"))
  def * = (id, name, updatedAt, createdAt) <> (Platform.tupled, Platform.unapply)
}



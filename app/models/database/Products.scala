package models.database

import play.api.db.slick.Config.driver.simple._

/**
 * A released application
 * Created by tcastillo on 2/12/15.
 */

class Products extends Table[(Long,Sring)]("PRODUCT") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  def platform = column[String]("PLATFORM")
  def versionName = column[String]("VERSION_NAME")
  def description = column[Option[String]]("DESCRIPTION")h
  def updatedAt = column[String]("UPDATED_AT")
  def createdAt = column[String]("UPDATED_AT")
  def * = id ~ name ~ platform ~ versionName ~ updatedAt ~ createdAt
}

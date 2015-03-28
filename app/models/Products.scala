package models

import play.api.db.slick.Config.driver.simple._
import java.sql.Timestamp

case class Product(id: Option[Long], name: String, platformId: Long, version: String, description: Option[String], updatedAt: Option[Timestamp], createdAt: Option[Timestamp]) {
  // def platform(implicit s: Session) = platforms.filter(_.id === platformId).first 
}
  /**
   * A released application
   * Created by tcastillo on 2/12/15.
   */
class Products(tag: Tag) extends Table[Product](tag, "PRODUCTS") {
  // class Products(tag: Tag) extends Table[Long, String, String, String, Option[String], String, String](tag, "PRODUCTS") {
    def id = column[Option[Long]]("ID", O.PrimaryKey, O.AutoInc)
    def name = column[String]("NAME")
    def platformId = column[Long]("PLATFORM_ID")
    def version = column[String]("VERSION")
    def description = column[Option[String]]("DESCRIPTION")
    def updatedAt = column[Option[Timestamp]]("UPDATED_AT", O.NotNull, O.DBType("timestamp default now()"))
    def createdAt = column[Option[Timestamp]]("CREATED_AT", O.NotNull, O.DBType("timestamp default now()"))
    def * = (id, name, platformId, version, description,updatedAt,createdAt) <> (Product.tupled, Product.unapply)
    
    // def platform = foreignKey("PLATFORM_FK", platformId, platforms)(_.id.get)
  }



package models

import javax.persistence.{Id, Entity}

import play.api.data.validation.Constraint
import play.data.format.Formats
import play.data.validation.Constraints
import play.db.ebean.Model
import play.db.ebean.Model.Finder

import scala.Long

/**
 * Created by tcastillo on 2/12/15.
 */
@Entity
class MobileApplication extends Model {

  @Id
  var id: Long = 0

  @Constraints.Required
  var name: String = null
  var versionName: String = null
  @Formats.DateTime(pattern="dd/MM/YYY")
  var updatedAt: String = null
  @Formats.DateTime(pattern="dd/MM/YYY")
  var createdAt: String = null

  def find: Model.Finder[Long,MobileApplication] = new Finder[Long,MobileApplication](classOf[Long], classOf[MobileApplication])

}

package models

import javax.persistence.{Id, Entity}

import play.api.data.validation.Constraint
import play.data.format.Formats
import play.data.validation.Constraints
import play.db.ebean.Model
import play.db.ebean.Model.Finder

import scala.Long
import scala.collection.mutable.ListBuffer

/**
 * A released application
 * Created by tcastillo on 2/12/15.
 */
@Entity

object MobileApplication {
  var apps:List[MobileApplication] = List(new MobileApplication("kelvim", 0))

  var find: Model.Finder[Long,MobileApplication] = new Finder[Long,MobileApplication](classOf[Long], classOf[MobileApplication])
}


class MobileApplication(@Constraints.Required var name: String,
                       @Id var id: Long = 0,
                       @Constraints.Required var platform: String = "Android",
                       var versionName: String = null,
                       var preview: Boolean = false,
                       @Formats.DateTime(pattern="dd/MM/YYY") var updatedAt: String = null,
                       @Formats.DateTime(pattern="dd/MM/YYY") var createdAt: String = null) extends Model {

}

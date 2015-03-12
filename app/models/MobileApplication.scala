package models

/**
 * A released application
 * Created by tcastillo on 2/12/15.
 */
object MobileApplication {
  var apps:List[MobileApplication] = List(new MobileApplication("kelvim", 0))

}

case class MobileApplication(
                              var name: String,
                              var id: Long = 0,
                              var platform: String = "Android",
                              var versionName: String = null,
                              var preview: Boolean = false,
                              var updatedAt: String = null,
                              var createdAt: String = null)

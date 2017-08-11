package controllers.Frontend

import javax.inject._
import play.api.mvc._
import play.api.db._
/**
  * Created by phongvt on 6/23/17.
  */
@Singleton
class FrontendController @Inject() (db: Database) extends Controller{
  def index = Action {
    Redirect(controllers.Backend.routes.BackendController.login())
  }
  def homepage = Action {
    Ok(views.html.frontend.index("Hello Phong dai ca"))
  }
  def testdb = Action {
    var outstring: String = ""
    val conn = db.getConnection()
    try {
      val stmt = conn.createStatement()
      val rs = stmt.executeQuery("Select * from users")
      while (rs.next()) {
        outstring += rs.getString("email") + "\n"
        println(rs.getString("email"))
      }
    } finally {
      conn.close()
    }
    Ok(outstring)
  }
}

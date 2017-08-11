package controllers.Frontend

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, Controller}
import play.api.db.{Database, NamedDatabase}

@Singleton
class TestdbController @Inject() (@NamedDatabase("slave") db:Database) extends Controller {

  def testslavedb = Action {
    var outstring: String = ""
    val conn = db.getConnection()
    try {
      val stmt = conn.createStatement()
      val rs = stmt.executeQuery("Select * from order_tb")
      while (rs.next()) {
        outstring += rs.getString("name") + " created time: " + rs.getString("created_time")+"\n"
        println(rs.getString("name"))
      }
    } finally {
      conn.close()
    }
    Ok(outstring)
  }
}

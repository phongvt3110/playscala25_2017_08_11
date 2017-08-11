package controllers.Backend

import javax.inject._

import play.api.mvc._
import scalikejdbc._
/**
  * Created by phongvt on 6/23/17.
  */
@Singleton
class BackendController @Inject() extends Controller {
  Class.forName("com.mysql.jdbc.Driver")
  scalikejdbc.ConnectionPool.singleton("jdbc:mysql://127.0.0.1/play25","root","livet")

  def index = Action {
    Ok(views.html.backend.index("Administration"))
  }
  def error404 = Action {
    Ok(views.html.backend.notfoundpage())
  }
  def basictable = Action {
    Ok(views.html.backend.basic_table())
  }
  def blank = Action {
    Ok(views.html.backend.blank())
  }
  def buttons = Action {
    Ok(views.html.backend.buttons())
  }
  def chart_chartjs = Action {
    Ok(views.html.backend.chart_chartjs())
  }
  def form_component = Action {
    Ok(views.html.backend.form_component())
  }
  def form_validation = Action {
    Ok(views.html.backend.form_validation())
  }
  def general = Action {
    Ok(views.html.backend.general())
  }
  def grids = Action {
    Ok(views.html.backend.grids())
  }
  def login = Action {
    Ok(views.html.backend.login())
  }
  def profile = Action {
    Ok(views.html.backend.profile())
  }
  def widgets = Action {
    Ok(views.html.backend.widgets())
  }
  def show_user()(implicit session: DBSession = AutoSession) = Action {
//    Class.forName("com.mysql.jdbc.Driver")
//    ConnectionPool.singleton("jdbc:mysql://127.0.0.1/play25","root","livet")
    val runSqlQuery: Option[String] = SQL("Select * from users limit 1").map{rs => rs.string("email")}.single().apply()
      println(runSqlQuery.getOrElse("users table is empty"))
    Ok(runSqlQuery.getOrElse("users table is empty"))
  }
}

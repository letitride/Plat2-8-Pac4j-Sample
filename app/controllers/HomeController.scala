package controllers

import java.util.Optional

import javax.inject._
import org.pac4j.core.profile.{CommonProfile, ProfileManager}
import org.pac4j.http.client.indirect.FormClient
import org.pac4j.oauth.profile.github.GitHubProfile
import org.pac4j.play.{LogoutController, PlayWebContext}
import org.pac4j.play.scala.{Security, SecurityComponents}
import play.api.mvc._


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() (val controllerComponents: SecurityComponents) extends BaseController with Security[CommonProfile] {

  private def getProfile(implicit request: RequestHeader): Optional[CommonProfile] = {
    val webContext = new PlayWebContext(request, playSessionStore)
    val profileManager = new ProfileManager[CommonProfile](webContext)
    val profile = profileManager.get(true)
    profile
  }

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def twitterlogin() = Secure("TwitterClient"){implicit request =>
    println(getProfile.map{ p => println(p) })
    Ok(views.html.index())
  }

  def githublogin() = Secure("GithubClient"){ implicit request =>
    val og = getProfile.map{ o => o.asInstanceOf[GitHubProfile] }
    println(getProfile map{ p => println(p) })
    Ok(views.html.index())
  }

  def signout() = Action{ implicit request =>
    println("signout")
    println(getProfile map{ p => println(p) })
    Ok(views.html.index())
  }
}

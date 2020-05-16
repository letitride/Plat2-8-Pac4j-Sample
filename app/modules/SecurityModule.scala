package modules

import com.google.inject.{AbstractModule, Provides}
import org.pac4j.core.client.Clients
import org.pac4j.core.config.Config
import org.pac4j.oauth.client.{GitHubClient, TwitterClient}
import org.pac4j.play.http.PlayHttpActionAdapter
import org.pac4j.play.scala.{DefaultSecurityComponents, SecurityComponents}
import org.pac4j.play.{CallbackController, LogoutController}
import org.pac4j.play.store.{PlayCacheSessionStore, PlaySessionStore}
import play.api.Environment
import play.api.Configuration

class SecurityModule (environment: Environment, configuration: Configuration) extends AbstractModule {

  val baseUrl = "http://localhost:9000"

  override def configure(): Unit = {

    bind(classOf[PlaySessionStore]).to(classOf[PlayCacheSessionStore])

    // callback
    val callbackController = new CallbackController()
    callbackController.setDefaultUrl("/")
    callbackController.setMultiProfile(true)
    bind(classOf[CallbackController]).toInstance(callbackController)

    // logout
    val logoutController = new LogoutController()
    logoutController.setDefaultUrl("/signout")
    bind(classOf[LogoutController]).toInstance(logoutController)

    // security components used in controllers
    bind(classOf[SecurityComponents]).to(classOf[DefaultSecurityComponents])
  }

  @Provides
  def provideGithubClient: GitHubClient = new GitHubClient(
    "Client ID",
    "Client Secret"
  )

  @Provides
  def provideTwitterClient: TwitterClient = new TwitterClient(
    "CONSUMER_KEY",
    "CONSUMER_SECRET"
  )

  @Provides
  def provideConfig(twitterClient: TwitterClient, gitHubClient: GitHubClient):Config = {
    val clients = new Clients(baseUrl + "/oauth_callback", twitterClient, gitHubClient)
    val config = new Config(clients)
    config.setHttpActionAdapter(new PlayHttpActionAdapter())
    config
  }
}

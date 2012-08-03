package controllers

import play.api.mvc.{AnyContent, Action}
import play.api.mvc.Controller
import play.api.Play
import play.api.Play.current


object RemoteAssets extends Controller {

  def at(path: String, file: String): Action[AnyContent] = Action { request =>
    val action: Action[AnyContent] = Assets.at(path, file)
    action.apply(request)
  }

  def at(url: String) = {
    Play.configuration.getString("contentURL") match {
      case Some(contentURL) => contentURL + controllers.routes.ExternalAssets.at(url).url
      case None => controllers.routes.ExternalAssets.at(url)
    }
  }

  def getContentURL() = {
    Play.configuration.getString("contentURL") match {
      case Some(contentURL) => contentURL
      case None => ""
    }
  }

}

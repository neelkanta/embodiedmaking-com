package models

import play.api.Play
import play.api.Play.current
import play.Logger

class LazyCache[T](v: => T) {
  private val cache = Play.isProd
  private var state: Option[T] = None

  Logger.info("Cache enabled: %b".format(cache))

  def value: T = if (cache && state.isDefined) state.get
  else {
    state = Some(v)
    state.get
  }
}

object LazyCache {
  def apply[T](v: => T) = new LazyCache[T](v)

  implicit def unwrap[T](v: LazyCache[T]): T = v.value
}
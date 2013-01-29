package models

import org.joda.time.LocalDateTime
import java.net.{URLConnection, URL}
import com.sun.syndication.io.{XmlReader, SyndFeedInput}
import com.sun.syndication.feed.synd.{SyndEntry, SyndFeed}

import scala.collection.JavaConversions._

import play.api.Play.current
import play.api.{Configuration, Play}

case class RecentUpdate(title: String, date: LocalDateTime)

object RecentUpdate {
  private val recentUpdates: List[RecentUpdate] = {
    val configuration: Configuration = Play.application.configuration
    val url: URL = new URL(configuration.getString("venturesite.recentUpdates.source").get)
    val urlConnection: URLConnection = url.openConnection()

    val input: SyndFeedInput = new SyndFeedInput()
    val reader: XmlReader = new XmlReader(urlConnection)

    try {
      val feed: SyndFeed = input.build(reader)
      val entries: List[SyndEntry] = feed.getEntries.toList.asInstanceOf[List[SyndEntry]]

      entries.take(configuration.getInt("venturesite.recentUpdates.count").getOrElse(6)).map(entry => {
        new RecentUpdate(entry.getTitle, new LocalDateTime(entry.getUpdatedDate))
      })
    } finally {
      reader.close()
    }
  }

  def all(): List[RecentUpdate] = recentUpdates
}

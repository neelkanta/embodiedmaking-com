package models

import org.joda.time.LocalDateTime
import java.net.{URLConnection, URL}
import com.sun.syndication.io.{XmlReader, SyndFeedInput}
import com.sun.syndication.feed.synd.{SyndEntry, SyndFeed}

import scala.collection.JavaConversions._

import play.api.Play.current
import play.api.Play

case class RecentUpdate(title: String, date: LocalDateTime)

object RecentUpdate {
  // TODO [AK] Add caching
  def all(): List[RecentUpdate] = {
    val url: URL = new URL(Play.application.configuration.getString("venturesite.recentUpdateSource").get)
    val urlConnection: URLConnection = url.openConnection()

    val input: SyndFeedInput = new SyndFeedInput()
    val reader: XmlReader = new XmlReader(urlConnection)

    try {
      val feed: SyndFeed = input.build(reader)
      val entries: List[SyndEntry] = feed.getEntries.toList.asInstanceOf[List[SyndEntry]]

      entries.take(5).map(entry => {
        new RecentUpdate(entry.getTitle, new LocalDateTime(entry.getUpdatedDate))
      })
    } finally {
      reader.close()
    }
  }
}

package models

import java.io.InputStream
import java.util.Scanner
import play._

object StaticResources {
  private def getInputStream(name: String): InputStream = {
    Logger.info(name)
    Thread.currentThread().getContextClassLoader.getResourceAsStream(name)
  }

  def scan[R](name: String, f: (Scanner) => R): R = {
    val stream: InputStream = getInputStream(name)
    try {
      f(new Scanner(stream, "UTF-8"))
    } finally {
      stream.close()
    }
  }
}

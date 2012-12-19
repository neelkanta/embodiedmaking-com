package models

import java.io.InputStream
import java.util.Scanner

object StaticResources {
  private def getInputStream(name: String): InputStream = {
    Thread.currentThread().getContextClassLoader.getResourceAsStream(name)
  }

  def scan[T](name: String, f: Scanner => T) = {
    val stream: InputStream = getInputStream(name)
    try {
      val scanner: Scanner = new Scanner(stream, "UTF-8")
      f(scanner)
    } finally {
      stream.close()
    }
  }
}

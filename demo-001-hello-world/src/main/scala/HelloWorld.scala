import geotrellis.raster._

import scala.util.Success
object HelloWorld {
  def main(args: Array[String]): Unit = {
    val error = new GeoAttrsError("Hello, world!")
    println(error)
  }
}
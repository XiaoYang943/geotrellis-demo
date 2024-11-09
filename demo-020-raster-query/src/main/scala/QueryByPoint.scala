import geotrellis.proj4.{CRS, LatLng}
import geotrellis.raster.io.geotiff.{GeoTiffReader, SinglebandGeoTiff}
import geotrellis.vector.{Point, ReprojectPoint}

object QueryByPoint {

  def main(args: Array[String]): Unit = {
    val path: String = "D:\\data\\raster\\geotiff\\dem12.5m\\陕西\\huashan_dem_4490.tif"
    val geoTiff: SinglebandGeoTiff = GeoTiffReader.readSingleband(path)

    println(querySingleBandTifValueByPoint(110, 34.45, geoTiff))
  }

  def querySingleBandTifValueByPoint(lon: Double, lat: Double, geoTiff: SinglebandGeoTiff): Double = {
    val crs = CRS.fromEpsgCode(geoTiff.crs.epsgCode.get)
    val point = Point(lon, lat).reproject(LatLng, crs)

    if (geoTiff.extent.contains(point)) {
      val d = geoTiff.raster.getDoubleValueAtPoint(point.getX, point.getY)
      return d
    }

    -9999.0
  }


}

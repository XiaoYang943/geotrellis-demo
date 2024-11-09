import geotrellis.proj4.{CRS, LatLng}
import geotrellis.raster.io.geotiff.{GeoTiffReader, SinglebandGeoTiff}
import geotrellis.vector.Extent

object QueryPngByExtent {
  def main(args: Array[String]): Unit = {
    val path: String = "D:\\data\\raster\\geotiff\\dem12.5m\\陕西\\陕西.tif"
    val geoTiff: SinglebandGeoTiff = GeoTiffReader.readSingleband(path)

    val crs = CRS.fromEpsgCode(geoTiff.crs.epsgCode.get)
    val sourceExtent = Extent(109.9779582630000050, 34.4277878609999988, 110.1287005650000026, 34.5778054399999988)
    val extent = sourceExtent.reproject(LatLng, crs)

    geoTiff.crop(extent).tile.renderPng().write("C:\\Users\\admin\\Desktop\\result.png")
  }

}

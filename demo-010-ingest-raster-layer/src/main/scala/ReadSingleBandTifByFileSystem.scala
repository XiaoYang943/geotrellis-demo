import geotrellis.raster.io.geotiff.{GeoTiffReader, SinglebandGeoTiff}

object ReadSingleBandTifByFileSystem {
  def main(args: Array[String]): Unit = {
    val path: String = "D:\\data\\raster\\geotiff\\dem12.5m\\陕西\\陕西.tif"
    val geoTiff: SinglebandGeoTiff = GeoTiffReader.readSingleband(path)
    print(geoTiff.raster.rasterExtent)
  }

}

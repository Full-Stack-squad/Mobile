package ca.weblite.codename1.mapbox;


/**
 *  
 *  
 *  @author shannah
 */
public class MBTilesProvider extends com.codename1.maps.providers.TiledProvider {

	public MBTilesProvider(String dbName) {
	}

	public static MBTilesProvider createFromResource(String path) {
	}

	public static MBTilesProvider createFromFile(String path) {
	}

	public static MBTilesProvider create(String name, java.io.InputStream is) {
	}

	public static boolean isLoaded(String dbName) {
	}

	/**
	 *  @inheritDoc
	 */
	@java.lang.Override
	public com.codename1.maps.BoundingBox bboxFor(com.codename1.maps.Coord position, int zoomLevel) {
	}

	/**
	 *  @inheritDoc
	 */
	@java.lang.Override
	public com.codename1.maps.Tile tileFor(com.codename1.maps.BoundingBox bbox) {
	}

	public java.util.Map metadata() {
	}

	@java.lang.Override
	public int maxZoomLevel() {
	}

	@java.lang.Override
	public int minZoomLevel() {
	}

	@java.lang.Override
	public String attribution() {
	}

	public com.codename1.maps.Coord center() {
	}

	public com.codename1.maps.BoundingBox bounds() {
	}
}

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Thread-safe vehicle tracker using delegation
// Delegates thread safety to ConcurrentHashMap with immutable Point objects
public class DelegatingVehicleTracker {
    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null)
            throw new IllegalArgumentException("Invalid vehicle name: " + id);
    }

    // Alternative: return snapshot instead of live view
    public Map<String, Point> getLocationsSnapshot() {
        return Collections.unmodifiableMap(new ConcurrentHashMap<>(locations));
    }
}

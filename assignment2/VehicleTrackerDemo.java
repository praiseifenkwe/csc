import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VehicleTrackerDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing MonitorVehicleTracker (Synchronized) ===\n");
        testMonitorVehicleTracker();
        
        System.out.println("\n\n=== Testing DelegatingVehicleTracker (ConcurrentHashMap) ===\n");
        testDelegatingVehicleTracker();
    }

    private static void testMonitorVehicleTracker() {
        // Initialize vehicle locations with MutablePoint
        Map<String, MutablePoint> initialLocations = new HashMap<>();
        initialLocations.put("Vehicle1", new MutablePoint());
        initialLocations.put("Vehicle2", new MutablePoint());
        initialLocations.put("Vehicle3", new MutablePoint());

        MonitorVehicleTracker tracker = new MonitorVehicleTracker(initialLocations);

        // Create threads to update vehicle locations
        Thread updater1 = new Thread(new MonitorVehicleUpdater(tracker, "Vehicle1"));
        Thread updater2 = new Thread(new MonitorVehicleUpdater(tracker, "Vehicle2"));
        Thread updater3 = new Thread(new MonitorVehicleUpdater(tracker, "Vehicle3"));

        // Create thread to monitor locations
        Thread monitor = new Thread(new MonitorLocationMonitor(tracker));

        // Start all threads
        updater1.start();
        updater2.start();
        updater3.start();
        monitor.start();

        // Let them run for a while
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Interrupt all threads
        updater1.interrupt();
        updater2.interrupt();
        updater3.interrupt();
        monitor.interrupt();

        System.out.println("\nFinal locations (MonitorVehicleTracker):");
        System.out.println(tracker.getLocations());
    }

    private static void testDelegatingVehicleTracker() {
        // Initialize vehicle locations with immutable Point
        Map<String, Point> initialLocations = new HashMap<>();
        initialLocations.put("Vehicle1", new Point(0, 0));
        initialLocations.put("Vehicle2", new Point(10, 10));
        initialLocations.put("Vehicle3", new Point(20, 20));

        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(initialLocations);

        // Create threads to update vehicle locations
        Thread updater1 = new Thread(new DelegatingVehicleUpdater(tracker, "Vehicle1"));
        Thread updater2 = new Thread(new DelegatingVehicleUpdater(tracker, "Vehicle2"));
        Thread updater3 = new Thread(new DelegatingVehicleUpdater(tracker, "Vehicle3"));

        // Create thread to monitor locations
        Thread monitor = new Thread(new DelegatingLocationMonitor(tracker));

        // Start all threads
        updater1.start();
        updater2.start();
        updater3.start();
        monitor.start();

        // Let them run for a while
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Interrupt all threads
        updater1.interrupt();
        updater2.interrupt();
        updater3.interrupt();
        monitor.interrupt();

        System.out.println("\nFinal locations (DelegatingVehicleTracker):");
        System.out.println(tracker.getLocations());
    }
}

// Updater for MonitorVehicleTracker
class MonitorVehicleUpdater implements Runnable {
    private final MonitorVehicleTracker tracker;
    private final String vehicleId;
    private final Random random = new Random();

    public MonitorVehicleUpdater(MonitorVehicleTracker tracker, String vehicleId) {
        this.tracker = tracker;
        this.vehicleId = vehicleId;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int x = random.nextInt(100);
                int y = random.nextInt(100);
                tracker.setLocation(vehicleId, x, y);
                System.out.println(vehicleId + " moved to " + tracker.getLocation(vehicleId));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Monitor for MonitorVehicleTracker
class MonitorLocationMonitor implements Runnable {
    private final MonitorVehicleTracker tracker;

    public MonitorLocationMonitor(MonitorVehicleTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("\n=== All Vehicle Locations (Monitor) ===");
                Map<String, MutablePoint> locations = tracker.getLocations();
                for (Map.Entry<String, MutablePoint> entry : locations.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Updater for DelegatingVehicleTracker
class DelegatingVehicleUpdater implements Runnable {
    private final DelegatingVehicleTracker tracker;
    private final String vehicleId;
    private final Random random = new Random();

    public DelegatingVehicleUpdater(DelegatingVehicleTracker tracker, String vehicleId) {
        this.tracker = tracker;
        this.vehicleId = vehicleId;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int x = random.nextInt(100);
                int y = random.nextInt(100);
                tracker.setLocation(vehicleId, x, y);
                System.out.println(vehicleId + " moved to " + tracker.getLocation(vehicleId));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Monitor for DelegatingVehicleTracker
class DelegatingLocationMonitor implements Runnable {
    private final DelegatingVehicleTracker tracker;

    public DelegatingLocationMonitor(DelegatingVehicleTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("\n=== All Vehicle Locations (Delegating) ===");
                Map<String, Point> locations = tracker.getLocations();
                for (Map.Entry<String, Point> entry : locations.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}



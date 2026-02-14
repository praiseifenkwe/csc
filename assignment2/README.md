# Assignment 2: Tracking Fleet Vehicles

This implementation is based on Section 4.2.2 of "Java Concurrency In Practice" by Brian Göetz et al.

## Overview

The program demonstrates TWO different approaches to building a thread-safe vehicle tracking system, as presented in the book:

1. **MonitorVehicleTracker** - Uses monitor pattern with synchronized methods
2. **DelegatingVehicleTracker** - Delegates thread safety to ConcurrentHashMap

## Components

### Core Classes
1. **Point.java** - Immutable class representing a location coordinate
2. **MutablePoint.java** - Mutable point class (NOT thread-safe by itself)
3. **MonitorVehicleTracker.java** - Thread-safe tracker using synchronization and deep copying
4. **DelegatingVehicleTracker.java** - Thread-safe tracker using ConcurrentHashMap delegation
5. **VehicleTrackerDemo.java** - Demo application testing both implementations

## Key Concurrency Concepts Demonstrated

### MonitorVehicleTracker Approach
- Uses **synchronized methods** for thread safety
- Works with **mutable** MutablePoint objects
- Returns **deep copies** to prevent external modification
- All access to shared state is guarded by intrinsic lock

### DelegatingVehicleTracker Approach
- Delegates thread safety to **ConcurrentHashMap**
- Uses **immutable** Point objects
- Returns **unmodifiable live view** of locations
- No explicit synchronization needed
- Better scalability due to lock-free reads

## Comparison

| Feature | MonitorVehicleTracker | DelegatingVehicleTracker |
|---------|----------------------|--------------------------|
| Point Type | MutablePoint | Immutable Point |
| Synchronization | Explicit (synchronized) | Delegated (ConcurrentHashMap) |
| getLocations() | Returns snapshot | Returns live view |
| Scalability | Limited (single lock) | Better (lock-free reads) |
| Complexity | Higher | Lower |

## How to Run

```cmd
javac *.java
java VehicleTrackerDemo
```

## Expected Behavior

The demo runs both implementations sequentially:
1. Tests MonitorVehicleTracker for 3 seconds
2. Tests DelegatingVehicleTracker for 3 seconds
3. Each test has 3 vehicles updating positions every second
4. A monitor thread displays all locations every 2 seconds
5. Final locations are displayed for each implementation

## Learning Points

- **Immutability** simplifies thread safety
- **Delegation** to thread-safe classes reduces complexity
- **Deep copying** protects mutable state but has performance cost
- **ConcurrentHashMap** provides better scalability than synchronized methods

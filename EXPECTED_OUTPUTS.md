# Expected Outputs - Quick Reference

**What You Should See When Running Each Assignment**  
**Last Updated**: February 14, 2026

---

## Assignment 1: SERP Analysis

### Command
```cmd
cd assignment1
javac src/*.java -d bin
echo 3 | java -cp bin Main
```

### Expected Console Output
```
=== Crime-Reporting Papers Analysis ===
Analyzing 10 crime-reporting systems using 5 threads...
Thread pool created with 5 workers
...
Total papers analyzed: 10
Features categorized by frequency:
 1. Web Portal                :  6 systems (60.0%)
 2. Crime Categories          :  5 systems (50.0%)
...
Visualization saved to: output/crime_features_chart.png

=== Deep Learning Papers Analysis ===
Analyzing 10 journal papers using 5 threads...
...
Total papers analyzed: 10
Sub-headings sorted by frequency:
 1. Comparison with Baselines :  8 papers (80.0%)
...
Visualization saved to: output/dl_headings_chart.png
```

### Expected Files Created
- `output/crime_features_chart.png` - Bar chart
- `output/dl_headings_chart.png` - Bar chart

### Runtime
~15-20 seconds

---

## Assignment 2: Fleet Tracking

### Command
```cmd
cd assignment2
javac *.java
java VehicleTrackerDemo
```

### Expected Console Output
```
======================================================================
VEHICLE TRACKING SYSTEM DEMO
======================================================================

======================================================================
PART 1: MonitorVehicleTracker (Synchronized + Deep Copy)
======================================================================
Starting MonitorVehicleTracker test...
Vehicle-1 starting at (0, 0)
Vehicle-2 starting at (0, 0)
Vehicle-3 starting at (0, 0)
[Monitor] All vehicle locations:
  Vehicle-1: (1, 1)
  Vehicle-2: (1, 1)
  Vehicle-3: (1, 1)
...
Test complete. Final locations:
  Vehicle-1: (3, 3)
  Vehicle-2: (3, 3)
  Vehicle-3: (3, 3)

======================================================================
PART 2: DelegatingVehicleTracker (ConcurrentHashMap + Immutable)
======================================================================
...
Demo complete!
======================================================================
```

### Runtime
~6 seconds

---

## Assignment 3: Ayo Game

### Command
```cmd
cd assignment3
javac *.java
java AyoGame
```

### Expected Console Output
```
=== AYO GAME ===
Welcome to Ayo (Mancala)!

==================================================
Player 2:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
Store 2:  0                              Store 1:  0
Player 1:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
            1   2   3   4   5   6
==================================================

Player 1's turn
Choose a pit (1-6): 
```

### Interactive
- You play against computer
- Enter pit numbers 1-6
- Game continues until one side empty
- Winner announced at end

### Runtime
5-15 minutes (depends on gameplay)

---

## Assignment 4: Dining Philosophers

### Command
```cmd
cd assignment4
javac *.java
java Main
```

### Expected Console Output
```
======================================================================
DINING PHILOSOPHERS PROBLEM
Demonstrating solutions to Deadlock, Livelock, and Starvation
======================================================================

Starting simulation with 5 philosophers
Each philosopher will eat 5 meals

Philosopher 0 requesting permission to dine...
Philosopher 0 got permission to dine.
  Fork 0 picked up by Philosopher 0
  Fork 1 picked up by Philosopher 0
Philosopher 0 is EATING (meal #1)
...
All philosophers have finished eating!

======================================================================
SIMULATION COMPLETE - STATISTICS
======================================================================

Per-Philosopher Statistics:
----------------------------------------------------------------------
Philosopher 0: Meals=5, Failed=9, AvgWait=80ms, AvgEat=2296ms
Philosopher 1: Meals=5, Failed=12, AvgWait=27ms, AvgEat=2175ms
Philosopher 2: Meals=5, Failed=13, AvgWait=8ms, AvgEat=2354ms
Philosopher 3: Meals=5, Failed=10, AvgWait=9ms, AvgEat=2375ms
Philosopher 4: Meals=5, Failed=15, AvgWait=38ms, AvgEat=2328ms

Overall Statistics:
----------------------------------------------------------------------
Total meals eaten: 25
Total failed attempts: 59
Success rate: 29.8%

Starvation Analysis:
----------------------------------------------------------------------
✓ No starvation detected - all philosophers ate

Fairness Analysis:
----------------------------------------------------------------------
Min meals eaten: 5
Max meals eaten: 5
Difference: 0
✓ Good fairness - meal distribution is balanced

Concurrency Issues Handled:
----------------------------------------------------------------------
✓ DEADLOCK: Prevented by limiting concurrent diners (semaphore)
✓ LIVELOCK: Prevented by timeout + random backoff
✓ STARVATION: Prevented by fair semaphore + timeout mechanism
======================================================================
```

### Key Verification Points
- All 5 philosophers eat exactly 5 meals
- No deadlock (program completes)
- No starvation (all eat equal amounts)
- Statistics show fairness

### Runtime
~30-60 seconds

---

## Assignment 5: Producer/Consumer

### Command
```cmd
cd assignment5
javac *.java
java ProducerConsumer
```

### Expected Console Output
```
======================================================================
PRODUCER-CONSUMER PROBLEM
Bounded Buffer Implementation using BlockingQueue
======================================================================

Configuration:
- Buffer size: 10
- Producers: 3
- Consumers: 2
- Items per producer: 10

Starting simulation...

Producer-1 produced: Item{producer=1, seq=1, timestamp=...}
Producer-2 produced: Item{producer=2, seq=1, timestamp=...}
Producer-3 produced: Item{producer=3, seq=1, timestamp=...}
[Buffer size: 3]

Consumer-1 consumed: Item{producer=1, seq=1, timestamp=...}
Consumer-2 consumed: Item{producer=2, seq=1, timestamp=...}
[Buffer size: 1]

...

Producer-1 finished producing 10 items
Producer-2 finished producing 10 items
Producer-3 finished producing 10 items

All producers finished. Waiting for buffer to empty...

Consumer-1 consumed: Item{producer=3, seq=10, timestamp=...}
[Buffer size: 0]

Buffer is empty. Stopping consumers...

Consumer-1 stopped
Consumer-2 stopped

======================================================================
SIMULATION COMPLETE - STATISTICS
======================================================================

Producer Statistics:
----------------------------------------------------------------------
Producer-1: 10 items produced
Producer-2: 10 items produced
Producer-3: 10 items produced
Total produced: 30 items

Consumer Statistics:
----------------------------------------------------------------------
Consumer-1: 15 items consumed
Consumer-2: 15 items consumed
Total consumed: 30 items

Verification:
----------------------------------------------------------------------
✓ SUCCESS: All produced items were consumed
✓ No data loss detected
✓ Thread-safe operations verified

======================================================================
```

### Key Verification Points
- 30 items produced (3 × 10)
- 30 items consumed
- No data loss
- Buffer size changes shown

### Runtime
~10-20 seconds

---

## Quick Verification Checklist

### Assignment 1
- [ ] Console shows "Thread pool created with 5 workers"
- [ ] 10 papers analyzed in each part
- [ ] Features/headings sorted by frequency
- [ ] Two PNG files created in `output/` folder
- [ ] No errors or exceptions

### Assignment 2
- [ ] Both implementations run (Monitor and Delegating)
- [ ] 3 vehicles update positions
- [ ] Monitor thread displays locations
- [ ] Final locations shown
- [ ] No errors or exceptions

### Assignment 3
- [ ] Board displays correctly (6 pits per side)
- [ ] Can enter pit numbers 1-6
- [ ] Computer makes moves
- [ ] Seeds distributed correctly
- [ ] Game ends when side empty
- [ ] Winner announced

### Assignment 4
- [ ] 5 philosophers shown
- [ ] Each eats 5 meals
- [ ] Statistics displayed
- [ ] All three issues marked as handled
- [ ] No starvation (all ate equal amounts)
- [ ] Program completes successfully

### Assignment 5
- [ ] 3 producers shown
- [ ] 2 consumers shown
- [ ] Buffer size changes displayed
- [ ] 30 items produced
- [ ] 30 items consumed
- [ ] Success message shown
- [ ] No data loss

---

## Troubleshooting

### If you don't see expected output:

1. **Compilation errors**: Check Java version (need JDK 8+)
2. **Class not found**: Make sure you're in correct directory
3. **No visualizations (Assignment 1)**: Check `output/` folder exists
4. **Program hangs**: Some assignments take time (Assignment 4: 30-60 seconds)
5. **Different numbers**: Random elements cause variation, but patterns should match

---

**All assignments should complete without errors and show the patterns described above.**

---

**Last Updated**: February 14, 2026  
**Status**: Complete ✅

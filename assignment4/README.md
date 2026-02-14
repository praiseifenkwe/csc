# Assignment 4: Dining Philosophers Problem

## Overview
This implementation demonstrates the classic Dining Philosophers problem and shows how to handle three critical concurrency issues:
1. **Deadlock** - All philosophers waiting indefinitely for resources
2. **Livelock** - Philosophers continuously changing state without progress
3. **Starvation** - Some philosophers never getting to eat

## The Problem
Five philosophers sit at a round table with five forks (chopsticks). Each philosopher needs two forks to eat. The challenge is to design a solution where:
- No deadlock occurs (all philosophers stuck waiting)
- No livelock occurs (philosophers keep trying but never succeed)
- No starvation occurs (all philosophers get to eat eventually)

## Solution Implemented

This implementation uses a **combined approach** that prevents all three concurrency issues:

### 1. Semaphore (Prevents Deadlock)
**Strategy**: Limit concurrent diners to (n-1) using a semaphore.

**How it prevents deadlock**:
- Only 4 of 5 philosophers can attempt to eat simultaneously
- Guarantees at least one philosopher can always get both forks
- Breaks the circular wait condition

**Implementation**: `DiningTable.java` with semaphore

### 2. Timeout with Random Backoff (Prevents Livelock)
**Strategy**: Use timeouts when acquiring forks, release if unsuccessful, and retry after random delay.

**How it prevents livelock**:
- Timeout prevents indefinite waiting
- Random backoff breaks synchronized retry patterns
- Eventually timing differences allow progress

**Implementation**: `Fork.java` with `tryLock(timeout)` and `Philosopher.java` with random delays

### 3. Fair Semaphore + Timeout (Prevents Starvation)
**Strategy**: Fair semaphore ensures FIFO ordering, timeout mechanism ensures eventual success.

**How it prevents starvation**:
- Fair semaphore gives equal opportunity to all philosophers
- Timeout mechanism prevents indefinite blocking
- All philosophers eventually get to eat

**Implementation**: Combined in `Philosopher.java` and `DiningTable.java`

## File Structure

```
assignment4/
├── Main.java                    # Main class - runs the simulation
├── Philosopher.java             # Philosopher thread implementation
├── Fork.java                    # Fork (chopstick) with timeout locking
├── DiningTable.java             # Semaphore-based arbitrator
├── README.md                    # This file
└── IMPLEMENTATION_NOTES.md      # Detailed technical notes
```

## How to Run

### Compile
```cmd
javac *.java
```

### Run
```cmd
java -cp assignment4 Main
```

The program will run a simulation where each philosopher eats 5 meals.

## Expected Output

The simulation displays:
- When philosophers request permission to dine
- When they pick up/put down forks
- When they are eating
- Failed attempts and timeouts
- Final statistics including:
  - Meals eaten per philosopher
  - Failed attempts
  - Average wait and eating times
  - Starvation analysis
  - Fairness analysis

### Sample Output
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

## Key Concepts Demonstrated

### Deadlock
**Definition**: A situation where all threads are waiting for resources held by other threads, creating a circular dependency.

**Classic Dining Philosophers Deadlock**:
1. All philosophers pick up their left fork simultaneously
2. All try to pick up their right fork
3. All right forks are held by neighbors
4. Everyone waits forever

**Prevention**: Resource ordering ensures the circular wait cannot occur.

### Livelock
**Definition**: Threads continuously change state in response to each other without making progress.

**Example in Dining Philosophers**:
1. Philosopher picks up left fork
2. Can't get right fork, puts down left fork
3. Neighbor does the same
4. Both retry at the same time
5. Repeat indefinitely

**Prevention**: Random backoff breaks the synchronization pattern.

### Starvation
**Definition**: A thread is perpetually denied access to resources it needs.

**Example in Dining Philosophers**:
- Some philosophers eat frequently
- Others rarely or never get both forks
- Unfair scheduling leads to imbalance

**Prevention**: Arbitrator ensures fair access and limits concurrent attempts.

## Implementation Details

### Fork Class
- Uses `ReentrantLock` for mutual exclusion
- Provides `tryLock()` for non-blocking acquisition
- Supports timeout-based locking

### Thread Safety
- All shared resources protected by locks
- Atomic operations for statistics
- Proper exception handling and cleanup

### Simulation Parameters
- 5 philosophers (configurable)
- 2 seconds eating time (with random variation)
- 1 second thinking time (with random variation)
- 30 seconds total simulation time per solution

## Comparison of Solutions

| Solution | Deadlock | Livelock | Starvation | Throughput | Complexity |
|----------|----------|----------|------------|------------|------------|
| Resource Ordering | ✓ Prevented | Possible | Possible | High | Low |
| Timeout + Retry | ✓ Prevented | ✓ Prevented | Possible | Medium | Medium |
| Arbitrator | ✓ Prevented | ✓ Prevented | ✓ Prevented | Medium | Medium |

## Testing

### Verify Deadlock Prevention
- Run for extended period
- All philosophers should continue eating
- No permanent blocking

### Verify Livelock Prevention
- Check failed attempt counts
- Should be low relative to successful meals
- Progress should be steady

### Verify Starvation Prevention
- Compare meal counts across philosophers
- Should be relatively balanced
- No philosopher with zero meals

## Extensions

### Possible Enhancements
1. Add priority levels for philosophers
2. Implement different fairness policies
3. Add metrics collection and visualization
4. Simulate fork failures
5. Add dynamic philosopher addition/removal

### Real-World Applications
- Database transaction management
- Resource allocation in operating systems
- Network packet routing
- Distributed system coordination

## References
- Dijkstra, E. W. (1971). "Hierarchical ordering of sequential processes"
- "Java Concurrency in Practice" by Brian Goetz
- Operating Systems concepts (Silberschatz, Galvin, Gagne)

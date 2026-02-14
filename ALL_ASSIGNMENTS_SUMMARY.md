# CSC310 Programming Assignments - Complete Summary

**Student Name**: [Your Name]  
**Date Submitted**: 12th February, 2026  
**Course**: CSC310 Programming Assignments

---

## Overview

This document provides a comprehensive summary of all five programming assignments completed for CSC310. Each assignment demonstrates key concepts in concurrent programming, multithreading, and synchronization.

---

## Assignment 1: SERP Analysis with Multithreading

### Objective
Analyze Search Engine Results Pages (SERP) using multithreaded programming to extract and categorize features from crime-reporting systems and deep learning papers.

### Implementation
- **Part 1**: Crime-Reporting Papers Analysis
  - Extracts 20 distinctive features from at least 10 systems
  - Categorizes features by frequency
  - Generates bar chart visualization
  
- **Part 2**: Deep Learning Papers Analysis
  - Extracts 27 distinct sub-headings from journal papers
  - Analyzes heading frequency
  - Generates visualization

### Key Technologies
- Thread pools (ExecutorService)
- ConcurrentHashMap for thread-safe data storage
- CountDownLatch for thread coordination
- Custom visualization using Graphics2D

### Files
- `assignment1/src/Main.java`
- `assignment1/src/CrimeReportingAnalyzer.java`
- `assignment1/src/DeepLearningPapersAnalyzer.java`
- `assignment1/src/DataVisualizer.java`

### Status
✅ Complete with working demo and visualizations

---

## Assignment 2: Tracking Fleet Vehicles

### Objective
Implement the Tracking Fleet Vehicles example from Section 4.2.2 of "Java Concurrency In Practice" by Brian Göetz.

### Implementation
Two approaches demonstrated:
1. **MonitorVehicleTracker**: Uses synchronized methods with MutablePoint
2. **DelegatingVehicleTracker**: Uses ConcurrentHashMap with immutable Point

### Key Concepts
- Thread safety through synchronization
- Immutability for concurrent access
- Delegation to thread-safe collections
- Deep copying vs live views

### Files
- `assignment2/Point.java` (immutable)
- `assignment2/MutablePoint.java`
- `assignment2/MonitorVehicleTracker.java`
- `assignment2/DelegatingVehicleTracker.java`
- `assignment2/VehicleTrackerDemo.java`

### Status
✅ Complete with both implementations tested

---

## Assignment 3: Ayo Game

### Objective
Implement the traditional Ayo (Mancala) game.

### Implementation
- Complete playable Ayo/Mancala game
- Human vs Computer gameplay
- Board with 6 pits per side, 4 seeds per pit
- Capture mechanics following traditional rules
- Win condition detection and scoring

### Key Features
- Object-oriented design (Player hierarchy)
- Interactive console interface
- Input validation
- AI opponent (random move selection)
- Clear board visualization

### Files
- `assignment3/AyoGame.java`
- `assignment3/AyoBoard.java`
- `assignment3/Player.java`
- `assignment3/HumanPlayer.java`
- `assignment3/ComputerPlayer.java`

### Status
✅ Complete with working gameplay

---

## Assignment 4: Dining Philosophers Problem

### Objective
Implement the dining philosophers problem and demonstrate how it handles starvation, livelock, and deadlock.

### Implementation
Combined approach using:
1. **Semaphore** (prevents deadlock by limiting concurrent diners)
2. **Timeout with tryLock** (prevents livelock)
3. **Fair semaphore + retry logic** (prevents starvation)

### Key Features
- 5 philosophers, 5 forks
- Each philosopher eats 5 meals
- No deadlock, livelock, or starvation
- Detailed statistics and verification

### Files
- `assignment4/Main.java`
- `assignment4/Philosopher.java`
- `assignment4/Fork.java`
- `assignment4/DiningTable.java`

### Test Results
```
Total meals eaten: 25 (5 per philosopher)
✓ No starvation detected
✓ Good fairness - meal distribution balanced
✓ Deadlock prevented
✓ Livelock prevented
```

### Status
✅ Complete with successful test results

---

## Assignment 5: Producer/Consumer Problem

### Objective
Implement the classic producer/consumer problem with proper synchronization.

### Implementation
Uses `BlockingQueue` (LinkedBlockingQueue) for:
- Thread-safe buffer operations
- Automatic blocking when full/empty
- No explicit locks needed

### Configuration
- Buffer size: 10
- Producers: 3
- Consumers: 2
- Items per producer: 10

### Key Features
- Bounded buffer prevents overflow
- Automatic blocking for producers/consumers
- Graceful shutdown
- No data loss

### Files
- `assignment5/ProducerConsumer.java`
- `assignment5/Producer.java`
- `assignment5/Consumer.java`
- `assignment5/Item.java`

### Test Results
```
Total items produced: 30
Total items consumed: 30
✓ SUCCESS: All produced items were consumed
```

### Status
✅ Complete with successful test results

---

## Summary of Key Concepts Demonstrated

### Multithreading
- Thread creation and management
- Thread pools (ExecutorService)
- Thread coordination (join, CountDownLatch)
- Thread interruption for graceful shutdown

### Synchronization
- Synchronized methods
- ReentrantLock with tryLock
- Semaphores for resource limiting
- BlockingQueue for producer-consumer

### Thread Safety
- Immutable objects
- Thread-safe collections (ConcurrentHashMap)
- Atomic operations (AtomicInteger)
- Defensive copying

### Concurrency Issues
- **Deadlock**: Prevented using resource ordering and semaphores
- **Livelock**: Prevented using timeouts and random backoff
- **Starvation**: Prevented using fair locks and semaphores
- **Race Conditions**: Prevented using proper synchronization

### Design Patterns
- Producer-Consumer pattern
- Monitor pattern
- Delegation pattern
- Thread pool pattern

---

## Compilation and Execution

### Assignment 1
```cmd
javac assignment1/src/*.java -d assignment1/bin
java -cp assignment1/bin Main
```

### Assignment 2
```cmd
javac assignment2/*.java
java VehicleTrackerDemo
```

### Assignment 4
```cmd
javac assignment4/*.java
java -cp assignment4 Main
```

### Assignment 5
```cmd
javac assignment5/*.java
java -cp assignment5 ProducerConsumer
```

---

## Documentation Structure

Each assignment includes:
- **README.md**: Overview and usage instructions
- **Source files**: Well-commented Java code
- **IMPLEMENTATION_NOTES.md**: Technical details
- **ASSIGNMENT_SUMMARY.md**: Complete summary

---

## Technologies and Libraries Used

- **Java 8+**: Core language features
- **java.util.concurrent**: Concurrency utilities
  - ExecutorService
  - BlockingQueue
  - Semaphore
  - ReentrantLock
  - CountDownLatch
  - ConcurrentHashMap
  - AtomicInteger
- **Java Graphics2D**: Custom visualizations
- **Standard Java libraries**: Collections, I/O, etc.

---

## Learning Outcomes

Through these assignments, the following skills were developed:

1. **Concurrent Programming**
   - Understanding thread lifecycle
   - Managing multiple threads
   - Coordinating thread execution

2. **Synchronization Techniques**
   - Using locks and semaphores
   - Implementing thread-safe data structures
   - Preventing concurrency issues

3. **Problem Solving**
   - Analyzing classic concurrency problems
   - Implementing multiple solution approaches
   - Testing and verifying correctness

4. **Software Design**
   - Clean code principles
   - Proper documentation
   - Modular architecture

5. **Testing and Debugging**
   - Concurrent program testing
   - Statistics collection
   - Verification of correctness

---

## References

1. "Java Concurrency in Practice" by Brian Göetz et al.
2. "Operating System Concepts" by Silberschatz, Galvin, and Gagne
3. Java Documentation: java.util.concurrent package
4. Classic synchronization problems by Edsger Dijkstra

---

## Conclusion

All assignments successfully demonstrate key concepts in concurrent programming and multithreading. Each implementation:
- Solves the stated problem correctly
- Handles concurrency issues properly
- Includes comprehensive documentation
- Provides working demonstrations
- Shows understanding of underlying concepts

The assignments progress from basic multithreading (Assignment 1) through classic synchronization problems (Assignments 2, 4, 5), demonstrating increasing complexity and sophistication in concurrent programming techniques.

---

**End of Summary**

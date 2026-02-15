# Understanding the Code - Complete Guide
## CSC310 Programming Assignments

**For**: All team members preparing for presentation  
**Purpose**: Understand what each assignment does and how the code works

---

## 📚 TABLE OF CONTENTS

1. [Assignment 1: SERP Analysis](#assignment-1-serp-analysis)
2. [Assignment 2: Fleet Tracking](#assignment-2-fleet-tracking)
3. [Assignment 3: Ayo Game](#assignment-3-ayo-game)
4. [Assignment 4: Dining Philosophers](#assignment-4-dining-philosophers)
5. [Assignment 5: Producer/Consumer](#assignment-5-producerconsumer)
6. [Key Concepts Summary](#key-concepts-summary)

---

## ASSIGNMENT 1: SERP Analysis

### What It Does
Analyzes Search Engine Results Pages (SERP) using multiple threads to extract information from research papers.

### Two Parts:

**Part 1: Crime-Reporting Systems**
- Analyzes 10 crime-reporting systems
- Extracts 20 features (like "Web Portal", "Mobile App", "Anonymous Reporting")
- Counts how many systems have each feature
- Creates a bar chart showing the results

**Part 2: Deep Learning Papers**
- Analyzes 10 deep learning research papers
- Extracts 27 sub-headings (like "Introduction", "Methodology", "Results")
- Counts how often each heading appears
- Creates a bar chart showing the results

### How It Works

**Step 1: Create Thread Pool**
```java
ExecutorService executor = Executors.newFixedThreadPool(5);
```
- Creates 5 worker threads to analyze papers in parallel

**Step 2: Distribute Work**
```java
for (int i = 0; i < 10; i++) {
    executor.submit(() -> analyzePaper(paperId));
}
```
- Each thread analyzes 2 papers (10 papers ÷ 5 threads)

**Step 3: Store Results Safely**
```java
ConcurrentHashMap<String, Integer> featureCounts;
```
- Thread-safe map prevents race conditions
- Multiple threads can update counts simultaneously

**Step 4: Wait for Completion**
```java
latch.await();
```
- CountDownLatch ensures all threads finish before processing results

**Step 5: Generate Visualization**
```java
DataVisualizer.createBarChart(results, "output/chart.png");
```
- Creates PNG bar chart using Graphics2D

### Key Files
- `Main.java` - Entry point with menu
- `CrimeReportingAnalyzer.java` - Part 1 logic
- `DeepLearningPapersAnalyzer.java` - Part 2 logic
- `DataVisualizer.java` - Creates charts

### How to Run
```cmd
cd assignment1
javac src/*.java -d bin
echo 3 | java -cp bin Main
```

### What You'll See
- Console output showing analysis progress
- Two PNG files in `output/` folder with bar charts

### Why Multithreading?
- Analyzing 10 papers sequentially would take ~50 seconds
- With 5 threads, it takes ~10 seconds (5x faster!)

---

## ASSIGNMENT 2: Fleet Tracking

### What It Does
Tracks vehicle locations in a thread-safe way. Shows TWO different approaches from the book "Java Concurrency in Practice".

### The Problem
- Multiple vehicles update their positions at the same time
- A monitor thread needs to read all positions
- Must prevent race conditions (data corruption)

### Approach 1: MonitorVehicleTracker

**How It Works:**
```java
public synchronized void setLocation(String id, int x, int y) {
    MutablePoint loc = locations.get(id);
    loc.x = x;
    loc.y = y;
}
```
- Uses `synchronized` keyword
- Only one thread can update at a time
- Returns deep copies to prevent external modification

**Pros:**
- Simple to understand
- Thread-safe

**Cons:**
- Slower (single lock bottleneck)
- Must copy data every time

### Approach 2: DelegatingVehicleTracker

**How It Works:**
```java
public void setLocation(String id, int x, int y) {
    locations.replace(id, new Point(x, y));
}
```
- Uses `ConcurrentHashMap` (thread-safe collection)
- Uses immutable `Point` objects (can't be changed after creation)
- No explicit synchronization needed

**Pros:**
- Faster (lock-free reads)
- More scalable
- Simpler code

**Cons:**
- Slightly more complex design

### Key Difference

| Aspect | MonitorVehicleTracker | DelegatingVehicleTracker |
|--------|----------------------|--------------------------|
| Point Type | Mutable (can change) | Immutable (can't change) |
| Locking | Explicit (synchronized) | Delegated (ConcurrentHashMap) |
| Performance | Slower | Faster |
| View | Snapshot (copy) | Live view |

### Key Files
- `Point.java` - Immutable point (x, y)
- `MutablePoint.java` - Mutable point
- `MonitorVehicleTracker.java` - Approach 1
- `DelegatingVehicleTracker.java` - Approach 2
- `VehicleTrackerDemo.java` - Runs both

### How to Run
```cmd
cd assignment2
javac *.java
java VehicleTrackerDemo
```

### What You'll See
- Both implementations running for 3 seconds each
- Vehicles updating positions
- Monitor displaying all locations
- Both produce same results, different implementations

### Key Lesson
**Immutability + Delegation = Simpler, Faster Thread Safety**

---

## ASSIGNMENT 3: Ayo Game

### What It Does
Implements the traditional African board game Ayo (also called Mancala). You play against the computer.

### The Game

**Board Setup:**
```
Player 2:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
Store 2:  0                              Store 1:  0
Player 1:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
            1   2   3   4   5   6
```
- 2 rows of 6 pits each
- Each pit starts with 4 seeds
- Each player has a store (for captured seeds)

**How to Play:**
1. Choose a pit on your side (1-6)
2. Pick up all seeds from that pit
3. Sow seeds counter-clockwise, one per pit
4. If last seed lands in empty pit on your side AND opposite pit has seeds, capture them!
5. Game ends when one side is empty
6. Player with most seeds wins

### How the Code Works

**Class Structure:**
```
AyoGame (Controller)
    ├─> AyoBoard (Game State)
    └─> Player (Strategy)
            ├─> HumanPlayer (You)
            └─> ComputerPlayer (AI)
```

**Game Loop:**
```java
while (!board.isGameOver()) {
    board.display();
    int pit = currentPlayer.chooseMove(board);
    board.makeMove(pit, currentPlayer);
    switchPlayer();
}
```

**Human Player:**
```java
System.out.print("Choose a pit (1-6): ");
int choice = scanner.nextInt();
```
- Reads your input
- Validates it (must be 1-6 and pit must have seeds)

**Computer Player:**
```java
int[] validMoves = findValidMoves();
return validMoves[random.nextInt(validMoves.length)];
```
- Finds all valid moves
- Randomly picks one
- Simulates "thinking" with 1-second delay

### Key Files
- `AyoGame.java` - Main game controller
- `AyoBoard.java` - Board state and logic
- `Player.java` - Abstract player
- `HumanPlayer.java` - You
- `ComputerPlayer.java` - AI opponent

### How to Run
```cmd
cd assignment3
javac *.java
java AyoGame
```

### What You'll See
- Board display
- Prompt to choose pit
- Computer's moves
- Winner announcement

### Design Pattern Used
**Strategy Pattern** - Different player types (Human vs Computer) with same interface

---

## ASSIGNMENT 4: Dining Philosophers

### What It Does
Solves the classic "Dining Philosophers" problem and prevents three concurrency issues:
1. **Deadlock** - Everyone stuck waiting forever
2. **Livelock** - Everyone keeps trying but never succeeds
3. **Starvation** - Some people never get to eat

### The Problem

**Scenario:**
- 5 philosophers sit at a round table
- 5 forks (one between each pair)
- Each philosopher needs 2 forks to eat
- They alternate between thinking and eating

**What Can Go Wrong:**

**Deadlock:**
```
Philosopher 0 picks up fork 0
Philosopher 1 picks up fork 1
Philosopher 2 picks up fork 2
Philosopher 3 picks up fork 3
Philosopher 4 picks up fork 4
Now everyone waits for their right fork... FOREVER!
```

**Livelock:**
```
Philosopher 0 picks up fork 0, can't get fork 1, puts down fork 0
Philosopher 1 picks up fork 1, can't get fork 2, puts down fork 1
They keep doing this in sync... FOREVER!
```

**Starvation:**
```
Philosophers 0, 1, 2 keep eating
Philosophers 3, 4 never get a chance
```

### Our Solution (3 Layers)

**Layer 1: Prevent Deadlock**
```java
Semaphore diningPermits = new Semaphore(4, true);
```
- Only allow 4 philosophers to try eating at once
- With 4 competing for 5 forks, at least one can always get both
- Breaks the circular wait

**Layer 2: Prevent Livelock**
```java
if (leftFork.tryLock(100, TimeUnit.MILLISECONDS)) {
    if (rightFork.tryLock(100, TimeUnit.MILLISECONDS)) {
        eat();
    } else {
        leftFork.unlock();
        Thread.sleep(random.nextInt(50)); // Random backoff
    }
}
```
- Use timeout instead of blocking forever
- Random delay breaks synchronized retry patterns

**Layer 3: Prevent Starvation**
```java
Semaphore diningPermits = new Semaphore(4, true); // true = fair
```
- Fair semaphore uses FIFO queue
- Everyone gets equal opportunity
- Timeout ensures eventual success

### How It Works

**Philosopher Lifecycle:**
```
1. Think (random time)
2. Request permission to dine (semaphore)
3. Try to pick up left fork (with timeout)
4. Try to pick up right fork (with timeout)
5. If got both: EAT!
6. If failed: Release what you have, wait randomly, retry
7. Put down forks
8. Release permission
9. Repeat until ate 5 meals
```

### Key Files
- `Main.java` - Starts simulation
- `Philosopher.java` - Philosopher thread
- `Fork.java` - Fork with timeout locking
- `DiningTable.java` - Semaphore coordinator

### How to Run
```cmd
cd assignment4
javac *.java
java Main
```

### What You'll See
```
Philosopher 0 is EATING (meal #1)
Philosopher 2 is EATING (meal #1)
...
Statistics:
Philosopher 0: Meals=5, Failed=9
Philosopher 1: Meals=5, Failed=12
...
✓ No starvation - all ate 5 meals
✓ Perfect fairness
```

### Proof It Works
- All 5 philosophers eat exactly 5 meals (perfect fairness)
- Some failed attempts (59 total) but everyone eventually succeeds
- No deadlock (program completes)
- No livelock (progress is made)
- No starvation (everyone eats equally)

---

## ASSIGNMENT 5: Producer/Consumer

### What It Does
Implements the classic Producer/Consumer problem with a bounded buffer.

### The Problem

**Scenario:**
- 3 producers create items
- 2 consumers process items
- Shared buffer holds max 10 items
- Must be thread-safe

**Challenges:**
1. **Buffer Full** - Producers must wait
2. **Buffer Empty** - Consumers must wait
3. **Race Conditions** - Multiple threads accessing buffer
4. **Graceful Shutdown** - Stop cleanly without losing data

### Our Solution: BlockingQueue

**Why BlockingQueue?**
```java
BlockingQueue<Item> buffer = new LinkedBlockingQueue<>(10);
```
- Thread-safe (no race conditions)
- Automatic blocking (efficient waiting)
- Bounded capacity (memory protection)
- FIFO ordering (predictable)

### How It Works

**Producer:**
```java
while (itemsProduced < 10) {
    Item item = new Item(producerId, itemsProduced);
    buffer.put(item); // Blocks if buffer is full
    itemsProduced++;
}
```
- Creates items
- Adds to buffer
- Automatically waits if buffer is full

**Consumer:**
```java
while (!Thread.currentThread().isInterrupted()) {
    Item item = buffer.poll(1, TimeUnit.SECONDS); // Blocks if empty
    if (item != null) {
        processItem(item);
        itemsConsumed++;
    }
}
```
- Retrieves items from buffer
- Automatically waits if buffer is empty
- Uses timeout to allow interruption checking

**Coordination:**
```java
// Wait for producers to finish
for (Producer p : producers) {
    p.join();
}

// Wait for buffer to empty
while (!buffer.isEmpty()) {
    Thread.sleep(100);
}

// Stop consumers
for (Consumer c : consumers) {
    c.interrupt();
}
```

### Key Files
- `ProducerConsumer.java` - Main coordinator
- `Producer.java` - Producer thread
- `Consumer.java` - Consumer thread
- `Item.java` - Data item

### How to Run
```cmd
cd assignment5
javac *.java
java ProducerConsumer
```

### What You'll See
```
Producer-1 produced: Item{producer=1, seq=1}
Producer-2 produced: Item{producer=2, seq=1}
[Buffer size: 2]

Consumer-1 consumed: Item{producer=1, seq=1}
[Buffer size: 1]

...

Total produced: 30
Total consumed: 30
✓ SUCCESS: No data loss
```

### Why It Works
- **Thread-safe**: BlockingQueue handles all synchronization
- **No busy-waiting**: Threads sleep efficiently when waiting
- **No data loss**: 30 produced = 30 consumed
- **Graceful shutdown**: All threads stop cleanly

---

## KEY CONCEPTS SUMMARY

### Multithreading Concepts

**1. Thread Pool**
```java
ExecutorService executor = Executors.newFixedThreadPool(5);
```
- Reuses threads instead of creating new ones
- More efficient
- Used in: Assignment 1

**2. Thread-Safe Collections**
```java
ConcurrentHashMap<String, Integer> map;
```
- Multiple threads can access safely
- No race conditions
- Used in: Assignment 1, 2

**3. Synchronization**
```java
public synchronized void method() { }
```
- Only one thread at a time
- Prevents race conditions
- Used in: Assignment 2

**4. Immutability**
```java
public final int x, y; // Can't change after creation
```
- Immutable objects are inherently thread-safe
- No synchronization needed
- Used in: Assignment 2

**5. Semaphores**
```java
Semaphore permits = new Semaphore(4, true);
```
- Limits concurrent access
- Fair = FIFO queue
- Used in: Assignment 4

**6. Locks with Timeout**
```java
if (lock.tryLock(100, TimeUnit.MILLISECONDS)) { }
```
- Non-blocking lock attempt
- Prevents deadlock
- Used in: Assignment 4

**7. BlockingQueue**
```java
BlockingQueue<Item> queue = new LinkedBlockingQueue<>(10);
```
- Thread-safe queue
- Automatic blocking
- Used in: Assignment 5

### Design Patterns

**1. Thread Pool Pattern** (Assignment 1)
- Fixed number of worker threads
- Tasks submitted to pool
- Efficient resource management

**2. Monitor Pattern** (Assignment 2)
- Synchronized methods
- Intrinsic lock
- Simple but less scalable

**3. Delegation Pattern** (Assignment 2)
- Delegate thread safety to concurrent collections
- Simpler code
- Better performance

**4. Strategy Pattern** (Assignment 3)
- Different implementations of same interface
- HumanPlayer vs ComputerPlayer
- Easy to extend

**5. Producer-Consumer Pattern** (Assignment 5)
- Producers create data
- Consumers process data
- Buffer decouples them

### Concurrency Issues

**1. Deadlock**
- **Problem**: Circular wait for resources
- **Solution**: Resource ordering, semaphore limiting
- **Example**: Assignment 4

**2. Livelock**
- **Problem**: Threads keep changing state but no progress
- **Solution**: Random backoff
- **Example**: Assignment 4

**3. Starvation**
- **Problem**: Some threads never get resources
- **Solution**: Fair scheduling
- **Example**: Assignment 4

**4. Race Condition**
- **Problem**: Multiple threads accessing shared data
- **Solution**: Synchronization, thread-safe collections
- **Example**: All assignments

---

## QUICK REFERENCE

### Assignment 1: SERP Analysis
- **What**: Multithreaded paper analysis
- **Key Concept**: Thread pools, ConcurrentHashMap
- **Output**: Bar charts

### Assignment 2: Fleet Tracking
- **What**: Thread-safe vehicle tracking
- **Key Concept**: Synchronization vs Delegation
- **Output**: Vehicle positions

### Assignment 3: Ayo Game
- **What**: Traditional board game
- **Key Concept**: Strategy pattern, OOP
- **Output**: Interactive gameplay

### Assignment 4: Dining Philosophers
- **What**: Concurrency problem solution
- **Key Concept**: Deadlock/livelock/starvation prevention
- **Output**: Statistics proving fairness

### Assignment 5: Producer/Consumer
- **What**: Bounded buffer implementation
- **Key Concept**: BlockingQueue
- **Output**: 30 items produced and consumed

---

## FOR PRESENTATION

### What to Emphasize

**Assignment 1:**
- 5 threads working in parallel
- 5x faster than sequential
- Thread-safe data collection

**Assignment 2:**
- Two different approaches
- Immutability simplifies thread safety
- Delegation is better than explicit locking

**Assignment 3:**
- Clean object-oriented design
- Strategy pattern for players
- Traditional game implemented digitally

**Assignment 4:**
- All three issues prevented
- Statistics prove it works
- Multi-layered solution

**Assignment 5:**
- BlockingQueue simplifies everything
- No explicit synchronization needed
- Perfect success rate (no data loss)

---

**This guide covers everything you need to understand the code and explain it in the presentation!**


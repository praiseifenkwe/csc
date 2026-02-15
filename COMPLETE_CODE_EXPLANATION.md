# COMPLETE CODE EXPLANATION
## Understanding All 5 Assignments

**For**: All team members  
**Purpose**: Understand what each assignment does and how the code works

---

## 📚 TABLE OF CONTENTS

1. [Assignment 1: SERP Analysis](#assignment-1-serp-analysis)
2. [Assignment 2: Fleet Tracking](#assignment-2-fleet-tracking)
3. [Assignment 3: Ayo Game](#assignment-3-ayo-game)
4. [Assignment 4: Dining Philosophers](#assignment-4-dining-philosophers)
5. [Assignment 5: Producer/Consumer](#assignment-5-producerconsumer)

---

## ASSIGNMENT 1: SERP ANALYSIS

### What It Does
Analyzes research papers using multiple threads to extract information faster.

### The Problem
- Need to analyze 10+ papers
- Extracting features manually is slow
- Solution: Use 5 threads to work simultaneously

### How It Works

**Step 1: Create Thread Pool**
```java
ExecutorService executor = Executors.newFixedThreadPool(5);
```
- Creates 5 worker threads
- Like having 5 people working instead of 1

**Step 2: Distribute Work**
```java
for (int i = 0; i < 10; i++) {
    executor.submit(() -> analyzePaper(i));
}
```
- Each thread gets papers to analyze
- They work at the same time (concurrently)

**Step 3: Store Results Safely**
```java
ConcurrentHashMap<String, Integer> featureCounts;
```
- Multiple threads can add results without conflicts
- Thread-safe = no data corruption

**Step 4: Wait for Completion**
```java
latch.await();  // Wait for all threads to finish
```
- Makes sure all 10 papers are analyzed before continuing

**Step 5: Sort and Display**
- Count how many papers have each feature
- Sort by frequency (most common first)
- Create bar chart visualization

### What It Produces

**Part 1: Crime-Reporting Features**
```
1. Web Portal           : 6 systems (60%)
2. Crime Categories     : 5 systems (50%)
3. Real-time Tracking   : 5 systems (50%)
...
```
Plus a PNG chart: `output/crime_features_chart.png`

**Part 2: Deep Learning Sub-headings**
```
1. Comparison with Baselines : 8 papers (80%)
2. Transfer Learning         : 6 papers (60%)
3. Background                : 6 papers (60%)
...
```
Plus a PNG chart: `output/dl_headings_chart.png`

### Key Concepts
- **Multithreading**: Multiple tasks running simultaneously
- **Thread Pool**: Reusable group of worker threads
- **ConcurrentHashMap**: Thread-safe data storage
- **CountDownLatch**: Coordination between threads

### How to Run
```cmd
cd assignment1
javac src/*.java -d bin
echo 3 | java -cp bin Main
```

---

## ASSIGNMENT 2: FLEET TRACKING

### What It Does
Tracks vehicle locations with multiple threads updating positions simultaneously.

### The Problem
- Multiple vehicles updating positions at same time
- Need to prevent data corruption
- Two different solutions from the textbook

### Approach 1: MonitorVehicleTracker

**How It Works**:
```java
public synchronized Map<String, MutablePoint> getLocations() {
    return deepCopy(locations);
}
```

**Key Points**:
- `synchronized` = only one thread at a time
- `deepCopy` = makes a copy so original can't be changed
- Simple but slower (lock blocks other threads)

**Think of it like**:
- A notebook that only one person can write in at a time
- When someone reads it, they get a photocopy

### Approach 2: DelegatingVehicleTracker

**How It Works**:
```java
private final ConcurrentMap<String, Point> locations;

public Map<String, Point> getLocations() {
    return unmodifiableMap;  // Live view
}
```

**Key Points**:
- `ConcurrentMap` = multiple threads can access safely
- `Point` is immutable = can't be changed after creation
- No copying needed = faster
- No explicit locks = better performance

**Think of it like**:
- A digital display board
- Multiple people can update different parts
- Everyone sees live updates

### Comparison

| Feature | Monitor | Delegating |
|---------|---------|------------|
| Speed | Slower | Faster |
| Complexity | Simple | Moderate |
| Scalability | Limited | Better |
| View Type | Snapshot | Live |

### What It Produces
```
Vehicle-1: (0,0) → (1,1) → (2,2) → (3,3)
Vehicle-2: (0,0) → (1,1) → (2,2) → (3,3)
Vehicle-3: (0,0) → (1,1) → (2,2) → (3,3)
```
Both approaches work correctly!

### Key Concepts
- **Synchronization**: Controlling access to shared data
- **Immutability**: Objects that can't be changed
- **Delegation**: Letting another class handle thread safety
- **Live View vs Snapshot**: Different consistency guarantees

### How to Run
```cmd
cd assignment2
javac *.java
java VehicleTrackerDemo
```

---

## ASSIGNMENT 3: AYO GAME

### What It Does
Implements a traditional African board game where you play against the computer.

### The Game Rules

**Setup**:
```
Player 2:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
Store 2:  0                    Store 1:  0
Player 1:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
            1   2   3   4   5   6
```
- 6 pits per player
- 4 seeds in each pit
- Goal: Capture more seeds than opponent

**How to Play**:
1. Pick a pit on your side (1-6)
2. Pick up all seeds from that pit
3. Sow seeds counter-clockwise, one per pit
4. If last seed lands in empty pit on your side AND opposite pit has seeds:
   - Capture those seeds!
   - Add to your store

**Winning**:
- Game ends when one side is empty
- Player with most seeds in store wins

### How the Code Works

**Main Classes**:

1. **AyoGame** (Controller)
   - Manages game flow
   - Switches between players
   - Checks win condition

2. **AyoBoard** (Model)
   - Stores pit and store values
   - Executes moves
   - Displays board

3. **Player** (Strategy)
   - Abstract class
   - HumanPlayer: Gets input from user
   - ComputerPlayer: Randomly picks valid move

**Game Loop**:
```java
while (!board.isGameOver()) {
    board.display();
    int pit = currentPlayer.chooseMove(board);
    board.makeMove(pit, currentPlayer);
    switchPlayer();
}
announceWinner();
```

### What It Produces
```
Player 1's turn
Choose a pit (1-6): 3

[Board updates with seed distribution]

Computer's turn
Computer chose pit 4

[Game continues until one side empty]

=== GAME OVER ===
Player 1: 28 seeds
Computer: 20 seeds
🏆 Player 1 WINS!
```

### Key Concepts
- **MVC Pattern**: Model-View-Controller separation
- **Strategy Pattern**: Different player behaviors
- **Inheritance**: HumanPlayer and ComputerPlayer extend Player
- **Game Logic**: Turn-based gameplay

### How to Run
```cmd
cd assignment3
javac *.java
java AyoGame
```
Then enter pit numbers 1-6 when prompted!

---

## ASSIGNMENT 4: DINING PHILOSOPHERS

### What It Does
Solves a classic concurrency problem where 5 philosophers need to share 5 forks.

### The Problem

**Setup**:
- 5 philosophers sit at round table
- 5 forks (one between each pair)
- Each philosopher needs 2 forks to eat
- They alternate: Think → Eat → Think → Eat...

**Three Issues to Prevent**:

1. **Deadlock**: All stuck waiting forever
   - Example: All pick up left fork, wait for right fork forever

2. **Livelock**: Keep trying but never succeed
   - Example: Pick up fork, can't get second, put down, retry, repeat forever

3. **Starvation**: Some never get to eat
   - Example: Philosopher 0 eats 10 times, Philosopher 4 eats 0 times

### Our Solution (Three Layers)

**Layer 1: Prevent Deadlock**
```java
Semaphore diningPermits = new Semaphore(4, true);
```
- Only 4 of 5 can try to eat at once
- Guarantees at least one can get both forks
- Breaks circular wait

**Layer 2: Prevent Livelock**
```java
if (leftFork.tryLock(100, TimeUnit.MILLISECONDS)) {
    // Got it!
} else {
    // Timeout - try again later
    Thread.sleep(random.nextInt(50));  // Random delay
}
```
- Timeout prevents infinite waiting
- Random delay breaks synchronized retries

**Layer 3: Prevent Starvation**
```java
Semaphore diningPermits = new Semaphore(4, true);  // true = fair
```
- Fair semaphore = FIFO queue
- Everyone gets equal opportunity
- No one is left out

### How It Works

**Philosopher Lifecycle**:
```
1. Think (random time)
2. Request permission to dine (semaphore)
3. Try to pick up left fork (with timeout)
4. Try to pick up right fork (with timeout)
5. If got both: EAT!
6. Put down forks
7. Release permission
8. Repeat
```

### What It Produces
```
Philosopher 0: Meals=5, Failed=9
Philosopher 1: Meals=5, Failed=12
Philosopher 2: Meals=5, Failed=13
Philosopher 3: Meals=5, Failed=10
Philosopher 4: Meals=5, Failed=15

✓ No starvation - all ate 5 meals
✓ Perfect fairness!
```

### Key Concepts
- **Semaphore**: Limits concurrent access
- **Timeout**: Prevents indefinite waiting
- **Fair Scheduling**: FIFO queue for equality
- **Random Backoff**: Breaks synchronization patterns

### How to Run
```cmd
cd assignment4
javac *.java
java Main
```

---

## ASSIGNMENT 5: PRODUCER/CONSUMER

### What It Does
Multiple threads produce items while other threads consume them, using a shared buffer.

### The Problem

**Setup**:
- 3 producer threads making items
- 2 consumer threads processing items
- Shared buffer (size 10)

**Challenges**:
- What if buffer is full? (Producers must wait)
- What if buffer is empty? (Consumers must wait)
- How to prevent data corruption?

### Our Solution: BlockingQueue

**Why BlockingQueue?**
```java
BlockingQueue<Item> buffer = new LinkedBlockingQueue<>(10);
```

**Magic Features**:
1. **Automatic Blocking**:
   - `put()` blocks if buffer full
   - `poll()` blocks if buffer empty

2. **Thread-Safe**:
   - Multiple threads can use it safely
   - No explicit locks needed

3. **Bounded**:
   - Fixed size (10 items)
   - Prevents unlimited memory use

### How It Works

**Producer**:
```java
while (itemsProduced < 10) {
    Item item = new Item(producerId, itemsProduced);
    buffer.put(item);  // Blocks if buffer full
    itemsProduced++;
}
```

**Consumer**:
```java
while (!interrupted) {
    Item item = buffer.poll(1, TimeUnit.SECONDS);  // Blocks if empty
    if (item != null) {
        processItem(item);
        itemsConsumed++;
    }
}
```

**Coordination**:
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

### What It Produces
```
Producer-1 produced: Item{producer=1, seq=1}
Producer-2 produced: Item{producer=2, seq=1}
[Buffer size: 2]

Consumer-1 consumed: Item{producer=1, seq=1}
[Buffer size: 1]

...

Producer Statistics:
Total produced: 30 items

Consumer Statistics:
Total consumed: 30 items

✓ SUCCESS: No data loss!
```

### Key Concepts
- **Producer-Consumer Pattern**: Classic concurrency pattern
- **Bounded Buffer**: Fixed-size queue
- **BlockingQueue**: Java's thread-safe queue
- **Automatic Blocking**: Efficient waiting without busy-loops

### How to Run
```cmd
cd assignment5
javac *.java
java ProducerConsumer
```

---

## 🎯 QUICK COMPARISON

| Assignment | Main Concept | Key Technique |
|------------|--------------|---------------|
| 1 | Multithreading | Thread Pool + ConcurrentHashMap |
| 2 | Thread Safety | Synchronization vs Delegation |
| 3 | Game Logic | OOP + Strategy Pattern |
| 4 | Concurrency Issues | Semaphore + Timeout + Fairness |
| 5 | Bounded Buffer | BlockingQueue |

---

## 💡 KEY TAKEAWAYS

### Assignment 1
- **Lesson**: Multithreading speeds up independent tasks
- **Real Use**: Web scraping, data processing

### Assignment 2
- **Lesson**: Immutability simplifies thread safety
- **Real Use**: GPS tracking, real-time systems

### Assignment 3
- **Lesson**: Clean OOP design for complex logic
- **Real Use**: Game development, interactive systems

### Assignment 4
- **Lesson**: Multiple techniques needed for complex concurrency
- **Real Use**: Database transactions, resource allocation

### Assignment 5
- **Lesson**: Use high-level utilities (BlockingQueue) when available
- **Real Use**: Message queues, logging systems, thread pools

---

## 🔧 HOW TO TEST EVERYTHING

### Quick Test All Assignments:
```cmd
REM Assignment 1
cd assignment1
javac src/*.java -d bin
echo 3 | java -cp bin Main

REM Assignment 2
cd assignment2
javac *.java
java VehicleTrackerDemo

REM Assignment 3 (interactive)
cd assignment3
javac *.java
java AyoGame

REM Assignment 4
cd assignment4
javac *.java
java Main

REM Assignment 5
cd assignment5
javac *.java
java ProducerConsumer
```

---

## 📚 FOR MORE DETAILS

- **DETAILED_ASSIGNMENT_GUIDE.md**: More detailed explanations
- **EXPECTED_OUTPUTS.md**: What you should see when running
- **Each assignment's README.md**: Specific instructions

---

## ❓ COMMON QUESTIONS

**Q: Why use multithreading?**
A: Makes programs faster by doing multiple things at once

**Q: What's the difference between synchronized and ConcurrentHashMap?**
A: synchronized = one at a time, ConcurrentHashMap = multiple can access safely

**Q: Why is immutability important?**
A: Immutable objects can't be changed, so they're automatically thread-safe

**Q: What's a semaphore?**
A: A counter that limits how many threads can do something at once

**Q: Why use BlockingQueue?**
A: It handles all the thread safety and blocking automatically

---

**Created**: February 15, 2026  
**For**: CSC310 Team Understanding  
**Status**: All assignments explained ✅


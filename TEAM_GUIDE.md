# CSC310 Programming Assignments - Team Guide

**For Team Members** 👥  
**Last Updated**: February 14, 2026

---

## 📋 Table of Contents

1. [Project Overview](#project-overview)
2. [Folder Structure](#folder-structure)
3. [How to Navigate](#how-to-navigate)
4. [Running Each Assignment](#running-each-assignment)
5. [Understanding the Code](#understanding-the-code)
6. [Documentation Guide](#documentation-guide)
7. [Common Issues & Solutions](#common-issues--solutions)

**💡 TIP**: For detailed explanations with expected outputs, see **[DETAILED_ASSIGNMENT_GUIDE.md](DETAILED_ASSIGNMENT_GUIDE.md)**

---

## 📁 Project Overview

This repository contains **5 completed programming assignments** for CSC310. Each assignment is in its own folder with complete source code and documentation.

### Quick Status
- ✅ Assignment 1: SERP Analysis (Multithreading)
- ✅ Assignment 2: Fleet Tracking (Thread Safety)
- ✅ Assignment 3: Ayo Game (Board Game)
- ✅ Assignment 4: Dining Philosophers (Concurrency)
- ✅ Assignment 5: Producer/Consumer (Synchronization)

---

## 📂 Folder Structure

### Root Directory
```
csc/
├── assignment1/              # Assignment 1 - SERP Analysis
├── assignment2/              # Assignment 2 - Fleet Tracking
├── assignment3/              # Assignment 3 - Ayo Game
├── assignment4/              # Assignment 4 - Dining Philosophers
├── assignment5/              # Assignment 5 - Producer/Consumer
├── output/                   # Generated visualizations
├── README.md                 # Main project overview
├── TEAM_GUIDE.md            # This file - START HERE!
├── QUICK_START_GUIDE.md     # Quick reference for running code
├── ALL_ASSIGNMENTS_SUMMARY.md    # Detailed summary of all assignments
├── SUBMISSION_CHECKLIST.md  # What to submit
└── FINAL_COMPLETION_REPORT.md    # Final report
```

### Assignment 1 Structure
```
assignment1/
├── src/                      # Source code folder
│   ├── Main.java            # Entry point - run this
│   ├── CrimeReportingAnalyzer.java    # Analyzes crime papers
│   ├── DeepLearningPapersAnalyzer.java # Analyzes DL papers
│   └── DataVisualizer.java  # Creates charts
├── bin/                      # Compiled classes (auto-generated)
├── README.md                 # How to use Assignment 1
├── IMPLEMENTATION_GUIDE.md  # Technical details
└── ASSIGNMENT_SUMMARY.md    # Complete summary
```

**What it does**: Analyzes papers using multiple threads and creates visualizations

**How to run**:
```cmd
cd assignment1
javac src/*.java -d bin
echo 3 | java -cp bin Main
```

### Assignment 2 Structure
```
assignment2/
├── Point.java                        # Immutable point class
├── MutablePoint.java                 # Mutable point class
├── MonitorVehicleTracker.java        # Approach 1: Synchronized
├── DelegatingVehicleTracker.java     # Approach 2: ConcurrentHashMap
├── VehicleTrackerDemo.java           # Main demo - run this
├── README.md                         # How to use Assignment 2
└── IMPLEMENTATION_NOTES.md           # Technical details
```

**What it does**: Shows two ways to track vehicles safely with multiple threads

**How to run**:
```cmd
cd assignment2
javac *.java
java VehicleTrackerDemo
```

### Assignment 3 Structure
```
assignment3/
├── AyoGame.java              # Main game controller - run this
├── AyoBoard.java             # Game board logic
├── Player.java               # Base player class
├── HumanPlayer.java          # Human player (you)
├── ComputerPlayer.java       # AI opponent
├── README.md                 # How to play
└── ASSIGNMENT_SUMMARY.md     # Complete summary
```

**What it does**: Traditional Ayo/Mancala board game (Human vs Computer)

**How to run**:
```cmd
cd assignment3
javac *.java
java AyoGame
```

### Assignment 4 Structure
```
assignment4/
├── Main.java                 # Main program - run this
├── Philosopher.java          # Philosopher thread
├── Fork.java                 # Fork (chopstick) resource
├── DiningTable.java          # Manages dining permissions
├── README.md                 # How to use Assignment 4
├── IMPLEMENTATION_NOTES.md   # Technical details
└── ASSIGNMENT_SUMMARY.md     # Complete summary
```

**What it does**: Solves dining philosophers problem (prevents deadlock/livelock/starvation)

**How to run**:
```cmd
cd assignment4
javac *.java
java Main
```

### Assignment 5 Structure
```
assignment5/
├── ProducerConsumer.java     # Main program - run this
├── Producer.java             # Producer thread
├── Consumer.java             # Consumer thread
├── Item.java                 # Item being produced/consumed
├── README.md                 # How to use Assignment 5
├── IMPLEMENTATION_NOTES.md   # Technical details
└── ASSIGNMENT_SUMMARY.md     # Complete summary
```

**What it does**: Producer/Consumer problem with bounded buffer

**How to run**:
```cmd
cd assignment5
javac *.java
java ProducerConsumer
```

---

## 🗺️ How to Navigate

### For First-Time Users

1. **Start Here**: Read this file (TEAM_GUIDE.md)
2. **Quick Overview**: Read [README.md](README.md) in root folder
3. **Pick an Assignment**: Go to any assignment folder
4. **Read Assignment README**: Each folder has its own README.md
5. **Run the Code**: Follow the "How to run" instructions
6. **Understand the Code**: Read IMPLEMENTATION_NOTES.md

### For Quick Testing

1. Open [QUICK_START_GUIDE.md](QUICK_START_GUIDE.md)
2. Copy the commands for the assignment you want to test
3. Paste in terminal and run

### For Understanding Implementation

1. Go to assignment folder
2. Read README.md first (overview)
3. Read IMPLEMENTATION_NOTES.md (technical details)
4. Read the source code (well-commented)

---

## 🚀 Running Each Assignment

### Assignment 1: SERP Analysis

**Location**: `assignment1/`

**Steps**:
```cmd
cd assignment1
javac src/*.java -d bin
echo 3 | java -cp bin Main
```

**What to expect**:
- Console output showing analysis progress
- Two PNG charts created in `output/` folder
- Takes about 15-20 seconds

**Output files**:
- `output/crime_features_chart.png`
- `output/dl_headings_chart.png`

---

### Assignment 2: Fleet Tracking

**Location**: `assignment2/`

**Steps**:
```cmd
cd assignment2
javac *.java
java VehicleTrackerDemo
```

**What to expect**:
- Two implementations run sequentially
- Vehicle positions update in real-time
- Takes about 6 seconds total
- Shows thread-safe vehicle tracking

---

### Assignment 3: Ayo Game

**Location**: `assignment3/`

**Steps**:
```cmd
cd assignment3
javac *.java
java AyoGame
```

**What to expect**:
- Interactive board game
- You play against computer
- Enter pit numbers (1-6) when prompted
- Game ends when one side is empty
- Takes 5-15 minutes depending on gameplay

**How to play**:
1. Board shows your pits (bottom row) numbered 1-6
2. Choose a pit number
3. Seeds are distributed counter-clockwise
4. Try to capture opponent's seeds
5. Player with most seeds wins

---

### Assignment 4: Dining Philosophers

**Location**: `assignment4/`

**Steps**:
```cmd
cd assignment4
javac *.java
java Main
```

**What to expect**:
- 5 philosophers eating with 5 forks
- Real-time updates of who's eating
- Takes about 30-60 seconds
- Shows no deadlock/livelock/starvation
- Final statistics displayed

---

### Assignment 5: Producer/Consumer

**Location**: `assignment5/`

**Steps**:
```cmd
cd assignment5
javac *.java
java ProducerConsumer
```

**What to expect**:
- 3 producers creating items
- 2 consumers processing items
- Buffer size shown in real-time
- Takes about 10-20 seconds
- Shows thread-safe operations

---

## 📖 Understanding the Code

### Assignment 1: SERP Analysis

**Main Concepts**:
- **Multithreading**: Uses thread pools (ExecutorService)
- **Thread Safety**: ConcurrentHashMap for shared data
- **Coordination**: CountDownLatch to wait for threads

**Key Files**:
- `Main.java`: Entry point, menu system
- `CrimeReportingAnalyzer.java`: Analyzes crime papers with 5 threads
- `DeepLearningPapersAnalyzer.java`: Analyzes DL papers with 5 threads
- `DataVisualizer.java`: Creates bar charts

**Flow**:
1. User selects analysis type
2. Thread pool created with 5 workers
3. Each thread analyzes papers concurrently
4. Results aggregated in thread-safe map
5. Visualization generated

---

### Assignment 2: Fleet Tracking

**Main Concepts**:
- **Thread Safety**: Two different approaches
- **Synchronization**: Synchronized methods vs ConcurrentHashMap
- **Immutability**: Immutable vs mutable objects

**Key Files**:
- `VehicleTrackerDemo.java`: Runs both implementations
- `MonitorVehicleTracker.java`: Uses synchronized methods
- `DelegatingVehicleTracker.java`: Uses ConcurrentHashMap
- `Point.java`: Immutable point
- `MutablePoint.java`: Mutable point

**Two Approaches**:
1. **Monitor**: Synchronized methods + defensive copying
2. **Delegating**: ConcurrentHashMap + immutable objects

---

### Assignment 3: Ayo Game

**Main Concepts**:
- **Object-Oriented Design**: Inheritance (Player hierarchy)
- **Game Logic**: Turn-based gameplay
- **AI**: Simple random move selection

**Key Files**:
- `AyoGame.java`: Game controller, manages turns
- `AyoBoard.java`: Board state, move validation
- `Player.java`: Abstract player class
- `HumanPlayer.java`: Gets input from user
- `ComputerPlayer.java`: AI opponent

**Flow**:
1. Board initialized with seeds
2. Players take turns
3. Seeds distributed counter-clockwise
4. Captures happen when landing in empty pit
5. Game ends when one side empty
6. Winner determined by seed count

---

### Assignment 4: Dining Philosophers

**Main Concepts**:
- **Deadlock Prevention**: Semaphore limits concurrent diners
- **Livelock Prevention**: Timeout + random backoff
- **Starvation Prevention**: Fair semaphore

**Key Files**:
- `Main.java`: Sets up and runs simulation
- `Philosopher.java`: Philosopher thread (think/eat cycle)
- `Fork.java`: Fork resource with timeout locking
- `DiningTable.java`: Semaphore-based permission system

**How it prevents issues**:
- **Deadlock**: Only 4 of 5 can dine at once (semaphore)
- **Livelock**: Timeout on fork acquisition + random backoff
- **Starvation**: Fair semaphore ensures everyone gets a turn

---

### Assignment 5: Producer/Consumer

**Main Concepts**:
- **Bounded Buffer**: Fixed-size queue (BlockingQueue)
- **Thread Safety**: BlockingQueue handles synchronization
- **Blocking**: Automatic waiting when full/empty

**Key Files**:
- `ProducerConsumer.java`: Main controller
- `Producer.java`: Creates items, adds to buffer
- `Consumer.java`: Takes items, processes them
- `Item.java`: Data being produced/consumed

**Flow**:
1. Shared buffer created (size 10)
2. 3 producers start creating items
3. 2 consumers start processing items
4. Producers block when buffer full
5. Consumers block when buffer empty
6. All items eventually consumed

---

## 📚 Documentation Guide

### Where to Find Information

| Question | Document to Read |
|----------|------------------|
| What does this assignment do? | Assignment's README.md |
| What output should I expect? | DETAILED_ASSIGNMENT_GUIDE.md |
| How do I run it? | Assignment's README.md or QUICK_START_GUIDE.md |
| How does it work technically? | IMPLEMENTATION_NOTES.md or IMPLEMENTATION_GUIDE.md |
| What are the test results? | ASSIGNMENT_SUMMARY.md |
| Overview of all assignments? | ALL_ASSIGNMENTS_SUMMARY.md |
| What to submit? | SUBMISSION_CHECKLIST.md |
| Final report? | FINAL_COMPLETION_REPORT.md |

### Reading Order for Each Assignment

1. **README.md** - Start here (overview, how to run)
2. **Source Code** - Read the main file first
3. **IMPLEMENTATION_NOTES.md** - Technical details
4. **ASSIGNMENT_SUMMARY.md** - Complete summary

---

## 🔧 Common Issues & Solutions

### Issue: "Class not found" error

**Solution**: Make sure you're in the correct directory
```cmd
REM Check current directory
cd

REM Navigate to assignment folder
cd assignment1
```

### Issue: Compilation errors

**Solution**: Check Java version
```cmd
java -version
REM Should be Java 8 or higher
```

### Issue: Assignment 1 - No visualizations

**Solution**: Check the output folder
```cmd
dir output
REM Should see two PNG files
```

### Issue: Assignment 3 - Game won't start

**Solution**: Make sure all files are compiled
```cmd
cd assignment3
javac *.java
java AyoGame
```

### Issue: Assignment 4 - Program hangs

**Solution**: This is normal! It runs for 30-60 seconds. Wait for completion.

### Issue: Assignment 5 - Mismatch in produced/consumed

**Solution**: This is a timing issue. Run again - it should work correctly.

---

## 👥 Team Collaboration Tips

### For Code Review

1. **Start with README**: Understand what the assignment does
2. **Check Main File**: Find the entry point
3. **Follow the Flow**: Trace execution from main
4. **Read Comments**: Code is well-commented
5. **Run the Code**: See it in action

### For Presentation

1. **Assignment 1**: Show the visualizations (PNG files)
2. **Assignment 2**: Explain the two approaches
3. **Assignment 3**: Play a quick game
4. **Assignment 4**: Show the statistics (no deadlock!)
5. **Assignment 5**: Show the buffer size changes

### For Understanding

1. **Don't panic**: Start with one assignment
2. **Read README first**: Get the overview
3. **Run the code**: See what it does
4. **Read implementation notes**: Understand how
5. **Ask questions**: Use the documentation

---

## 📝 Quick Reference

### Compile All
```cmd
javac assignment1/src/*.java -d assignment1/bin
javac assignment2/*.java
javac assignment3/*.java
javac assignment4/*.java
javac assignment5/*.java
```

### Run All (One by One)
```cmd
echo 3 | java -cp assignment1/bin Main
java -cp assignment2 VehicleTrackerDemo
java -cp assignment3 AyoGame
java -cp assignment4 Main
java -cp assignment5 ProducerConsumer
```

### Key Concepts by Assignment

| Assignment | Key Concept |
|------------|-------------|
| 1 | Multithreading with thread pools |
| 2 | Thread-safe data structures |
| 3 | Object-oriented game design |
| 4 | Deadlock/livelock/starvation prevention |
| 5 | Producer-consumer with bounded buffer |

---

## 🎯 For Team Presentation

### What to Highlight

**Assignment 1**:
- "We used 5 threads to analyze papers concurrently"
- "Generated visualizations showing feature frequencies"
- Show the PNG charts

**Assignment 2**:
- "Implemented two thread-safe approaches from the textbook"
- "One uses synchronized methods, other uses ConcurrentHashMap"
- Show both implementations running

**Assignment 3**:
- "Traditional African board game with AI opponent"
- "Demonstrates object-oriented design with inheritance"
- Play a quick game

**Assignment 4**:
- "Prevents all three concurrency issues: deadlock, livelock, starvation"
- "Uses semaphore, timeout, and fair locking"
- Show the statistics proving no issues

**Assignment 5**:
- "Classic producer-consumer with bounded buffer"
- "Uses BlockingQueue for automatic synchronization"
- Show that all items produced were consumed

---

## 📞 Need Help?

### Documentation Hierarchy

1. **This file (TEAM_GUIDE.md)** - Team overview
2. **README.md** - Project overview
3. **QUICK_START_GUIDE.md** - Quick commands
4. **Assignment README** - Specific assignment help
5. **IMPLEMENTATION_NOTES** - Technical details

### Still Confused?

1. Read the assignment's README.md
2. Run the code and see what happens
3. Read the source code comments
4. Check IMPLEMENTATION_NOTES.md
5. Review the test results in ASSIGNMENT_SUMMARY.md

---

## ✅ Team Checklist

Before presentation/submission:

- [ ] Everyone has read this TEAM_GUIDE.md
- [ ] Everyone can compile all assignments
- [ ] Everyone can run all assignments
- [ ] Everyone understands what each assignment does
- [ ] Everyone knows which files to look at
- [ ] Everyone has read the main README.md
- [ ] Team has reviewed all documentation
- [ ] Team has tested all assignments

---

**Good luck with your presentation and submission!** 🎓✨

---

**Questions?** Check the documentation files or run the code to see it in action!

# Complete Folder Structure - Visual Guide

**For Team Members** 👥  
**Quick Reference for Navigation**

---

## 📂 Complete Project Tree

```
csc/
│
├── 📄 README.md                          ⭐ START HERE - Main overview
├── 📄 TEAM_GUIDE.md                      ⭐ FOR TEAMMATES - Read this!
├── 📄 QUICK_START_GUIDE.md               Quick commands reference
├── 📄 ALL_ASSIGNMENTS_SUMMARY.md         Detailed summary of all
├── 📄 SUBMISSION_CHECKLIST.md            What to submit
├── 📄 FINAL_COMPLETION_REPORT.md         Final report
├── 📄 FOLDER_STRUCTURE.md                This file
│
├── 📁 output/                            Generated visualizations
│   ├── 🖼️ crime_features_chart.png      Assignment 1 output
│   └── 🖼️ dl_headings_chart.png         Assignment 1 output
│
├── 📁 assignment1/                       ✅ SERP Analysis
│   ├── 📁 src/                          Source code folder
│   │   ├── 📄 Main.java                 ⭐ RUN THIS - Entry point
│   │   ├── 📄 CrimeReportingAnalyzer.java
│   │   ├── 📄 DeepLearningPapersAnalyzer.java
│   │   └── 📄 DataVisualizer.java
│   ├── 📁 bin/                          Compiled classes (auto-generated)
│   ├── 📄 README.md                     How to use this assignment
│   ├── 📄 IMPLEMENTATION_GUIDE.md       Technical details
│   ├── 📄 ASSIGNMENT_SUMMARY.md         Complete summary
│   └── 📄 USAGE.md                      Usage instructions
│
├── 📁 assignment2/                       ✅ Fleet Tracking
│   ├── 📄 VehicleTrackerDemo.java       ⭐ RUN THIS - Main demo
│   ├── 📄 Point.java                    Immutable point
│   ├── 📄 MutablePoint.java             Mutable point
│   ├── 📄 MonitorVehicleTracker.java    Approach 1: Synchronized
│   ├── 📄 DelegatingVehicleTracker.java Approach 2: ConcurrentHashMap
│   ├── 📄 README.md                     How to use this assignment
│   └── 📄 IMPLEMENTATION_NOTES.md       Technical details
│
├── 📁 assignment3/                       ✅ Ayo Game
│   ├── 📄 AyoGame.java                  ⭐ RUN THIS - Main game
│   ├── 📄 AyoBoard.java                 Game board logic
│   ├── 📄 Player.java                   Base player class
│   ├── 📄 HumanPlayer.java              Human player
│   ├── 📄 ComputerPlayer.java           AI opponent
│   ├── 📄 README.md                     How to play
│   └── 📄 ASSIGNMENT_SUMMARY.md         Complete summary
│
├── 📁 assignment4/                       ✅ Dining Philosophers
│   ├── 📄 Main.java                     ⭐ RUN THIS - Main program
│   ├── 📄 Philosopher.java              Philosopher thread
│   ├── 📄 Fork.java                     Fork resource
│   ├── 📄 DiningTable.java              Dining permissions
│   ├── 📄 README.md                     How to use this assignment
│   ├── 📄 IMPLEMENTATION_NOTES.md       Technical details
│   └── 📄 ASSIGNMENT_SUMMARY.md         Complete summary
│
└── 📁 assignment5/                       ✅ Producer/Consumer
    ├── 📄 ProducerConsumer.java         ⭐ RUN THIS - Main program
    ├── 📄 Producer.java                 Producer thread
    ├── 📄 Consumer.java                 Consumer thread
    ├── 📄 Item.java                     Item class
    ├── 📄 README.md                     How to use this assignment
    ├── 📄 IMPLEMENTATION_NOTES.md       Technical details
    └── 📄 ASSIGNMENT_SUMMARY.md         Complete summary
```

---

## 🎯 Quick Navigation Guide

### For First-Time Users

```
1. Read: README.md (root)
   ↓
2. Read: TEAM_GUIDE.md
   ↓
3. Pick an assignment folder
   ↓
4. Read: assignment's README.md
   ↓
5. Run the main file (marked with ⭐)
```

### For Running Code

```
Assignment 1: cd assignment1 → javac src/*.java -d bin → java -cp bin Main
Assignment 2: cd assignment2 → javac *.java → java VehicleTrackerDemo
Assignment 3: cd assignment3 → javac *.java → java AyoGame
Assignment 4: cd assignment4 → javac *.java → java Main
Assignment 5: cd assignment5 → javac *.java → java ProducerConsumer
```

### For Understanding Code

```
1. Go to assignment folder
   ↓
2. Read README.md (overview)
   ↓
3. Read main file (marked with ⭐)
   ↓
4. Read IMPLEMENTATION_NOTES.md (technical)
   ↓
5. Read other source files
```

---

## 📋 File Types Explained

### 📄 .java Files
- **Source code** - The actual program
- **Well-commented** - Explains what code does
- **Compile first** - Use `javac` command

### 📄 .md Files
- **Documentation** - Explains the project
- **Markdown format** - Easy to read
- **Open with any text editor**

### 📁 Folders
- **Organize files** - Keep things tidy
- **Navigate with cd** - Change directory command

### 🖼️ .png Files
- **Images** - Visualizations from Assignment 1
- **Open with image viewer**

---

## 🗂️ Assignment-Specific Structures

### Assignment 1 (Detailed)

```
assignment1/
│
├── 📁 src/                              SOURCE CODE FOLDER
│   │
│   ├── 📄 Main.java                     ⭐ START HERE
│   │   └── Purpose: Entry point, menu system
│   │   └── Run: java -cp bin Main
│   │
│   ├── 📄 CrimeReportingAnalyzer.java
│   │   └── Purpose: Analyzes crime-reporting papers
│   │   └── Uses: 5 threads, ConcurrentHashMap
│   │
│   ├── 📄 DeepLearningPapersAnalyzer.java
│   │   └── Purpose: Analyzes deep learning papers
│   │   └── Uses: 5 threads, ConcurrentHashMap
│   │
│   └── 📄 DataVisualizer.java
│       └── Purpose: Creates bar charts
│       └── Output: PNG files in output/ folder
│
├── 📁 bin/                              COMPILED CLASSES
│   └── (Auto-generated .class files)
│
├── 📄 README.md                         📖 READ FIRST
│   └── What: Overview and usage
│
├── 📄 IMPLEMENTATION_GUIDE.md           🔧 TECHNICAL DETAILS
│   └── What: How it works internally
│
└── 📄 ASSIGNMENT_SUMMARY.md             📊 COMPLETE SUMMARY
    └── What: Test results and analysis
```

### Assignment 2 (Detailed)

```
assignment2/
│
├── 📄 VehicleTrackerDemo.java           ⭐ START HERE
│   └── Purpose: Runs both implementations
│   └── Shows: Two thread-safe approaches
│
├── 📄 MonitorVehicleTracker.java        APPROACH 1
│   └── Uses: Synchronized methods
│   └── With: MutablePoint + defensive copying
│
├── 📄 DelegatingVehicleTracker.java     APPROACH 2
│   └── Uses: ConcurrentHashMap
│   └── With: Immutable Point
│
├── 📄 Point.java                        IMMUTABLE
│   └── Purpose: Thread-safe by design
│
├── 📄 MutablePoint.java                 MUTABLE
│   └── Purpose: Needs synchronization
│
├── 📄 README.md                         📖 READ FIRST
│
└── 📄 IMPLEMENTATION_NOTES.md           🔧 TECHNICAL DETAILS
```

### Assignment 3 (Detailed)

```
assignment3/
│
├── 📄 AyoGame.java                      ⭐ START HERE
│   └── Purpose: Game controller
│   └── Manages: Turns, moves, winner
│
├── 📄 AyoBoard.java                     GAME STATE
│   └── Purpose: Board representation
│   └── Handles: Pits, stores, validation
│
├── 📄 Player.java                       BASE CLASS
│   └── Purpose: Abstract player
│   └── Extended by: HumanPlayer, ComputerPlayer
│
├── 📄 HumanPlayer.java                  YOU
│   └── Purpose: Interactive player
│   └── Gets: Input from console
│
├── 📄 ComputerPlayer.java               AI
│   └── Purpose: Computer opponent
│   └── Strategy: Random valid moves
│
├── 📄 README.md                         📖 READ FIRST
│
└── 📄 ASSIGNMENT_SUMMARY.md             📊 COMPLETE SUMMARY
```

### Assignment 4 (Detailed)

```
assignment4/
│
├── 📄 Main.java                         ⭐ START HERE
│   └── Purpose: Sets up simulation
│   └── Creates: Philosophers, forks, table
│
├── 📄 Philosopher.java                  THREAD
│   └── Purpose: Philosopher behavior
│   └── Does: Think, eat, repeat
│
├── 📄 Fork.java                         RESOURCE
│   └── Purpose: Shared resource (chopstick)
│   └── Uses: ReentrantLock with timeout
│
├── 📄 DiningTable.java                  COORDINATOR
│   └── Purpose: Manages permissions
│   └── Uses: Semaphore (4 of 5 can dine)
│
├── 📄 README.md                         📖 READ FIRST
│
├── 📄 IMPLEMENTATION_NOTES.md           🔧 TECHNICAL DETAILS
│
└── 📄 ASSIGNMENT_SUMMARY.md             📊 COMPLETE SUMMARY
```

### Assignment 5 (Detailed)

```
assignment5/
│
├── 📄 ProducerConsumer.java             ⭐ START HERE
│   └── Purpose: Main controller
│   └── Creates: Buffer, producers, consumers
│
├── 📄 Producer.java                     THREAD
│   └── Purpose: Creates items
│   └── Adds to: Shared buffer
│
├── 📄 Consumer.java                     THREAD
│   └── Purpose: Processes items
│   └── Takes from: Shared buffer
│
├── 📄 Item.java                         DATA
│   └── Purpose: Item being produced/consumed
│   └── Contains: ID, timestamp
│
├── 📄 README.md                         📖 READ FIRST
│
├── 📄 IMPLEMENTATION_NOTES.md           🔧 TECHNICAL DETAILS
│
└── 📄 ASSIGNMENT_SUMMARY.md             📊 COMPLETE SUMMARY
```

---

## 🎨 Color-Coded Legend

- ⭐ **Main File** - Run this file
- 📄 **Source File** - Java code
- 📁 **Folder** - Directory
- 🖼️ **Image** - PNG visualization
- 📖 **Overview** - Start reading here
- 🔧 **Technical** - Deep dive details
- 📊 **Summary** - Results and analysis

---

## 📍 Where to Find Things

### "I want to run Assignment X"
→ Go to `assignmentX/` folder  
→ Look for file marked with ⭐  
→ Follow compile and run instructions

### "I want to understand how Assignment X works"
→ Go to `assignmentX/` folder  
→ Read `README.md` first  
→ Then read `IMPLEMENTATION_NOTES.md`

### "I want to see test results"
→ Go to `assignmentX/` folder  
→ Read `ASSIGNMENT_SUMMARY.md`

### "I want an overview of everything"
→ Read `README.md` in root folder  
→ Or read `ALL_ASSIGNMENTS_SUMMARY.md`

### "I want quick commands"
→ Read `QUICK_START_GUIDE.md`

### "I'm a teammate and confused"
→ Read `TEAM_GUIDE.md` (made for you!)

---

## 🔍 Finding Specific Information

| I need to know... | Look in... |
|-------------------|------------|
| What does Assignment X do? | `assignmentX/README.md` |
| How do I run Assignment X? | `assignmentX/README.md` or `QUICK_START_GUIDE.md` |
| How does Assignment X work? | `assignmentX/IMPLEMENTATION_NOTES.md` |
| What are the test results? | `assignmentX/ASSIGNMENT_SUMMARY.md` |
| Overview of all assignments? | `ALL_ASSIGNMENTS_SUMMARY.md` |
| Quick commands for all? | `QUICK_START_GUIDE.md` |
| Team collaboration guide? | `TEAM_GUIDE.md` |
| What to submit? | `SUBMISSION_CHECKLIST.md` |
| Final report? | `FINAL_COMPLETION_REPORT.md` |

---

## ✅ Team Checklist

Before your presentation, make sure everyone knows:

- [ ] Where each assignment folder is
- [ ] Which file to run for each assignment (marked with ⭐)
- [ ] Where to find documentation (README.md files)
- [ ] How to compile and run each assignment
- [ ] What each assignment demonstrates

---

## 💡 Pro Tips for Teammates

1. **Start with TEAM_GUIDE.md** - It's made specifically for you!
2. **README files are your friend** - Always read them first
3. **Look for the ⭐** - That's the main file to run
4. **Don't panic** - Everything is well-documented
5. **Run the code** - See it in action to understand better

---

**Happy coding!** 🚀

---

**Last Updated**: February 14, 2026

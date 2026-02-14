# CSC310 Programming Assignments

**Course**: CSC310 Programming Assignments  
**Due Date**: February 12, 2026 at 10:00 AM  
**Status**: ✅ ALL 5 ASSIGNMENTS COMPLETE (100%)

---

## 📋 Quick Overview

This repository contains all 5 completed programming assignments for CSC310, demonstrating advanced concepts in concurrent programming, multithreading, and synchronization.

### 👥 FOR TEAMMATES: START HERE!

**New to this project?** Read these files in order:
1. **[TEAM_GUIDE.md](TEAM_GUIDE.md)** ⭐ - Complete guide for team members
2. **[FOLDER_STRUCTURE.md](FOLDER_STRUCTURE.md)** - Visual folder structure
3. **[QUICK_START_GUIDE.md](QUICK_START_GUIDE.md)** - Quick commands reference

### Assignments Status

| # | Assignment | Status | Description |
|---|------------|--------|-------------|
| 1 | SERP Analysis | ✅ Complete | Multithreaded analysis with visualizations |
| 2 | Fleet Tracking | ✅ Complete | Thread-safe vehicle tracking (2 approaches) |
| 3 | Ayo Game | ✅ Complete | Traditional board game implementation |
| 4 | Dining Philosophers | ✅ Complete | Deadlock/livelock/starvation prevention |
| 5 | Producer/Consumer | ✅ Complete | Bounded buffer with BlockingQueue |

---

## 🚀 Quick Start

### Run All Assignments

```cmd
REM Assignment 1 - SERP Analysis
cd assignment1
javac src/*.java -d bin
echo 3 | java -cp bin Main
cd ..

REM Assignment 2 - Fleet Tracking
cd assignment2
javac *.java
java VehicleTrackerDemo
cd ..

REM Assignment 3 - Ayo Game
cd assignment3
javac *.java
java AyoGame
cd ..

REM Assignment 4 - Dining Philosophers
cd assignment4
javac *.java
java Main
cd ..

REM Assignment 5 - Producer/Consumer
cd assignment5
javac *.java
java ProducerConsumer
cd ..
```

---

## 📁 Project Structure

```
csc/
├── assignment1/          # SERP Analysis with Multithreading
├── assignment2/          # Tracking Fleet Vehicles
├── assignment3/          # Ayo Game
├── assignment4/          # Dining Philosophers Problem
├── assignment5/          # Producer/Consumer Problem
├── output/               # Generated visualizations
├── ALL_ASSIGNMENTS_SUMMARY.md
├── QUICK_START_GUIDE.md
├── SUBMISSION_CHECKLIST.md
├── FINAL_COMPLETION_REPORT.md
└── README.md (this file)
```

---

## 📚 Documentation

### 👥 For Team Members (START HERE!)
- **[TEAM_GUIDE.md](TEAM_GUIDE.md)** - Complete guide for team members
- **[PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md)** - Visual folder structure
- **[QUICK_START_GUIDE.md](QUICK_START_GUIDE.md)** - Quick reference

### 📋 For Understanding the Project
- **[README.md](README.md)** - This file (overview)
- **[ALL_ASSIGNMENTS_SUMMARY.md](ALL_ASSIGNMENTS_SUMMARY.md)** - Comprehensive summary

### ✅ For Submission
- **[SUBMISSION_CHECKLIST.md](SUBMISSION_CHECKLIST.md)** - Detailed checklist
- **[FINAL_COMPLETION_REPORT.md](FINAL_COMPLETION_REPORT.md)** - Final report

### Per-Assignment Documentation
Each assignment folder contains:
- `README.md` - Overview and usage instructions
- `IMPLEMENTATION_NOTES.md` or `IMPLEMENTATION_GUIDE.md` - Technical details
- `ASSIGNMENT_SUMMARY.md` - Complete summary and test results

---

## 🎯 Key Concepts Demonstrated

### Multithreading & Concurrency
- Thread creation and management
- Thread pools (ExecutorService)
- Thread coordination (join, CountDownLatch)
- Thread interruption

### Synchronization
- Synchronized methods
- ReentrantLock with tryLock
- Semaphores
- BlockingQueue
- ConcurrentHashMap

### Concurrency Issues
- ✅ Deadlock prevention
- ✅ Livelock prevention
- ✅ Starvation prevention
- ✅ Race condition prevention

### Design Patterns
- Producer-Consumer pattern
- Monitor pattern
- Delegation pattern
- Thread pool pattern

---

## 📊 Statistics

### Code Metrics
- **Total Java Files**: 22
- **Total Lines of Code**: ~2,500+
- **Documentation Files**: 15+
- **Total Documentation**: ~5,000+ lines

### Test Results
- ✅ All assignments compile without errors
- ✅ All assignments run successfully
- ✅ All test cases passed
- ✅ No concurrency issues detected

---

## 💻 Requirements

- **Java**: JDK 8 or higher
- **OS**: Windows (cmd shell)
- **Memory**: Minimal (< 100MB)
- **Disk Space**: < 10MB

---

## 🔧 Compilation

### Compile All Assignments
```cmd
javac assignment1/src/*.java -d assignment1/bin
javac assignment2/*.java
javac assignment3/*.java
javac assignment4/*.java
javac assignment5/*.java
```

---

## ✅ Verification

### Quick Test
Run each assignment to verify:
1. **Assignment 1**: Check for visualizations in `output/` folder
2. **Assignment 2**: Verify both implementations run
3. **Assignment 3**: Play a game to completion
4. **Assignment 4**: Verify all philosophers eat without deadlock
5. **Assignment 5**: Verify all items produced and consumed

---

## 📦 Submission

### What's Included
1. ✅ All source code (.java files)
2. ✅ All documentation (.md files)
3. ✅ Compiled classes (.class files)
4. ✅ Output files (.png visualizations)
5. ✅ Comprehensive documentation

### Submission Format
- **Bounded Copy**: Print all source code and documentation
- **Soft Copy**: ZIP file with all contents

---

## 🎓 Learning Outcomes

Through these assignments, the following skills were developed:

1. **Concurrent Programming**
   - Thread lifecycle management
   - Synchronization techniques
   - Deadlock/livelock/starvation prevention

2. **Problem Solving**
   - Analyzing classic concurrency problems
   - Implementing multiple solution approaches
   - Testing and verification

3. **Software Engineering**
   - Object-oriented design
   - Clean code principles
   - Comprehensive documentation

---

## 📞 Support

For questions or issues:
1. Check the assignment-specific README
2. Review IMPLEMENTATION_NOTES
3. Consult QUICK_START_GUIDE
4. See FINAL_COMPLETION_REPORT

---

## 🏆 Achievement

**Status**: ALL 5 ASSIGNMENTS COMPLETE ✅

- 100% completion rate
- All tests passed
- Comprehensive documentation
- Ready for submission

---

## 📝 License

Educational project for CSC310 course.

---

**Last Updated**: February 14, 2026  
**Version**: 1.0 (Final)

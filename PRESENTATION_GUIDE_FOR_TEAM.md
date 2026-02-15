# PRESENTATION GUIDE FOR TEAM
## CSC310 Programming Assignments

**For**: All team members preparing for Wednesday, February 18, 2026 presentation  
**Read this**: Before creating PowerPoint slides

---

## 📋 WHAT YOU NEED TO KNOW

### We Have 5 Assignments - All Complete ✅

1. **Assignment 1**: SERP Analysis (Multithreading)
2. **Assignment 2**: Fleet Tracking (Thread Safety)
3. **Assignment 3**: Ayo Game (Game Logic)
4. **Assignment 4**: Dining Philosophers (Concurrency Issues)
5. **Assignment 5**: Producer/Consumer (Bounded Buffer)

---

## 🎯 PRESENTATION STRUCTURE (20 minutes total)

### Slide 1: Title Slide (30 seconds)
**What to show**:
- Course: CSC310 Programming Assignments
- Group Number: [Add your group number]
- All 6 names with matric numbers
- Date: February 18, 2026

---

### Slide 2: Project Overview (1 minute)
**What to show**:
- Table showing all 5 assignments
- Status: All complete ✅
- Statistics: 22 Java files, 2,500+ lines of code

---

### Slides 3-4: Assignment 1 - SERP Analysis (3 minutes)

**Slide 3: Assignment 1 - Question & Analysis**

**Question**: 
"Design and implement a multithreaded program for analyzing Search Engine Results Pages (SERP) to extract:
1. Distinctive features of crime-reporting papers (at least 10)
2. Distinct sub-headings from deep learning papers"

**Analysis**:
- Input: 10+ papers per analysis
- Process: Use 5 worker threads to analyze papers concurrently
- Output: Categorized features/headings + bar chart visualizations

**Slide 4: Assignment 1 - Design & Results**

**Design**:
- Thread Pool Pattern with 5 threads
- ConcurrentHashMap for thread-safe data storage
- CountDownLatch for thread coordination

**Results**:
- ✅ 20 crime-reporting features extracted
- ✅ 27 deep learning sub-headings extracted
- ✅ Visualizations created (show the PNG charts)

**Key Point**: Multithreading reduced analysis time by ~5x

---

### Slides 5-6: Assignment 2 - Fleet Tracking (3 minutes)

**Slide 5: Assignment 2 - Question & Analysis**

**Question**:
"Implement the Tracking Fleet Vehicles example in section 4.2.2 of 'Java Concurrency In Practice' by Brian Göetz"

**Analysis**:
- Input: 3 vehicles updating positions concurrently
- Process: Two different approaches to thread safety
- Output: Thread-safe location tracking

**Slide 6: Assignment 2 - Two Approaches**

**Approach 1: MonitorVehicleTracker**
- Uses synchronized methods
- Mutable points with deep copying
- Returns snapshot of locations

**Approach 2: DelegatingVehicleTracker**
- Uses ConcurrentHashMap
- Immutable points (no copying needed)
- Returns live view of locations

**Comparison Table**:
| Feature | Monitor | Delegating |
|---------|---------|------------|
| Locking | Explicit | Delegated |
| Scalability | Limited | Better |
| Complexity | Higher | Lower |

**Key Point**: Immutability + delegation = simpler, more scalable code

---

### Slides 7-8: Assignment 3 - Ayo Game (2 minutes)

**Slide 7: Assignment 3 - Question & Overview**

**Question**:
"Implement the Ayo game"

**What is Ayo?**:
- Traditional African board game (also called Mancala)
- 2 players, 6 pits per side, 4 seeds per pit
- Capture opponent's seeds to win

**Slide 8: Assignment 3 - Implementation**

**Design**:
- MVC Pattern (Model-View-Controller)
- Strategy Pattern for players
- Human vs Computer gameplay

**Features**:
- Interactive console interface
- AI opponent with random moves
- Proper capture mechanics
- Win condition detection

**Key Point**: Clean object-oriented design for traditional game

---

### Slides 9-10: Assignment 4 - Dining Philosophers (3 minutes)

**Slide 9: Assignment 4 - The Problem**

**Question**:
"Implement the dining philosophers' problem and show how it handles starvation, livelock and deadlock"

**The Problem**:
- 5 philosophers sit at round table
- 5 forks (one between each pair)
- Each philosopher needs 2 forks to eat
- Must prevent: Deadlock, Livelock, Starvation

**Slide 10: Assignment 4 - Our Solution**

**Three-Layer Prevention**:

1. **Deadlock Prevention**:
   - Semaphore limits to 4 concurrent diners
   - Guarantees at least one can get both forks

2. **Livelock Prevention**:
   - Timeout on fork acquisition (100ms)
   - Random backoff delays (0-50ms)

3. **Starvation Prevention**:
   - Fair semaphore (FIFO queue)
   - All philosophers get equal opportunity

**Results** (show statistics):
```
Philosopher 0: 5 meals
Philosopher 1: 5 meals
Philosopher 2: 5 meals
Philosopher 3: 5 meals
Philosopher 4: 5 meals
✓ Perfect fairness!
```

**Key Point**: All 3 issues prevented with proof from statistics

---

### Slides 11-12: Assignment 5 - Producer/Consumer (2 minutes)

**Slide 11: Assignment 5 - Question & Design**

**Question**:
"Implement the consumer/producer problem"

**Design**:
- 3 producer threads generate items
- 2 consumer threads process items
- Bounded buffer (size 10) using BlockingQueue

**Why BlockingQueue?**:
- Automatic blocking when full/empty
- Thread-safe operations built-in
- No explicit synchronization needed

**Slide 12: Assignment 5 - Results**

**Output**:
```
Producer-1: 10 items produced
Producer-2: 10 items produced
Producer-3: 10 items produced
Total: 30 items

Consumer-1: 15 items consumed
Consumer-2: 15 items consumed
Total: 30 items

✓ SUCCESS: No data loss!
```

**Key Point**: BlockingQueue provides simple, correct solution

---

### Slide 13: Technical Summary (2 minutes)

**Concurrency Techniques Mastered**:
- ✅ Thread Pools (ExecutorService)
- ✅ Concurrent Collections (ConcurrentHashMap)
- ✅ Synchronization (synchronized, ReentrantLock)
- ✅ Semaphores (fair and unfair)
- ✅ BlockingQueue (bounded buffer)
- ✅ Thread Coordination (CountDownLatch)

**Design Patterns Applied**:
- Producer-Consumer Pattern
- Monitor Pattern
- Delegation Pattern
- Strategy Pattern
- MVC Pattern

---

### Slide 14: Real-World Applications (1 minute)

**Where These Concepts Are Used**:

- **Assignment 1**: Web scraping, data mining, analytics
- **Assignment 2**: GPS tracking, Uber/Lyft location services
- **Assignment 3**: Game development, AI opponents
- **Assignment 4**: Database transactions, OS resource allocation
- **Assignment 5**: Message queues (Kafka, RabbitMQ), logging systems

---

### Slide 15: Key Learnings (1 minute)

**What We Learned**:

**Technical Skills**:
- Concurrent programming mastery
- Thread-safe design patterns
- Preventing deadlock/livelock/starvation

**Software Engineering**:
- Clean code organization
- Comprehensive documentation
- Testing and verification

---

### Slide 16: Project Statistics (1 minute)

**By The Numbers**:
- 📁 22 Java files
- 💻 2,500+ lines of code
- 📝 6,000+ lines of documentation
- ✅ 100% completion rate
- ✅ 0 concurrency issues
- ✅ All tests passed

---

### Slide 17: Conclusion (1 minute)

**Project Success**:
- ✅ All 5 assignments completed
- ✅ All requirements met
- ✅ Production-ready code
- ✅ Comprehensive documentation

**Key Achievements**:
- Mastered concurrent programming
- Solved classic CS problems
- Created real-world applicable solutions

---

### Slide 18: Q&A (2 minutes)

**Questions & Answers**

Be ready to discuss:
- Implementation details
- Design decisions
- Concurrency challenges
- Testing approaches
- Real-world applications

**Thank you!**

---

## 🎨 POWERPOINT DESIGN TIPS

### Slide Layout:
- **Title**: Large, clear font
- **Content**: Bullet points (not paragraphs)
- **Code**: Use monospace font, keep snippets short
- **Images**: Include the visualization charts from Assignment 1

### Color Scheme:
- Use consistent colors throughout
- Dark text on light background (or vice versa)
- Highlight key points in different color

### Font Sizes:
- Title: 44pt
- Headings: 32pt
- Body text: 24pt
- Code: 20pt

### Keep It Simple:
- Max 6 bullet points per slide
- Max 6 words per bullet
- Use images/diagrams where possible
- Don't overcrowd slides

---

## 📊 WHAT TO INCLUDE FROM OUR CODE

### Assignment 1 - Show:
```java
ExecutorService executor = Executors.newFixedThreadPool(5);
ConcurrentHashMap<String, Integer> results;
```
- Also show the PNG charts!

### Assignment 2 - Show:
```java
// Monitor approach
public synchronized Map<String, MutablePoint> getLocations()

// Delegation approach  
private final ConcurrentMap<String, Point> locations;
```

### Assignment 3 - Show:
```
Board display:
Player 2:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
Store 2:  0                    Store 1:  0
Player 1:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
```

### Assignment 4 - Show:
```java
Semaphore diningPermits = new Semaphore(4, true);
if (leftFork.tryLock(100, TimeUnit.MILLISECONDS))
```
- Show the statistics table!

### Assignment 5 - Show:
```java
BlockingQueue<Item> buffer = new LinkedBlockingQueue<>(10);
buffer.put(item);  // Blocks if full
Item item = buffer.poll(1, TimeUnit.SECONDS);  // Blocks if empty
```

---

## 🎤 PRESENTATION TIPS

### Before Presentation:
1. **Practice together** - Run through entire presentation
2. **Time yourselves** - Make sure it's 15-20 minutes
3. **Test equipment** - Make sure laptop connects to projector
4. **Have backup** - Save presentation on USB drive

### During Presentation:
1. **Speak clearly** - Don't rush
2. **Make eye contact** - Look at audience, not just slides
3. **Use pointer** - Point to what you're discussing
4. **Stay calm** - You know this material!

### Handling Questions:
1. **Listen carefully** - Make sure you understand the question
2. **Think before answering** - It's okay to pause
3. **Be honest** - If you don't know, say so
4. **Help each other** - Team members can support answers

---

## 📁 FILES TO REFERENCE

### For Understanding Code:
- `DETAILED_ASSIGNMENT_GUIDE.md` - Detailed explanation of each assignment
- `EXPECTED_OUTPUTS.md` - What each program should output
- Each `assignment#/README.md` - How to run each assignment

### For Creating PowerPoint:
- `final/PRESENTATION_SLIDES.md` - This outline (use it!)
- `final/FINAL_PROJECT_DOCUMENT.md` - Full details for each assignment

### For Quick Reference:
- `QUICK_START_GUIDE.md` - Commands to run everything
- `final/QUICK_REFERENCE.md` - Quick action items

---

## ✅ CHECKLIST FOR TEAM

### Everyone Should:
- [ ] Read this guide completely
- [ ] Read `DETAILED_ASSIGNMENT_GUIDE.md`
- [ ] Understand your assigned section
- [ ] Practice your part (2-3 minutes)
- [ ] Know how to run your assignment's code

### For PowerPoint Creation:
- [ ] Use the 18-slide structure above
- [ ] Include code snippets (keep them short)
- [ ] Include Assignment 1 visualizations
- [ ] Include Assignment 4 statistics
- [ ] Keep design clean and consistent
- [ ] Test presentation on actual equipment

### Before Presentation Day:
- [ ] Practice together as a team
- [ ] Time the presentation (15-20 minutes)
- [ ] Prepare for Q&A
- [ ] Have backup on USB drive
- [ ] Dress professionally

---

## 🎯 WHO PRESENTS WHAT (Suggestion)

You can divide the slides among team members:

**Person 1**: Slides 1-2 (Introduction)
**Person 2**: Slides 3-4 (Assignment 1)
**Person 3**: Slides 5-6 (Assignment 2)
**Person 4**: Slides 7-8 (Assignment 3)
**Person 5**: Slides 9-10 (Assignment 4)
**Person 6**: Slides 11-12 (Assignment 5)
**Person 1**: Slides 13-14 (Summary)
**Person 2**: Slides 15-16 (Learnings & Stats)
**Person 3**: Slides 17-18 (Conclusion & Q&A)

Or divide however works best for your team!

---

## 💡 FINAL TIPS

### Remember:
- You've done excellent work
- All code works perfectly
- You understand the concepts
- You're well-prepared

### On Presentation Day:
- Arrive 15 minutes early
- Test equipment
- Support each other
- Stay confident

**You've got this! Good luck! 🎉**

---

**Created**: February 15, 2026  
**For**: CSC310 Team Presentation  
**Presentation Date**: Wednesday, February 18, 2026


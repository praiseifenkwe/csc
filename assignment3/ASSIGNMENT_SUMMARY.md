# Assignment 3 - Complete Implementation Summary

## What Was Implemented

A complete, playable implementation of the Ayo game (also known as Mancala or Oware), a traditional African board game.

✅ **Full game implementation** with proper rules
✅ **Human player** with interactive console input
✅ **Computer AI player** with random move selection
✅ **Board display** with clear visualization
✅ **Move validation** and error handling
✅ **Capture mechanics** following traditional rules
✅ **Win condition** detection and scoring
✅ **Clean object-oriented design**

## The Game

### Overview
Ayo is a count-and-capture game where players:
- Take turns picking up seeds from pits
- Sow seeds counter-clockwise around the board
- Capture opponent's seeds under certain conditions
- Try to collect the most seeds in their store

### Board Layout
```
Player 2:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
Store 2:  0                              Store 1:  0
Player 1:  [ 4] [ 4] [ 4] [ 4] [ 4] [ 4]
            1   2   3   4   5   6
```

- 2 rows of 6 pits each
- Each pit starts with 4 seeds
- Each player has a store for captured seeds

## Implementation Details

### Class Structure

#### 1. AyoGame.java (Main Controller)
- Manages game flow and turns
- Handles move execution
- Implements capture logic
- Determines winner
- Coordinates players

**Key Methods**:
- `play()`: Main game loop
- `makeMove()`: Executes a move and handles captures
- `isGameOver()`: Checks win conditions
- `announceWinner()`: Displays final results

#### 2. AyoBoard.java (Game State)
- Represents the board with pits and stores
- Manages seed distribution
- Validates moves
- Displays board state

**Key Methods**:
- `getSeeds()`, `setSeeds()`: Pit management
- `addToStore()`: Score tracking
- `isSideEmpty()`: End game detection
- `display()`: Visual representation

#### 3. Player.java (Abstract Base)
- Defines player interface
- Stores player name and side
- Abstract `chooseMove()` method

#### 4. HumanPlayer.java
- Interactive human player
- Gets moves from console input
- Validates user input
- Handles invalid entries

#### 5. ComputerPlayer.java
- AI opponent
- Randomly selects valid moves
- Simulates "thinking" time
- Extensible for better strategies

## Game Rules Implemented

### 1. Basic Movement
- Player selects a pit on their side
- All seeds from that pit are picked up
- Seeds are sown counter-clockwise, one per pit
- Continues until all seeds are placed

### 2. Capturing
- If last seed lands in an empty pit on player's side
- AND the opposite pit contains seeds
- Player captures those seeds plus their last seed
- Captured seeds go to player's store

### 3. Game End
- Game ends when one side has no seeds
- Remaining seeds go to the player on that side
- Player with most seeds in store wins

## How to Play

### Compile
```cmd
javac *.java
```

### Run
```cmd
java AyoGame
```

### Gameplay
1. Board is displayed
2. Player 1 (human) chooses a pit (1-6)
3. Seeds are sown and captures are made
4. Computer takes its turn
5. Repeat until game ends
6. Winner is announced

## Sample Game Session

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
Choose a pit (1-6): 3
Player 1 chose pit 3

[Board updates with seed distribution]

Computer's turn
Computer chose pit 4

[Game continues...]

=== GAME OVER ===
Player 1: 28 seeds
Computer: 20 seeds

🏆 Player 1 WINS!
```

## Key Features

### 1. Object-Oriented Design
- Clear separation of concerns
- Inheritance hierarchy (Player classes)
- Encapsulation of game state
- Abstraction of player behavior

### 2. Input Validation
- Checks for valid pit selection
- Handles non-numeric input
- Prevents empty pit selection
- Clear error messages

### 3. Visual Display
- Clear board representation
- Pit numbering for easy selection
- Store scores displayed
- Move feedback

### 4. AI Implementation
- Random but valid move selection
- Extensible for better strategies
- Simulated thinking time

### 5. Game Flow
- Turn-based gameplay
- Automatic turn switching
- End game detection
- Winner determination

## Configuration

### Adjustable Parameters
```java
// In AyoBoard.java
public static final int PITS_PER_SIDE = 6;    // Pits per player
public static final int INITIAL_SEEDS = 4;     // Seeds per pit
```

### Game Variants
Can be modified to support:
- Different board sizes (4, 5, or 6 pits)
- Different seed counts (3, 4, or 5 seeds)
- Alternative capture rules
- Extra turn rules

## Testing

### Test Scenarios

1. **Basic Move**: Seeds distributed correctly
2. **Capture**: Opposite seeds captured properly
3. **Game End**: Remaining seeds collected
4. **Invalid Input**: Handled gracefully
5. **Empty Pit**: Rejected appropriately

## Future Enhancements

### 1. Better AI
- Greedy strategy (maximize captures)
- Defensive play (protect vulnerable pits)
- Minimax algorithm (look ahead)
- Alpha-beta pruning (optimize search)
- Monte Carlo Tree Search (advanced)

### 2. GUI Version
- Graphical board display
- Click to select pits
- Animated seed movement
- Sound effects

### 3. Multiplayer
- Human vs Human mode
- Network play
- Online matchmaking
- Tournament mode

### 4. Features
- Undo move
- Move history
- Save/load game
- Statistics tracking
- Replay system

### 5. Variants
- Different rule sets
- Board sizes
- Special moves
- Time limits

## AI Enhancement Example

### Current AI (Random)
```java
// Randomly selects any valid move
int chosenMove = validMoves[random.nextInt(count)];
```

### Greedy AI (Possible Enhancement)
```java
// Choose move that captures most seeds
int bestMove = -1;
int maxCapture = 0;

for (int pit : validMoves) {
    int captured = simulateCapture(pit);
    if (captured > maxCapture) {
        maxCapture = captured;
        bestMove = pit;
    }
}
```

## Cultural Significance

Ayo/Mancala games:
- Played in Africa for thousands of years
- Teaches counting and strategic thinking
- Has numerous regional variants
- One of the oldest known board games
- Played across many African countries

## Compilation & Execution

### Compile
```cmd
javac assignment3/*.java
```

### Run
```cmd
java -cp assignment3 AyoGame
```

### Expected Runtime
- Variable (depends on player decisions)
- Typically 5-15 minutes per game
- Computer moves have 1-second delay

## Deliverables Checklist

✅ Complete game implementation
✅ Human player with input validation
✅ Computer AI player
✅ Board display and visualization
✅ Move validation
✅ Capture mechanics
✅ Win condition detection
✅ Clean, readable code
✅ Comprehensive documentation
✅ Working demonstration

## Learning Outcomes

Through this implementation, students learn:

1. **Game Logic**: Turn-based game flow
2. **Object-Oriented Design**: Inheritance and abstraction
3. **Input Handling**: Validation and error handling
4. **AI Basics**: Random move selection
5. **State Management**: Board representation
6. **User Interface**: Console-based interaction

## References

- Traditional Ayo/Mancala rules
- Game theory and AI strategies
- Object-oriented design patterns
- African board game history

## Conclusion

This implementation provides a fully functional Ayo game with:
- Proper game rules
- Interactive gameplay
- AI opponent
- Clean code structure
- Extensible design

The game is playable, educational, and demonstrates key programming concepts including object-oriented design, game logic, and basic AI implementation.

---

**Enjoy playing Ayo!** 🎮

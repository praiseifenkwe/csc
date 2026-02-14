# Assignment 3: Ayo Game

## Overview

Ayo (also known as Mancala, Oware, or Ayoayo) is a traditional African board game in the mancala family. This implementation provides a playable version with both human and computer players.

## The Game

### Board Setup
- 2 rows of 6 pits each (one row per player)
- Each pit starts with 4 seeds
- Each player has a store (scoring area)

```
Player 2:  [4] [4] [4] [4] [4] [4]
Store 2: 0                        Store 1: 0
Player 1:  [4] [4] [4] [4] [4] [4]
            1   2   3   4   5   6
```

### Rules

1. **Taking a Turn**
   - Choose a pit on your side with seeds
   - Pick up all seeds from that pit
   - Sow seeds counter-clockwise, one per pit

2. **Capturing**
   - If your last seed lands in an empty pit on your side
   - AND the opposite pit has seeds
   - Capture those seeds plus your last seed
   - Add captured seeds to your store

3. **Winning**
   - Game ends when one side has no seeds
   - Remaining seeds go to the player on that side
   - Player with most seeds in their store wins

## Implementation Features

### Classes

1. **AyoGame.java**
   - Main game controller
   - Manages game flow and turns
   - Handles move validation
   - Determines winner

2. **AyoBoard.java**
   - Represents the game board
   - Manages pits and stores
   - Displays board state
   - Validates moves

3. **Player.java** (Abstract)
   - Base class for all players
   - Defines player interface

4. **HumanPlayer.java**
   - Interactive human player
   - Gets moves from console input
   - Validates user input

5. **ComputerPlayer.java**
   - AI opponent
   - Makes random valid moves
   - Can be enhanced with strategy

## How to Run

### Compile
```cmd
javac *.java
```

### Run
```cmd
java AyoGame
```

## Gameplay

### Sample Game Flow
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

[Board updates...]

Computer's turn
Computer chose pit 4

[Game continues...]

=== GAME OVER ===
Player 1: 28 seeds
Computer: 20 seeds

🏆 Player 1 WINS!
```

## Game Modes

### Current Implementation
- Human vs Computer

### Possible Extensions
- Human vs Human
- Computer vs Computer
- Network multiplayer
- Different difficulty levels

## Strategy Tips

1. **Capture Opportunities**
   - Look for moves that land in empty pits
   - Check if opposite pit has seeds

2. **Defensive Play**
   - Don't leave vulnerable pits
   - Protect pits opposite opponent's empty pits

3. **Endgame**
   - Try to empty opponent's side
   - Collect remaining seeds

## AI Implementation

### Current AI (Simple)
- Randomly selects valid moves
- No strategic thinking

### Possible Enhancements
1. **Greedy AI**: Choose moves that capture most seeds
2. **Defensive AI**: Avoid leaving vulnerable positions
3. **Minimax AI**: Look ahead several moves
4. **Alpha-Beta Pruning**: Optimize minimax
5. **Monte Carlo Tree Search**: Advanced strategy

## Configuration

### Adjustable Parameters
```java
// In AyoBoard.java
public static final int PITS_PER_SIDE = 6;    // Number of pits per player
public static final int INITIAL_SEEDS = 4;     // Seeds per pit at start
```

### Game Variants
Different regions play with different rules:
- Number of pits (4, 5, or 6 per side)
- Initial seeds (3, 4, or 5 per pit)
- Capture rules
- Extra turn rules

## Testing

### Test Cases

1. **Basic Move**
   - Pick up seeds from a pit
   - Sow them correctly
   - Verify board state

2. **Capture**
   - Land in empty pit
   - Capture opposite seeds
   - Add to store

3. **Game End**
   - Empty one side
   - Collect remaining seeds
   - Determine winner

4. **Invalid Moves**
   - Empty pit selection
   - Out of range pit
   - Opponent's pit

## Code Structure

```
assignment3/
├── AyoGame.java           # Main game controller
├── AyoBoard.java          # Board representation
├── Player.java            # Abstract player class
├── HumanPlayer.java       # Human player implementation
├── ComputerPlayer.java    # AI player implementation
└── README.md              # This file
```

## Key Concepts Demonstrated

1. **Object-Oriented Design**
   - Inheritance (Player hierarchy)
   - Encapsulation (Board state)
   - Abstraction (Player interface)

2. **Game Logic**
   - Turn-based gameplay
   - Move validation
   - Win condition checking

3. **User Interaction**
   - Console input/output
   - Input validation
   - Clear display

4. **AI Implementation**
   - Random move selection
   - Valid move generation
   - Extensible for better AI

## Future Enhancements

1. **GUI Version**
   - Graphical board display
   - Click to select pits
   - Animated seed movement

2. **Better AI**
   - Implement minimax algorithm
   - Add difficulty levels
   - Strategic evaluation

3. **Multiplayer**
   - Network play
   - Online matchmaking
   - Replay system

4. **Statistics**
   - Track wins/losses
   - Move history
   - Performance metrics

5. **Variants**
   - Different rule sets
   - Board sizes
   - Special moves

## Cultural Background

Ayo/Mancala games have been played in Africa for thousands of years. The game:
- Teaches counting and strategy
- Played across many African countries
- Has numerous regional variants
- Recognized as one of the oldest board games

## References

- Traditional Ayo/Mancala rules
- Game theory and AI strategies
- Object-oriented design patterns

## Learning Outcomes

Through this implementation, you will learn:
1. Game logic implementation
2. Turn-based game flow
3. Input validation
4. AI basics
5. Object-oriented design
6. User interface design

---

**Enjoy playing Ayo!** 🎮

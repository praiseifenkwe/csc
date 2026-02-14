import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random random;
    
    public ComputerPlayer(String name, int side) {
        super(name, side);
        this.random = new Random();
    }
    
    @Override
    public int chooseMove(AyoBoard board) {
        // Simple AI: Choose random valid move
        // Could be enhanced with strategy
        
        int[] validMoves = new int[AyoBoard.PITS_PER_SIDE];
        int count = 0;
        
        for (int pit = 0; pit < AyoBoard.PITS_PER_SIDE; pit++) {
            if (board.isValidMove(side, pit)) {
                validMoves[count++] = pit;
            }
        }
        
        if (count == 0) {
            return -1;  // No valid moves
        }
        
        int chosenMove = validMoves[random.nextInt(count)];
        
        // Simulate thinking
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return chosenMove;
    }
}

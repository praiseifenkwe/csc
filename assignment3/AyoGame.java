public class AyoGame {
    private final AyoBoard board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private boolean gameOver;
    
    public AyoGame(Player player1, Player player2) {
        this.board = new AyoBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gameOver = false;
    }
    
    public void play() {
        System.out.println("=== AYO GAME ===");
        System.out.println("Welcome to Ayo (Mancala)!\n");
        
        board.display();
        
        while (!gameOver) {
            System.out.println("\n" + currentPlayer.getName() + "'s turn");
            
            int pit = currentPlayer.chooseMove(board);
            
            if (pit == -1) {
                System.out.println(currentPlayer.getName() + " has no valid moves!");
                endGame();
                break;
            }
            
            boolean extraTurn = makeMove(pit);
            
            board.display();
            
            if (isGameOver()) {
                endGame();
                break;
            }
            
            if (!extraTurn) {
                switchPlayer();
            } else {
                System.out.println(currentPlayer.getName() + " gets another turn!");
            }
        }
        
        announceWinner();
    }
    
    private boolean makeMove(int pit) {
        System.out.println(currentPlayer.getName() + " chose pit " + (pit + 1));
        
        int seeds = board.getSeeds(currentPlayer.getSide(), pit);
        board.setSeeds(currentPlayer.getSide(), pit, 0);
        
        int currentSide = currentPlayer.getSide();
        int currentPit = pit;
        
        // Sow seeds
        while (seeds > 0) {
            currentPit++;
            
            // Move to next side if needed
            if (currentPit >= AyoBoard.PITS_PER_SIDE) {
                currentSide = 1 - currentSide;
                currentPit = 0;
            }
            
            // Skip opponent's store in some variants
            board.addSeed(currentSide, currentPit);
            seeds--;
        }
        
        // Check for capture
        if (currentSide == currentPlayer.getSide() && 
            board.getSeeds(currentSide, currentPit) == 1) {
            // Landed in empty pit on own side - capture opposite pit
            int oppositeSide = 1 - currentSide;
            int oppositePit = AyoBoard.PITS_PER_SIDE - 1 - currentPit;
            int capturedSeeds = board.getSeeds(oppositeSide, oppositePit);
            
            if (capturedSeeds > 0) {
                System.out.println("Capture! " + currentPlayer.getName() + 
                                 " captured " + capturedSeeds + " seeds");
                board.setSeeds(oppositeSide, oppositePit, 0);
                board.addToStore(currentPlayer.getSide(), capturedSeeds + 1);
                board.setSeeds(currentSide, currentPit, 0);
            }
        }
        
        // Check if player gets another turn (landed in own store in some variants)
        // For simplicity, no extra turn in this implementation
        return false;
    }
    
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    
    private boolean isGameOver() {
        return board.isSideEmpty(0) || board.isSideEmpty(1);
    }
    
    private void endGame() {
        gameOver = true;
        
        // Collect remaining seeds
        for (int side = 0; side < 2; side++) {
            int remaining = 0;
            for (int pit = 0; pit < AyoBoard.PITS_PER_SIDE; pit++) {
                remaining += board.getSeeds(side, pit);
                board.setSeeds(side, pit, 0);
            }
            board.addToStore(side, remaining);
        }
    }
    
    private void announceWinner() {
        System.out.println("\n=== GAME OVER ===");
        
        int score1 = board.getStore(player1.getSide());
        int score2 = board.getStore(player2.getSide());
        
        System.out.println(player1.getName() + ": " + score1 + " seeds");
        System.out.println(player2.getName() + ": " + score2 + " seeds");
        
        if (score1 > score2) {
            System.out.println("\n🏆 " + player1.getName() + " WINS!");
        } else if (score2 > score1) {
            System.out.println("\n🏆 " + player2.getName() + " WINS!");
        } else {
            System.out.println("\n🤝 It's a TIE!");
        }
    }
    
    public static void main(String[] args) {
        Player player1 = new HumanPlayer("Player 1", 0);
        Player player2 = new ComputerPlayer("Computer", 1);
        
        AyoGame game = new AyoGame(player1, player2);
        game.play();
    }
}

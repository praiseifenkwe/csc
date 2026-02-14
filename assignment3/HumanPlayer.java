import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;
    
    public HumanPlayer(String name, int side) {
        super(name, side);
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public int chooseMove(AyoBoard board) {
        while (true) {
            System.out.print("Choose a pit (1-" + AyoBoard.PITS_PER_SIDE + "): ");
            
            try {
                int input = scanner.nextInt();
                int pit = input - 1;  // Convert to 0-based index
                
                if (board.isValidMove(side, pit)) {
                    return pit;
                } else {
                    System.out.println("Invalid move! Choose a pit with seeds.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                scanner.nextLine();  // Clear buffer
            }
        }
    }
}

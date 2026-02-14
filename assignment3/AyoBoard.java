public class AyoBoard {
    public static final int PITS_PER_SIDE = 6;
    public static final int INITIAL_SEEDS = 4;
    
    private final int[][] pits;  // [side][pit]
    private final int[] stores;  // [side]
    
    public AyoBoard() {
        pits = new int[2][PITS_PER_SIDE];
        stores = new int[2];
        
        // Initialize with seeds
        for (int side = 0; side < 2; side++) {
            for (int pit = 0; pit < PITS_PER_SIDE; pit++) {
                pits[side][pit] = INITIAL_SEEDS;
            }
            stores[side] = 0;
        }
    }
    
    public int getSeeds(int side, int pit) {
        return pits[side][pit];
    }
    
    public void setSeeds(int side, int pit, int seeds) {
        pits[side][pit] = seeds;
    }
    
    public void addSeed(int side, int pit) {
        pits[side][pit]++;
    }
    
    public int getStore(int side) {
        return stores[side];
    }
    
    public void addToStore(int side, int seeds) {
        stores[side] += seeds;
    }
    
    public boolean isSideEmpty(int side) {
        for (int pit = 0; pit < PITS_PER_SIDE; pit++) {
            if (pits[side][pit] > 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidMove(int side, int pit) {
        return pit >= 0 && pit < PITS_PER_SIDE && pits[side][pit] > 0;
    }
    
    public void display() {
        System.out.println("\n" + "=".repeat(50));
        
        // Player 2 side (top)
        System.out.print("Player 2:  ");
        for (int pit = PITS_PER_SIDE - 1; pit >= 0; pit--) {
            System.out.printf("[%2d] ", pits[1][pit]);
        }
        System.out.println();
        
        // Stores
        System.out.printf("Store 2: %2d                              Store 1: %2d\n", 
                         stores[1], stores[0]);
        
        // Player 1 side (bottom)
        System.out.print("Player 1:  ");
        for (int pit = 0; pit < PITS_PER_SIDE; pit++) {
            System.out.printf("[%2d] ", pits[0][pit]);
        }
        System.out.println();
        
        // Pit numbers
        System.out.print("           ");
        for (int pit = 1; pit <= PITS_PER_SIDE; pit++) {
            System.out.printf(" %2d  ", pit);
        }
        System.out.println();
        System.out.println("=".repeat(50));
    }
}

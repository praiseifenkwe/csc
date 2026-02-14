public abstract class Player {
    protected final String name;
    protected final int side;  // 0 or 1
    
    public Player(String name, int side) {
        this.name = name;
        this.side = side;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSide() {
        return side;
    }
    
    public abstract int chooseMove(AyoBoard board);
}

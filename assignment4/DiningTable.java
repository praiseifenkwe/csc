import java.util.concurrent.Semaphore;

public class DiningTable {
    public static final int NUM_PHILOSOPHERS = 5;
    public static final int MAX_MEALS = 5;
    
    // Semaphore to limit concurrent diners (prevents deadlock)
    // Allow only N-1 philosophers to dine simultaneously
    private final Semaphore diningPermits;
    
    public DiningTable() {
        // Allow only 4 out of 5 philosophers to attempt eating at once
        // This guarantees at least one philosopher can get both forks
        this.diningPermits = new Semaphore(NUM_PHILOSOPHERS - 1);
    }
    
    public void requestPermission(int philosopherId) throws InterruptedException {
        System.out.println("Philosopher " + philosopherId + " requesting permission to dine...");
        diningPermits.acquire();
        System.out.println("Philosopher " + philosopherId + " got permission to dine.");
    }
    
    public void releasePermission(int philosopherId) {
        diningPermits.release();
        System.out.println("Philosopher " + philosopherId + " released dining permission.");
    }
    
    public int getAvailablePermits() {
        return diningPermits.availablePermits();
    }
}

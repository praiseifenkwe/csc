import java.util.Random;

public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final DiningTable table;
    private final Random random = new Random();
    
    private int mealsEaten = 0;
    private int failedAttempts = 0;
    private long totalWaitTime = 0;
    private long totalEatingTime = 0;
    
    private static final long TIMEOUT_MS = 100;
    private static final int THINKING_TIME = 1000;
    private static final int EATING_TIME = 2000;
    
    public Philosopher(int id, Fork leftFork, Fork rightFork, DiningTable table) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.table = table;
    }
    
    @Override
    public void run() {
        try {
            while (mealsEaten < DiningTable.MAX_MEALS) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\nPhilosopher " + id + " finished eating " + mealsEaten + " meals.");
        System.out.println("  Failed attempts: " + failedAttempts);
    }
    
    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking...");
        Thread.sleep(THINKING_TIME + random.nextInt(500));
    }
    
    private void eat() throws InterruptedException {
        long startWait = System.currentTimeMillis();
        
        // Request permission from table (prevents deadlock by limiting concurrent diners)
        table.requestPermission(id);
        
        boolean hasLeftFork = false;
        boolean hasRightFork = false;
        
        try {
            // Try to pick up left fork with timeout (prevents livelock)
            hasLeftFork = leftFork.pickUp(id, TIMEOUT_MS);
            
            if (hasLeftFork) {
                // Add small random delay to reduce contention
                Thread.sleep(random.nextInt(10));
                
                // Try to pick up right fork with timeout
                hasRightFork = rightFork.pickUp(id, TIMEOUT_MS);
                
                if (hasRightFork) {
                    // Successfully got both forks - eat!
                    long waitTime = System.currentTimeMillis() - startWait;
                    totalWaitTime += waitTime;
                    
                    System.out.println("Philosopher " + id + " is EATING (meal #" + (mealsEaten + 1) + ")");
                    long startEat = System.currentTimeMillis();
                    Thread.sleep(EATING_TIME + random.nextInt(500));
                    long eatTime = System.currentTimeMillis() - startEat;
                    totalEatingTime += eatTime;
                    
                    mealsEaten++;
                } else {
                    // Couldn't get right fork - this prevents starvation by releasing and retrying
                    System.out.println("Philosopher " + id + " couldn't get right fork, releasing left");
                    failedAttempts++;
                }
            } else {
                System.out.println("Philosopher " + id + " couldn't get left fork");
                failedAttempts++;
            }
        } finally {
            // Always release forks in reverse order to prevent deadlock
            if (hasRightFork) {
                rightFork.putDown(id);
            }
            if (hasLeftFork) {
                leftFork.putDown(id);
            }
            
            // Release dining permission
            table.releasePermission(id);
            
            // Random backoff to prevent livelock
            if (!hasLeftFork || !hasRightFork) {
                Thread.sleep(random.nextInt(50));
            }
        }
    }
    
    public int getMealsEaten() {
        return mealsEaten;
    }
    
    public int getFailedAttempts() {
        return failedAttempts;
    }
    
    public long getAverageWaitTime() {
        return mealsEaten > 0 ? totalWaitTime / mealsEaten : 0;
    }
    
    public long getAverageEatingTime() {
        return mealsEaten > 0 ? totalEatingTime / mealsEaten : 0;
    }
}

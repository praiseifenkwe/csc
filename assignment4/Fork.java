import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final int id;
    private final Lock lock;
    private int holder = -1; // ID of philosopher holding this fork
    
    public Fork(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }
    
    public boolean pickUp(int philosopherId, long timeoutMs) throws InterruptedException {
        // Try to acquire lock with timeout to prevent indefinite waiting (livelock prevention)
        if (lock.tryLock(timeoutMs, TimeUnit.MILLISECONDS)) {
            holder = philosopherId;
            System.out.println("  Fork " + id + " picked up by Philosopher " + philosopherId);
            return true;
        }
        System.out.println("  Fork " + id + " timeout for Philosopher " + philosopherId);
        return false;
    }
    
    public void putDown(int philosopherId) {
        if (holder == philosopherId) {
            holder = -1;
            System.out.println("  Fork " + id + " put down by Philosopher " + philosopherId);
            lock.unlock();
        }
    }
    
    public int getId() {
        return id;
    }
    
    public boolean isAvailable() {
        return holder == -1;
    }
}

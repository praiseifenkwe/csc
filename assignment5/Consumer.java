import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {
    private final int id;
    private final BlockingQueue<Item> buffer;
    private final AtomicInteger totalConsumed;
    private int itemsConsumed = 0;
    
    public Consumer(int id, BlockingQueue<Item> buffer, AtomicInteger totalConsumed) {
        this.id = id;
        this.buffer = buffer;
        this.totalConsumed = totalConsumed;
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Take from buffer (blocks if buffer is empty)
                // Use poll with timeout to allow checking for interruption
                Item item = buffer.poll(1, TimeUnit.SECONDS);
                
                if (item != null) {
                    System.out.println("Consumer " + id + " consumed: " + item + 
                                     " | Buffer size: " + buffer.size());
                    
                    // Simulate consumption time
                    Thread.sleep((long) (Math.random() * 700));
                    
                    itemsConsumed++;
                    totalConsumed.incrementAndGet();
                }
            }
            
            System.out.println(">>> Consumer " + id + " finished. Total consumed: " + itemsConsumed);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(">>> Consumer " + id + " finished. Total consumed: " + itemsConsumed);
        }
    }
    
    public int getItemsConsumed() {
        return itemsConsumed;
    }
}

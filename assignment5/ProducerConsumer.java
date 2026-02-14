import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {
    private static final int BUFFER_SIZE = 10;
    private static final int NUM_PRODUCERS = 3;
    private static final int NUM_CONSUMERS = 3;
    private static final int ITEMS_PER_PRODUCER = 10;
    
    public static void main(String[] args) {
        System.out.println("=== PRODUCER/CONSUMER PROBLEM ===");
        System.out.println("Buffer Size: " + BUFFER_SIZE);
        System.out.println("Producers: " + NUM_PRODUCERS);
        System.out.println("Consumers: " + NUM_CONSUMERS);
        System.out.println("Items per Producer: " + ITEMS_PER_PRODUCER);
        System.out.println("=".repeat(60) + "\n");
        
        // Shared buffer using BlockingQueue (thread-safe)
        BlockingQueue<Item> buffer = new LinkedBlockingQueue<>(BUFFER_SIZE);
        
        // Statistics tracking
        AtomicInteger totalProduced = new AtomicInteger(0);
        AtomicInteger totalConsumed = new AtomicInteger(0);
        
        // Create and start producer threads
        Thread[] producers = new Thread[NUM_PRODUCERS];
        for (int i = 0; i < NUM_PRODUCERS; i++) {
            Producer producer = new Producer(i, buffer, ITEMS_PER_PRODUCER, totalProduced);
            producers[i] = new Thread(producer, "Producer-" + i);
            producers[i].start();
        }
        
        // Create and start consumer threads
        Thread[] consumers = new Thread[NUM_CONSUMERS];
        for (int i = 0; i < NUM_CONSUMERS; i++) {
            Consumer consumer = new Consumer(i, buffer, totalConsumed);
            consumers[i] = new Thread(consumer, "Consumer-" + i);
            consumers[i].start();
        }
        
        // Wait for all producers to finish
        for (Thread producer : producers) {
            try {
                producer.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\n*** All producers finished ***\n");
        
        // Wait for buffer to be empty and give consumers time to finish
        while (!buffer.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Give consumers a bit more time to finish processing
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Stop all consumers
        for (Thread consumer : consumers) {
            consumer.interrupt();
        }
        
        // Wait for all consumers to finish
        for (Thread consumer : consumers) {
            try {
                consumer.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Print final statistics
        printStatistics(totalProduced.get(), totalConsumed.get());
    }
    
    private static void printStatistics(int produced, int consumed) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SIMULATION COMPLETE - STATISTICS");
        System.out.println("=".repeat(60));
        System.out.println("Total items produced: " + produced);
        System.out.println("Total items consumed: " + consumed);
        
        if (produced == consumed) {
            System.out.println("✓ SUCCESS: All produced items were consumed");
        } else {
            System.out.println("⚠ WARNING: Mismatch between produced and consumed items");
        }
        
        System.out.println("\nKey Features Demonstrated:");
        System.out.println("✓ Thread-safe buffer using BlockingQueue");
        System.out.println("✓ Automatic blocking when buffer is full (producers wait)");
        System.out.println("✓ Automatic blocking when buffer is empty (consumers wait)");
        System.out.println("✓ No race conditions or data corruption");
        System.out.println("✓ Proper synchronization between producers and consumers");
        System.out.println("=".repeat(60));
    }
}

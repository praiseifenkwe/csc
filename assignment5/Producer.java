import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private final int id;
    private final BlockingQueue<Item> buffer;
    private final int itemsToProduce;
    private final AtomicInteger totalProduced;
    private int itemsProduced = 0;
    
    public Producer(int id, BlockingQueue<Item> buffer, int itemsToProduce, AtomicInteger totalProduced) {
        this.id = id;
        this.buffer = buffer;
        this.itemsToProduce = itemsToProduce;
        this.totalProduced = totalProduced;
    }
    
    @Override
    public void run() {
        try {
            while (itemsProduced < itemsToProduce) {
                // Create an item
                Item item = new Item(id, itemsProduced);
                
                // Simulate production time
                Thread.sleep((long) (Math.random() * 500));
                
                // Add to buffer (blocks if buffer is full)
                System.out.println("Producer " + id + " attempting to produce: " + item);
                buffer.put(item);
                System.out.println("Producer " + id + " produced: " + item + 
                                 " | Buffer size: " + buffer.size());
                
                itemsProduced++;
                totalProduced.incrementAndGet();
            }
            
            System.out.println(">>> Producer " + id + " finished. Total produced: " + itemsProduced);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer " + id + " was interrupted.");
        }
    }
    
    public int getItemsProduced() {
        return itemsProduced;
    }
}

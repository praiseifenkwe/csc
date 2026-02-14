public class Item {
    private final int producerId;
    private final int itemNumber;
    private final long timestamp;
    
    public Item(int producerId, int itemNumber) {
        this.producerId = producerId;
        this.itemNumber = itemNumber;
        this.timestamp = System.currentTimeMillis();
    }
    
    public int getProducerId() {
        return producerId;
    }
    
    public int getItemNumber() {
        return itemNumber;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return "Item[P" + producerId + "-" + itemNumber + "]";
    }
}

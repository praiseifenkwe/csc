public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("DINING PHILOSOPHERS PROBLEM");
        System.out.println("Demonstrating solutions to Deadlock, Livelock, and Starvation");
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Create the dining table (with semaphore to prevent deadlock)
        DiningTable table = new DiningTable();
        
        // Create forks
        Fork[] forks = new Fork[DiningTable.NUM_PHILOSOPHERS];
        for (int i = 0; i < DiningTable.NUM_PHILOSOPHERS; i++) {
            forks[i] = new Fork(i);
        }
        
        // Create philosophers
        Philosopher[] philosophers = new Philosopher[DiningTable.NUM_PHILOSOPHERS];
        for (int i = 0; i < DiningTable.NUM_PHILOSOPHERS; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % DiningTable.NUM_PHILOSOPHERS];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, table);
        }
        
        System.out.println("Starting simulation with " + DiningTable.NUM_PHILOSOPHERS + " philosophers");
        System.out.println("Each philosopher will eat " + DiningTable.MAX_MEALS + " meals\n");
        
        // Start all philosophers
        for (Philosopher p : philosophers) {
            p.start();
        }
        
        // Wait for all philosophers to finish
        for (Philosopher p : philosophers) {
            try {
                p.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Print statistics
        printStatistics(philosophers);
    }
    
    private static void printStatistics(Philosopher[] philosophers) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("SIMULATION COMPLETE - STATISTICS");
        System.out.println("=".repeat(70));
        
        int totalMeals = 0;
        int totalFailedAttempts = 0;
        
        System.out.println("\nPer-Philosopher Statistics:");
        System.out.println("-".repeat(70));
        
        for (Philosopher p : philosophers) {
            int meals = p.getMealsEaten();
            int failed = p.getFailedAttempts();
            long avgWait = p.getAverageWaitTime();
            long avgEat = p.getAverageEatingTime();
            
            totalMeals += meals;
            totalFailedAttempts += failed;
            
            System.out.printf("Philosopher %d: Meals=%d, Failed=%d, AvgWait=%dms, AvgEat=%dms\n",
                p.getId(), meals, failed, avgWait, avgEat);
        }
        
        System.out.println("\nOverall Statistics:");
        System.out.println("-".repeat(70));
        System.out.println("Total meals eaten: " + totalMeals);
        System.out.println("Total failed attempts: " + totalFailedAttempts);
        System.out.println("Success rate: " + String.format("%.1f%%", 
            (totalMeals * 100.0) / (totalMeals + totalFailedAttempts)));
        
        // Check for starvation
        System.out.println("\nStarvation Analysis:");
        System.out.println("-".repeat(70));
        boolean starvationDetected = false;
        for (Philosopher p : philosophers) {
            if (p.getMealsEaten() == 0) {
                System.out.println("WARNING: Philosopher " + p.getId() + " did not eat (STARVATION)");
                starvationDetected = true;
            }
        }
        if (!starvationDetected) {
            System.out.println("✓ No starvation detected - all philosophers ate");
        }
        
        // Check for fairness
        System.out.println("\nFairness Analysis:");
        System.out.println("-".repeat(70));
        int minMeals = Integer.MAX_VALUE;
        int maxMeals = 0;
        for (Philosopher p : philosophers) {
            int meals = p.getMealsEaten();
            minMeals = Math.min(minMeals, meals);
            maxMeals = Math.max(maxMeals, meals);
        }
        System.out.println("Min meals eaten: " + minMeals);
        System.out.println("Max meals eaten: " + maxMeals);
        System.out.println("Difference: " + (maxMeals - minMeals));
        
        if (maxMeals - minMeals <= 2) {
            System.out.println("✓ Good fairness - meal distribution is balanced");
        } else {
            System.out.println("⚠ Moderate fairness - some imbalance in meal distribution");
        }
        
        System.out.println("\nConcurrency Issues Handled:");
        System.out.println("-".repeat(70));
        System.out.println("✓ DEADLOCK: Prevented by limiting concurrent diners (semaphore)");
        System.out.println("✓ LIVELOCK: Prevented by timeout + random backoff");
        System.out.println("✓ STARVATION: Prevented by fair semaphore + timeout mechanism");
        System.out.println("=".repeat(70));
    }
}

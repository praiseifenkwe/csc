import java.util.*;
import java.util.concurrent.*;
import java.io.*;

public class CrimeReportingAnalyzer {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int MIN_PAPERS = 10;
    
    // Thread-safe data structures
    private final ConcurrentHashMap<String, Set<String>> paperFeatures = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> featureFrequency = new ConcurrentHashMap<>();
    
    // Distinctive features to look for in crime-reporting systems
    private static final String[] FEATURES = {
        "Authentication", "Anonymous Reporting", "Mobile App", "Web Portal",
        "SMS Reporting", "Email Reporting", "Real-time Tracking", "Photo Upload",
        "Video Upload", "Location Services", "Push Notifications", "Crime Categories",
        "Emergency Button", "Multi-language Support", "Offline Mode", "Data Encryption",
        "User Verification", "Report Status", "Community Forum", "Crime Statistics"
    };
    
    public void analyze() {
        System.out.println("Starting Crime-Reporting Papers Analysis...");
        System.out.println("Analyzing at least " + MIN_PAPERS + " papers with " + THREAD_POOL_SIZE + " threads\n");
        
        // Sample URLs (in real implementation, these would be actual paper URLs)
        List<String> paperUrls = generateSamplePapers();
        
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        CountDownLatch latch = new CountDownLatch(paperUrls.size());
        
        // Submit tasks for each paper
        for (String url : paperUrls) {
            executor.submit(() -> {
                try {
                    analyzePaper(url);
                } finally {
                    latch.countDown();
                }
            });
        }
        
        try {
            latch.await(); // Wait for all threads to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Analysis interrupted: " + e.getMessage());
        }
        
        executor.shutdown();
        
        // Calculate feature frequencies
        calculateFrequencies();
        
        // Display results
        displayResults();
        
        // Generate visualization
        DataVisualizer.createBarChart(
            featureFrequency,
            "Crime-Reporting System Features",
            "Features",
            "Number of Systems",
            "output/crime_features_chart.png"
        );
    }
    
    private void analyzePaper(String paperUrl) {
        String paperId = extractPaperId(paperUrl);
        System.out.println("[Thread " + Thread.currentThread().getId() + "] Analyzing: " + paperId);
        
        // Simulate web scraping and feature extraction
        Set<String> features = extractFeatures(paperUrl);
        paperFeatures.put(paperId, features);
        
        System.out.println("[Thread " + Thread.currentThread().getId() + "] Completed: " + paperId + 
                         " (" + features.size() + " features found)");
    }
    
    private Set<String> extractFeatures(String paperUrl) {
        // Simulate feature extraction with random selection
        Set<String> features = new HashSet<>();
        Random random = new Random();
        
        // Each paper has 5-12 random features
        int numFeatures = 5 + random.nextInt(8);
        while (features.size() < numFeatures) {
            features.add(FEATURES[random.nextInt(FEATURES.length)]);
        }
        
        // Simulate network delay
        try {
            Thread.sleep(500 + random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return features;
    }
    
    private void calculateFrequencies() {
        for (Set<String> features : paperFeatures.values()) {
            for (String feature : features) {
                featureFrequency.merge(feature, 1, Integer::sum);
            }
        }
    }
    
    private void displayResults() {
        System.out.println("\n=== ANALYSIS RESULTS ===");
        System.out.println("Total papers analyzed: " + paperFeatures.size());
        System.out.println("\nFeatures categorized by frequency:\n");
        
        // Sort by frequency (descending)
        List<Map.Entry<String, Integer>> sortedFeatures = new ArrayList<>(featureFrequency.entrySet());
        sortedFeatures.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedFeatures) {
            System.out.printf("%2d. %-25s : %2d systems (%.1f%%)\n", 
                rank++, 
                entry.getKey(), 
                entry.getValue(),
                (entry.getValue() * 100.0 / paperFeatures.size())
            );
        }
    }
    
    private List<String> generateSamplePapers() {
        List<String> urls = new ArrayList<>();
        for (int i = 1; i <= MIN_PAPERS; i++) {
            urls.add("https://example.com/crime-paper-" + i);
        }
        return urls;
    }
    
    private String extractPaperId(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }
}

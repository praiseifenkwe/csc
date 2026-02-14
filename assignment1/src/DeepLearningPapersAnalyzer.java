import java.util.*;
import java.util.concurrent.*;

public class DeepLearningPapersAnalyzer {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int MIN_PAPERS = 10;
    
    // Thread-safe data structures
    private final ConcurrentHashMap<String, List<String>> paperHeadings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> headingFrequency = new ConcurrentHashMap<>();
    
    // Common sub-headings in deep learning papers
    private static final String[] COMMON_HEADINGS = {
        "Abstract", "Introduction", "Related Work", "Background",
        "Methodology", "Model Architecture", "Dataset", "Data Preprocessing",
        "Training Procedure", "Hyperparameters", "Experimental Setup",
        "Results", "Evaluation Metrics", "Ablation Study", "Comparison with Baselines",
        "Discussion", "Limitations", "Future Work", "Conclusion", "References",
        "Neural Network Design", "Loss Function", "Optimization", "Regularization",
        "Transfer Learning", "Fine-tuning", "Performance Analysis"
    };
    
    public void analyze() {
        System.out.println("Starting Deep Learning Papers Analysis...");
        System.out.println("Analyzing at least " + MIN_PAPERS + " papers with " + THREAD_POOL_SIZE + " threads\n");
        
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
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Analysis interrupted: " + e.getMessage());
        }
        
        executor.shutdown();
        
        // Calculate heading frequencies
        calculateFrequencies();
        
        // Display results
        displayResults();
        
        // Generate visualization
        DataVisualizer.createBarChart(
            headingFrequency,
            "Deep Learning Paper Sub-headings",
            "Sub-headings",
            "Frequency",
            "output/dl_headings_chart.png"
        );
    }
    
    private void analyzePaper(String paperUrl) {
        String paperId = extractPaperId(paperUrl);
        System.out.println("[Thread " + Thread.currentThread().getId() + "] Analyzing: " + paperId);
        
        // Extract headings from paper
        List<String> headings = extractHeadings(paperUrl);
        paperHeadings.put(paperId, headings);
        
        System.out.println("[Thread " + Thread.currentThread().getId() + "] Completed: " + paperId + 
                         " (" + headings.size() + " headings found)");
    }
    
    private List<String> extractHeadings(String paperUrl) {
        // Simulate heading extraction
        List<String> headings = new ArrayList<>();
        Random random = new Random();
        
        // Each paper has 8-15 headings
        int numHeadings = 8 + random.nextInt(8);
        Set<String> uniqueHeadings = new HashSet<>();
        
        while (uniqueHeadings.size() < numHeadings) {
            uniqueHeadings.add(COMMON_HEADINGS[random.nextInt(COMMON_HEADINGS.length)]);
        }
        
        headings.addAll(uniqueHeadings);
        
        // Simulate network delay
        try {
            Thread.sleep(500 + random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return headings;
    }
    
    private void calculateFrequencies() {
        for (List<String> headings : paperHeadings.values()) {
            for (String heading : headings) {
                headingFrequency.merge(heading, 1, Integer::sum);
            }
        }
    }
    
    private void displayResults() {
        System.out.println("\n=== ANALYSIS RESULTS ===");
        System.out.println("Total papers analyzed: " + paperHeadings.size());
        System.out.println("\nSub-headings sorted by frequency:\n");
        
        // Sort by frequency (descending)
        List<Map.Entry<String, Integer>> sortedHeadings = new ArrayList<>(headingFrequency.entrySet());
        sortedHeadings.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedHeadings) {
            System.out.printf("%2d. %-30s : %2d papers (%.1f%%)\n", 
                rank++, 
                entry.getKey(), 
                entry.getValue(),
                (entry.getValue() * 100.0 / paperHeadings.size())
            );
        }
    }
    
    private List<String> generateSamplePapers() {
        List<String> urls = new ArrayList<>();
        for (int i = 1; i <= MIN_PAPERS; i++) {
            urls.add("https://arxiv.org/dl-paper-" + i);
        }
        return urls;
    }
    
    private String extractPaperId(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }
}

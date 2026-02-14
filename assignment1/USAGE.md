# Usage Guide - Assignment 1

## Quick Start

### Compilation
```cmd
javac src/*.java -d bin
```

### Running the Program

#### Option 1: Interactive Mode
```cmd
java -cp bin Main
```
Then select:
- `1` for Crime-Reporting Papers Analysis only
- `2` for Deep Learning Papers Analysis only
- `3` for Both analyses

#### Option 2: Automated (Windows)
```cmd
run_test.bat
```

#### Option 3: Command Line (Both analyses)
```cmd
echo 3 | java -cp bin Main
```

## Output

### Console Output
The program displays:
- Thread activity (which thread is analyzing which paper)
- Progress updates
- Detailed results with frequencies and percentages
- Sorted lists of features/headings

### Visualization Files
Generated in `output/` folder:
- `crime_features_chart.png` - Bar chart of crime-reporting features
- `dl_headings_chart.png` - Bar chart of deep learning paper headings

## Understanding the Results

### Crime-Reporting Analysis
Shows 20 possible features across systems:
- **High frequency (>50%)**: Core features present in most systems
- **Medium frequency (30-50%)**: Common but not universal features
- **Low frequency (<30%)**: Specialized or emerging features

### Deep Learning Papers Analysis
Shows 27 common sub-headings:
- **Standard sections**: Abstract, Introduction, Conclusion (expected in most papers)
- **Methodology sections**: Model Architecture, Training, Dataset
- **Evaluation sections**: Results, Metrics, Ablation Studies
- **Technical sections**: Loss Function, Optimization, Regularization

## Customization

### Analyzing Different Papers
Currently uses simulated data. To analyze real papers:

1. **Modify the URL generation**:
```java
// In CrimeReportingAnalyzer.java or DeepLearningPapersAnalyzer.java
private List<String> generateSamplePapers() {
    List<String> urls = new ArrayList<>();
    // Add your actual paper URLs here
    urls.add("https://actual-paper-url-1.com");
    urls.add("https://actual-paper-url-2.com");
    return urls;
}
```

2. **Implement real scraping** (requires Jsoup library):
```java
private Set<String> extractFeatures(String paperUrl) {
    Set<String> features = new HashSet<>();
    try {
        Document doc = Jsoup.connect(paperUrl).get();
        // Extract features from document
        // Example: look for keywords in text
        String text = doc.body().text().toLowerCase();
        for (String feature : FEATURES) {
            if (text.contains(feature.toLowerCase())) {
                features.add(feature);
            }
        }
    } catch (IOException e) {
        System.err.println("Error scraping: " + e.getMessage());
    }
    return features;
}
```

### Adjusting Thread Pool Size
In the analyzer classes, modify:
```java
private static final int THREAD_POOL_SIZE = 5; // Change to desired number
```

Recommendations:
- **CPU cores × 2** for I/O-bound tasks (web scraping)
- **CPU cores** for CPU-bound tasks
- Consider rate limiting when scraping real websites

### Adding New Features/Headings
Simply add to the arrays:

```java
// In CrimeReportingAnalyzer.java
private static final String[] FEATURES = {
    "Authentication",
    "Anonymous Reporting",
    // Add your new features here
    "Blockchain Integration",
    "AI-powered Analysis"
};
```

### Changing Visualization Style
Modify `DataVisualizer.java`:
- **Colors**: Edit the `colors` array
- **Dimensions**: Change `width` and `height` variables
- **Chart type**: Implement pie chart, line chart, etc.

## Performance Tips

### For Large Datasets (100+ papers)
1. Increase heap size:
```cmd
java -Xmx2g -cp bin Main
```

2. Adjust thread pool based on available cores:
```java
int cores = Runtime.getRuntime().availableProcessors();
ExecutorService executor = Executors.newFixedThreadPool(cores * 2);
```

3. Add progress indicator:
```java
System.out.printf("Progress: %d/%d papers analyzed\n", 
    completed.get(), total);
```

### For Real Web Scraping
1. Add delays to respect rate limits:
```java
Thread.sleep(1000); // 1 second between requests
```

2. Implement retry logic:
```java
int maxRetries = 3;
for (int i = 0; i < maxRetries; i++) {
    try {
        // Scraping code
        break;
    } catch (IOException e) {
        if (i == maxRetries - 1) throw e;
        Thread.sleep(2000 * (i + 1)); // Exponential backoff
    }
}
```

3. Use connection pooling and timeouts:
```java
Document doc = Jsoup.connect(url)
    .timeout(10000)
    .maxBodySize(0)
    .get();
```

## Troubleshooting

### "Out of Memory" Error
Increase heap size:
```cmd
java -Xmx4g -cp bin Main
```

### Slow Performance
- Reduce thread pool size if CPU-bound
- Increase thread pool size if I/O-bound
- Check network latency for web scraping

### Charts Not Generated
- Ensure `output/` folder has write permissions
- Check console for error messages
- Verify Graphics2D is available (headless systems may need `-Djava.awt.headless=true`)

## Example Output Interpretation

### Crime-Reporting Features
```
1. Web Portal : 6 systems (60.0%)
```
Means: 60% of analyzed systems have a web portal feature

### Deep Learning Headings
```
1. Comparison with Baselines : 8 papers (80.0%)
```
Means: 80% of analyzed papers include a "Comparison with Baselines" section

## Next Steps

1. **Add real data sources**: Replace simulated data with actual paper URLs
2. **Implement semantic analysis**: Use NLP to better identify features
3. **Add export functionality**: Save results to CSV/JSON
4. **Create web interface**: Build a web UI for easier interaction
5. **Add caching**: Store results to avoid re-analyzing same papers

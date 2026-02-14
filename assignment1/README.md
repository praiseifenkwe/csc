# Assignment 1: SERP Analysis with Multithreading

## Overview
This assignment implements a multithreaded program for analyzing Search Engine Results Pages (SERP) with two main tasks:

1. **Crime Reporting Systems Analysis**: Extract and categorize distinctive features from at least 10 crime-reporting papers
2. **Deep Learning Papers Analysis**: Extract distinct sub-headings from journal papers on deep learning models

Both implementations include data visualization of results.

## Project Structure

```
assignment1/
├── Part1_CrimeReporting/
│   ├── CrimeReportingAnalyzer.java    # Main analyzer for crime reporting features
│   ├── FeatureExtractor.java          # Extracts features from papers
│   ├── FeatureCategorizer.java        # Categorizes and counts features
│   ├── DataVisualizer.java            # Creates visualizations
│   └── WebScraper.java                # Fetches SERP data
│
├── Part2_DeepLearning/
│   ├── DeepLearningAnalyzer.java      # Main analyzer for DL papers
│   ├── SubheadingExtractor.java       # Extracts subheadings
│   ├── SubheadingVisualizer.java      # Creates visualizations
│   └── PaperFetcher.java              # Fetches paper data
│
└── Common/
    ├── ThreadPool.java                # Custom thread pool implementation
    └── DataModel.java                 # Shared data structures
```

## Requirements

- Java 8 or higher
- Internet connection for fetching SERP data
- Libraries: None (uses standard Java libraries)

## Features

### Multithreading Implementation
- Custom thread pool for concurrent processing
- Thread-safe data structures for result aggregation
- Parallel fetching and processing of multiple papers

### Part 1: Crime Reporting Features
- Extracts features like: authentication methods, reporting channels, anonymity options, data storage, notification systems, etc.
- Categorizes features by frequency across systems
- Generates bar charts and frequency distributions

### Part 2: Deep Learning Subheadings
- Extracts common subheadings: Introduction, Methodology, Results, Discussion, etc.
- Analyzes subheading patterns across papers
- Visualizes subheading frequency and distribution

## How to Run

### Compile all files:
```cmd
javac -d bin Common/*.java Part1_CrimeReporting/*.java Part2_DeepLearning/*.java
```

### Run Part 1 (Crime Reporting Analysis):
```cmd
java -cp bin Part1_CrimeReporting.CrimeReportingAnalyzer
```

### Run Part 2 (Deep Learning Analysis):
```cmd
java -cp bin Part2_DeepLearning.DeepLearningAnalyzer
```

## Output

- Console output with analysis results
- Text-based visualizations (bar charts)
- CSV files with detailed data
- Summary statistics

## Note

This implementation uses simulated data for demonstration. In a production environment, you would integrate with actual search APIs (Google Custom Search, Bing API, etc.) and PDF parsing libraries for real paper analysis.

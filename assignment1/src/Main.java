import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SERP Analysis System ===");
        System.out.println("1. Analyze Crime-Reporting Papers");
        System.out.println("2. Analyze Deep Learning Papers");
        System.out.println("3. Run Both");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("\n--- Crime-Reporting Papers Analysis ---");
                CrimeReportingAnalyzer crimeAnalyzer = new CrimeReportingAnalyzer();
                crimeAnalyzer.analyze();
                break;
                
            case 2:
                System.out.println("\n--- Deep Learning Papers Analysis ---");
                DeepLearningPapersAnalyzer dlAnalyzer = new DeepLearningPapersAnalyzer();
                dlAnalyzer.analyze();
                break;
                
            case 3:
                System.out.println("\n--- Running Both Analyses ---");
                CrimeReportingAnalyzer ca = new CrimeReportingAnalyzer();
                ca.analyze();
                
                System.out.println("\n");
                
                DeepLearningPapersAnalyzer dla = new DeepLearningPapersAnalyzer();
                dla.analyze();
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
        System.out.println("\nAnalysis complete! Check the output folder for visualizations.");
    }
}

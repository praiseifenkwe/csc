import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;

public class DataVisualizer {
    
    public static void createBarChart(Map<String, Integer> data, String title, 
                                     String xLabel, String yLabel, String outputPath) {
        System.out.println("\nGenerating visualization: " + outputPath);
        
        // Sort data by value (descending)
        List<Map.Entry<String, Integer>> sortedData = new ArrayList<>(data.entrySet());
        sortedData.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Take top 15 for better visualization
        int maxItems = Math.min(15, sortedData.size());
        sortedData = sortedData.subList(0, maxItems);
        
        // Create chart
        int width = 1200;
        int height = 800;
        int padding = 80;
        int barWidth = (width - 2 * padding) / maxItems;
        
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        // Enable anti-aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        
        // Title
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        FontMetrics fm = g2d.getFontMetrics();
        int titleWidth = fm.stringWidth(title);
        g2d.drawString(title, (width - titleWidth) / 2, 40);
        
        // Find max value for scaling
        int maxValue = sortedData.stream().mapToInt(Map.Entry::getValue).max().orElse(1);
        
        // Draw bars
        int chartHeight = height - 2 * padding - 100;
        int x = padding;
        
        Color[] colors = {
            new Color(52, 152, 219),   // Blue
            new Color(46, 204, 113),   // Green
            new Color(155, 89, 182),   // Purple
            new Color(241, 196, 15),   // Yellow
            new Color(231, 76, 60)     // Red
        };
        
        for (int i = 0; i < sortedData.size(); i++) {
            Map.Entry<String, Integer> entry = sortedData.get(i);
            int barHeight = (int) ((entry.getValue() / (double) maxValue) * chartHeight);
            int y = height - padding - 50 - barHeight;
            
            // Draw bar
            g2d.setColor(colors[i % colors.length]);
            g2d.fillRect(x + 5, y, barWidth - 10, barHeight);
            
            // Draw border
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x + 5, y, barWidth - 10, barHeight);
            
            // Draw value on top of bar
            g2d.setFont(new Font("Arial", Font.BOLD, 12));
            String value = String.valueOf(entry.getValue());
            int valueWidth = g2d.getFontMetrics().stringWidth(value);
            g2d.drawString(value, x + (barWidth - valueWidth) / 2, y - 5);
            
            // Draw label (rotated)
            g2d.setFont(new Font("Arial", Font.PLAIN, 10));
            Graphics2D g2dRotated = (Graphics2D) g2d.create();
            g2dRotated.rotate(-Math.PI / 4, x + barWidth / 2, height - padding - 30);
            String label = entry.getKey();
            if (label.length() > 20) {
                label = label.substring(0, 17) + "...";
            }
            g2dRotated.drawString(label, x + barWidth / 2, height - padding - 30);
            g2dRotated.dispose();
            
            x += barWidth;
        }
        
        // Draw axes
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        // Y-axis
        g2d.drawLine(padding, padding, padding, height - padding - 50);
        // X-axis
        g2d.drawLine(padding, height - padding - 50, width - padding, height - padding - 50);
        
        // Y-axis label
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        Graphics2D g2dRotated = (Graphics2D) g2d.create();
        g2dRotated.rotate(-Math.PI / 2, 20, height / 2);
        g2dRotated.drawString(yLabel, 20, height / 2);
        g2dRotated.dispose();
        
        // X-axis label
        g2d.drawString(xLabel, (width - g2d.getFontMetrics().stringWidth(xLabel)) / 2, height - 20);
        
        g2d.dispose();
        
        // Save image
        try {
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();
            ImageIO.write(image, "PNG", outputFile);
            System.out.println("Chart saved successfully: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error saving chart: " + e.getMessage());
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purse_Panel {
    public static class PursePanel extends JPanel {
        private Purse purse; // Purse object
        private final Map<String, Image> images = new HashMap<>();  // Hashmap to store images

        public PursePanel() { // Initialize the purse as empty and load images from resource root folder
            this.purse = new Purse();
            loadImages();
        }

        // Purse Setter
        public void setPurse(Purse purse) {
            this.purse = purse;
            repaint(); // reset the purse when the constructor is called
        }


       // Load images based on the DENOMINATIONS list from Register.java
       private void loadImages() {
           List<Denomination> denominations = Register.getDenominations(); // Get the list of denominations

           for (Denomination denomination : denominations) { // iterate through denomination names

               String imagePath = denomination.img(); // Create the image path for the URL
               URL imageUrl = getClass().getResource(imagePath);  // Load the image from the resources folder

               if (imageUrl == null) {
                   System.err.println("Image not found for: " + denomination.name() + " at path: " + imagePath);
                   continue;
               }

               try {
                   ImageIcon icon = new ImageIcon(imageUrl);
                   if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                       System.err.println("Image failed to load completely for: " + denomination.name());
                   }
                   images.put(denomination.name(), icon.getImage());
               } catch (Exception e) {
                   System.err.println("Exception occurred while loading image for: " + denomination.name());
                   e.printStackTrace();
               }


               ImageIcon icon = new ImageIcon(imageUrl);  // Create an ImageIcon from the resource
               images.put(denomination.name(), icon.getImage());  // Store the image in the map
           }
       }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (purse == null || purse.getValue() == 0) { // Check for an empty purse, will always be empty to start
                g.drawString("Empty Purse", 10, 20);
            } else {
                Map<Denomination, Integer> cash = purse.getCash();  // Get "cash" map from Purse.Java
                int y = 20; // Start drawing at y position 20
                int x = 10; // Start drawing at x position 10

                for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) { // Loop through the entry set in the map
                    Denomination denom = entry.getKey(); // Get denomination name
                    int count = entry.getValue(); // Get value of that denomination

                    // Draw the count and name of the denomination as text
                    g.drawString(count + " x " + denom.name(), x, y);
                    y += 20; // Move y position down for the next line

                    // Draw the image for each denomination
                    Image img = images.get(denom.name());
                    if (img != null) { // Check for missing image
                        for (int i = 0; i < count; i++) {
                            g.drawImage(img, x, y, this); // Draw the image at position (x, y)
                            x += 50; // Move x position to the right for the next image
                            if (x > getWidth() - 50) { // If we reach the panel's width, move to the next line
                                x = 10;
                                y += 50;
                            }
                        }
                    }
                    y += 50; // Add spacing after each denomination's images
                    x = 10;  // Reset x position for the next denomination
                }
            }
        }
    }
}



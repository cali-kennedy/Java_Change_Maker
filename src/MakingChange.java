import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Making Change"); // Set up the frame
        frame.setSize(600, 600); // Set Window Size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Register_Panel registerPanel = new Register_Panel(); // Set up the register panel
        frame.add(registerPanel); // Add the register panel to the JFrame
        frame.setVisible(true); // Make the JFrame visible
    }

}

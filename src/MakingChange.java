import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        // Set up the frame
        JFrame frame = new JFrame("Making Change");
        frame.setSize(400, 300);
        Register_Panel registerPanel = new Register_Panel();
        frame.add(registerPanel);
        frame.setVisible(true);
    }

}

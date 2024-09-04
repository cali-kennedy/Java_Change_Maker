import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_Panel extends JPanel {
    // Create a new register object for register logic
    private final Register register  = new Register();

    // JTextField where the user will input the amount they want to make change for.
    private final JTextField input = new JTextField(10);

   // Change panel where the change will be displayed
    private final Purse_Panel.PursePanel changePanel = new Purse_Panel.PursePanel();

    public Register_Panel(){
       setLayout(new BorderLayout()); // Use BorderLayout to arrange the components in the panel.

       // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter amount: "));
        inputPanel.add(input); // text field for entering the amount
        add(inputPanel, BorderLayout.NORTH); // Place inputPanel at the top of the panel.

        // Change Panel

        add(changePanel, BorderLayout.CENTER); // Place the changePanel at the center of the layout.

        input.addActionListener(new InputListener());
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                double amount = Double.parseDouble(input.getText()); // Parse the user input (from the text field) to a double.
                Purse purse = register.makeChange(amount); // Calculate change for the entered amount
                changePanel.setPurse(purse); // Pass the purse (calculated change) to the changePanel to display it.
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(Register_Panel.this,
                                        "Invalid Input. Please enter a valid number.",
                                            "Error",JOptionPane.ERROR_MESSAGE);

            }
        }

    }
}


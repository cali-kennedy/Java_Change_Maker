import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_Panel extends JPanel {
    private final Register register  = new Register();
    private final JTextField input = new JTextField(10);
    private final Purse_Panel.PursePanel changePanel = new Purse_Panel.PursePanel();

    public Register_Panel(){
       setLayout(new BorderLayout());

       // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter amount: "));
        inputPanel.add(input);
        add(inputPanel, BorderLayout.NORTH);

        // Change Panel

        add(changePanel, BorderLayout.CENTER);

        input.addActionListener(new InputListener());
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.setPurse(purse);
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(Register_Panel.this,
                                        "Invalid Input. Please enter a valid number.",
                                            "Error",JOptionPane.ERROR_MESSAGE);

            }
        }

    }
}


import java.util.List;
import java.util.Scanner;

public class Register {
    private static final List<Denomination> DENOMINATIONS = List.of(
            new Denomination("Fifty Dollar Note", 50.00, Form.BILL, "fifty_note.png"),
            new Denomination("Twenty Dollar Note", 20.00, Form.BILL, "twenty_note.png"),
            new Denomination("Ten Dollar Note", 10.00, Form.BILL, "ten_note.png"),
            new Denomination("Five Dollar Note", 5.00, Form.BILL, "five_note.png"),
            new Denomination("One Dollar Note", 1.00, Form.BILL, "one_note.png"),
            new Denomination("Quarter", 0.25, Form.COIN, "quarter.png"),
            new Denomination("Dime", 0.10, Form.COIN, "dime.png"),
            new Denomination("Nickel", 0.05, Form.COIN, "nickel.png"),
            new Denomination("Penny", 0.01, Form.COIN, "penny.png")
    );
    public static List<Denomination> getDenominations() { // Denominations list Getter
        return DENOMINATIONS;
    }

    public Purse makeChange(double amt){
        Purse purse = new Purse(); // Create an empty purse to store the calculated change
        for(Denomination denom : DENOMINATIONS) // Iterate through the list of denominations
        {
            int count = (int) (amt/denom.amt()); // Calculate how much of the specified amount we can make -
                                                 // - with the current denomination
            if (count > 0)
            {
                purse.add(denom, count); // Add the denomination and count to the purse
                amt -= count * denom.amt(); // Subtract the total value of the added denomination from the -
                                            // - specified amount
                amt = Math.round(amt * 100.0) / 100.0; // Round the amount to avoid float-point -
                                                       // - rounding errors
            }
        }
        return purse;
    }
    public static void main(String[] args) {
        // Create a new register object
        Register register = new Register();

        // Run the MakingChange GUI by calling its main method.
        MakingChange.main(args);

        // Variable to hold the amount the user enters
        double amount = 0;

        Scanner scan = new Scanner(System.in);


        while (amount != -1) {
            System.out.print("Enter an amount: ");
            amount = scan.nextDouble();
            System.out.println("Making change for: $" + amount);
            Purse purse = register.makeChange(amount); // Call makeChange() to calculate the change for the entered amount.
            System.out.println(purse); // Display the contents of the purse
        }

    }


}

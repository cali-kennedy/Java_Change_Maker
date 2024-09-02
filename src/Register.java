import java.util.List;

public class Register {
    private static final List<Denomination> DENOMINATIONS = List.of(
            new Denomination("Fifty Dollar Note", 50.00, Form.BILL, "fifty.png"),
            new Denomination("Twenty Dollar Note", 20.00, Form.BILL, "twenty.png"),
            new Denomination("Ten Dollar Note", 10.00, Form.BILL, "ten.png"),
            new Denomination("Five Dollar Note", 5.00, Form.BILL, "five.png"),
            new Denomination("One Dollar Note", 1.00, Form.BILL, "one.png"),
            new Denomination("Quarter", 0.25, Form.COIN, "quarter.png"),
            new Denomination("Dime", 0.10, Form.COIN, "dime.png"),
            new Denomination("Nickle", 0.05, Form.COIN, "nickle.png"),
            new Denomination("Penny", 0.01, Form.COIN, "penny.png")
    );

    public Purse makeChange(double amt){
        Purse purse = new Purse();
        for(Denomination denom : DENOMINATIONS)
        {
            int count = (int) (amt/denom.amt());
            if (count > 0)
            {
                purse.add(denom, count);
                amt -= count * denom.amt();
            }
        }
        return purse;
    }
    public static void main(String[] args) {
        Register register = new Register();
        // Define test amounts to demonstrate functionality
        double[] testAmounts = {0, 1.25, 0.01, 0.05, -5.45, 69.89};

        // Test the makeChange method with different amounts
        for (double amount : testAmounts) {
            System.out.println("Making change for: $" + amount);
            Purse purse = register.makeChange(amount);
            System.out.println(purse);
        }
        MakingChange.main(args);
    }


}

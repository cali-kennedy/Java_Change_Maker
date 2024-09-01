import java.util.List;

public class Register {
    private static final List<Denomination> DENOMINATIONS = List.of(
            new Denomination("Fifty Dollar Bill", 50.00, Form.BILL, "fifty.png"),
            new Denomination("Twenty Dollar Bill", 20.00, Form.BILL, "twenty.png"),
            new Denomination("Ten Dollar Bill", 10.00, Form.BILL, "ten.png"),
            new Denomination("Five Dollar Bill", 5.00, Form.BILL, "five.png"),
            new Denomination("One Dollar Bill", 1.00, Form.BILL, "one.png"),
            new Denomination("Quarter", 0.25, Form.COIN, "quarter.png"),
            new Denomination("Dime", 0.10, Form.COIN, "dime.png"),
            new Denomination("Nickle", 0.05, Form.COIN, "nickle.png"),
            new Denomination("Penny", 0.01, Form.COIN, "penny.png")
    );
}

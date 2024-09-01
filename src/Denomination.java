// Create denomination record
public record Denomination(String name, double amt, Form form, String img) { }
// Create enum for type of bill
enum Form
{
    BILL, COIN
}
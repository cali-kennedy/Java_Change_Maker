
public record Denomination(String name, double amt, Form form, String img) { } // Create denomination record

enum Form // Create enum for the type of bill/coin
{
    BILL, COIN
}
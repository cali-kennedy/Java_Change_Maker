import java.util.HashMap;
import java.util.Map;

/*
---------- ASSIGNMENT NOTES ---------------
    cash: Map<Denomination, int>   // represents the money in the purse
	add(type: Denomination, num: int): void  // adds a number of a particular denomination
    remove(type: Denomination, num: int): double //diminishes the money in the purse and returns that amount.
	getValue(): double    // returns the amount of money in the Purse
	toString(): String    // returns a string representation of the Purse and its contents
 */
public class Purse {
    //Denomination is the key and Integer is the value representing
    //the count of that denomination in the purse.
   private final Map<Denomination, Integer> cash = new HashMap<>();

   // Adds a specified number of denominations to the purse
   public void add(Denomination type, int num)
   {
       //cash.getOrDefault(type,0) : retrieves the current count of that denomination
       // from the map, if the denomination isn't there it defaults to 0
       //cash.put: updates the count of the denomination in the map
       cash.put(type, cash.getOrDefault(type, 0) + num);
   }

   public double remove(Denomination type, int num)
   {
       int currentCount = cash.getOrDefault(type,0);
       //if there's enough money in the purse, remove the amount specified,
       //otherwise return 0
       if (currentCount >= num) {
        cash.put(type, currentCount - num);
        return type.amt() * num; // return the value of removed denominations
       }
       return 0;
   }

   public double getValue()
   {
       // Maps each entry in the "cash" map to its monetary value and adds the total amount
       return cash.entrySet().stream()
               .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
               .sum();
   }

    // Returns a string representation of the purse
    public String toString() {
        if (cash.isEmpty()) return "Empty Purse";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey().name()).append("\n");
        }
        return sb.toString();
    }

}
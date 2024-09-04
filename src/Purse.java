import java.util.HashMap;
import java.util.Map;


public class Purse {
    //Denomination is the key and Integer is the value representing
    //the count of that denomination in the purse.
   private final Map<Denomination, Integer> cash = new HashMap<>(); // Hashmap to describe the *current* amt/type
                                                                    // of money in the purse
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
       // Maps each denomination in the 'cash' map to its monetary value and adds the total amount
       return cash.entrySet().stream()
               .mapToDouble(entry -> entry.getKey().amt() * entry.getValue()) // Multiply denomination value by its count
               .sum(); // Sum up all the individual values to get the total
   }

   // Getter method for cash
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    // Returns a string representation of the purse
    public String toString() {
        if (cash.isEmpty()) return "Empty Purse";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) { // Iterate through the 'cash' map

            // Append the count and the name of the denomination to the string.
            sb.append(entry.getValue()).append(" ").append(entry.getKey().name()).append("\n");
            // Note: .getValue() is not the same function we created, here it retrieves a count not a sum
        }
        return sb.toString(); // Return the string
    }

}
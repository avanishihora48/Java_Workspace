package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ans11 
{
    public static void main(String[] args) 
    {
        String input = "successes";
        char secondChar = findSecondChar(input);
        
        if (secondChar != '\0') 
        {
            System.out.println("The second most frequent char in the string is: " + secondChar);
        } 
        else 
        {
            System.out.println("There is no second most frequent character.");
        }
    }

    private static char findSecondChar(String i)
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : i.toCharArray()) 
        {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies, Collections.reverseOrder());

        if (frequencies.size() < 2) 
        {
            return '\0'; 
        }

        int secondHighestFrequency = frequencies.get(1);

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) 
        {
            if (entry.getValue() == secondHighestFrequency) 
            {
                return entry.getKey();
            }
        }

        return '\0'; 
    }
}

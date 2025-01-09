package NeetCode_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Neetcode150_04 
{
	/* Example Input
	 * Input: strs = ["act","pots","tops","cat","stop","hat"]
	 * Example output
	 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
	 */
	
	public List<List<String>> groupAnagrams(String[] strs) 
	{
        Map<String, List<String>> solution = new HashMap<>();
        
        for (String index_A: strs)
        {
        	
        	char[] solution_system = index_A.toCharArray();
        	Arrays.sort(solution_system); // So we are sorting out the individual string that we're checking
        	String Sorted_Char = new String(solution_system);
        	// Then we need to convert it back into a string
        	solution.putIfAbsent(Sorted_Char, new ArrayList<>()); 
        	// Above we then create a new arraylist for that solution
        	solution.get(Sorted_Char).add(index_A);
        }
        return new ArrayList<>(solution.values());
        // Here we are essentially creating an ArrayList out of the list of values provided from the map
    }
	public static boolean isAnagram(String s, String t)
	{
		StringBuilder String_A = new StringBuilder(s), String_B = new StringBuilder(t);
		// Above are mutable strings, meaning that they can be altered in comparison to normal strings
		int count = 0;
		for (int index_A = 0; index_A < String_A.length(); index_A++)
		{
			for (int index_B = 0; index_B < String_B.length(); index_B++)
			{
				//System.out.println("We are comparing " + String_A.charAt(index_A) + " " + String_B.charAt(index_B));
				if (String_A.charAt(index_A) == String_B.charAt(index_B))
				{
					//System.out.println("They are equal!");
					String_A.deleteCharAt(index_A);
					String_B.deleteCharAt(index_B);
					
					//System.out.println(index_A);
					index_A = -1; //Here we are resetting the index back due to the deletingCharAt 
					break; // To prevent an additional check 
				}
			}
		}
		//System.out.println("Here is the first string"+ String_A);
		//System.out.println("Here is the second string"+ String_B);
		if (String_A.toString().equals("") && String_B.toString().equals(""))
		{
			return true;
		}
		return false;
	}
}

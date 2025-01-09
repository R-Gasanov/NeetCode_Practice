package NeetCode_150;

public class Neetcode150_02 
{
	public static void main(String args[])
	{
		System.out.println(isAnagram("carrace","racecar"));
	}
	public static boolean istheSameBack(String s, String t)
	{
		int index_A = t.length()-1;
		for (int index_B = 0; index_B < s.length(); index_B++)
		{
			if (s.charAt(index_A) != t.charAt(index_B))
			{
				//System.out.println(s.charAt(index_A));
				//System.out.println(t.charAt(index_B));
				//System.out.println(s.charAt(index_A) + t.charAt(index_B));
				return false;
			}
			index_A--;
		}
		return true;
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

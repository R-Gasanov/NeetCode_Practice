package NeetCode_150;

import java.util.ArrayList;
import java.util.List;

public class Neetcode150_06 
{
	public static void main(String args[])
	{
		
	}
	
    public String encode(List<String> strs) 
	{
    	String encoded = "";
    	for (String index: strs)
    	{
    		encoded += index + "|";
    	}
    	return encoded;
    }

    public List<String> decode(String str) 
	{
    	ArrayList<String> decoded = new ArrayList<>();
    	char[] string_characters = str.toCharArray();
    	String addon_string = "";
    	
    	for (int index = 0; index < string_characters.length; index++)
    	{
    		
    		if (string_characters[index] != '|')
    		{
    			addon_string += string_characters[index];
    		}
    		else
    		{
    			decoded.add(addon_string);
    			addon_string = "";
    		}
    	}
    	//String[] answer = decoded.toArray(new String[0]);
    	
    	return decoded;
    	
    }
}

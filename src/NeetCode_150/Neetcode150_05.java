package NeetCode_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Neetcode150_05 
{
	public static void main(String args[])
	{ //nums=[1,1,1,2,2,3]
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		
		int[] result = topKFrequent(nums, k);
		
		for (int index: result)
		{
			System.out.println(index);
		}
	}
	public static int[] topKFrequent(int[] nums, int k)
	{
		Arrays.sort(nums);
		//int counter = 0;
		TreeMap<Integer, Integer> solution = new TreeMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		int[] answer;
		
		
		for (int index: nums)
		{
			//int counter = 0;
			
			if (solution.containsKey(index))
			{
				solution.replace(index, solution.get(index)+1);
			} // Above we are adding an additional value to determine the current amount
			else
			{
				solution.putIfAbsent(index, 1);
			}
			//solution.get(index).put(counter++);
		}
		// So above we have a map with the key representing the integer and the value the amount of them
		
		
		
		
		for (int index = 0; index < k; index++)
		{
			int highest_sum = 0;
			int key_hs = 0;
			for (Map.Entry<Integer, Integer> entry: solution.entrySet())
			{
				if (entry.getValue() > highest_sum)
				{
					highest_sum = entry.getValue();
					key_hs = entry.getKey();
				}
			}
			result.add(key_hs); // Adding the highest value found.
			solution.remove(key_hs);
		}
		
		
		
		/*
		TreeMap<Integer, Integer> swapped_solution = new TreeMap<>();
		// Essentially I came across an error, what I wanna do here is have the treemap sort it
		// based on the counter values I've added and then show its value.
		// Theres probably an easier way to do it, however this will do for now
		
		for (Map.Entry<Integer, Integer> entry: solution.entrySet())
		{
			swapped_solution.put(entry.getValue(),entry.getKey());
			
		}
		
		// swapped_solution now has the counter as the key and the actual data set as the numbers
		
		// We will be using the last 
		//result.add(swapped_solution.get(swapped_solution.lastKey()));
		//int check = swapped_solution.get(swapped_solution.lastKey());
		for (int index = 0; index < k; index++)
		{
			int key_counter = swapped_solution.lastKey();
			result.add(swapped_solution.get(key_counter));
			swapped_solution.remove(key_counter);
			//result.add(swapped_solution.get(swapped_solution.lowerKey(check)));
			//check = swapped_solution.lowerKey(check);
		}
		*/
		
		// Below, we are converting the ArrayList into a normal array int[]
		answer = result.stream().mapToInt(Integer::intValue).toArray();
		
		/*
		 * result.add(solution.lowerKey(check));
			check = solution.lowerKey(check);
		 */
		
		
		
		return answer;
		//System.out.println(solution.get())
	}
}

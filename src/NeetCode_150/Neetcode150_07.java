package NeetCode_150;

import java.util.ArrayList;

public class Neetcode150_07 
{
	public static void main(String args[])
	{
		// Testing the method to check if it works or not
		int[] nums = {-1,0,1,2,3};
		int[] answer;
		
		answer = productExceptSelf(nums);
		
		for (int index: answer)
		{
			System.out.println(index);
		}
		
	}
	
	public static int[] productExceptSelf(int[] nums) 
	{
		ArrayList<Integer> solution = new ArrayList<>();
		int[] answer;
		int counter = 0, sum = 0; 
		// Above we will use counter to prevent the index number from being a multiplier itself
		for (int index_A = 0; index_A < nums.length; index_A++)
		{
			for (int index_B = 0; index_B < nums.length; index_B++)
			{
				if (index_A != index_B && counter == 0) // To prevent the same index position
				{	counter++;
					sum = nums[index_B];
					System.out.println("To check if the number is being assigned at all" + sum);
				}
				else if (index_A != index_B && sum != 0)
				{
					sum = sum * nums[index_B];
				}
			}
			counter = 0;
			solution.add(sum);
			sum = 0;
		}
		
		answer = solution.stream().mapToInt(Integer::intValue).toArray();
        
		return answer;
    }
}

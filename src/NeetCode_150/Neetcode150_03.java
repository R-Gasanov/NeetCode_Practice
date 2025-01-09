package NeetCode_150;

public class Neetcode150_03 
{
	public static void main(String args[])
	{
		int nums[] = {3,4,5,6};
		int target = 7;
		System.out.println(twoSum(nums, target));
	}
	public static int[] twoSum(int[] nums, int target)
	{
		int num_a = 0, num_b = 0;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = 0; j < nums.length; j++)
			{
				if (i != j)
				{
					if (nums[i] + nums[j] == target)
					{
						num_a = i;
						num_b = j;
					}
				}
			}
		}
		if (num_a < num_b)
		{
			return new int[] {num_a, num_b};
			
			//return num_a + num_b;
		}
		else
		{
			return new int[] {num_b, num_a};
			//return num_b + num_a;
		}
	}
}

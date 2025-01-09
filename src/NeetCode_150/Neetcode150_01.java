package NeetCode_150;

public class Neetcode150_01 
{
	public static void main(String args[])
	{
		int[] nums = {1,2,3,3};
		System.out.println(hasDuplicate(nums));
	}
	
	public static boolean hasDuplicate(int[] nums) 
    {
		System.out.println(nums.length);
        for (int index = 0; index < nums.length; index++)
        {
            for (int index_2 = 0; index_2 < nums.length; index_2++)
            {
            	System.out.println(index + index_2);
                if (index != index_2)
                {
                	//System.out.println("Here we are comparing the values"+ index + index_2);
                    if (nums[index] == nums[index_2])
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

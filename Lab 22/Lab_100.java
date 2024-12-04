/*
	Problem: https://www.codechef.com/problems/HOLIDAYS
	Above link is not opening, so sir has given new question.
	
	LeetCode :-
	75. Sort Colors

	Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
	We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
	You must solve this problem without using the library's sort function.

	Example 1:
		Input: nums = [2,0,2,1,1,0]
		Output: [0,0,1,1,2,2]
	Example 2:
		Input: nums = [2,0,1]
        Output: [0,1,2]

	Constraints:
		n == nums.length
		1 <= n <= 300
		nums[i] is either 0, 1, or 2.
 */

class Solution {
	public void sortColors(int[] nums) {
		int a=0,b=0;
		for(int i:nums){
			if(i==0){
				a++;
			}
			else if(i==1) {
				b++;
			}
		}
		for(int i=0;i<nums.length;i++){
			if(a!=0){
				nums[i]=0;
				a--;
			}
			else if(b!=0){
				nums[i]=1;
				b--;
			}
			else{
				nums[i]=2;
			}
		}
		System.out.println(nums);
	}
}
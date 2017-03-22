package com.amao.prep;

public class LC238ProductofArrayExceptSelf {

	
	public int[] productExceptSelf(int[] nums) {
		
		/*{		1,		[0],	[0][1],[0][1][2]}
		 *{[1][2][3],	[2][3]	,[3],		1	}*/
		
		int[] res = new int[nums.length];
		res[0] = 1;
		
		for (int i = 1; i < res.length; i++) {
			res[i] = res[i-1]*nums[i-1];
			
			//i=1,2,3
			/*
			 *i=1, res[1]=res[0]*nums[0]
			 *i=2  res[2]=res[1]*nums[1] */
		}
		
		
		int right = 1;
		for (int j = res.length-1; j >=0; j--) {
			res[j]*=right;
			right*=nums[j];
			
			//j=3,2,1,0
			/*j=3,	right=1,				res[3]*=1
			 *j=2,	right=nums[3],			res[2]*=nums[3];
			 *j=1,	right=nums[3]*nums[2], 	res[1]*=right
			 **/
		}
        
		return res;
    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC238ProductofArrayExceptSelf ls = new LC238ProductofArrayExceptSelf();
		int[] t = {1,2,3,4};
		
		for(int i:ls.productExceptSelf(t)){
			System.out.print(i+",");
		}
	}

}

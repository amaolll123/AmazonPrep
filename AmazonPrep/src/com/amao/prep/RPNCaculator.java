package com.amao.prep;


import java.util.Stack;

//************ Input:[],["iwoeri"],["1"],["+"]  ********************

public class RPNCaculator {
	
	
	public int Caculator(String[] tokens){
		Stack<Integer> intStk =  new Stack<Integer>();

		
			//traverse the array	
			for(String s:tokens){
				try{
					int num = Integer.parseInt(s);
					//push the number
					intStk.push(num);
				}catch(Exception e){
					//process the operator
					try{
						if(s.equals("+")){
							intStk.push(intStk.pop()+intStk.pop());
						}
						else if(s.equals("-")){
							int num2 = intStk.pop();
							int num1 = intStk.pop();
							intStk.push(num1-num2);
						}
						else if(s.equals("*")){
							intStk.push(intStk.pop()*intStk.pop());
						}else if(s.equals("/")){
							int num2 = intStk.pop();
							int num1 = intStk.pop();
							intStk.push(num1/num2);
						}
						
					}catch(Exception exc){
						System.out.println("no enough number");
					}
					
				}
			}
		
		return intStk.pop();
		
		
	}

	public static void main(String[] args) {
		String[] s = {"4","12","3","/","*"};
		RPNCaculator rpnC = new RPNCaculator();
		
		System.out.println(rpnC.Caculator(s));
	}

}

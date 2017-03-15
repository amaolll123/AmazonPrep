package com.amao.prep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

	/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

	Subscribe to see which companies asked this question.*/
	
	//***************          Input type: "","()","123","]","(])"       *********************************
	
	
	public boolean validParentheses(String s){
		
		//""
		if(s.isEmpty()){
			return false;
		}
		Map<Character,Character> m = new HashMap<Character,Character>();
		m.put('(', ')');
		m.put('[', ']');
		m.put('{', '}');
		
		Stack<Character> stack  = new Stack<Character>();
		
		char[] cArr = s.toCharArray();
		
		for(int i = 0;i<cArr.length;i++){
			
			//"123"
			if(!m.containsKey(cArr[i])&&!m.containsValue(cArr[i])){
				return false;
			}
			
			
				
				if(m.containsKey(cArr[i])){
					stack.push(cArr[i]);
				}
				else{
					//"]"
					if(stack.empty()) return false;
					//Ò»¶Ô
					if(m.get(stack.peek()).equals(cArr[i])){
						stack.pop();
					}
					//"(})"
					else{
						return false;
					}
				}
			
		}
		if(stack.empty()){
			return true;
		}
		return false;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()[]{}";
		ValidParenthesis vp = new ValidParenthesis();
		
		System.out.println(vp.validParentheses(s));
	}

}

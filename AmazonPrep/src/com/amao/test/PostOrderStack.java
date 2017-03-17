package com.amao.test;

import java.util.Stack;

import com.amao.support.TreeNode;

public class PostOrderStack {

	public void StackPost(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = root;
		s.push(root);
		TreeNode temp;
		
		while(current!=null&&!s.empty()){
			
			
			if(current.left != null){//L有
				current = current.left;
				s.push(current);
			}
			
			
			else{//L没
				temp = s.peek().right;
				
				
				
				if(temp==null){//R没
					s.pop();
					System.out.print(current.val);
					
					
					
					while(!s.empty()&&current == s.peek().right){
						current = s.pop();
						System.out.print(current.val);
					}
					if(!s.empty()){
						current = s.peek().right;
						s.push(current);
					}
					
				}
				
				
				else{//L没R有
					current = temp;
					s.push(current);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t21 = new TreeNode(4);
		TreeNode t22 = new TreeNode(5);
		TreeNode t11 = new TreeNode(6);
		TreeNode t12 = new TreeNode(7);
		root.left = t1;
		root.right = t2;
		t1.left = t11;
		t1.right = t12;
		t2.left = t21;
		t2.right = t22;
		
		PostOrderStack pos = new PostOrderStack();
		pos.StackPost(root);
	}

}

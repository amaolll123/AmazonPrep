package com.amao.test;

import com.amao.support.TreeNode;

public class InOrderTraversal {
	
	public void InOrder(TreeNode tn){
		
		if(tn.left!=null) InOrder(tn.left);
		System.out.print(tn.val+",");
		if(tn.right!=null) InOrder(tn.right);
		
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode t1 = new TreeNode(20);
		TreeNode t2 = new TreeNode(9);
		TreeNode t21 = new TreeNode(15);
		TreeNode t22 = new TreeNode(7);
		TreeNode t11 = new TreeNode(8);
		TreeNode t12 = new TreeNode(6);
		root.left = t1;
		root.right = t2;
		t1.left = t11;
		t1.right = t12;
		t2.left = t21;
		t2.right = t22;
		
		InOrderTraversal iot = new InOrderTraversal();
		iot.InOrder(root);
		
	}
}

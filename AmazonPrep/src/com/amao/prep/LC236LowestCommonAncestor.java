package com.amao.prep;

import com.amao.support.TreeNode;

public class LC236LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		//自己反自己
		//一边有反一边，两边有反自己
		//两边无反无
		
        if(root == null) return null;
        if(root ==p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null&&right == null)return null;
        if(left!=null&&right!=null) return root;
        
        return left!=null?left:right;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		LC236LowestCommonAncestor lca = new LC236LowestCommonAncestor();
		TreeNode tn = lca.lowestCommonAncestor(root, t2, t12);
		System.out.println(tn.val);
	}

}

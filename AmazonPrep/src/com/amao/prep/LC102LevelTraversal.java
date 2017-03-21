package com.amao.prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.amao.support.TreeNode;

public class LC102LevelTraversal {
	
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        
		Queue<TreeNode> bsfQueue = new LinkedList<TreeNode>();
		
		List<List<Integer>> levelList = new ArrayList<List<Integer>>();
		
		if(root == null){
			return levelList;
		}
		
		bsfQueue.offer(root);
		
		while(!bsfQueue.isEmpty()){
			int size = bsfQueue.size();
			List<Integer> l = new ArrayList<Integer>();
			for(int i = 0 ;i<size;i++){
			
				TreeNode tn = bsfQueue.poll();
				
				l.add(tn.val);
				
				
				if(tn.left!=null){
					bsfQueue.add(tn.left);
				}
				if(tn.right!=null){
					bsfQueue.add(tn.right);
				}
			}
			
			
			
			
			levelList.add(l);
		}
		
		return levelList;
		
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
		
		LC102LevelTraversal test = new LC102LevelTraversal();
		List<List<Integer>> result = test.levelOrder(root);
		System.out.print("{ ");
		for(List<Integer> iList:result){
			System.out.print("[");
			for(int i:iList){
				
				System.out.print(i+",");
				
			}
			System.out.print("], ");
		}
		System.out.println("}");
	}

}

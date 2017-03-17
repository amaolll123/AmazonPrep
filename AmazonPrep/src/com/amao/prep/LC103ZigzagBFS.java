package com.amao.prep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.amao.support.TreeNode;

public class LC103ZigzagBFS {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList();
        Deque<TreeNode> deque = new LinkedList();

        if(root==null) return rs;

        deque.add(root);
        int level = 0;
        int size;

        while(!deque.isEmpty()){//Every Loop represents a level

        	size = deque.size();// the size of the level

        	List<Integer> levelList = new ArrayList();//level Result
        	
        	for(int i = 0;i<size;i++){//loop every level member
        		TreeNode tn = deque.poll();
        		levelList.add(tn.val);
        		if(tn.left!=null) deque.add(tn.left);
        		if(tn.right!=null) deque.add(tn.right);
        	}

        	if(level%2==1) Collections.reverse(levelList);
        	if(!deque.isEmpty()) level++;
        	rs.add(levelList);
        }
        return rs;
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
		
		LC103ZigzagBFS t = new LC103ZigzagBFS();
		
		List<List<Integer>> result = t.zigzagLevelOrder(root);
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

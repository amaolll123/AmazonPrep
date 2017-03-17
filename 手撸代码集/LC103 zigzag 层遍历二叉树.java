public class Solution {
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
}
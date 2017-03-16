public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	//用队列记录
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        List<List<Integer>> result = new ArrayList();

        if(root==null){
        	return result;
        }

        q.offer(root);

        //队列里有东西时
        while(!q.isEmpty()){
        	int size = q.size();
        	//每一个level的遍历结果
        	List<Integer> levelList = new ArrayList<Integer>();
        	for(int i = 0;i<size;i++){//**这一行很关键**
        		TreeNode tn = q.poll();
        		levelList.add(tn.val);
        		if(tn.left!=null){
        			q.add(tn.left);
        		}
        		if(tn.right!=null){
        			q.add(tn.right);
        		}
        	}
        	result.add(levelList);
        }
        return result;
    }
}
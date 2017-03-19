public void PostOrderStack(TreeNode root){
	TreeNode cur = root;
	Stack<TreeNode> stack = new Stack<TreeNode>();

	while(cur!=null||!stack.empty()){

		
		if(cur!=null){
			stack.push(cur);
			cur=cur.left;
		}



		else{//cur为空是栈顶node工作状态&&左树处理完了
			temp = stack.peek().right;//工作节点的右侧
			if(temp!=null){
				cur = temp; 
			}
			else{//工作节点右侧Null，工作完成，打印回溯
				temp = stack.pop();
				//print
				while(!stack.empty()&&temp==stack.peek().right){//循环结束时，temp在一个左子树的头结点，并且打印过这个节点，这是条件决定的
					temp = stack.pop();
					//print
				}
			}
		}
	}
}
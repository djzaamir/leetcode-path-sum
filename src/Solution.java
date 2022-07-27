class Solution {
    public boolean hasPathSum(TreeNode node, int targetSum) {

        return hasPathSumCore(node, 0, targetSum, 0);
    }

    //Backend Recursive method, actually responsible for computing the existence of target value inside the tree.
    private boolean hasPathSumCore(TreeNode node, int parent_sum, int target_sum, int depth_so_far){
        //Base cases
        if(node == null) return false;

        if (((parent_sum + node.val) == target_sum) && (depth_so_far == 0)){

            //SPECIAL CHECK
            //Now if depth == 0 && (left && right) == null then this means this is the only node in the tree
            //And therefore its sole sum can be used to check if target exists
            if((node.left == null) && (node.right == null)) return true;
        }else if (((parent_sum + node.val) == target_sum) && (depth_so_far > 0)) return true;

        boolean left_side_result = this.hasPathSumCore(node.left, parent_sum+node.val, target_sum, depth_so_far+1) ;

        //Check if target has been achieved, to avoid going through the right side
        if (left_side_result) return true;

        //Continue searching for solution in the right-hand side
        return this.hasPathSumCore(node.right, parent_sum + node.val, target_sum, depth_so_far+1);
    }
}
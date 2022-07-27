class Solution {
    public boolean hasPathSum(TreeNode node, int targetSum) {
        return hasPathSumCore(node, 0, targetSum);
    }
    //Backend Recursive method, actually responsible for computing the existence of target value inside the tree.
    private boolean hasPathSumCore(TreeNode node, int parent_sum, int target_sum){
        //Base cases
        if(node == null) return false;

        int curr_sum = parent_sum + node.val;
        if ((curr_sum == target_sum) && node.left == null && node.right == null) return true;

        boolean left_side_result = this.hasPathSumCore(node.left, curr_sum, target_sum) ;

        //Check if target has been achieved, to avoid going through the right side
        if (left_side_result) return true;

        //Continue searching for solution in the right-hand side
        return this.hasPathSumCore(node.right, curr_sum, target_sum);
    }
}
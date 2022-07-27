class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumCore(root, 0, targetSum);
    }

    //Backend Recursive method, actually responsible for computing the existence of target value inside the tree.
    private boolean hasPathSumCore(TreeNode root, int parent_sum, int target_sum){

        //Base cases
        if(root == null) return false;
        if ((parent_sum + root.val) == target_sum) return true;

        boolean left_side_result = this.hasPathSumCore(root.left, parent_sum+root.val, target_sum);

        //Check if target has been achieved, to avoid going through the right side
        if (left_side_result) return true;

        //Continue searching for solution in the right-hand side
        return this.hasPathSumCore(root.right, parent_sum + root.val, target_sum);
    }
}
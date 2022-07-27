import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private TreeNode root =  null;
    public Tree(){
    }

    public void pushArray(int arr[]){

        //Maintains the node list of where to add the next node
        Queue<TreeNode> pushOrderQ = new LinkedList<>();

        //Insert the first element outside of loop to avoid a branch inside
        root = new TreeNode(arr[0]);
        pushOrderQ.add(root);

        for (int i =1; i < arr.length; i+=2){
            TreeNode next_node_to_add_value = null;
            //Because the insertion list also contains null nodes, and we can't add data to null nodes
            //Therefore, we will keep searching for a valid non-null node
            while (next_node_to_add_value == null)
                next_node_to_add_value = pushOrderQ.poll();

            //Consider 0 nodes as Null nodes
            TreeNode left =  null;
            if ((i) < arr.length && arr[i] != 0)
                left = new TreeNode(arr[i]);

            TreeNode right = null;
            if ((i+1) < arr.length && arr[i+1] != 0)
                right = new TreeNode(arr[i+1]);



            //Add nodes to the tree
            next_node_to_add_value.left = left;
            next_node_to_add_value.right = right;

            pushOrderQ.add(left);
            pushOrderQ.add(right);
        }
    }

    //User facing non-recursive method
    public void printTreePreOrder(){
        //Call the recursive method with root node to print the tree
        this.printTreePreOrderCore(root);
    }
    //Backend recursive method to print the tree
    private void printTreePreOrderCore(TreeNode node){
        if(node == null) return;
        System.out.println(node.val);
        this.printTreePreOrderCore(node.left);
        this.printTreePreOrderCore(node.right);
    }

    public TreeNode getRoot(){
        return root;
    }
}

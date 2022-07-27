import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {
        //Binary Tree data to input
        /*
        * 0 represents a Null a node
        * Rest of the data is structured like following
        * Input Node, then left and right
        * Then goto the left entry and again input Node, left then right
        * */

        //TEST CASE 1; target_val = 22; expected result = TRUE
//        int data_to_injest[] = new int[]{
//                5,4,8,11,0,13,4,7,2,0,0,0,1,99
//        };

        //TEST CASE 2; target_val = 1; expected result = FALSE
//        int data_to_injest[] = new int[]{
//                1,2
//        };

        //TEST CASE 3; target_val = 1; expected result = TRUE
//        int data_to_injest[] = new int[]{
//                1
//        };

        //TEST CASE 4; target_val = 6; expected result = FALSE
        int data_to_injest[] = new int[]{
              1,2,0,3,0,4,0,5
        };

        Tree tree = new Tree();

        //Input data in a specific order, defined inside the pushArray method
        tree.pushArray(data_to_injest);

        //Instantiating Solution class, to check if a target sum inside the tree
        Solution mySolution =  new Solution();

        final int target = 6;

        if (mySolution.hasPathSum(tree.getRoot(), target))
            System.out.printf("Given Target -> %d exists in the Tree", target);
        else
            System.out.printf("Given Target -> %d DOES NOT exists in the Tree", target);

    }
}

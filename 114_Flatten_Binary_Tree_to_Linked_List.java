/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        root = flat(root);
    }

    public static TreeNode flat(TreeNode root){
        if(root == null)
            return null;
        
        TreeNode right = root.right;
    
        root.right = flat(root.left);
        root.left = null;

        TreeNode temp = root;

        while(temp.right !=null)
            temp = temp.right;
        
        temp.right = flat(right);

        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode prev = null;
    TreeNode ans;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return ans;
    }
    private void inorder(TreeNode root, TreeNode p){
        if(root == null) return;
        inorder(root.left, p);
        if(prev == p) {
            ans = root;
        }
        prev = root;
        inorder(root.right, p);
    }
}

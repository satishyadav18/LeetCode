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
    int ans = 0;
    public int findTilt(TreeNode root) {
        PostOrd(root);
        return ans;
    }

    private int PostOrd(TreeNode root){
          if(root == null){
            return 0;
        }

        int left = PostOrd(root.left);
        int right = PostOrd(root.right);

        ans += Math.abs(left - right);

        return left + right + root.val;
    }
}
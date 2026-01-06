package basic;

import java.util.List;

public class TreeCode {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //二叉树的最大深度
    static  class Solution {
        public int maxDepth(TreeNode root) {
            int depth  = 0;
            if (root == null){
                return depth;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    //验证二叉搜索树
    static class Solution1 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        public boolean isValidBST(TreeNode root, Long min, Long max) {
            if (root == null){
                return true;
            }
            if (root.val <= min ){
                return false;
            }
            if (root.val >= max){
                return false;
            }
            return isValidBST(root.left, min, Long.valueOf(root.val)) && isValidBST(root.right, Long.valueOf(root.val), max);
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        }
    }

    //对称二叉树
    static class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
        }
        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null){
                return true;
            }
            if (left == null &&  right != null){
                return false;
            }
            if (left!=null && right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }

        public static void main(String[] args) {
            //[2,3,3,4,5,null,4]
            System.out.println(new Solution2().isSymmetric(new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(4), null))));

        }
    }

    //二叉树的层序遍历
    static class Solution3 {
        public List<List<Integer>> levelOrder(TreeNode root) {

            return null;
        }
    }
}

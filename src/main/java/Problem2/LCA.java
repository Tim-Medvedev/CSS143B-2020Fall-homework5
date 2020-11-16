package Problem2;

import Problem1.TreeNode;

public class LCA {
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftAncestor = lowestCommonAncestor(root.left, p , q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p , q);

        if (leftAncestor != null && rightAncestor != null) {
            return root;
        }

        if (leftAncestor != null) {
            return leftAncestor;
        } else {
            return rightAncestor;
        }
    }
}

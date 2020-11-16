package Problem1;

import java.util.*;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode ptr = root;
        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            result.add((int)ptr.val);
            ptr = ptr.right;
        }
        return result;  // place holder
    }
}

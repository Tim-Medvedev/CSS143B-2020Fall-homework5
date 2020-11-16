package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    //I used the linked list implementation of the queue interface just because it seemed to be the
    //simplest one since it just adds a value to the end and pops the head.
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> thisLevel = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode ptr = q.poll();
                thisLevel.add((int)ptr.val);
                if (ptr.left != null) {
                    q.add(ptr.left);
                }
                if (ptr.right != null) {
                    q.add(ptr.right);
                }
            }
            result.add(thisLevel);
        }
        return result;  // place holder
    }
}

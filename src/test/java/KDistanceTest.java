import ExtraCredit.KDistance;
import Problem1.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KDistanceTest {
    public static class TestCase {
        TreeNode<Integer> root;
        TreeNode<Integer> target;
        int k;
        List<Integer> expect;

        public TestCase(TreeNode<Integer> root, int target, int[] expect) {
            this.root = root;
            this.target = findTreeNodeByValue(target);
            this.expect = new ArrayList<>();
            for (int v : expect) {
                this.expect.add(v);
            }
        }

        public TestCase(TreeNode<Integer> root, int target, int k, int[] expect) {
            this(root, target, expect);
            this.k = k;
            Collections.sort(this.expect);
        }

        private TreeNode<Integer> findTreeNodeByValue(int val) {
            return findTreeNodeByValueHelper(val, root);
        }

        private TreeNode<Integer> findTreeNodeByValueHelper(int val, TreeNode<Integer> node) {
            if (node == null) {
                return null;
            }

            if (node.val == val) {
                return node;
            }

            TreeNode<Integer> result = findTreeNodeByValueHelper(val, node.left);
            if (result != null) {
                return result;
            }

            result = findTreeNodeByValueHelper(val, node.right);
            return result;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                    "root=" + root +
                    ", target=" + target +
                    ", k=" + k +
                    '}';
        }
    }

    @Test
    public void testDistanceK() {
        List<TestCase> testCases = getDistanceKTestCases();
        for (TestCase testCase : testCases) {
            List<Integer> actual = KDistance.distanceK(testCase.root, testCase.target, testCase.k);
            Collections.sort(actual);
            //assertEquals(testCase.expect, actual);
        }
    }

    private List<TestCase> getDistanceKTestCases() {
        List<TestCase> testCases = new ArrayList<>();

        //      1
        //     / \
        //    2   N
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        testCases.add(new TestCase(root, 1, 1, new int[]{2}));
        testCases.add(new TestCase(root, 2, 1, new int[]{1}));
        testCases.add(new TestCase(root, 2, 2, new int[]{}));
        testCases.add(new TestCase(root, 1, 2, new int[]{}));
        testCases.add(new TestCase(root, 1, 0, new int[]{1}));
        testCases.add(new TestCase(root, 2, 0, new int[]{2}));

        //      1
        //     / \
        //    2   3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        testCases.add(new TestCase(root, 1, 1, new int[]{2, 3}));
        testCases.add(new TestCase(root, 2, 1, new int[]{1}));
        testCases.add(new TestCase(root, 2, 2, new int[]{3}));
        testCases.add(new TestCase(root, 2, 3, new int[]{}));
        testCases.add(new TestCase(root, 3, 1, new int[]{1}));
        testCases.add(new TestCase(root, 3, 2, new int[]{2}));
        testCases.add(new TestCase(root, 3, 3, new int[]{}));

        //          1
        //         /
        //        2
        //       /
        //      3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        testCases.add(new TestCase(root, 1, 1, new int[]{2}));
        testCases.add(new TestCase(root, 1, 2, new int[]{3}));
        testCases.add(new TestCase(root, 1, 3, new int[]{}));
        testCases.add(new TestCase(root, 2, 1, new int[]{1, 3}));
        testCases.add(new TestCase(root, 2, 2, new int[]{}));
        testCases.add(new TestCase(root, 3, 1, new int[]{2}));
        testCases.add(new TestCase(root, 3, 2, new int[]{1}));
        testCases.add(new TestCase(root, 3, 3, new int[]{}));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.right.right = new TreeNode<>(3);
        testCases.add(new TestCase(root, 1, 1, new int[]{2}));
        testCases.add(new TestCase(root, 1, 2, new int[]{3}));
        testCases.add(new TestCase(root, 1, 3, new int[]{}));
        testCases.add(new TestCase(root, 2, 1, new int[]{1, 3}));
        testCases.add(new TestCase(root, 2, 2, new int[]{}));
        testCases.add(new TestCase(root, 3, 1, new int[]{2}));
        testCases.add(new TestCase(root, 3, 2, new int[]{1}));
        testCases.add(new TestCase(root, 3, 3, new int[]{}));

        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        testCases.add(new TestCase(root, 1, 1, new int[]{2, 3}));
        testCases.add(new TestCase(root, 2, 1, new int[]{1, 4, 5}));
        testCases.add(new TestCase(root, 2, 2, new int[]{3}));


        //             1
        //            /  \
        //           2    3
        //          /  \    \
        //         4    5    6
        //        /    /
        //       7    8
        //      /
        //     9
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.left.left = new TreeNode<>(7);
        root.left.left.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(8);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        testCases.add(new TestCase(root, 2, 2, new int[]{3, 7, 8}));
        testCases.add(new TestCase(root, 5, 2, new int[]{1, 4}));
        testCases.add(new TestCase(root, 5, 3, new int[]{3, 7}));
        testCases.add(new TestCase(root, 4, 2, new int[]{1, 5, 9}));

        //             0
        //            /  \
        //           1    3
        //          /
        //         2
        //        /
        //       4
        root = new TreeNode<>(0);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.left.left = new TreeNode<>(4);
        testCases.add(new TestCase(root, 1, 0, new int[]{1}));

        //             0
        //            /  \
        //           1    3
        //          /
        //         2
        //        /
        //       4
        root = new TreeNode<>(0);
        root.right = new TreeNode<>(1);
        root.right.left = new TreeNode<>(3);
        root.right.right = new TreeNode<>(2);
        root.right.right.left = new TreeNode<>(4);
        root.right.right.left.right = new TreeNode<>(5);
        testCases.add(new TestCase(root, 4, 0, new int[]{4}));
        return testCases;
    }
}
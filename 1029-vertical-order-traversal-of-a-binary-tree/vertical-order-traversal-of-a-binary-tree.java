import java.util.*;

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

    class Tuple {
        TreeNode node;
        int row, col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<int[]> nodes = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0, 0));

        // BFS traversal
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();

            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            nodes.add(new int[]{col, row, node.val});

            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Sort by col → row → value
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];   // col
            if (a[1] != b[1]) return a[1] - b[1];   // row
            return a[2] - b[2];                    // value
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (int[] arr : nodes) {
            int col = arr[0], val = arr[2];

            if (col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = col;
            }
            result.get(result.size() - 1).add(val);
        }

        return result;
    }
}
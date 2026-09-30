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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root!=null) q.offerLast(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.pollFirst();
                level.add(node.val);
                if(node.left!=null) q.offerLast(node.left);
                if(node.right!=null) q.offerLast(node.right);
            }
            if(result.size()%2!=0){
                Collections.reverse(level);
                result.add(level);
            }
            else{
                result.add(level);
            }
        }
        return result;
    }
}
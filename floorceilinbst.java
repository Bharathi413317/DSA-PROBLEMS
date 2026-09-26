/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public static int floorinBst(TreeNode root,int key){
        int floor=-1;
        while(root!=null){
            if(root.data==key){
                floor=root.data;
                return floor;
            }if(root.data<key){
                floor=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }return floor;
    }public static int ceilinBst(TreeNode root,int key){
        int ceil=-1;
        while(root!=null){
            if(root.data==key){
                ceil=root.data;
                return ceil;
            }if(root.data<key){
                root=root.right;
            }else{
               ceil=root.data;
               root=root.left;
            }
        }return ceil;
    }
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer>arr=new ArrayList();
        int k=floorinBst(root,key);
        int l=ceilinBst(root,key);
        arr.add(k);
        arr.add(l);
        return arr;
    }
}

class Solution {
    public int[] leaf(List<Integer>arr,TreeNode root){
        
        if(root==null){
            return arr.stream().mapToInt(Integer::intValue).toArray();
        }
        if(root.left==null && root.right==null){
            arr.add(root.val);
        }
        leaf(arr,root.left);
        leaf(arr,root.right);
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer>arr=new ArrayList<>();
        ArrayList<Integer>arr1=new ArrayList<>();
        int []a=leaf(arr,root1);
        int []b=leaf(arr1,root2);
        if (Arrays.equals(a, b)) {
            return true;
        }
        return false;
    }
}
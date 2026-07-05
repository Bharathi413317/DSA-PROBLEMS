
class Solution {
    ArrayList<Integer>arr=new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
         int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }int l=0;
        int r=result.length-1;
     
       while(l<r){
        int sum=result[l]+result[r];
        
        if(sum==k)  return true;
        else if(sum>k){
           
            r--;
        }else{
       
          l++;
        }
       }return false;
    }
}

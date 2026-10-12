class Solution {
    public boolean checkeven(List<Integer>lst){
        for(int i=0;i<lst.size();i++){
            if(lst.get(i)%2!=0) return false;
        }return true;
    }public boolean checkodd(List<Integer>lst){
        for(int i=0;i<lst.size();i++){
            if(lst.get(i)%2==0) return false;
        }return true;
    }public boolean checkinc(List<Integer>lst){
        for(int i=1;i<lst.size();i++){
            if(lst.get(i-1)>=lst.get(i)){
                return false;
            }
        }return true;
    }public boolean checkdec(List<Integer>lst){
        for(int i=1;i<lst.size();i++){
            if(lst.get(i-1)<=lst.get(i)){
                return false;
            }
        }return true;
    }
    public boolean isEvenOddTree(TreeNode root) {
         if(root==null  ||(root.left==null && root.right==null && root.val%2 !=0)){
            return true;
            
         }List<List<Integer>>lst=new ArrayList<>();
         Queue<TreeNode>q=new LinkedList<>();
         q.add(root);
         while(!q.isEmpty()){
            int k=q.size();
            List<Integer>sub=new ArrayList<>();
            for(int i=0;i<k;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);

                }if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }sub.add(q.poll().val);
            }lst.add(sub);
         }int i=0;
         for(List<Integer>list:lst){
            if(i%2==0){
                boolean x=checkodd(list);
                boolean y=checkinc(list);
                if (!(x && y)) return false;
            }else{
                boolean x=checkeven(list);
                boolean y=checkdec(list);
             if (!(x && y)) return false;
            }i++;
         }return true;
    }
}
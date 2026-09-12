
public class Codec {

    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode>q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("n ");
                continue;
            }sb.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);

        }return sb.toString();
    }

 
    public TreeNode deserialize(String data) {
         if(data=="") return null;
         Queue<TreeNode>q=new LinkedList<>();
         String []values=data.split(" ");
         TreeNode parent=new TreeNode(Integer.parseInt(values[0]));
         q.add(parent);
         for(int i=1;i<values.length;i++){
            TreeNode root=q.poll();

            if(!values[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                root.left=left;
                q.add(left);
            } if(!values[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                root.right=right;
                q.add(right);
            }
         }return parent;
    }
}


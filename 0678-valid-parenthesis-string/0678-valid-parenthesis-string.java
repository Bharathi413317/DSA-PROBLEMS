class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>ob=new Stack<>();
        Stack<Integer>sr=new Stack<>();
      
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                ob.push(i);
            }else if(ch=='*'){
                sr.push(i);
            }else{
                if(!ob.isEmpty()){
                    ob.pop();
                }else if(!sr.isEmpty()){
                    sr.pop();
                }else{
                    return false;
                }
            }
        }while(!ob.isEmpty()){
            if(sr.isEmpty()){
                return false;
            }
            if(sr.pop()<ob.pop()){
                    return false;
                }
            }
        
        return true;
        
    }
}
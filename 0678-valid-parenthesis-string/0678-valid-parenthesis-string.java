class Solution {
    public boolean checkValidString(String s) {
        int len=s.length();
        Stack<Integer> sr=new Stack<>();
        Stack<Integer> ob=new Stack<>();
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                ob.push(i);
            }
            else if(ch==')'){
                if(!ob.isEmpty()){
                    ob.pop();
                }
                else if(!sr.isEmpty()){
                    sr.pop();
                }
                else{
                    return false;
                }
            }
            else{  //ch=='*'
            sr.push(i);
            }
        }
        while(!ob.isEmpty()){
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
class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer>os=new Stack<>();
        Stack<Integer>zs=new Stack<>();
        if(s.length()%2!=0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                zs.push(i);
            }else if(s.charAt(i)=='('){
                os.push(i);
            }else{
                if(!os.isEmpty()){
                    os.pop();
                }else if(!zs.isEmpty()){
                    zs.pop();
                }else{
                    return false;
                }
            }
        }while(!os.isEmpty()){
            if(zs.isEmpty()){
                return false;
            }
            int open=os.pop();
            int zero=zs.pop();
            if(open>zero){
                return false;
            }

        }return true;
    }
}
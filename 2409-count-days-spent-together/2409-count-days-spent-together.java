// class Solution {
//     public int tointeger(String leaveAlice){
//          int a=(int)leaveAlice.charAt(0)-'0';
//         int b=(int)leaveAlice.charAt(1)-'0';
//         int c=(int)leaveAlice.charAt(3)-'0';
//         int d=(int)leaveAlice.charAt(4)-'0';
//         int k1=10*a+b;
//         int k2=10*c+d;
//         return k1*100+k2;
//     }
//     public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
//        int l=tointeger(leaveAlice);
//        int m=tointeger(arriveBob);
//        int a=tointeger(arriveAlice);
//        int b=tointeger(leaveBob);
//        if(m>l){
//         return 0;
//        }if(b<a){
//         return 0;
//        }
//        return l-m+1;
//     }
// }
class Solution {
    public int tointeger(String date) {
        int a = (int)date.charAt(0) - '0';
        int b = (int)date.charAt(1) - '0';
        int c = (int)date.charAt(3) - '0';
        int d = (int)date.charAt(4) - '0';

        int month = 10 * a + b;
        int day = 10 * c + d;

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        int sum = day;

        for(int i = 0; i < month - 1; i++) {
            sum += days[i];
        }

        return sum;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int a = tointeger(arriveAlice);
        int b = tointeger(arriveBob);
        int l = tointeger(leaveAlice);
        int m = tointeger(leaveBob);

        int start = Math.max(a, b);
        int end = Math.min(l, m);

        if(start > end) {
            return 0;
        }

        return end - start + 1;
    }
}
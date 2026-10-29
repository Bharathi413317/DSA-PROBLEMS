// class Solution {
//     public boolean canMakeSubsequence(String s, String t) {
//         int slen=s.length();
//         int tlen=t.length();
//         int i=0;
//         int j=0;
//         int count=0;
//         while(i<slen && j<tlen){
//             if(s.charAt(i)==t.charAt(j)){
//                 i++;
//                 j++;
//             }else{
                
//                 int k=j;
//                 while(j<tlen && s.charAt(i)!=t.charAt(j)){
//                     j++;

//                 }
//                 if(j<tlen){
//                     i++;
//                     j++;
                 
//                 }else if(count==0){
//                i++;
//                j=k+1;
//                count+=1;
               
//             }else{
//                 return false;
//             }
//         }
//     }
//         return i==slen;
//     }

// }

class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        if (n > m) return false;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Earliest position in t matching s[0...i]
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            prefix[i] = j;
            if (j < m) j++;
        }

        // Latest position in t matching s[i...n-1]
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && s.charAt(i) != t.charAt(j)) {
                j--;
            }
            suffix[i] = j;
            if (j >= 0) j--;
        }

        // Try replacing each character of s
        for (int i = 0; i < n; i++) {
            int left = (i == 0) ? -1 : prefix[i - 1];
            int right = (i == n - 1) ? m : suffix[i + 1];

            if (left + 1 < right) {
                return true;
            }
        }

        return false;
    }
}

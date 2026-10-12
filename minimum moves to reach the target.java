class Solution {
    public int minMoves(int target, int maxDoubles) {
        int count=0;
       
        while (target > 1) {
    if (target % 2 == 1) {
        target--;
        count++;
    } else if (maxDoubles > 0) {
        target /= 2;
        maxDoubles--;
        count++;
    } else {
        count += target - 1;
        break;
    }
}return count;
    }
}

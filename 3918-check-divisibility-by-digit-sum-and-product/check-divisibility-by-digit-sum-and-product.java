class Solution {
    public boolean checkDivisibility(int n) {
        int i = n;
        int k = 0 , j = 1;
        while(i > 0) {
            k += i % 10;
            j *= i % 10;
            i /= 10;
        }
        if(n % (j + k) == 0) return true;
        return false;
    }
}
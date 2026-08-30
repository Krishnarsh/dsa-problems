class Solution {
    public int minimumDeletions(int[] nums) {
        int l = Integer.MIN_VALUE;
        int s = Integer.MAX_VALUE;
        int li = 0, si = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > l) {l = nums[i]; li = i;}
            if(nums[i] < s) {s = nums[i]; si = i;}
        }
        int le = nums.length-li;
        int se = nums.length-si;
        if(li > si) {
            int ans = Math.min(li+1 , se);
            return Math.min(ans , si+le+1);
        }
        else {
            int ans = Math.min(si+1 , le);
            return Math.min(ans , li+se+1);
        }
    }
}
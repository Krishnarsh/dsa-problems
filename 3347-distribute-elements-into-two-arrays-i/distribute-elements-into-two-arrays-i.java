class Solution {
    public int[] resultArray(int[] nums) {
        int [] arr = new int [nums.length];
        arr[0] = nums[1];
        int j = 0;
        int k = 0;
        for(int i = 2 ; i < nums.length ; i++) {
            if(nums[j] > arr[k]){nums[++j] = nums[i];}
            else{arr[++k] = nums[i];}
        }
        for(int i = 0 ; j < nums.length && i <= k ; i++) {
            nums[++j] = arr[i];
        }
        return nums;
    }
}
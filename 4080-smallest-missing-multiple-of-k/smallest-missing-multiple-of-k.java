class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> s = new HashSet<>();
        for(int i : nums){
            if(i % k == 0){s.add(i);}
        }
        for(int i = 1 ; i < 102 ; i++){
            if(!s.contains(k * i)){return i * k ;}
        }
        return 0;
    }
}
class Solution {
    public int minDeletions(String s) {
        int count = 0;
        int [] arr = new int [26];
        HashSet<Integer> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++) {
            if(arr[i] == 0) {continue;}
            if(set.contains(arr[i])) {
                while(arr[i] > 0 && set.contains(arr[i])){arr[i]--;count++;}
            }
            if(arr[i] > 0) set.add(arr[i]);
        }
        
        return count;
    }
}
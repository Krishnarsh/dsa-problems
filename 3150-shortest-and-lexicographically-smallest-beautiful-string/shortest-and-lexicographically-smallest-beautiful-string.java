class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
       StringBuilder s1 = new StringBuilder();
       StringBuilder s2 = new StringBuilder(s + "X");
       int count = 0;
       int i = 0 , j = 0;
       for(i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '1') {
                count++;
                s1.append(s.charAt(i));
                for(j = i+1 ; j < s.length() && count != k ; j++) {
                    if(s.charAt(j) == '1') {
                        count++;
                    }
                    s1.append(s.charAt(j));
                }
                if(count == k) {
                    count = 0;
                    if(s1.length() < s2.length()) {
                        s2.setLength(0);
                        s2.append(s1);
                    }
                    else if(s1.length() == s2.length()) {
                        if (s1.compareTo(s2) < 0) {
                            s2.setLength(0);
                            s2.append(s1);
                        }
                    } 
                }
            }
            count = 0;
            s1.setLength(0);
       }
       return s2.toString().endsWith("X") ? "" : s2.toString();
    }
}
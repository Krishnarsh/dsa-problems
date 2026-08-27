// class Solution {
//     public String lexGreaterPermutation(String s, String target) {
//         int j = 0 , count = 0 , track = 0 , ind = 0;
//         int n = s.length();
//         char [] chars = s.toCharArray();
//         Arrays.sort(chars);
//         StringBuilder sb = new StringBuilder();
//         StringBuilder s1 = new StringBuilder();
//         StringBuilder s2 = new StringBuilder();
//         sb.append(chars);
//         s2.append(chars);
//         Arrays.fill(chars, '0');
//         if(sb.charAt(n-1) < target.charAt(0)) {return "";}

//         for(int i = 0 ; i < sb.length() ; i++) {
//             if(sb.charAt(i) > target.charAt(j)) {
//                 s1.append(sb.charAt(i));
//                 sb.deleteCharAt(i);
//                 s1.append(sb);
//                 return s1.toString();
//             }
//             else if(sb.charAt(i) == target.charAt(j)) {
//                 if(chars[i] == '1'){continue;}
//                 s1.append(sb.charAt(i));
//                 sb.deleteCharAt(i);
//                 j++;
//                 count = 0;
//                 track++;
//                 if(track == 1) {ind = i;}
//                 i = -1;
//             }
//             if(i == sb.length()-1 && count >= sb.length()) {
//                 sb.setLength(0);
//                 sb.append(s2);
//                 s1.setLength(0); 
//                 i = ind;
//                 chars[ind] = '1';
//                 j = 0;
//                 track = 0;
//                 count = 0;
//             }
//             count++;
//         }
//         return "";
//     }
// }
class Solution {
    public String lexGreaterPermutation(String s, String target) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int n = s.length();

        // Try every possible position from right to left
        // where we can make target[pos] bigger.
        for (int pos = n - 1; pos >= 0; pos--) {

            StringBuilder prefix = new StringBuilder();
            StringBuilder remaining = new StringBuilder();

            // Put target[0 ... pos-1] into the prefix.
            // We must be able to form this prefix from s.
            remaining.append(chars);

            boolean possible = true;

            for (int i = 0; i < pos; i++) {

                int index = remaining.indexOf(
                    String.valueOf(target.charAt(i))
                );

                if (index == -1) {
                    possible = false;
                    break;
                }

                prefix.append(target.charAt(i));
                remaining.deleteCharAt(index);
            }

            if (!possible) {
                continue;
            }

            // At position 'pos', find the smallest
            // character greater than target[pos].
            for (int i = 0; i < remaining.length(); i++) {

                if (remaining.charAt(i) > target.charAt(pos)) {

                    prefix.append(remaining.charAt(i));
                    remaining.deleteCharAt(i);

                    // Remaining characters are already sorted.
                    prefix.append(remaining);

                    return prefix.toString();
                }
            }
        }

        return "";
    }
}


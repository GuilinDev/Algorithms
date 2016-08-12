public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) {
            return "";
        }
        
    // 1) Start from first String, to compare all the other strings
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if (j == 0) {
                // quick return
                return "";
            }
            // every iteration should replace prefix with the new value
            prefix = prefix.substring(0, j);
        }
        return prefix;
        
    // 2) Start from first char for all Strings, then the second char
        // if (strs[0] == null || strs[0].length() == 0) {
        //     return "";
        // }
        // String prefix = strs[0];
        
        // for (int i = 0; i < strs[0].length(); i++) {// the index of strs[0]
        //     int p = 0;
        //     while (p < strs[0].length() && p < strs[p].length() && strs[0].charAt(p) == strs[p].charAt(p)) {
        //         p++;
        //     }
        //     if (p==0) {
        //         return "";
        //     }    
        //     prefix = prefix.substring(0, p);
        // }
        // return prefix;
    }
}
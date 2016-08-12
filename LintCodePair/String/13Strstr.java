class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        } else if (target.length() == 0){
            return 0;
        }
        for (int i = 0; i < source.length()-target.length()+1; i++){
            int j = 0;
            // compare source string from i+j postion to target string from beginning
            for (j = 0; j < target.length(); j++){
                if(source.charAt(i+j) != target.charAt(j)){
                    break;
                }
            // to check whether j is same as the length of target string
                if (j == target.length() - 1) {
                    return i; // index in string source
                }
            }
        }
        
        return -1;
    }
}
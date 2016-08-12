public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        //store biggest substring length
        int lenA = A.length();
        int lenB = B.length();
        int maxSubLen = 0;
        
        for (int i = 0; i < lenA; i++){
            for (int j = 0; j < lenB; j++) {
                int tempLen = 0;
                while (i+tempLen < lenA && j+tempLen < lenB && A.charAt(i+tempLen) == B.charAt(j+tempLen)){
                    tempLen++;
                    if (tempLen > maxSubLen){
                        maxSubLen = tempLen;
                    }
                }
                
            }
        }
        return maxSubLen;
    }
}
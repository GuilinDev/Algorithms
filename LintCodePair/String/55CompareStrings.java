public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // 1) get each character of String B
        // 2) check by index where this character is in A
        // 3) if yes, delete the character; if no, return false
        
        if ((A.length() == 0 && B.length() != 0) || A.length() < B.length()){
            return false;
        }
        if (A.length() == 0 && B.length() == 0){
            return true;
        }
        
        StringBuilder sb = new StringBuilder(A);
        char[] charArray = B.toCharArray();
        
        for (Character ch : charArray){
            int index = String.valueOf(sb).indexOf(ch);
            
            if (index == -1){
                return false;
            }
            
            sb.delete(index, index + 1);
        }
        return true;
    }
}

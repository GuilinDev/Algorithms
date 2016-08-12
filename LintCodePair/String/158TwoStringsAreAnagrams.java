public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        //take each character in one String, compare to another String, if contains, delete that character
        //Otherwise, return false
        
        if (s.length() != t.length()){
            return false;
        }
      
        StringBuilder sb = new StringBuilder(s);
        char[] charArray = t.toLowerCase().toCharArray();
        
        for (Character ch : charArray){
            int index = String.valueOf(sb).toLowerCase().indexOf(ch);
            
            if (index == -1){
                return false;
            }
            sb.delete(index, index + 1);
        }
        
        return true;
    }
};
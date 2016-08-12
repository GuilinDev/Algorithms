public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // 1) traverse the given string array 
        // 2) compare first element to second, third .. last, to check whether are anagrams
        // 3) if yes, put target and matched one into result; 
        //    move the matched one, continue checking; after the traverse, move the target 
        // 4) if no, continue checking; after the traverse, delete the target
        //ArrayList<String> results = new ArrayList<String>();
        //String temp;
        //Boolean isTarget;

        //if (strs.length < 2){
        //    return results;
        //}
        
        //for (int i = 0; i < strs.length - 1; i++){
         //   temp = strs[i]; // read elements one by one
          //  isTarget = false;
            // traverse all remaining elements
          //  for (int j = i + 1; j <= strs.length - 1; j++){   
            //    if (checkAnagrams(strs[i],strs[j])){ //compare two string elements
          //          isTarget = true;
          //          results.add(strs[j]);
          //          strs.remove(j);
           //     }
           // }
          //  if (isTarget){
         //       results.add(temp);
           // }
       // }
       // return results;
       
	   
	   /* 
		Nine Chapter's Solution
	   */
       ArrayList<String> result = new ArrayList<String>();
       
       // Create a hashmap to store the string arraylist and its occurance
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }

        return result;
    }
    
    private int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }
    
    //private static boolean checkAnagrams(String s, String t){
    //    if (s.length() != t.length()){
   //         return false;
    //    }
        
    //    StringBuilder sb = new StringBuilder(s);
    //    char[] charArray = t.toCharArray();
        
    //    for (Character ch : charArray){
    //        int index = String.valueOf(sb).indexOf(ch);
    //        if (index == -1){
    //            return false;
     //       }
    //    }
    //    return true;
   // }
        
}

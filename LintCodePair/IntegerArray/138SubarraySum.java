public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> answer = new ArrayList<Integer>(); // store return answer
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int sum = 0; //mark sum of elements is 0
        
        map.put(0, -1); // default there is not elements which sum is 0
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            
            if (map.containsKey(sum)) { // similar to 2 sum
                answer.add(map.get(sum) + 1);// sum is key, index is value
                answer.add(i);
                return answer;
            }
            map.put(sum, i);
        }
        return answer;
    }
}
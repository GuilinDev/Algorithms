public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int size = 0; // start from first index
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {// if nexe element is not same, varialbe "size" will not ++
                nums[++size] = nums[i]; // array nums will not change the size
            }
        }
        return size + 1;
    }
}
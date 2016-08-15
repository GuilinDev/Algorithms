public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int tailPointer = A.length - 1; // to record how many time of elements in A == ele
        int headPointer = 0; 
        
        while (headPointer <= tailPointer) {// "=" in case it is odd elements
            if (A[headPointer] == elem) {
                A[headPointer] = A[tailPointer]; // the current element should be changed to check whether it is equal or not equal 
                tailPointer--;
            } else {
                headPointer++;
            }
        }
        return tailPointer + 1; // because it will return the length
    }
}
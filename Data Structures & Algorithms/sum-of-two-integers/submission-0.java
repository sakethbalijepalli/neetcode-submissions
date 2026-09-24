class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
        int partialSum = a ^ b;  // XOR handles the addition digits
        int carry = (a & b) << 1; // AND handles the carries, shifted left
        
        a = partialSum;          // New 'a' is the sum
        b = carry;                // New 'b' is the carry to add next loop
        }
        return a;
    }
}

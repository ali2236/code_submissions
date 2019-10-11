import java.util.BitSet;

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 3, 7, 8};
        int[] nums2 = {1, 2, 3, 5};
        BitSet bitSet = new BitSet(nums2.length + 1);
        for(int num : nums2){
            bitSet.set(num - 1);
        }
        System.out.println(bitSet.nextClearBit(0) - 1);
    }
}

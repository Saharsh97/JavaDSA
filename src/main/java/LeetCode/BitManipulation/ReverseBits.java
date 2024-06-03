//package LeetCode.BitManipulation;
//
//public class ReverseBits {
//    public int reverseBits(int n) {
//        int result = 0;
//        int position = 1;
//        int idx = 0;
//        while(idx < 32){
//            int bit = n & position;
//            if(bit == 0){
//                result = result | position;
//            }
//            position = position << 1;
//            idx++;
//        }
//        return result;
//    }
//}

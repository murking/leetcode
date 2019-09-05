package leetcode;

public class p410 {
        public static void main(String[] args) {
            Solution s = new Solution();
            int[] a = {7,2,5,10,8};
            System.out.println(s.splitArray(a, 2));
        }
    }
    class Solution {
        public int splitArray(int[] nums, int m) {
            long left = 0,right = 0;
            for (int n:nums){
                right+=n;
            }
            if (m==1){
                return (int)right;
            }
            long result = 0;
            long mid;
            while (left<right){
                mid = left+right >> 1;
                if (judge((int)mid, nums, m)) {
                    right = mid;
                }
                else
                    left = mid+1;
            }
            return (int)right;
        }
        private boolean judge(int mid,int[] nums,int m){
            int sums = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>mid)
                    return false;
                if(sums+nums[i]>mid){
                    m--;
                    sums=nums[i];
                }else {
                    sums += nums[i];
                }
            }
            return m>=1;
        }
}

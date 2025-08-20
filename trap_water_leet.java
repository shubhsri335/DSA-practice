//brute force
class Solution {
    public int[] prefix(int[] height) {
        int[] leftMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        return leftMax;
    }

    public int[] suffix(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];

        rightMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        return rightMax;
    }

    public int trap(int[] height) {
        int[] leftMax = prefix(height);
        int[] rightMax = suffix(height);

        int water = 0;
        for(int i = 0; i < height.length; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
//two pointer solution
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0, leftMax = height[0], rightMax = height[n - 1];
        int left = 0, right = n - 1;

        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(height[left] <= height[right]) {
                water += Math.min(leftMax, rightMax) - height[left];
                left++;
            }
            else {
                water += Math.min(leftMax, rightMax) - height[right];
                right--;
            }
        }
        return water;
    }
}

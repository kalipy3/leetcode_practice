//官方题解
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}

//kalipy一次过 送分题
class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int ans = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
                l++;
            } else {
                ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
                r--;
            }
        }

        return ans;
    }
}

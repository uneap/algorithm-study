//물을 담을 수 있는 용기가 가장 큰 걸 구해야 하므로, 작은 값이면 움직이는 투포인터
class Solution {
    public int maxArea(int[] height) {
        int left = 0; int right = height.length - 1;
        int answer = 0;
        while(left < right) {
            answer = Math.max(answer, Math.min(height[left], height[right]) * (right - left));
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return answer;
    }
}
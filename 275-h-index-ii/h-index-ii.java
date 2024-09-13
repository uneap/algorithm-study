// 1부터 가장 마지막 인덱스 값까지 이진 탐색 수행
// length - 현재 가리키는 값을 인덱스로 그 값이 현재 가리키는 값과 같거나 크면 left = mid + 1
// 아니면 right = mid - 1
class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 1; int right = citations[length - 1];
        int answer = 0;
        while(left < right) {
            int mid = (left + right) / 2;
            if(length - mid >= 0 && citations[length - mid] >= mid) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(answer, length - left >= 0 && citations[length - left] >= left ? left : answer);
    }
}
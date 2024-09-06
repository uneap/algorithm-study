// 중앙 값과 비교해서 정렬해야 함.
// 중앙값 구함
// 중앙 값에서 가까운 값을 기준으로 짝수 인덱스일 경우 뒤에서 앞으로 채워야 함
// 홀수 인덱스는 앞에서 뒤로 채워야 함
// 짝수 인덱스는 현재 채워지고 있는 인덱스를 넘어간 경우, 현 인덱스가 홀수일 때만 swap, 아닐 땐 이미 채워진 거니까 패스
// 홀은 그 반대
class Solution {
    public void wiggleSort(int[] nums) {
        int currentIndex = 0;
        int oddIndex = 1;
        int evenIndex = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        quickSelection(nums, 0, nums.length - 1, (nums.length - 1)/2);
        int mid = nums[(nums.length - 1)/2]; 
        while(currentIndex < nums.length) {
            if(mid > nums[currentIndex] && ( evenIndex > currentIndex || currentIndex > evenIndex && currentIndex % 2 != 0)) {
                swap(nums, currentIndex, evenIndex);
                evenIndex -= 2;
            }
            else if(mid < nums[currentIndex] && ( oddIndex < currentIndex || currentIndex < oddIndex && currentIndex % 2 == 0)) {
                swap(nums, currentIndex, oddIndex);
                oddIndex += 2;
            }
            else {
                currentIndex++;
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        if(j >= nums.length) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void quickSelection(int[] nums, int low, int high, int kthIndex) {
        int partitionIndex = partition(nums, low, high);
        if(kthIndex == partitionIndex) {
            return;
        }
        if(kthIndex < partitionIndex) {
            quickSelection(nums, low, partitionIndex - 1, kthIndex);
        } else {
            quickSelection(nums, partitionIndex + 1, high, kthIndex);
        }
        
    }
    public int partition(int[] nums, int low, int high) {
        int start = low;
        int pivot = nums[high];
        for(int i = low; i <= high; i++) {
            if(nums[i] < pivot) {
                swap(nums,i, start);
                start++;
            }
        }
        int temp = nums[start];
        nums[start] = pivot;
        nums[high] = temp;
        return start;
    }
}
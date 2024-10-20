// 숫자 별로 마지막 인덱스 저장
// 0부터 순회하면서 9부터 현재 순회하는 값 전까지 체크했을 때 인덱스가 더 작은 경우 swap
// 아니면 패스
class Solution {
    public int maximumSwap(int num) {
        if(num < 10) {
            return num;
        }
        char[] numbers = Integer.toString(num).toCharArray();
        int[] indexes = new int[10];
        for(int i = 0; i < numbers.length; i++) {
            indexes[numbers[i] - '0'] = i;
        }
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 9; j > numbers[i] - '0'; j--) {
                if(indexes[j] > i) {
                    swap(i,indexes[j], numbers);
                    return Integer.parseInt(new String(numbers));
                }
            }
        }
        return Integer.parseInt(new String(numbers));
    }
    public void swap(int i, int j, char[] numbers) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
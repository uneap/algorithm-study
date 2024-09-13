class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0; int right = matrix[0].length * matrix.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (left / matrix[0].length) >= 0 && (right % matrix[0].length) >= 0 
            && matrix[left/matrix[0].length][right%matrix[0].length] == target;
    }
}
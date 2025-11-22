class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1, row = matrix.length;

        while (i < row && j >= 0) {
            if (matrix[i][j] > target)
                j--;

            else if (matrix[i][j] == target)
                return true;

            else
                i++;
        }
        return false;
    }
}

class Solution {

    static boolean binarySearch(int[] arr, int target){
        int beg = 0, end = arr.length - 1;

        while(beg <= end){
            int mid  = beg + (end - beg) / 2;

            if(arr[mid] < target)
                beg = mid + 1;
            
            else if (target == arr[mid])
                return true;
            
            else
                end = mid - 1;
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length - 1;

        if(row == 1)
            return binarySearch(matrix[0], target);
        
        int initRow = 0, lastRow = row - 1;

        while(initRow < lastRow){
            int mid = initRow + (lastRow - initRow) / 2;

            if(matrix[mid][col] < target)
                initRow = mid + 1;
            
            else if(matrix[mid][col] == target)
                return true;
            
            else
                lastRow = mid;
        }

        return binarySearch(matrix[initRow], target);
    }
}

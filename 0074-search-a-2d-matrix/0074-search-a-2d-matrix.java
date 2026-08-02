class Solution {
    public boolean searchMatrix(int[][] arr, int target){
        int n = arr.length , m = arr[0].length;
        int st = 0, end = n*m-1;
        while(st <= end){
            int mid = st + (end-st)/2;
            int midelmt = arr[mid/m][mid%m];
            if (midelmt == target) return true;
            if (midelmt > target){
                end = mid -1;
            }
            else{
                st = mid +1;
            }
        }
        return false;
    }
}
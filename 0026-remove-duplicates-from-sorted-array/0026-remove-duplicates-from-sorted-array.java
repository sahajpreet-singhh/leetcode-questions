class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0 , j = 1 ;
        while(j < arr.length){
            if(arr[i] == arr[j]){
                j++;
            }
            else{
                arr[++i] = arr[j];
                j++;
            }
        }
        return i+1;
    }
}
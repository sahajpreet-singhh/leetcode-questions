int maxArea(int* height, int heightSize) {
    int left = 0;
    int right = heightSize -1;
    int area = 0;
    int h = 0 , max = 0, width = 0;
    while (left < right){
        if (height[left] < height[right]){
            h = height[left];
        }
        else{
            h = height[right];
        }
        width = right - left;
        max = h * width;
        if (max > area){
            area = max;
        }
        if (height[left] < height[right]){
            left++;
        }
        else right--;


    } return area;
}
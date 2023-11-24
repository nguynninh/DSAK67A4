package homework7.practice1;

class Solution {
    public static int isRepresentingBST(int arr[], int N) {
        // code here
        for (int i = 1; i < N; i++)
            if (arr[i] <= arr[i - 1])
                return 0;
        return 1;
    }
}
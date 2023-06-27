class reverse_pairs{

    // similar to count inversion
    // implemented merge sort
    public int reversePairs(int[] nums) {
        
        int N=nums.length;
        return mergeSortAndCount(nums, new int[N], 0, N - 1);
    }

    public int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }

        return count;
    }

    public int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int count = 0;

        while (i <= mid && j <= right) {
            if ((long) arr[i] > 2 * (long) arr[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        merge(arr, temp, left, mid, right);

        return count;
    }

    public void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
}

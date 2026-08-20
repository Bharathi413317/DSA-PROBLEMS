class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        // First operation
        arr1.add(nums[0]);

        // Second operation
        arr2.add(nums[1]);

        // Remaining elements
        for (int i = 2; i < n; i++) {

            if (arr1.get(arr1.size() - 1) >
                arr2.get(arr2.size() - 1)) {

                arr1.add(nums[i]);

            } else {

                arr2.add(nums[i]);
            }
        }

        // Combine arr1 and arr2
        int[] arr = new int[n];
        int k = 0;

        for (int i = 0; i < arr1.size(); i++) {
            arr[k++] = arr1.get(i);
        }

        for (int i = 0; i < arr2.size(); i++) {
            arr[k++] = arr2.get(i);
        }

        return arr;
    }
}
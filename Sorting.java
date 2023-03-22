public class Sorting {

    public Sorting () {

    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; ++i)
        {
            for (int index = 0; index < 5; ++index)
            {
                System.out.print(arr[index] + "\t");
            }
            System.out.println();
        }
        
    }

    // Bubble Sort Algorithm.
    public static void bubbleSort(String[] arr) {
        bubbleSort(arr, arr.length);
    }

    public static void reverseBubbleSort(String[] arr) {
        reverseBubbleSort(arr, arr.length);
    }

    private static void bubbleSort(String[] arr, int n) {

        for (int i = 0; i < n - 1; ++i)
        {
            for (int j = 0; j < n - i - 1; ++j)
            {
                if (arr[j + 1].compareTo(arr[j]) < 0)
                {
                    String temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    private static void reverseBubbleSort(String[] arr, int n) {

        for (int i = 0; i < n - 1; ++i)
        {
            for (int j = 0; j < n - i - 1; ++j)
            {
                if (arr[j + 1].compareTo(arr[j]) > 0)
                {
                    String temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Selection Sort.
    public static void selectionSort(String[] arr) {
        selectionSort(arr, arr.length);
    }

    public static void reverseSelectionSort(String[] arr) {
        reverseSelectionSort(arr, arr.length);
    }

    private static void selectionSort(String[] arr, int n) {

        for (int i = 0; i < n - 1; ++i)
        {
            int small = i;
            for (int j = i + 1; j < n; ++j)
            {
                if (arr[j].compareTo(arr[small]) < 0)
                {
                    small = j;
                }
            }

            String temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
    }

    private static void reverseSelectionSort(String[] arr, int n) {

        for (int i = 0; i < n - 1; ++i)
        {
            int small = i;
            for (int j = i + 1; j < n; ++j)
            {
                if (arr[j].compareTo(arr[small]) > 0)
                {
                    small = j;
                }
            }

            String temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
    }

    // Insertion Sort.
    public static void insertionSort(String[] arr) {
        insertionSort(arr, arr.length);
    }

    public static void reverseInsertionSort(String[] arr) {
        reverseInsertionSort(arr, arr.length);
    }

    private static void insertionSort(String[] arr, int n) {

        for (int i = 1; i < n; ++i)
        {
            String temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(temp) > 0)
            {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = temp;
        }
    }

    private static void reverseInsertionSort(String[] arr, int n) {

        for (int i = 1; i < n; ++i)
        {
            String temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(temp) < 0)
            {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = temp;
        }
    }

    // Quick Sort Algorithm.
    public static void quickSort(String[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void reverseQuickSort(String[] arr) {
        reverseQuickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(String[] arr, int start, int end) {
        if (end <= start) return;

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(String[] arr, int start, int end) {
        String pivot = arr[start + (end - start) / 2];
        int i = start-1;
        int j = end+1;

        while(true)
        {
            while (arr[++i].compareTo(pivot) < 0);
            while (arr[--j].compareTo(pivot) > 0);

            if(i >= j)
                return j;

            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void reverseQuickSort(String[] arr, int start, int end) {
        if (end <= start) return;

        int pivot = partitionReverse(arr, start, end);
        reverseQuickSort(arr, start, pivot);
        reverseQuickSort(arr, pivot + 1, end);
    }

    private static int partitionReverse(String[] arr, int start, int end) {
        String pivot = arr[start + (end - start) / 2];
        int i = start - 1;
        int j = end + 1;

        while(true)
        {
            while (arr[++i].compareTo(pivot) > 0);
            while (arr[--j].compareTo(pivot) < 0);

            if(i >= j)
                return j;

            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Merge Sort Algorithm
    public static void mergeSort(String[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void reverseMergeSort(String[] arr) {
        reverseMergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(String[] arr, int left, int right) {
    
        if (right <= left) return; // base case
        
        int middle = left + (right - left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }
    
    private static void merge(String[] arr, int left, int middle, int right) {
        String[] temp = new String[right - left + 1];
    
        int i = left, j = middle + 1, k = 0;
    
        while (i <= middle && j <= right)
        {
            if (arr[i].compareTo(arr[j]) < 0)
            {
                temp[k] = arr[i];
                ++i;
            } 
            else
            {
                temp[k] = arr[j];
                ++j;
            }
    
            ++k;
        }
    
        while (i <= middle)
        {
            temp[k] = arr[i];
            ++i;
            ++k;
        }
    
        while (j <= right)
        {
            temp[k] = arr[j];
            ++j;
            ++k;
        }
    
        for (int l = 0; l < temp.length; ++l)
        {
            arr[left + l] = temp[l];
        }
    }

    private static void reverseMergeSort(String[] arr, int left, int right) {
    
        if (right <= left) return; // base case
        
        int middle = left + (right - left) / 2;
        reverseMergeSort(arr, left, middle);
        reverseMergeSort(arr, middle + 1, right);
        mergeReverse(arr, left, middle, right);
    }
    
    private static void mergeReverse(String[] arr, int left, int middle, int right) {
        String[] temp = new String[right - left + 1];
    
        int i = left, j = middle + 1, k = 0;
    
        while (i <= middle && j <= right)
        {
            if (arr[i].compareTo(arr[j]) > 0)
            {
                temp[k] = arr[i];
                ++i;
            } 
            else
            {
                temp[k] = arr[j];
                ++j;
            }
    
            ++k;
        }
    
        while (i <= middle)
        {
            temp[k] = arr[i];
            ++i;
            ++k;
        }
    
        while (j <= right)
        {
            temp[k] = arr[j];
            ++j;
            ++k;
        }
    
        for (int l = 0; l < temp.length; ++l)
        {
            arr[left + l] = temp[l];
        }
    }

    // Pancake Sort
    public static void pancakeSort(String[] arr) {
        pancakeSort(arr, arr.length - 1);
    }

    public static void reversePancakeSort(String[] arr) {
        reversePancakeSort(arr, arr.length - 1);
    }

    private static void pancakeSort(String[] arr, int i) {

        for (; i > 0; --i)
        {
            int maxIndex = getMaxIndex(arr, i);

            if (maxIndex != i) // avoids unnecessary method calls by fliping twice from the same starting and ending positions...
            {
                flip(arr, maxIndex); // flips elements from index 0 to the index of the max element
                flip(arr, i); // moves element at 0 (where max element is now) to the very last element before i updates and flips everything else in its path
            }
        }
    }
    
    private static int getMaxIndex(String[] arr, int right) {
        int maxIndex = 0;

        // finds biggest value at an index
        for (int i = 1; i <= right; ++i)
        {
            if (arr[i].compareTo(arr[maxIndex]) > 0)
                maxIndex = i;
        }

        return maxIndex;
    }
    
    private static void flip(String[] arr, int endToStart) {
        int startToEnd = 0;

        // reverses array from index 0 to the end point provided...
        while (startToEnd < endToStart)
        {
            String temp = arr[startToEnd];
            arr[startToEnd] = arr[endToStart];
            arr[endToStart] = temp;

            ++startToEnd; --endToStart; // updates variables to keep reversing...
        }
    }

    private static void reversePancakeSort(String[] arr, int i) {

        for (; i > 0; --i)
        {
            int minIndex = getMinIndexInReverse(arr, i);

            if (minIndex != i) // avoids unnecessary method calls by fliping twice from the same starting and ending positions...
            {
                flipReverse(arr, minIndex); // flips elements from index 0 to the index of the min element
                flipReverse(arr, i); // moves element at 0 (where min element is now) to the very last element before i updates and flips everything else in its path
            }
        }
    }
    
    private static int getMinIndexInReverse(String[] arr, int right) {
        int minIndex = 0;

        // finds smallest value at an index
        for (int i = 1; i <= right; ++i)
        {
            if (arr[i].compareTo(arr[minIndex]) < 0)
                minIndex = i;
        }

        return minIndex;
    }
    
    private static void flipReverse(String[] arr, int endToStart) {
        int startToEnd = 0;

        // reverses array from index 0 to the end point provided...
        while (startToEnd < endToStart)
        {
            String temp = arr[startToEnd];
            arr[startToEnd] = arr[endToStart];
            arr[endToStart] = temp;

            ++startToEnd; --endToStart; // updates variables to keep reversing...
        }
    }


}

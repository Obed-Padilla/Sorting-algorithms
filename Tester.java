import java.io.IOException;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;

/*
 * tests algorithms performance in nanoseconds to sort an array of Strings (values are derived from the file "dictionary.txt")
 * 
 * variables that calculate their time are numbered as follows:
 *  - by number of algorithm (algorithms numbered as bubble sort being 1, selection sort being 2....)
 *  - and by number of test case (unsorted array being 1, already sorted being 2, and sorted to reversed being 3)
 * 
 * Example: timeLapsed11 means Bubble Sort is being tested with an unsorted array...
 */
public class Tester {
    public static void main(String[] args) throws IOException {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US); // formats the amount of nanoseconds displayed

        List<String> words = Files.readAllLines(Paths.get("dictionary.txt"), StandardCharsets.UTF_8); // reads txt file and stores it in an array list
  
        String[] transformed = words.toArray(new String[words.size()]); // transforms array list into a String array...
        String[] wordsToSort = transformed.clone(); // makes a copy to safely change it in the future...

        // Warm-up Phase (triggers the JVM optimizations)......
        for (int i = 0; i < 550; i++)
        {
                List<String> getSmaller = Files.readAllLines(Paths.get("64139Words.txt"), StandardCharsets.UTF_8);
                String[] warmupArray = getSmaller.toArray(new String[getSmaller.size()]);
                Sorting.bubbleSort(warmupArray);
                warmupArray = getSmaller.toArray(new String[getSmaller.size()]);
                Sorting.selectionSort(warmupArray);
                warmupArray = getSmaller.toArray(new String[getSmaller.size()]);
                Sorting.insertionSort(warmupArray);
                warmupArray = getSmaller.toArray(new String[getSmaller.size()]);
                Sorting.quickSort(warmupArray);
                warmupArray = getSmaller.toArray(new String[getSmaller.size()]);
                Sorting.mergeSort(warmupArray);
                warmupArray = getSmaller.toArray(new String[getSmaller.size()]);
                Sorting.pancakeSort(warmupArray);
        }
// ---------------------------------------------------------------------------------------------------------




        // Testing Sorting algorithms......
// ----------------- (1) Bubble Sort -----------------------------
        // Unsorted
        long startTime11 = System.nanoTime();
        Sorting.bubbleSort(wordsToSort);
        long endTime11 = System.nanoTime();
        long timeLapsed11 = endTime11 - startTime11;
        // Already sorted
        long startTime12 = System.nanoTime();
        Sorting.bubbleSort(wordsToSort);
        long endTime12 = System.nanoTime();
        long timeLapsed12 = endTime12 - startTime12;
        // Sorted to reversed
        long startTime13 = System.nanoTime();
        Sorting.reverseBubbleSort(wordsToSort);
        long endTime13 = System.nanoTime();
        long timeLapsed13 = endTime13 - startTime13;
        // formats time with commas
        String formated11 = formatter.format(timeLapsed11); // Time taken for Bubble Sort formated (unsorted values)
        String formated12 = formatter.format(timeLapsed12); // Time taken for Bubble Sort formated (already sorted values)
        String formated13 = formatter.format(timeLapsed13); // Time taken for Bubble Sort formated (sorted to reversed values)
// ----------------- (2) Selection Sort -----------------------------
        // Unsorted
        wordsToSort = transformed.clone();
        long startTime21 = System.nanoTime();
        Sorting.selectionSort(wordsToSort);
        long endTime21 = System.nanoTime();
        long timeLapsed21 = endTime21 - startTime21;
        // Already Sorted
        long startTime22 = System.nanoTime();
        Sorting.selectionSort(wordsToSort);
        long endTime22 = System.nanoTime();
        long timeLapsed22 = endTime22 - startTime22;
        // Sorted to reversed
        long startTime23 = System.nanoTime();
        Sorting.reverseSelectionSort(wordsToSort);
        long endTime23 = System.nanoTime();
        long timeLapsed23 = endTime23 - startTime23;
        // formats time with commas
        String formated21 = formatter.format(timeLapsed21); // Time taken for Selection Sort formated (unsorted values)
        String formated22 = formatter.format(timeLapsed22); // Time taken for Selection Sort formated (already sorted values)
        String formated23 = formatter.format(timeLapsed23); // Time taken for Selection Sort formated (sorted to reversed values)
// ----------------- (3) Insertion Sort -----------------------------
        // Unsorted
        wordsToSort = transformed.clone();
        long startTime31 = System.nanoTime();
        Sorting.insertionSort(wordsToSort);
        long endTime31 = System.nanoTime();
        long timeLapsed31 = endTime31 - startTime31;
        // Already Sorted
        long startTime32 = System.nanoTime();
        Sorting.insertionSort(wordsToSort);
        long endTime32 = System.nanoTime();
        long timeLapsed32 = endTime32 - startTime32;
        // Sorted to reversed
        long startTime33 = System.nanoTime();
        Sorting.reverseInsertionSort(wordsToSort);
        long endTime33 = System.nanoTime();
        long timeLapsed33 = endTime33 - startTime33;
        // formats time with commas
        String formated31 = formatter.format(timeLapsed31); // Time taken for Insertion Sort formated (unsorted values)
        String formated32 = formatter.format(timeLapsed32); // Time taken for Insertion Sort formated (already sorted values)
        String formated33 = formatter.format(timeLapsed33); // Time taken for Insertion Sort formated (sorted to reversed values)
// ----------------- (4) Quick Sort -----------------------------
        // Unsorted
        wordsToSort = transformed.clone();
        long startTime41 = System.nanoTime();
        Sorting.quickSort(wordsToSort);
        long endTime41 = System.nanoTime();
        long timeLapsed41 = endTime41 - startTime41;
        // Already sorted
        long startTime42 = System.nanoTime();
        Sorting.quickSort(wordsToSort);
        long endTime42 = System.nanoTime();
        long timeLapsed42 = endTime42 - startTime42;
        // Sorted to reversed
        long startTime43 = System.nanoTime();
        Sorting.reverseQuickSort(wordsToSort);
        long endTime43 = System.nanoTime();
        long timeLapsed43 = endTime43 - startTime43;
        // formats time with commas
        String formated41 = formatter.format(timeLapsed41); // Time taken for Quick Sort formated (unsorted values)
        String formated42 = formatter.format(timeLapsed42); // Time taken for Quick Sort formated (already sorted values)
        String formated43 = formatter.format(timeLapsed43); // Time taken for Quick Sort formated (sorted to reversed values)
// ----------------- (5) Merge Sort -----------------------------
        // Unsorted
        wordsToSort = transformed.clone();
        long startTime51 = System.nanoTime();
        Sorting.mergeSort(wordsToSort);
        long endTime51 = System.nanoTime();
        long timeLapsed51 = endTime51 - startTime51;
        // Already sorted
        long startTime52 = System.nanoTime();
        Sorting.mergeSort(wordsToSort);
        long endTime52 = System.nanoTime();
        long timeLapsed52 = endTime52 - startTime52;
        // Sorted to reversed
        long startTime53 = System.nanoTime();
        Sorting.reverseMergeSort(wordsToSort);
        long endTime53 = System.nanoTime();
        long timeLapsed53 = endTime53 - startTime53;
        // formats time with commas
        String formated51 = formatter.format(timeLapsed51); // Time taken for Merge Sort formated (unsorted values)
        String formated52 = formatter.format(timeLapsed52); // Time taken for Merge Sort formated (already sorted values)
        String formated53 = formatter.format(timeLapsed53); // Time taken for Merge Sort formated (sorted to reversed values)
// ----------------- (6) Pancake Sort -----------------------------
        // Unsorted
        wordsToSort = transformed.clone();
        long startTime61 = System.nanoTime();
        Sorting.pancakeSort(wordsToSort);
        long endTime61 = System.nanoTime();
        long timeLapsed61 = endTime61 - startTime61;
        // Already sorted
        long startTime62 = System.nanoTime();
        Sorting.pancakeSort(wordsToSort);
        long endTime62 = System.nanoTime();
        long timeLapsed62 = endTime62 - startTime62;
        // Sorted to reversed
        long startTime63 = System.nanoTime();
        Sorting.reversePancakeSort(wordsToSort);
        long endTime63 = System.nanoTime();
        long timeLapsed63 = endTime63 - startTime63;
        // formats time with commas
        String formated61 = formatter.format(timeLapsed61); // Time taken for Pancake Sort formated (unsorted values)
        String formated62 = formatter.format(timeLapsed62); // Time taken for Pancake Sort formated (already sorted values)
        String formated63 = formatter.format(timeLapsed63); // Time taken for Pancake Sort formated (sorted to reversed values)

        System.out.println("========================================= Results ==========================================");
        System.out.println("Time taken by the Bubble Sort algorithm: \n\tUnsorted values: " + formated11 + " nanoseconds.");
        System.out.println("\tSorted values: " + formated12 + " nanoseconds.");
        System.out.println("\tSorted to reversed: " + formated13 + " nanoseconds.");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Time taken by the Selection Sort algorithm: \n\tUnsorted values: " + formated21 + " nanoseconds.");
        System.out.println("\tSorted values: " + formated22 + " nanoseconds.");
        System.out.println("\tSorted to reversed: " + formated23 + " nanoseconds.");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Time taken by the Insertion Sort algorithm: \n\tUnsorted values: " + formated31 + " nanoseconds.");
        System.out.println("\tSorted values: " + formated32 + " nanoseconds.");
        System.out.println("\tSorted to reversed: " + formated33 + " nanoseconds.");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Time taken by the Quick Sort algorithm: \n\tUnsorted values: " + formated41 + " nanoseconds.");
        System.out.println("\tSorted values: " + formated42 + " nanoseconds.");
        System.out.println("\tSorted to reversed: " + formated43 + " nanoseconds.");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Time taken by the Merge Sort algorithm: \n\tUnsorted values: " + formated51 + " nanoseconds.");
        System.out.println("\tSorted values: " + formated52 + " nanoseconds.");
        System.out.println("\tSorted to reversed: " + formated53 + " nanoseconds.");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Time taken by the Pancake Sort algorithm: \n\tUnsorted values: " + formated61 + " nanoseconds.");
        System.out.println("\tSorted values: " + formated62 + " nanoseconds.");
        System.out.println("\tSorted to reversed: " + formated63 + " nanoseconds.");
        System.out.println("============================================================================================");
    }
}

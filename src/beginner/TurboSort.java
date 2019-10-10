package beginner;
import java.util.Arrays;
import java.util.Scanner;

public class TurboSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] numbers = new int[T];
        for (int i=0;i<T;i++){
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);
        for (int i:numbers){
            System.out.println(i);
        }
    }
}

class Way2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] numbers = new int[T];
        for (int i=0;i<T;i++){
            numbers[i] = scanner.nextInt();
        }
       insertionSort(numbers);
        for (int i:numbers){
            System.out.println(i);
        }
    }

    // not by me
    public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
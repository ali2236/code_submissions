package hackerrank.algorithms.sorting;

import java.util.Scanner;

public class InsertionSort1 {
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int i = n-1;
        int key = arr[i];
        while(i>0 && arr[i-1]>key){
            arr[i] = arr[i-1];
            i--;
            print(arr);
        }
        arr[i] = key;
        print(arr);
    }

    static void print(int[] a){
        for (int e : a){
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
